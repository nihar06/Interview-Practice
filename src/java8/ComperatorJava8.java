package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class points {
	int a;
	int b;
	int c;

	public points(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
}

public class ComperatorJava8 implements Comparator<points> {

	@Override
	public int compare(points o1, points o2) {
		if (o1.a - o2.a == 0)
			return o1.c - o2.c;
		return o1.a - o2.a;
	}

	public static void main(String args[]) {

		List<points> listt = new ArrayList<points>();
		listt.add(new points(1, 2, 3));
		listt.add(new points(1, 2, 2));
		listt.add(new points(1, 2, 0));

		//listt.sort(new ComperatorJava8());
		//x.a - y.a == 0 ? x.c - y.c : x.a - y.a 
		listt.sort((x,y) -> (x.a - y.a == 0 ? x.c - y.c : x.a - y.a) );

		listt.stream().map(x -> x.c).forEach(System.out::print);
	}

}
