
public class Car {
	
	private String carMake;
	private String carModel;
	private String carYear;
	private String carLocation;
	private String status;

	public Car(String newCarMake, String newCarModel, String newCarYear, String newCarLocation ){
		
		carMake = newCarMake;
		carModel = newCarModel;
		carYear = newCarYear;
		carLocation = newCarLocation;
		
	}
	
	public String checkStatus() {
		return status;
	}
	
	public void changeStatus(String newStatus) {
		status = newStatus;
	}
	
	public String getCarModel() {
		if(carModel == null) return "No Car Assigned Yet";
		else return carModel;
	}
	public String getCarAsString() {
		return "Car Manufacturer: "+carMake+" Car Model: "+carModel+" Year Made: "+carYear+" Location Made: "+carLocation;
	}
}
