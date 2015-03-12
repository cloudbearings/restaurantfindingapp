package course.distributedsystems.findrestaurant;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Profile {
	private Map<String, Integer> restaurant = new HashMap<String, Integer>();

	public Profile() {
		restaurant.put("Indian", 0);
		restaurant.put("Chinese", 0);
		restaurant.put("Italian", 0);
	}

	public void setScores(Map<String, Integer> scores) {
		if(scores != null) {
			for(Entry<String, Integer> score: scores.entrySet()) {
				if(restaurant.containsKey(score.getKey())) {
					restaurant.put(score.getKey(), score.getValue());
				}
			}
		}
	}
	
	public Map<String, Integer> getScores() {
		return restaurant;
	}

}
