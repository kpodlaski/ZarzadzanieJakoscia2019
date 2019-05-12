package biz;

import db.Car;

/**
 * Created by Krzysztof Podlaski on 13.04.2019.
 */
public interface Printer {
    void printBill(String owner, Car c, double cost)
            throws Exception;
}
