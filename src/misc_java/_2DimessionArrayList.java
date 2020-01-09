package misc_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2DimessionArrayList {
	
	public static void main(String args[]) {
		
		List<List<Integer>> l = new ArrayList<>(); 
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(1);
		l2.add(2);
		l2.add(3);
		l.add(l2);
		l.add(Arrays.asList(4,5,6));
		l.add(Arrays.asList(7,8,9));
		l.add(Arrays.asList(10,11,12));
		
		System.out.println(l);
		l.get(0).add(4);
		l.get(0).set(2,99);
		
		System.out.println(l);
	}

}
