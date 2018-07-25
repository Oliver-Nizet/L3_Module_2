package intro_to_file_io;

public class BubbleSort {
	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
		int[] test = { 2, 4, 5, 9, 1, 3 };
		boolean unsorted = true;
		String s = "";
		for (int i = 0; i < test.length; i++) {
			s += test[i];
		}
		while (unsorted) {
			bs.sort(test);
			String s1 = "";
			for (int i = 0; i < test.length; i++) {
				s += test[i];
			}
			if (s.equals(s1)) {
				unsorted = false;
			}
			for (int i = 0; i < test.length; i++) {
				s += test[i];
			}
		}
		System.out.println(s);
	}

	private void sort(int[] i) {
		for (int j = 1; j < i.length; j++) {
			if (i[j] < i[j - 1]) {
				int t = i[j - 1];
				i[j - 1] = i[j];
				i[j] = t;
			}
		}
	}
}
