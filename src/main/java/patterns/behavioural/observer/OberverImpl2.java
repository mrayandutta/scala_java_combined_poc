package patterns.behavioural.observer;

public class OberverImpl2 implements Observer{
	

	@Override
	public void update(String msg) {
		System.out.println("msg recievd by OberverImpl2 is "+msg);
		
	}

}
