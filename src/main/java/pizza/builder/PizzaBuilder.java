package pizza.builder;

public class PizzaBuilder {
	
	Pizza pizza = new Pizza();
	
	public PizzaBuilder withTopping(Topping topping) {
        pizza.setTopping(topping);
        pizza.addToPrice(topping.getCost());
        pizza.addToDescription(topping.getDescription());
        return this;
    }
 
    public PizzaBuilder withSize(Size size) {
        pizza.setSize(size);
        pizza.addToPrice(size.getCost());
        pizza.addToDescription(size.getDescription());
        return this;
    }
    
    public Pizza build() {
        return pizza;
    }
}
