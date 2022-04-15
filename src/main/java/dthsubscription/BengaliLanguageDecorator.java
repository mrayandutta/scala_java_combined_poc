package dthsubscription;

public class BengaliLanguageDecorator extends LanguageDecorator{
	
	public BengaliLanguageDecorator(Subscription subscription) 
	{
		this.subscription = subscription;
	}

	public String getDescription() {
		return subscription.getDescription()+",Bengali";
	}

	public double getPrice() {
		return subscription.getPrice()+50;
	}

	
}
