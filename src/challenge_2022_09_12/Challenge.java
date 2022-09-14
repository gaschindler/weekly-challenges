package challenge_2022_09_12;

public class Challenge {

	public static void main(String[] args) {
		System.out.println("----- reorderDigits() Tests -----");
		
		System.out.print("\n");
		
		System.out.println("----- canPartition() Tests -----");
		System.out.println(canPartition(new int[] {2, 8, 4, 1}));
		System.out.println(canPartition(new int[] {-1, -10, 1, -2, 20}));
		System.out.println(canPartition(new int[] {-1, -20, 5, -1, -2, 2}));
	}
	
	public static int[] reorderDigits(int[] numbers, String method) {
		return null;
	}
	
	public static boolean canPartition(int[] numbers) {
		int preProduct = 1;
		int postProduct = 1;
		
		for (int i = 1; i < numbers.length; i++) {
			postProduct *= numbers[i];
		}
		
		if (postProduct == numbers[0]) {
			return true;
		}
		
		for (int i = 1; i < numbers.length; i++) {
			preProduct *= numbers[i - 1];
			postProduct /= numbers[i];
			
			if ((preProduct * postProduct) == numbers[i]) {
				return true;
			}
		}
		
		return false;
	}
	
}
