
public class Admin extends User{

	
	private VehicalController VC;
	
	public Admin(String newName, String newId, int newPhoneNumber) {
		super(newName, newId, newPhoneNumber);
	}
	
	public void accessVehicalController() {
		VC = VehicalController.accessController();
	}
}
