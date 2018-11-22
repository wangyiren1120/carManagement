package carSystem;

public interface ICarDao {
	boolean save (Car car);
	boolean delete (String cardId);
	Car queryCarId (String carId);
	Car[] queryCarType (String type);
	Car[] queryCarBrand (String brand);
	Car[] queryAll ();

}
