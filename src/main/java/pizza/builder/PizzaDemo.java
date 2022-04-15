package pizza.builder;

public class PizzaDemo {
	
	public static void main(String[] args) {
		Pizza pizza = new PizzaBuilder().withTopping(Topping.CHICKEN).withSize(Size.LARGE).build();
		System.out.println(pizza.getTotalPrice());
		System.out.println(pizza.getDescription());
		
		
	}

}
