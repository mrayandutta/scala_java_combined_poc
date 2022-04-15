package patterns.behavioural.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	
	private List<Observer> observers = new ArrayList<Observer>();
	public void subscribe(Observer observer) 
	{
		observers.add(observer);
	}

	public void unSubscribe(Observer observer) 
	{
		observers.remove(observer);
	}
	
	public void publish(String msg) 
	{
		observers.forEach(o -> o.update(msg));
	}
}
