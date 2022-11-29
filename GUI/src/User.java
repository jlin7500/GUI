
abstract public class User {

	protected String name;
	protected int id;
	protected int phoneNumber;

	public User(String newName, int newId, int newPhoneNumber) {
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

	public void notify(String message) {

	}
}
