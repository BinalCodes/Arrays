/*
 * Given an input array, the result should be product of all elements except for the current element
 */
public class ArrayProduct {

	public static void main(String[] args) {
		ArrayProduct obj = new ArrayProduct();
		int[] arr = {10,3,2,5,1};
		// result = {30,100,150,60,300}
		long[] res = obj.productOfElements(arr);
		for(long i : res)
			System.out.println(i);
	}

	public long[] productOfElements(int[] arr) {
		long ans =1;
		long[] res = new long[arr.length];
		for(int i : arr) {
			ans *= i;
		}
		for(int i=0 ;i <arr.length; i++) {
			if(arr[i] != 0)
				res[i] = ans /arr[i];
			else
				res[i] = ans;
		}
		return res;
	}
}
