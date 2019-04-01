package pakiet;

import java.util.Map;

/**
 * Created by Krzysztof Podlaski on 25.03.2019.
 */
public class Waluta {

    private double ilosc;
    private Waluty waluta;
    private Map<Waluty, Double> exchangeRates;

    public void setIlosc(double ilosc) {
        this.ilosc = ilosc;
    }

    public void setWaluta(Waluty waluta) {
        this.waluta = waluta;
    }

    public double getIlosc() {
        return ilosc;
    }

    public Waluty getWaluta() {
        return waluta;
    }

    public void setExchangeRates(Map<Waluty, Double> exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    public double exchangeTo(Waluty waluta) {
        return exchangeRates.get(waluta)*ilosc;
    }



}
