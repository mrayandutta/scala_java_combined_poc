package algoandusecases.dthsubscription;

public class SportsSubscription implements Subscription {

	@Override
	public double getPrice() {
		return 20;
	}

	@Override
	public String getDescription() {
		return "SportsSubscription";
	}

}
