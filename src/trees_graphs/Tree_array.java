package trees_graphs;

public class Tree_array {
	static String solution(long[] arr) {

		int n = 2;
		long left = 0;
		long right = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > 0) {
				int a = (int) Math.pow(2, n);
				for (int j = 0; j < a / 2; j++) {
					if (i < arr.length) {
						if (j < a / 4) {
							left += arr[i];
						} else {
							right += arr[i];
						}
						i++;
					}
				}
				n++;
				i--;
			}
		}
		if (left > right)
			return "Left";
		if (right > left)
			return "Right";
		return "";
	}

	public static void main(String args[]) {
		long arr[] = { 1, 2, 3, 4, 5, 6, 7};
		System.out.print(solution(arr));
	}

}
