package challenge_2022_09_12;

import java.util.Arrays;

public class Challenge {

	public static void main(String[] args) {
		System.out.println("----- reorderDigits() Tests -----");
		System.out.println(Arrays.toString(reorderDigits(new int[] {515, 341, 98, 44, 211}, "asc")));
		System.out.println(Arrays.toString(reorderDigits(new int[] {515, 341, 98, 44, 211}, "desc")));
		System.out.println(Arrays.toString(reorderDigits(new int[] {63251, 78221}, "asc")));
		System.out.println(Arrays.toString(reorderDigits(new int[] {63251, 78221}, "desc")));
		System.out.println(Arrays.toString(reorderDigits(new int[] {1, 2, 3, 4}, "asc")));
		System.out.println(Arrays.toString(reorderDigits(new int[] {1, 2, 3, 4}, "desc")));
		
		System.out.print("\n");
		
		System.out.println("----- canPartition() Tests -----");
		System.out.println(canPartition(new int[] {2, 8, 4, 1}));
		System.out.println(canPartition(new int[] {-1, -10, 1, -2, 20}));
		System.out.println(canPartition(new int[] {-1, -20, 5, -1, -2, 2}));
	}
	
	public static int[] reorderDigits(int[] numbers, String method) {
		for (int i = 0; i < numbers.length; i++) {
			char[] currentNumber = String.valueOf(numbers[i]).toCharArray();
			
			// selection sort on currentNumber
			if (method.equals("asc")) {
				for (int j = 0; j < currentNumber.length; j++) {
					int minIndex = j;
					
					for (int k = j + 1; k < currentNumber.length; k++) {
						if (currentNumber[k] < currentNumber[minIndex]) {
							minIndex = k;
						}
					}
					
					char temp = currentNumber[j];
					currentNumber[j] = currentNumber[minIndex];
					currentNumber[minIndex] = temp;
				}
			} else if (method.equals("desc")) {
				for (int j = 0; j < currentNumber.length; j++) {
					int maxIndex = j;
					
					for (int k = j + 1; k < currentNumber.length; k++) {
						if (currentNumber[k] > currentNumber[maxIndex]) {
							maxIndex = k;
						}
					}
					
					char temp = currentNumber[j];
					currentNumber[j] = currentNumber[maxIndex];
					currentNumber[maxIndex] = temp;
				}
			} else {
				return null;
			}
			
			numbers[i] = Integer.parseInt(new String(currentNumber));
		}
		
		return numbers;
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
