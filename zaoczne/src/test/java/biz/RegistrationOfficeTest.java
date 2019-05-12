package biz;

import db.Car;
import db.DAO;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.*;

/**
 * Created by Krzysztof Podlaski on 13.04.2019.
 */
public class RegistrationOfficeTest {
    RegistrationOffice regOffice;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    DAO dao;
    @Mock
    Printer printer;

    @Before
    public void preareTest() throws
            NoSuchFieldException,
            IllegalAccessException {
        regOffice = new RegistrationOffice();
        Field f = regOffice.getClass().getDeclaredField("dao");
        f.setAccessible(true);
        f.set(regOffice,dao);
        f = RegistrationOffice.class.getDeclaredField("printer");
        f.setAccessible(true);
        f.set(regOffice,printer);
    }

    @Test
    public void billToARegTest1() throws Exception {
        //Test case
        String reg = "EL1231";
        Car c = mock(Car.class);
        when(dao.findCarByPlateNumber(eq(reg)))
                .thenReturn(c);
        assertNotNull(c);
        String owner = "Olaf Olaszewski";
        when(dao.findOwnerForCar(eq(c)))
                .thenReturn(owner);

        //Run tested method
        boolean result = regOffice.billToAReg(reg,150);

        //Chcek results and path
        assertEquals("Olaf Olaszewski",owner);
        assertEquals(true,result);
        assertEquals(regOffice.total_gain,150,0.1);
        verify(dao).findCarByPlateNumber(reg);
        verify(printer,times(1))
                .printBill(eq(owner),
                        eq(c),eq(150.0));
    }

    @Test(expected = Exception.class)
    public void billToARegTestEx() throws Exception {
        String reg = "EL1231";
        Car c = mock(Car.class);
        when(dao.findCarByPlateNumber(eq(reg)))
                .thenReturn(c);
        assertNotNull(c);
        String owner = "Olaf Olaszewski";
        when(dao.findOwnerForCar(eq(c)))
                .thenReturn(owner);
        willThrow(new Exception()).given(printer)
                .printBill(any(String.class),
                eq(c),anyDouble());
        regOffice.billToAReg(reg,150.0);
    }
}
