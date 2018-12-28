import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestElementInArr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int arr[] = {0,0,1,2,3,3,4,7,7,8};
		int arr[] = {9,7,1,5,3,10};
		KClosestElementInArr obj = new KClosestElementInArr();
		obj.printList(obj.findClosestElements(arr,4,3));
		System.out.println(" Another method ");
		//obj.printList(obj.findClosestElements1(arr,3,5));
		System.out.println(" Another method ");
		//obj.printList(obj.tryanotherMethod(arr,3,5));
	}
	public void printList(List<Integer> l) {
		for(int i : l) {
			System.out.println(" elements "+i);
		}
	}
	public List<Integer> tryanotherMethod(int[] arr, int k, int x){
		List<Integer> ans = new ArrayList<>(); 
		for(int i : arr) {
			 ans.add(i);
		 }
		 
		 Collections.sort(ans, (a,b) -> a == b ? a - b : Math.abs(a-x) - Math.abs(b-x));
	     ans = ans.subList(0, k);
	     Collections.sort(ans);
	     return ans;
	}
	public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        // maxHeap, sort descendingly according to diff to x
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (a, b) -> Math.abs(x - b) == Math.abs(x - a) ? b - a : Math.abs(x - b) - Math.abs(x - a)
        );
        // each time, if we have better option, delete num with max diff from x, and insert the new num
        for (int num: arr) {
            maxHeap.offer(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        // convert heap back to List<Integer> and sort them to get the original order
        List<Integer> res = new ArrayList(maxHeap);
        Collections.sort(res);
        return res;
    }
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                int d1 = getAbsoluteDistance(a,x);
                int d2 = getAbsoluteDistance(b,x);
                System.out.println("a: "+a +" b: "+b +" d1:" + d1 + " d2 :"+ d2);
                return (d2==d1) ? b-a : d2-d1 ;
            }
        });
        
        for(int i = 0 ; i <arr.length ; i++){
            q.offer(arr[i]);
            System.out.println("added to q "+arr[i]);
            if(i+1> k) {
            	System.out.println("Removed from the q "+q.peek());
                q.poll();   
            }
        }
        List<Integer> ans = new ArrayList<Integer>(q);
        Collections.sort(ans);
        return ans;
    }
    public int getAbsoluteDistance(int a, int x){
        return Math.abs(x-a);
    }

}
