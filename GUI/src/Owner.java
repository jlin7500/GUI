import java.util.ArrayList;

public class Owner extends User{
	
	private ArrayList<Registration> registrations;
	
	public Owner(String newName, String newId, int newPhoneNumber, String newResidencyTime, Car newCar) {
		
		super(newName, newId, newPhoneNumber);
		registerNewCar(newCar, newResidencyTime);
		
	}
	
	private class Registration{
		
		Car registeredCar;
		String residencyTime;
		
		public Registration(Car newCar, String recordedResidencyTime){
			
			registeredCar = newCar;
			residencyTime = recordedResidencyTime;
			
		}
	}
	
	public void registerNewCar(Car newCar, String recordedResidencyTime) {
		Registration newRegistration = new Registration(newCar, recordedResidencyTime);
		registrations.add(newRegistration);
	}
	
	
	
}
