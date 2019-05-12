package test_app;

import biz.AccountManager;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertTrue;


/**
 * Created by Krzysztof Podlaski on 12.05.2019.
 */
public class AccountManagerTest {
    @Mock
    AccountManager accMan=null;

    @Before
    public void prepareTest(){

    }

    @Test
    public void paymentInTest(){
        assertTrue(accMan==null);
    }

}
