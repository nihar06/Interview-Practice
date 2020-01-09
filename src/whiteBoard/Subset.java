package whiteBoard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subset {

	public static void main(String[] args) {

		List<Integer> al = new ArrayList<>();
		List<List<Integer>> ans = new ArrayList<>();
			
		al.add(1);
		al.add(2);
		al.add(1);
//		al.add(4);

		for (int i = 0; i < (1 << al.size()); i++) {
			List<Integer> sub = new ArrayList<Integer>();
			for (int j = 0; j < al.size(); j++) {
				if((i & 1<<j) > 0)  sub.add(al.get(j));
			}
			ans.add(sub);
		}
		System.out.print(ans);
		
		/*
		 * Set<Integer> s = new HashSet<>(); Set<Integer> s1 = new HashSet<>();
		 * 
		 * s.add(1); s.add(2); s1.add(1); s1.add(2); Set<Set<Integer>> s2 = new
		 * HashSet<Set<Integer>>(); s2.add(s); s2.add(s1);
		 * 
		 * System.out.println("\n"+s2);
		 */
	}
}
