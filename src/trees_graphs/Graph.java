package trees_graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

class Gnode {
	public Gnode(int data) {
		this.data = data;
	}

	int data;
	public List<Gnode> adj = new ArrayList<>();
}

public class Graph {
	private static List<List<Gnode>> ans = new ArrayList<List<Gnode>>();

	public static void main(String[] args) {

		Gnode a = new Gnode(0);
		Gnode b = new Gnode(1);
		Gnode c = new Gnode(2);
		Gnode d = new Gnode(3);

		a.adj.add(b);
		a.adj.add(c);
		a.adj.add(d);

		b.adj.add(d);

		c.adj.add(a);
		c.adj.add(b);

		getPaths(c, d);
		ans.stream().map(x -> x.stream().map(a1 -> a1.data).collect(Collectors.toList())).collect(Collectors.toList())
				.forEach(System.out::println);
		int min = Integer.MAX_VALUE;
		for (List<Gnode> m : ans) {
			if (m.size() < min)
				min = m.size();
		}
		System.out.print(min);
	}

	static void getPaths(Gnode source, Gnode dest) {
		Queue<List<Gnode>> path = new LinkedList<>();
		List<Gnode> al = new ArrayList<>();
		al.add(source);
		path.add(al);

		while (!path.isEmpty()) {
			List<Gnode> p = path.poll();
			Set<Gnode> visited = new HashSet<Gnode>(p);
			if (p.get(p.size() - 1) == dest) {
				ans.add(p);
			} else {
				for (Gnode a : p.get(p.size() - 1).adj) {
					if (!visited.contains(a)) {
						List<Gnode> temp = new ArrayList<Gnode>(p);
						temp.add(a);
						path.add(temp);
						visited.add(a);
					}
				}
			}
		}
	}
	
	
}
