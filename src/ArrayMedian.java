
public class ArrayMedian {

	public static void main(String[] args) {
		
		System.out.println("median of two arrays is "+findMedianSortedArrays(new int[] {4,5,6,8,9} , new int[] {}));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i = 0, j = 0, sum =0;
        while ( i < len1 || j < len2){
            if(len1!=0 && i != len1){
                sum = sum + nums1[i];
                i++;
            }   
            if (len2!=0 && j!= len2){
                sum = sum + nums2[j];
                j++;
            }
            
        }
        return (double)sum/(len1+len2);
    }
}
