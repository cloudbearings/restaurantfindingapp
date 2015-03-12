package course.distributedsystems.findrestaurant;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class GetRestaurant {
	Map<String, Integer> restaurantScore;

	public GetRestaurant() {
		restaurantScore = new HashMap<String, Integer>();
		restaurantScore.put("Indian", 0);
		restaurantScore.put("Chinese", 0);
		restaurantScore.put("Italian", 0);
	}
	
	public String getRestaurantName(Profile[] profiles) {
		calculateScores(profiles);
		return getRestaurantName(getMax());
	}

	private String getRestaurantName(int max) {
		String result = new String();
		for(Entry<String, Integer> entry: restaurantScore.entrySet()) {
			if(entry.getValue() == max) {
				result = entry.getKey();
			}
		}
		return result;
	}

	private void calculateScores(Profile[] profiles) {
		for(Profile profile: profiles) {
			Map<String, Integer> profileRestaurant = profile.getScores();
			if(profileRestaurant != null) {
				for(Entry<String, Integer> entry: profileRestaurant.entrySet()) {
					if(restaurantScore.containsKey(entry.getKey())) {
						restaurantScore.put(entry.getKey(),
								restaurantScore.get(entry.getKey())+entry.getValue());
					}
				}
			}
		}
	}
	
	private int getMax() {
		Collection<Integer> values = restaurantScore.values();
		int max = -1;
		for(int i: values) {
			if(i > max) {
				max = i;
			}
		}
		return max;
	}

}