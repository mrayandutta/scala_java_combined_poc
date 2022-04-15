package patterns.behavioural.state.general;

public class Car implements CarState{
	
	private CarState powerOnState;
	private CarState powerOffState;
	private CarState driveState;
	private CarState stopState;
	
	
	private CarState state;

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drive() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		
	}

	public CarState getPowerOnState() {
		return powerOnState;
	}

	public void setPowerOnState(CarState powerOnState) {
		this.powerOnState = powerOnState;
	}

	public CarState getPowerOffState() {
		return powerOffState;
	}

	public void setPowerOffState(CarState powerOffState) {
		this.powerOffState = powerOffState;
	}

	public CarState getDriveState() {
		return driveState;
	}

	public void setDriveState(CarState driveState) {
		this.driveState = driveState;
	}

	
	public CarState getStopState() {
		return stopState;
	}

	public void setStopState(CarState stopState) {
		this.stopState = stopState;
	}

	public CarState getState() {
		return state;
	}

	public void setState(CarState state) {
		this.state = state;
	}
	
	
	
	

}
