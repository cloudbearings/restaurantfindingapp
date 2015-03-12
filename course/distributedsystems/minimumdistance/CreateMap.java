package course.distributedsystems.minimumdistance;

import java.io.File;
import java.util.Scanner;

public class CreateMap {
	private String mapLocation;
	private String map[][];

	public CreateMap() {
		File f = new File("src" + System.getProperty("file.separator")
				+ "course" + System.getProperty("file.separator")
				+ "distributedsystems" + System.getProperty("file.separator")
				+ "map" + System.getProperty("file.separator") + "Map10X10");
		mapLocation = f.getAbsolutePath();
		createMap();
	}

	public CreateMap(String mapLocation) {
		this.mapLocation = mapLocation;
	}

	private void createMap() {
		File mapFile = new File(mapLocation);
		int count = getNumberOfLines();
		Scanner sr = null;
		if(count != 0) {
			try {
				sr = new Scanner(mapFile);
				int round = 0;
				while(sr.hasNext()) {
					String[] contents = sr.nextLine().split(" ");
					if(map == null) {
						map = new String[count][contents.length];
					}
					for(int i = 0; i < contents.length; i++) {
						map[round][i] = contents[i];
					}
					round++;
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(sr != null) {
			sr.close();
		}
	}

	private int getNumberOfLines() {
		int count = 0;
		Scanner sr = null;
		try{
			sr = new Scanner(new File(mapLocation));
			while(sr.hasNext()) {
				count++;
				sr.nextLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(sr != null) {
			sr.close();
		}
		return count;
	}
	
	public String[][] getMap() {
		return map;
	}

}
