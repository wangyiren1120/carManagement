package carSystem;

public class CarDaoImpl implements ICarDao {
	private Car[] cars;
	private int index;
	
	CarDaoImpl() {
		cars = new Car[10];
	}
	CarDaoImpl(int s) {
		cars = new Car[s];
	}
	
	@Override
	public boolean save(Car car) {
		// ���
		if (index < cars.length) {
			cars[index++] = car;
			return true;
		}
		return false;
	}
	@Override
	public boolean delete(String carId) {
		// ������
		for (int i = 0; i < index; i++){
			if (cars[i].getCarId().equals(carId)){
				for (int k = i ; k < index - 1; k ++){
					cars[k] = cars[k+1];
				}
				index--;
				return true;
			}
		}
		return false;
	}
	@Override
	public Car queryCarId(String carId) {
		// ���
		for (int i = 0 ; i < index ; i++) {
			if (cars[i].getCarId().equals(carId)) {
				return cars[i];
			}
		}
		return null;
	}
	@Override
	public Car[] queryCarType(String type) {
		// ������
		int count = 0;
		for (int i = 0; i < index; i++){
			if (cars[i].getType().equals(type)){
				count ++;
			}
		}
		if (0 == count ){
			
			return null;
		}
		Car[] c1 = new Car[count ];
		for (int i = 0; i < index; i++){
			if ( cars[i].getType().equals(type)){
				c1[--count ] = cars[i];
			}
		}
		return c1;
	}
	@Override //������
	public Car[] queryCarBrand(String brand) {
		int count = 0;
		for(int i = 0;i<index;i++){
			if(cars[i].getBrand().equals(brand)){
				count++;
			}
		}
		if(count==0){
			return null;
		}
		Car[] newcars = new Car[count];
		for(int i = 0;i<index;i++){
			if(cars[i].getBrand().equals(brand)){
				newcars[--count] = cars[i];
			}
		}
		return newcars;
	}
	@Override
	// ������
	public Car[] queryAll() {
		Car [] newcars = new Car[index];
		System.arraycopy(cars, 0,newcars, 0, index);
		return newcars;
	}
}
