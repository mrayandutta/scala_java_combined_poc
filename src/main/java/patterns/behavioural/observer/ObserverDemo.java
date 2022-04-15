package patterns.behavioural.observer;

public class ObserverDemo {
	public static void main(String[] args) {
		Subject subject =new Subject();
		Observer observer1 = new OberverImpl1();
		Observer observer2 = new OberverImpl2();
		subject.subscribe(observer1);
		subject.subscribe(observer2);
		
		subject.publish("msg 1 ....");
		subject.publish("msg 2 ....");
	}

}
