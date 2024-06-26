package factoryPattern;

public class Testing {
	public static void main(String[] args) {
		Car obj1= FactoryDesignPattern.getInstance("tata");
		Car obj2= FactoryDesignPattern.getInstance("bajaj");
		Car obj3= FactoryDesignPattern.getInstance("hero");
		obj1.drive();
		obj2.drive();
		obj3.drive();
		
	}

}
