package whiteBoard;

import java.util.*;

public class PrintDirectory {

	private static Map<String, List<String>> manager = new HashMap<>();
	private Map<String, String> employee = new HashMap<>();

	PrintDirectory() {
		manager.put("-1", Arrays.asList("10", "15"));
		manager.put("10", Arrays.asList("11", "12"));
		manager.put("11", Arrays.asList("13"));
		manager.put("12", Arrays.asList("14"));
		

		employee.put("10", "-1");
		employee.put("11", "10");
		employee.put("12", "10");
		employee.put("13", "11");
		employee.put("14", "12");
	}
	
	public void print(List<String> str, int i) {
		for(String s : str) {
			for(int j = 0; j<i; j++) System.out.print("-");
			System.out.println(s);
			if(manager.containsKey(s)) print(manager.get(s), i+2);
		}
	}

	public static void main(String[] args) {
		PrintDirectory p = new PrintDirectory();
		
		p.print(manager.get("-1"), 0);
		
	}

}
