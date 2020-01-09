package whiteBoard;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruLinkedHashmap {

	private static Map<Integer, Integer> LruLinkList;
	private final static int size = 5;

	static int getData(int key) {

		LruLinkList.put(key, LruLinkList.remove(key));
		return LruLinkList.get(key);
	}

	static void putData(int key, int data) {

		if (LruLinkList == null)
			LruLinkList = new LinkedHashMap<>();
		if (LruLinkList.size() >= size)
			LruLinkList.remove(LruLinkList.keySet().iterator().next());

		LruLinkList.put(key, data);
	}

	public static void main(String args[]) {
		putData(1, 5);
		putData(2, 4);
		putData(3, 3);
		putData(4, 7);
		putData(5, 9);
		System.out.println(LruLinkList);
		putData(6, 10);
		System.out.println(LruLinkList);
		putData(7, 12);

		System.out.println(getData(3));

		System.out.println(LruLinkList);
		
		
	}
}
