
public class RotateArray {

	public static void main(String[] args) {
		int [] arr = {1,2,3,4,5,6};
		int order = 3 ; //order by which to rotate this array 
		// expected output int[] arr = {4,5,6,1,2,3}
		if (null == arr)
			return;
		if (order > arr.length)
			order = order % arr.length;
		int lenOfFirstPart = arr.length - order;
		reverse ( arr,0,lenOfFirstPart-1);
		reverse (arr, lenOfFirstPart , arr.length-1);
		reverse (arr, 0,arr.length-1);
		for(int i =0 ;i< arr.length ; i++)
			System.out.println("Reversed array is "+arr[i]);
		
	}
	
	public static void reverse (int[] arr ,int left, int right) {
		while (left< right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left ++;
			right --;
		}
	}

}
