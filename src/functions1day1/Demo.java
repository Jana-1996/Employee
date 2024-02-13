package functions1day1;

public class Demo {
	public int findMax(int[] a) {
		int max = a[0];
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		return max;
	}

	public void findEven(int[] b) {
		for (int ab : b) {
			if (ab % 2 == 0) {
				System.out.println(ab);
			}
		}
	}
}
