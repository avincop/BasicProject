package factoryPattern;

public class FactoryDesignPattern {
	public static Car getInstance(String name) {
		if(name.trim().equalsIgnoreCase("tata")) {
			return new Tata();
		}
		else if(name.trim().equalsIgnoreCase("bajaj")) {
			return new Bajaj();
		}
		else if(name.trim().equalsIgnoreCase("hero")) {
			return new Hero();
		}
		else {
			return null;
		}
	}

}
