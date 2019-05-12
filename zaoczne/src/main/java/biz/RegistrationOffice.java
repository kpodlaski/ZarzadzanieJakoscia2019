package biz;

import db.Car;
import db.DAO;

/**
 * Created by Krzysztof Podlaski on 13.04.2019.
 */
public class RegistrationOffice {
    private DAO dao;
    private Printer printer;
    double total_gain =0.0;

    public boolean billToAReg(String reg, double cost)
            throws Exception {
      Car c = dao.findCarByPlateNumber(reg);
      String owner = dao.findOwnerForCar(c);
      total_gain+=cost;
        //try {
            printer.printBill(owner, c, cost);
        /*} catch (Exception e) {
            e.printStackTrace();
        }
        */
        return true;
    }
}
