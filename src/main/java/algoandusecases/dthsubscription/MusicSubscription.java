package algoandusecases.dthsubscription;

public class MusicSubscription implements Subscription {

	@Override
	public double getPrice() {
		return 30;
	}

	@Override
	public String getDescription() {
		return "MusicSubscription";
	}

}
