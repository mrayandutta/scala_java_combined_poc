package patterns.behavioural.observer;

public class OberverImpl1 implements Observer{
	

	@Override
	public void update(String msg) {
		System.out.println("msg recievd by OberverImpl1 is "+msg);
		
	}

}
