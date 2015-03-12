package course.distributedsystems.minimumdistance;

import java.util.Map;
import java.util.Map.Entry;

import course.distributedsystems.findrestaurant.RestaurantProfile;

public class StartFindingDistance {
	private FindDistance fd = new FindDistance();
	private RestaurantProfile rp = new RestaurantProfile();
	private int[][] map;
	
	private void getAllDistances(int x, int y) {
		map = fd.getDistanceForHotel(x, y, 0, 1, "h");
	}
	
	public void searchHotelToVisit(int x, int y, Map<String, Integer> hotels) {
		getAllDistances(x, y);
		for(Entry<String, Integer> entry: hotels.entrySet()) {
			String[] location = entry.getKey().split(",");
			hotels.put(entry.getKey(), map[Integer.parseInt(location[0])]
					[Integer.parseInt(location[1])]);
		}
	}
	
	public Map<String, Integer> entry(int x, int y, String hotel) {
		Map<String, Integer> restaurantMap;
		if(hotel.compareToIgnoreCase("Indian") == 0) {
			restaurantMap = rp.getIndian();
			searchHotelToVisit(x, y, restaurantMap);
		} else if(hotel.compareToIgnoreCase("Chinese") == 0) {
			restaurantMap = rp.getChinese();
			searchHotelToVisit(x, y, restaurantMap);
		} else {
			restaurantMap = rp.getMexican();
			searchHotelToVisit(x, y, restaurantMap);
		}
		return restaurantMap;
	}

}
