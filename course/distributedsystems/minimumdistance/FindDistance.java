package course.distributedsystems.minimumdistance;

public class FindDistance {
	private String[][] map = new CreateMap().getMap();
	private int[][] resultMap = new int[map.length][map[0].length];

	public int[][] getDistanceForHotel(int xPosition, int yPosition, int hx, int hy, String horp) {
		String[][] roadMap = createRoadMap(horp);
		boolean[][] visited = new boolean[roadMap.length][roadMap[0].length];
		for(int i = 0; i < resultMap.length; i++) {
			for(int j = 0; j < resultMap[i].length; j++) {
				resultMap[i][j] = Integer.MAX_VALUE;
			}
		}
		resultMap[xPosition][yPosition] = 0;
		if(roadMap[xPosition][yPosition] != null &&
				roadMap[xPosition][yPosition].equals("r")) {
			calculateDistance(xPosition, yPosition, roadMap, visited);
//			for(int i = 0; i < resultMap.length; i++) {
//				for(int j = 0; j < resultMap[i].length; j++) {
//					if(resultMap[i][j] == Integer.MAX_VALUE) {
//						System.out.print("n" + "\t");
//					} else {
//						System.out.print(resultMap[i][j]+"\t");
//					}
//				}
//				System.out.println();
//			}
		}
		return resultMap;
	}

	private void calculateDistance(int xPosition, int yPosition, 
			String[][] roadMap, boolean[][] visited) {
		visited[xPosition][yPosition] = true;
		//System.out.println("At " + xPosition + ", " + yPosition);
		visited[xPosition][yPosition] = true;
		if(xPosition > 0 && xPosition < roadMap.length - 1) {
			if(yPosition > 0 && yPosition < roadMap[xPosition].length - 1) {
				goLeft(xPosition, yPosition, roadMap, visited);
				goRight(xPosition, yPosition, roadMap, visited);
				goUp(xPosition, yPosition, roadMap, visited);
				goDown(xPosition, yPosition, roadMap, visited);
			}
			if(yPosition == 0) {
				goUp(xPosition, yPosition, roadMap, visited);
				goDown(xPosition, yPosition, roadMap, visited);
				goRight(xPosition, yPosition, roadMap, visited);
			}
			if(yPosition == roadMap[xPosition].length - 1) {
				goLeft(xPosition, yPosition, roadMap, visited);
				goUp(xPosition, yPosition, roadMap, visited);
				goDown(xPosition, yPosition, roadMap, visited);
			}
		}
		if(xPosition == 0) {
			goDown(xPosition, yPosition, roadMap, visited);
			if(yPosition > 0 && yPosition < roadMap[xPosition].length - 1) {
				goLeft(xPosition, yPosition, roadMap, visited);
				goRight(xPosition, yPosition, roadMap, visited);
			}
			if(yPosition == 0) {
				goRight(xPosition, yPosition, roadMap, visited);
			}
			if(yPosition == roadMap[xPosition].length - 1) {
				goLeft(xPosition, yPosition, roadMap, visited);
			}
		}
		if(xPosition == roadMap.length - 1) {
			goUp(xPosition, yPosition, roadMap, visited);
			if(yPosition > 0 && yPosition < roadMap[xPosition].length - 1) {
				goLeft(xPosition, yPosition, roadMap, visited);
				goRight(xPosition, yPosition, roadMap, visited);
			}
			if(yPosition == 0) {
				goRight(xPosition, yPosition, roadMap, visited);
			}
			if(yPosition == roadMap[xPosition].length - 1) {
				goLeft(xPosition, yPosition, roadMap, visited);
			}
		}
	}

	/**
	 * This method makes the current position to take a step to the left.
	 * 
	 * @param xPosition		Current x position.
	 * @param yPosition		Current y position
	 * @param roadMap		Map containing the road and the hotels or parking lots.
	 * @param Visited		Matrix containing the positions visited by the
	 * 						current path.
	 */
	private void goLeft(int xPosition, int yPosition, String[][] roadMap,
			boolean[][] Visited) {
		if(roadMap[xPosition][yPosition-1] != null) {
			if(!Visited[xPosition][yPosition-1]) {
				if(roadMap[xPosition][yPosition-1].equals("r")) {
					boolean[][] visited = getVisited(Visited);
					if(resultMap[xPosition][yPosition-1] > resultMap[xPosition][yPosition] + 1) {
						resultMap[xPosition][yPosition-1] = resultMap[xPosition][yPosition] + 1;
					}
					calculateDistance(xPosition, yPosition-1, roadMap, visited);
				} else {
					if(resultMap[xPosition][yPosition-1] > resultMap[xPosition][yPosition] + 1) {
						resultMap[xPosition][yPosition-1] = resultMap[xPosition][yPosition] + 1;
					}
				}
			}
		}
	}

	/**
	 * This method makes the current position to take a step to the right.
	 * 
	 * @param xPosition		Current x position.
	 * @param yPosition		Current y position
	 * @param roadMap		Map containing the road and the hotels or parking lots.
	 * @param Visited		Matrix containing the positions visited by the
	 * 						current path.
	 */
	private void goRight(int xPosition, int yPosition, String[][] roadMap,
			boolean[][] Visited) {
		if(roadMap[xPosition][yPosition+1] != null) {
			if(!Visited[xPosition][yPosition+1]) {
				if(roadMap[xPosition][yPosition+1].equals("r")) {
					boolean[][] visited = getVisited(Visited);
					if(resultMap[xPosition][yPosition+1] > resultMap[xPosition][yPosition] + 1) {
						resultMap[xPosition][yPosition+1] = resultMap[xPosition][yPosition] + 1;
					}
					calculateDistance(xPosition, yPosition+1, roadMap, visited);
				} else {
					if(resultMap[xPosition][yPosition+1] > resultMap[xPosition][yPosition] + 1) {
						resultMap[xPosition][yPosition+1] = resultMap[xPosition][yPosition] + 1;
					}
				}
			}
		}
	}

	/**
	 * This method makes the current position to take a step to go up.
	 * 
	 * @param xPosition		Current x position.
	 * @param yPosition		Current y position
	 * @param roadMap		Map containing the road and the hotels or parking lots.
	 * @param Visited		Matrix containing the positions visited by the
	 * 						current path.
	 */
	private void goUp(int xPosition, int yPosition, String[][] roadMap,
			boolean[][] Visited) {
		if(roadMap[xPosition-1][yPosition] != null) {
			if(!Visited[xPosition-1][yPosition]) {
				if(roadMap[xPosition-1][yPosition].equals("r")) {
					boolean[][] visited = getVisited(Visited);
					if(resultMap[xPosition-1][yPosition] > resultMap[xPosition][yPosition] + 1) {
						resultMap[xPosition-1][yPosition] = resultMap[xPosition][yPosition] + 1;
					}
					calculateDistance(xPosition-1, yPosition, roadMap, visited);
				} else {
					if(resultMap[xPosition-1][yPosition] > resultMap[xPosition][yPosition] + 1) {
						resultMap[xPosition-1][yPosition] = resultMap[xPosition][yPosition] + 1;
					}
				}
			}
		}
	}

	/**
	 * This method makes the current position to take a step to go down.
	 * 
	 * @param xPosition		Current x position.
	 * @param yPosition		Current y position
	 * @param roadMap		Map containing the road and the hotels or parking lots.
	 * @param Visited		Matrix containing the positions visited by the
	 * 						current path.
	 */
	private void goDown(int xPosition, int yPosition, String[][] roadMap,
			boolean[][] Visited) {
		if(roadMap[xPosition+1][yPosition] != null) {
			if(!Visited[xPosition+1][yPosition]) {
				if(roadMap[xPosition+1][yPosition].equals("r")) {
					boolean[][] visited = getVisited(Visited);
					if(resultMap[xPosition+1][yPosition] > resultMap[xPosition][yPosition] + 1) {
						resultMap[xPosition+1][yPosition] = resultMap[xPosition][yPosition] + 1;
					}
					calculateDistance(xPosition+1, yPosition, roadMap, visited);
				} else {
					if(resultMap[xPosition+1][yPosition] > resultMap[xPosition][yPosition] + 1) {
						resultMap[xPosition+1][yPosition] = resultMap[xPosition][yPosition] + 1;
					}
				}
			}
		}
	}

	/**
	 * This method creates a map with hotels or parking lots.
	 * 
	 * @param value		Value except the the road that needs to be kept in the
	 * 					map.
	 * @return			Returns a map with road and the value provided.
	 */
	private String[][] createRoadMap(String value) {
		String[][] result = new String[map.length][map[0].length];
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(map[i][j].equals("r") || map[i][j].equals(value)) {
					result[i][j] = map[i][j];
				}
			}
		}
		return result;
	}

	/**
	 * 
	 * 
	 * @param visited
	 * @return
	 */
	private boolean[][] getVisited(boolean[][] visited) {
		boolean[][] result = new boolean[visited.length][];
		for(int i = 0; i < visited.length; i++) {
			result[i] = visited[i].clone();
		}
		return result;
	}

	
	/**
	 * Removal of other non required map.
	 * 
	 * @param x
	 * @param y
	 * @param roadMap
	 * @return
	 */
//	private String[][] removeOtherHotels(int x, int y, String roadMap[][]) {
//		for(int i = 0; i < roadMap.length; i++) {
//			for(int j = 0; j < roadMap[i].length; j++) {
//				if(i != x && j != y) {
//					if(roadMap[i][j] != null && roadMap[i][j].equals("h")) {
//						roadMap[i][j] = null;
//					}
//				}
//			}
//		}
//		return roadMap;
//	}

}
