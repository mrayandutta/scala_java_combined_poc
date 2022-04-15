package dthsubscription;

public class EnglishLanguageDecorator extends LanguageDecorator{
	
	public EnglishLanguageDecorator(Subscription subscription) 
	{
		this.subscription = subscription;
	}

	public String getDescription() {
		return subscription.getDescription()+",English";
	}

	public double getPrice() {
		return subscription.getPrice()+20;
	}

	
}
