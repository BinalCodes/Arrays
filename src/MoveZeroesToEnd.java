import java.util.Arrays;

public class MoveZeroesToEnd {

	public static void main(String[] args) {
		int[] arr = {1,3,0,0,2,1,5,4,0,8,0};
		moveZeroesToEnd(arr);
		for(int i =0;i<arr.length ; i++) {
			System.out.println("Array after moving zeroes to end is "+arr[i]);
		}

	}
	public static void moveZeroesToEnd(int[] input) {
		int count = 0;
		for (int i=0; i < input.length ; i++){
			if(input[i]!= 0) {
				input[count++] = input[i];
			}
		}
		while(count< input.length)
			input[count++] = 0;
	}

}
