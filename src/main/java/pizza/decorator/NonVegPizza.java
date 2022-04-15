package pizza.decorator;

public class NonVegPizza implements Pizza {

	@Override
	public double getPrice() {
		return 20;
	}

	@Override
	public String getDescription() {
		return "NonVegPizza";
	}

}
