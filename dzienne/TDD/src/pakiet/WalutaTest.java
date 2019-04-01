package pakiet;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Krzysztof Podlaski on 25.03.2019.
 */


public class WalutaTest {

    @BeforeClass
    public static void initTest(){

    }

    @Test
    public void exchange0(){
        Waluta w = new Waluta();
        w.setIlosc(0);
        w.setWaluta(Waluty.Zł);
        Map<Waluty,Double> eR= new HashMap<Waluty,Double>();
        eR.put(Waluty.Zł,1.0);
        eR.put(Waluty.Euro,4.29);
        eR.put(Waluty.USD,3.79);
        w.setExchangeRates(eR);

        double x = w.exchangeTo(Waluty.Euro);
        assertEquals(0,x,0.001);
        w.setIlosc(12);
        x = w.exchangeTo(Waluty.Euro);
        assertEquals(51.48,x,0.001);
        x = w.exchangeTo(Waluty.USD);
        assertEquals(45.48,x,0.001);


    }
}
