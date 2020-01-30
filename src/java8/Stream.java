package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class coordinates {
	private static List<List<Integer>> coordinates = new ArrayList<List<Integer>>();

	static {
		coordinates.add(Arrays.asList(9, 1));
		coordinates.add(Arrays.asList(2, 1));
		coordinates.add(Arrays.asList(3, 2));
		coordinates.add(Arrays.asList(1, 7));
		coordinates.add(Arrays.asList(9, 2));
		coordinates.add(Arrays.asList(5, 5));
		coordinates.add(Arrays.asList(7, 3));
	}

	public List<List<Integer>> getCoordinates() {
		return coordinates;
	}
}

public class Stream {

	public static void main(String args[]) {

		List<Integer> s = new ArrayList<>();
		s.add(1);
		s.add(0);
		s.add(1);
		s.add(0);
		s.add(1);
		s.add(0);

		coordinates p = new coordinates();

		System.out.println("\n---------------Before-----------------\n");
		System.out.println(p.getCoordinates());

		System.out.println("\n ---------------Sorting-----------------\n");
		p.getCoordinates().stream().sorted((x, y) -> (int) (Math.pow(x.get(0), 2) + Math.pow(x.get(1), 2)
				- Math.pow(y.get(0), 2) + Math.pow(y.get(1), 2))).collect(Collectors.toList());
		// .forEach(System.out::print);

		// System.out.print("==============" +p1);

		System.out.println("\n ---------------Filter-----------------\n");
		p.getCoordinates().stream().parallel().filter(x -> x.get(0) + x.get(1) > 5).forEach(System.out::print);

		System.out.println("\n ---------------Filter-----------------\n");
		s = s.stream().filter(x -> x > 0).collect(Collectors.toList());
		System.out.println(s);

		System.out.println("\n ---------------Map-----------------\n");
		p.getCoordinates().stream().map(x -> x.stream().map(a -> a - 1).collect(Collectors.toList()))
				.collect(Collectors.toList()).forEach(System.out::print);

		System.out.println("\n ---------------Reduce-----------------\n");
		int a = s.stream().reduce(0, (x, y) -> x + y);
		System.out.println(a);

		System.out.println("\n ---------------Reduce-----------------\n");
		Optional<Integer> b = s.stream().reduce((x, y) -> x + y);
		if (b.isPresent())
			System.out.println(b.get());

	}
}
