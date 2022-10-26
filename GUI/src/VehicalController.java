
public class VehicalController {
	
	private static VehicalController currentModel;

	private VehicalController() {
		
	}
	
	public static VehicalController accessController() {
		if(currentModel == null) currentModel = new VehicalController();
		return currentModel;
	}
	
	
}
