package carSystem;

public class Test {
	// 展示
	public static void dataDisplay(Car[] cars) {
		for (Car car : cars) {
			System.out.println("----------------");
			System.out.println("汽车品牌：" + car.getBrand());
			System.out.println("汽车类型：" + car.getType());
			System.out.println("汽车牌照：" + car.getCarId());
			System.out.println("----------------");
		}
	}

	public static void main(String[] args) {
		CarDaoImpl cdi = new CarDaoImpl(5);

		// 曲家岳创建八个车类对象
		Car c1 = new Car("宝马", "X1", "辽B111111111");
		Car c2 = new Car("奔驰", "X2", "辽B222222222");
		Car c3 = new Car("兰博基尼", "X3", "辽B333333333");
		Car c4 = new Car("大G", "X4", "辽B44444444");
		Car c5 = new Car("丰田", "X5", "辽B555555555");
		Car c6 = new Car("沃尔沃", "X6", "辽B666666");
		Car c7 = new Car("保时捷", "X7", "辽B7777777");
		Car c8 = new Car("卡宴", "X8", "辽B888888888");

		// 王怡人向cdi中添加前五辆车，并展示
		System.out.println("请输入要添加的车辆 ");
		cdi.save(c1);
		cdi.save(c2);
		cdi.save(c3);
		cdi.save(c4);
		cdi.save(c5);
		Car[] cars1 = cdi.queryAll();
		dataDisplay(cars1);

		// 曲家岳删除后三辆车，并添加创建的后三辆车，并展示
		System.out.println("请输入你要删除的车辆");
		cdi.delete("辽B333333333");
		cdi.delete("辽B44444444");
		cdi.delete("辽B555555555");
		System.out.println("请添加你要创建的车辆");
		cdi.save(c6);
		cdi.save(c7);
		cdi.save(c8);
		Car[] cars = cdi.queryAll();
		dataDisplay(cars);

		// 王怡人找出某个品牌的全部车辆，并展示
		System.out.println("请输入品牌");
		Car[] car3 = cdi.queryCarBrand("宝马");
		dataDisplay(car3);

		// 曲家岳找出某个类型的全部车辆，并展示
		Car[] car = cdi.queryCarType("X1");
		dataDisplay(car);

		// 王怡人找出某个牌照的车辆，并展示
		Car car2 = cdi.queryCarId("辽B111111111");
		System.out.println("汽车品牌：" + car2.getBrand());
		System.out.println("汽车类型：" + car2.getType());
		System.out.println("汽车牌照：" + car2.getCarId());
	}
}
