package merge;

import java.util.Arrays;

public class Main {

	public void solution(int [] numbers){
		mergeSort(numbers);
		System.out.println("Solution: " + Arrays.toString(numbers));
	}

	private void mergeSort(int [] numbers){
		mergeSort(numbers, 0, numbers.length - 1);
	}

	private void mergeSort(int[] numbers, int left, int right){
		if ( left < right ){
			int center = ( left + right) / 2;
			mergeSort(numbers, left, center);
			mergeSort(numbers, center+1, right);
			merge(numbers, left, right, center);
		}
	}

	private void merge(int[] numbers, int left, int right, int center){

		int i = left;
		int j = center + 1;
		int k = left;

		int[] helper = new int[numbers.length];
		for (int c = left; c <= right; c++)
			helper[c] = numbers[c];

		while ( i <= center && j <= right)
			if ( helper[i] <= helper[j] )
				numbers[k++] = helper[i++];
			else
				numbers[k++] = helper[j++];

		while ( i <= center )
			numbers[k++] = helper[i++];
		
		while ( j <= right)
			numbers[k++] = helper[j++];
		
	}

	public static void main(String[] args) {
		int [] numbers = {27,10,12,32,34,16,15,31};
		System.out.println("Input: " + Arrays.toString(numbers));
		new Main().solution(numbers);
	}

}
