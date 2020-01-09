package amazon_test;

import java.util.List;

public class NearestPoint {

	List<List<Integer>> near(int totatHouse, List<List<Integer>> allLocation, int numHouse) {
		allLocation.sort((l1, l2) -> (int)Math.sqrt(Math.pow(l1.get(0), 2) + Math.pow(l1.get(1), 2))
				- (int)Math.sqrt(Math.pow(l2.get(0), 2) + Math.pow(l2.get(1), 2)));
	
		return null;
	}

}