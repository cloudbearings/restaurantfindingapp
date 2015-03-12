package course.distributedsystems.findrestaurant;

import java.util.HashMap;
import java.util.Map;

public class RestaurantProfile {
	private Map<String, Integer> indian = new HashMap<String, Integer>();
	private Map<String, Integer> chinese = new HashMap<String, Integer>();
	private Map<String, Integer> mexican = new HashMap<String, Integer>();
	
	public RestaurantProfile() {
		indian.put("0,2", -1);
		chinese.put("0,8", -1);
		mexican.put("4,0", -1);
		indian.put("5,4", -1);
		chinese.put("6,3", -1);
		mexican.put("6,7", -1);
		indian.put("8,5", -1);
	}
	
	public Map<String, Integer> getIndian() {
		return indian;
	}
	
	public Map<String, Integer> getChinese() {
		return chinese;
	}
	
	public Map<String, Integer> getMexican() {
		return mexican;
	}
}
