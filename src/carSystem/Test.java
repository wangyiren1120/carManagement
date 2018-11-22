package carSystem;

public class Test {
	// չʾ
	public static void dataDisplay(Car[] cars) {
		for (Car car : cars) {
			System.out.println("----------------");
			System.out.println("����Ʒ�ƣ�" + car.getBrand());
			System.out.println("�������ͣ�" + car.getType());
			System.out.println("�������գ�" + car.getCarId());
			System.out.println("----------------");
		}
	}

	public static void main(String[] args) {
		CarDaoImpl cdi = new CarDaoImpl(5);

		// �����������˸��������
		Car c1 = new Car("����", "X1", "��B111111111");
		Car c2 = new Car("����", "X2", "��B222222222");
		Car c3 = new Car("��������", "X3", "��B333333333");
		Car c4 = new Car("��G", "X4", "��B44444444");
		Car c5 = new Car("����", "X5", "��B555555555");
		Car c6 = new Car("�ֶ���", "X6", "��B666666");
		Car c7 = new Car("��ʱ��", "X7", "��B7777777");
		Car c8 = new Car("����", "X8", "��B888888888");

		// ��������cdi�����ǰ����������չʾ
		System.out.println("������Ҫ��ӵĳ��� ");
		cdi.save(c1);
		cdi.save(c2);
		cdi.save(c3);
		cdi.save(c4);
		cdi.save(c5);
		Car[] cars1 = cdi.queryAll();
		dataDisplay(cars1);

		// ������ɾ����������������Ӵ����ĺ�����������չʾ
		System.out.println("��������Ҫɾ���ĳ���");
		cdi.delete("��B333333333");
		cdi.delete("��B44444444");
		cdi.delete("��B555555555");
		System.out.println("�������Ҫ�����ĳ���");
		cdi.save(c6);
		cdi.save(c7);
		cdi.save(c8);
		Car[] cars = cdi.queryAll();
		dataDisplay(cars);

		// �������ҳ�ĳ��Ʒ�Ƶ�ȫ����������չʾ
		System.out.println("������Ʒ��");
		Car[] car3 = cdi.queryCarBrand("����");
		dataDisplay(car3);

		// �������ҳ�ĳ�����͵�ȫ����������չʾ
		Car[] car = cdi.queryCarType("X1");
		dataDisplay(car);

		// �������ҳ�ĳ�����յĳ�������չʾ
		Car car2 = cdi.queryCarId("��B111111111");
		System.out.println("����Ʒ�ƣ�" + car2.getBrand());
		System.out.println("�������ͣ�" + car2.getType());
		System.out.println("�������գ�" + car2.getCarId());
	}
}
