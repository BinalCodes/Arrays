import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given an array input check if the array rotated to 180 degrees is the same
 * input : {1,6,0,9,1} -> true
 * input : {1,7,1} --> false
 * @author binal
 *
 */
public class check180 {
	public static void main(String[] args) {
		int[] arr = {1,8,1};
		System.out.println("After rotating the array to 180 degrees it is "+ 
		(check180Rotation(arr) ? "same" :"not equal"));
		
	}
	public static boolean check180Rotation(int[] arr) {
		int arrLen = arr.length;
		Map<String,String> matcher = new HashMap<String,String>() {
			{
				put("0","0");
				put("1","1");
				put("8","8");
				put("6","9");
				put("9","6");
			}
		};
		boolean oddLength = (arrLen%2) != 0;
		if(oddLength && !(arr[arrLen/2] == 0  || arr[arrLen/2] == 8 )) {
			return false;
		}
		int arrMid = oddLength ? (arrLen/2)+1 : arrLen/2;
		int j = arrLen -1;
		for (int i =0; i < arrMid; i++, j--) {
			System.out.println("i "+i +" j "+ j +"arr[i] "+arr[i]+" arr[j] "+arr[j] );
			System.out.println("matcher "+matcher.get(arr[i]));
			if(!matcher.get(arr[i]).equals(arr[j])) {
				return false;	
			}
		}
		return true;
	}
}
