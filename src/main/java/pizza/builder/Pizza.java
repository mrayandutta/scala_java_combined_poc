package pizza.builder;

public class Pizza {
	
	private double totalPrice = 0;
	private String description ="";
    private Size size;
    private Topping topping;
    
    
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	public Topping getTopping() {
		return topping;
	}
	public void setTopping(Topping topping) {
		this.topping = topping;
	}
	
	public void addToPrice(double price) {
        this.totalPrice = totalPrice + price;
    }
	
	public void addToDescription(String description) {
        this.description = this.description + ","+description;
    }
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
    
}
