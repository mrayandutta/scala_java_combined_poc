package pizza.decorator;

public class LargeSizeDecorator extends SizeDecorator{
	
	public LargeSizeDecorator(Pizza pizza) 
	{
		this.pizza = pizza;
	}

	public String getDescription() {
		return pizza.getDescription()+",LargeSize";
	}

	public double getPrice() {
		return pizza.getPrice()+20;
	}

	
}
