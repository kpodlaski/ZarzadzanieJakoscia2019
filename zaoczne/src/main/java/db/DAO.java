package db;

/**
 * Created by Krzysztof Podlaski on 13.04.2019.
 */
public interface DAO {
    Car findCarByPlateNumber(String plates);
    String findOwnerForCar(Car c);

}
