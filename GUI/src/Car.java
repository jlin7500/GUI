
public class Car {
	
	public String owner;
	public String ownerId;
	public String carMake;
	public String carModel;
	public String carYear;
	public String carLocation;
	public String status;
	public int carId;

	public Car(String newCarMake, String newCarModel, String newCarYear, String newCarLocation, int newCarId ){
		
		carMake = newCarMake;
		carModel = newCarModel;
		carYear = newCarYear;
		carLocation = newCarLocation;
		carId = newCarId;
		status = "available";
	}
	
	public String checkStatus() {
		return status;
	}
	
	public void changeStatus(String newStatus) {
		status = newStatus;
	}
	
	public String getCarModel() {
		if(carModel == null) return "No Car Model Assigned Yet";
		else return carModel;
	}
	
	public String getCarMake() {
		if(carMake == null) return "No Car Make Assigned Yet";
		else return carMake;
	}
	
	public String getCarLocation() {
		if(carLocation == null) return "No Car Location Assigned Yet";
		else return carLocation;
	}
	
	public String getCarYear() {
		if(carYear == null) return "No Car Year Assigned Yet";
		else return carYear;
	}
	
	public String getCarAsString() {
		return "Car Manufacturer: "+carMake+" Car Model: "+carModel+" Year Made: "+carYear+" Location Made: "+carLocation;
	}
}
