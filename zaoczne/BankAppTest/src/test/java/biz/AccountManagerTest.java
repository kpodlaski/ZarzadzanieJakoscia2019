package biz;

import dao.DAO;
import model.Account;
import model.Operation;
import model.User;
import model.exceptions.OperationIsNotAllowedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.lang.reflect.Field;
import java.sql.SQLException;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class AccountManagerTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    AccountManager am;
    @Mock
    DAO dao;
    @Mock
    AuthenticationManager auth;
    @Mock
    BankHistory history;
    @Mock
    User user;


    @Before
    public void initTest() {
        am = new AccountManager();
        //am.dao = dao;
        try {
            Class amClass = am.getClass();
            Field f = amClass.getDeclaredField("dao");
            f.setAccessible(true);  //Wyłączam prywatność
            f.set(am, dao);
            f = amClass.getDeclaredField("auth");
            f.setAccessible(true);  //Wyłączam prywatność
            f.set(am, auth);
            f = amClass.getDeclaredField("history");
            f.setAccessible(true);  //Wyłączam prywatność
            f.set(am, history);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    public void internalPaymentTestSuccess() throws OperationIsNotAllowedException, SQLException {
        Account sA = mock(Account.class);
        Account dA = mock(Account.class);
        double ammount = 1254.2;
        when(dao.findAccountById(1))
                .thenReturn(sA);
        when(dao.findAccountById(2))
                .thenReturn(dA);
        when(auth.canInvokeOperation(any(Operation.class),
                eq(user))).thenReturn(true);
        when(sA.outcome(ammount)).thenReturn(true);
        when(dA.income(ammount)).thenReturn(true);
        when(dao.updateAccountState(sA)).thenReturn(true);
        when(dao.updateAccountState(dA)).thenReturn(true);

        boolean result = am.internalPayment(user,
                ammount,
                "Przelew ",
                1,
                2);
        assertTrue(result);
        verify(dao,times(2))
                .findAccountById(anyInt());
        verify(auth,times(1))
                .canInvokeOperation(
                        any(Operation.class),any(User.class));
        verify(auth,times(1))
                .canInvokeOperation(any(Operation.class),
                        eq(user));
        verify(sA,times(1)).outcome(anyDouble());
        verify(sA,times(1)).outcome(ammount);
        verify(dA,times(1)).income(anyDouble());
        verify(dA,times(1)).income(ammount);
        verify(history,times(2))
                .logOperation(any(Operation.class),eq(true));
    }
}