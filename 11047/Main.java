import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int arr[] = new int[n];	
		
		int K = input.nextInt();
		
		for (int i = 0; i < n; i++)
			arr[i] = input.nextInt();
		n--;
		
		int sum = 0;
		int count = 0;

		while (n != -1) {
			if (arr[n] > K || sum + arr[n] > K)
				n--;
			else {
				if (sum + arr[n] < K) {
					sum = sum + arr[n];
					count ++;
				}
				else if(sum+arr[n]==K) {
					count ++;
					break;
				}
			}
		}
		System.out.print(count);

	}

}


