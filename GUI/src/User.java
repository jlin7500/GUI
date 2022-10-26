
abstract public class User {
	
	protected String name;
	protected String id;
	protected int phoneNumber;
	
	public User(String newName, String newId, int newPhoneNumber) {
		name = newName;
		id = newId;
		phoneNumber = newPhoneNumber;
	}
	
	public void changeUsername(String newName) {
		name = newName;
	}
	
	public void changePhonenumber(int newPhoneNumber) {
		phoneNumber = newPhoneNumber;
	}
	
	public void Notify(String message) {
		
	}
}
