package pizza.decorator;

public class DecoratorDemo {
	public static void main(String[] args) {
		Pizza vegPizza = new VegPizza();
		Pizza nonVegPizza = new NonVegPizza();
		Pizza medSizeNonVeg = new MediumSizeDecorator(nonVegPizza);
		Pizza largeSizeVeg = new LargeSizeDecorator(vegPizza);
		
		
		System.out.println(medSizeNonVeg.getDescription()+","+medSizeNonVeg.getPrice());
		System.out.println(largeSizeVeg.getDescription()+","+largeSizeVeg.getPrice());
	}

}
