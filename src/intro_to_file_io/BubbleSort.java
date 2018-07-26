package intro_to_file_io;

public class BubbleSort {
	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
		int[] test = { 2, 4, 3, 8, 5, 9 };
		for (int i = 0; i < 10000; i++) {
			sort(test);
		}
		String s = "";
		for (int i = 0; i < test.length; i++) {
			s += "[";
			s += test[i];
			s += "] ";
		}
		System.out.println(s);
	}

	private static void sort(int[] i) {
		for (int j = 1; j < i.length; j++) {
			if (i[j] < i[j - 1]) {
				int t = i[j - 1];
				i[j - 1] = i[j];
				i[j] = t;
			}
		}
	}
}
