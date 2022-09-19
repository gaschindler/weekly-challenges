package challenge_2022_09_19;

public class Challenge {

	public static void main(String[] args) {
		System.out.println("----- secondMax() Tests -----");
		secondMax(3, new int[][] {new int[] {1, 2, 3}, new int[] {10, 15, 5}, new int[] {100, 999, 500}});
		System.out.println("-----");
		secondMax(1, new int[][] {new int[] {6, 5, 4}});
		
		System.out.print("\n");
		
		System.out.println("----- sumDigits() Tests -----");
	}
	
	public static void secondMax(int N, int[][] tuples) {
		for (int i = 0; i < N; i++) {
			int[] workingTuple = tuples[i];
			
			for (int j = 0; j < workingTuple.length; j++) {
				int minIndex = j;
				
				for (int k = j + 1; k < workingTuple.length; k++) {
					if (workingTuple[k] < workingTuple[minIndex]) {
						minIndex = k;
					}
				}
				
				int temp = workingTuple[j];
				workingTuple[j] = workingTuple[minIndex];
				workingTuple[minIndex] = temp;
			}
			
			System.out.println(workingTuple[1]);
		}
	}
	
}
