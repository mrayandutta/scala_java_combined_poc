package pizza.decorator;

public class MediumSizeDecorator extends SizeDecorator{
	
	public MediumSizeDecorator(Pizza pizza) 
	{
		this.pizza = pizza;
	}

	public String getDescription() {
		return pizza.getDescription()+",MediumSize";
	}

	public double getPrice() {
		return pizza.getPrice()+10;
	}

	
}
