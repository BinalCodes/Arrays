
/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * Solution
 * Take minimum size of two array. Possible number of partitions are from 0 to m in m size array.
 * Try every cut in binary search way. When you cut first array at i then you cut second array at (m + n + 1)/2 - i
 * Now try to find the i where a[i-1] <= b[j] and b[j-1] <= a[i]. So this i is partition around which lies the median.
 *
 * Time complexity is O(log(min(x,y))
 * Space complexity is O(1)
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * https://discuss.leetcode.com/topic/4996/share-my-o-log-min-m-n-solution-with-explanation/4
 */
public class MedianTwoSortedArrays {

	public static void main(String[] args) {
		int[] x = {1, 3, 8, 9, 15};
        int[] y = {7, 11, 19, 21, 18, 25};
        System.out.println("Median of two sorted arrays is "+findMedianOfTwoSortedArrays(x,y));

	}
	public static double findMedianOfTwoSortedArrays( int[] input1, int[] input2) {
		
		if(input1.length > input2.length) {
			return findMedianOfTwoSortedArrays (input2, input1);
		}
		int x = input1.length; //shortest array
		int y = input2.length;
		int low = 0;
		int high = x;
		while (low <= high) {
			int partitionX = (high + low)/2;
			int partitionY = ((x + y +1)/2) - partitionX; // (x  + y + 1/2 ) - partitionX
			
			int maxLeftX = (partitionX == 0 )? Integer.MIN_VALUE : input1[partitionX-1];
			int minRightX = (partitionX == x)? Integer.MAX_VALUE : input1[partitionX];
			
			int maxLeftY = (partitionY == 0 )? Integer.MIN_VALUE : input2[partitionY-1];
			int minRightY = (partitionY == y)? Integer.MAX_VALUE : input2[partitionY];
			
			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				// if merged elements length is even then median is Avg(max(maxLeftX,maxLeftY), min (minRightX,minRIghtY))
				if((x + y )%2 == 0)
					return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
				// if odd then median is usually the middle element and even then median is avg of middle two elements
				return Math.max(maxLeftX, maxLeftY);
			}
			else if (maxLeftX > minRightY) {
				high = partitionX -1;
			}
			else {
				low = partitionX +1 ;
			}
		}
		throw new IllegalArgumentException(); 
	}
}
