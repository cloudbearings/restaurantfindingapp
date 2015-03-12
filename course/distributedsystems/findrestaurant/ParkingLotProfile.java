package course.distributedsystems.findrestaurant;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotProfile {
	private Map<String, Integer> parkingLots = new HashMap<String, Integer>();
	
	public ParkingLotProfile() {
		parkingLots.put("0,6", Integer.MAX_VALUE);
		parkingLots.put("1,4", Integer.MAX_VALUE);
		parkingLots.put("2,0", Integer.MAX_VALUE);
		parkingLots.put("2,4", Integer.MAX_VALUE);
		parkingLots.put("3,7", Integer.MAX_VALUE);
		parkingLots.put("3,8", Integer.MAX_VALUE);
		parkingLots.put("5,0", Integer.MAX_VALUE);
		parkingLots.put("7,1", Integer.MAX_VALUE);
		parkingLots.put("8,2", Integer.MAX_VALUE);
		parkingLots.put("9,9", Integer.MAX_VALUE);
	}
	
	public Map<String, Integer> getParkingLots() {
		return parkingLots;
	}

}
