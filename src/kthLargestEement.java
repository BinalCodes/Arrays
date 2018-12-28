import java.util.Comparator;
import java.util.PriorityQueue;

public class kthLargestEement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrToSort = new int[] {32,23,54,3,2,7,19};
		//System.out.println("k sorted elements in an array are "+findKthLargest(arrToSort,3));
		System.out.println("k smallest elements in an array are "+findKthSmallest(arrToSort,3));
		
	}

	public static int findKthLargest(int[] nums, int k) {
	    PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
	    for(int i: nums){
	    	q.offer(i);
	    	System.out.println("added to q "+i +" with size "+q.size() +" and ");
	        if(q.size()>k){
	        	System.out.println("removed from queue "+q.peek() +" with size of queue "+q.size());
	            q.poll();  
	        }
	    }
	    System.out.println("the "+k +" large elements in the queue are ");
	    for(Integer n : q) {
	    	System.out.println(n);
	    }
	    return q.peek();
	}
	public static int findKthSmallest(int[] nums, int k) {
	    PriorityQueue<Integer> q = new PriorityQueue<Integer>(k, new Comparator(){
	    	// when compare or compareTo returns 1 then it swaps otherwise it doesnt
			@Override
			public int compare(Object o1, Object o2) {
				System.out.println("Number "+o2 +" o1: "+o1 +" o2-o1 "+((Integer) o2 - (Integer) o1));
				return (Integer) o2 - (Integer) o1;
			}
	    });
	    for(int i: nums){
	    	q.offer(i);
	    	System.out.println("added to q "+i);
	        if(q.size()>k){
	        	System.out.println("removed from queue "+q.peek() +" with size of queue "+q.size());
	            q.poll();  
	        }
	    }
	 
	    return q.peek();
	}
	public static void findKLargest(int[] nums , int k) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
		for (int i :nums){
			q.offer(i);
			if(q.size() > k) {
				if(i> q.peek()) {
					q.poll();
				}
			}
		}
	}
}
