package testio.com;

public class sort {
	public static void main(String[] args) {
		int a[] = { 6,2,6,1,7,3,9 };
		for (int i = 0; i<= a.length - 2; i++) {
			int max = a[0];
			int index = 0;
			for (int j = 1; j <= a.length - i - 1; j++) {
				if (a[j]>max) {
					max = a[j];
					index = j;
				}
			}
			if (index != a.length - i - 1) {
				int temp = a[index];
				a[index] = a[a.length - i - 1];
				a[a.length - i - 1] = temp;
			}
		}
		
		for (int i =0;i<a.length;i++) {
			System.out.println(a[i]);
		}
	}
}