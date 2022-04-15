package pizza.decorator;

public class VegPizza implements Pizza {

	@Override
	public double getPrice() {
		return 10;
	}

	@Override
	public String getDescription() {
		return "VegPizza";
	}

}
