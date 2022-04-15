package patterns.behavioural.state.general;

public class PowerOnState implements CarState
{
	private final Car car;
	public PowerOnState(Car car)
	{
		this.car = car ;
	}
	@Override
	public void powerOn() {
		
		System.out.println("Turning the Power on ..");
		car.setState(car.getPowerOnState());
		
	}
	@Override
	public void stop() {
		System.out.println("Stopping the car");
		car.setState(car.getStopState());
		
		
	}
	@Override
	public void drive() {
		System.out.println("Driving the car");
		car.setState(car.getDriveState());
		
	}
	@Override
	public void powerOff() {
		System.out.println("Turning the Power off ..");
		car.setState(car.getPowerOffState());
		
		
	}
	
	

}
