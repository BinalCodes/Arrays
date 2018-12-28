/*
 * This class demonstrates min/Max Heap implementation through an array
 * Time complexity : 
 * insert : O(logN)
 * remove : O(logN)
 * 
 * 
 */
public class MinHeapAlgo {
	
	class Node{
		int key;
		public int getKey() {
			return key;
		}
		public void setKey(int key) {
			this.key = key;
		}
		Node(int key){
			this.key= key;
		}
	}
	class Heap{
		private Node[] heapArray;
		private int maxSize;
		private int currentSize;
		Heap(int maxSize){
			this.maxSize= maxSize;
			heapArray = new Node[maxSize];
			currentSize = 0;
		}
		public boolean isEmpty() {
			return currentSize ==0;
		}
		public boolean insert (int data) {
			if(currentSize == maxSize) {
				return false;
			}
			Node new_node = new Node(data);
			heapArray[currentSize] = new_node;
			trickleUp(currentSize++);
			return true;
		}
		public void trickleUp(int index) {
			int parent = (index -1)/2;
			Node bottom = heapArray[index];
			while(index >0 && heapArray[parent].getKey() < bottom.getKey()) {
				heapArray[index] = heapArray[parent]; 
				index = parent;
				parent = (parent -1)/2;
			}
			heapArray[index] = bottom;
		}
		public Node remove() throws Exception{
			Node root = heapArray[0];
			heapArray[0] = heapArray[--currentSize];
			trickleDown(0);
			return root;
		}
		public void trickleDown(int index) {
			int largerChild;
			
			Node top = heapArray[index];
			while (index < currentSize/2 ) {
					int leftChildIndex = 2*index +1;
					int rightChildIndex = leftChildIndex +1;
					if (rightChildIndex < currentSize && heapArray[rightChildIndex].getKey() > heapArray[leftChildIndex].getKey()) {
						largerChild = rightChildIndex;
					}
					else {
						largerChild = leftChildIndex;
					}
					//System.out.println("largerChildIndex "+largerChild + " top "+index);
					if(top.getKey() >= heapArray[largerChild].getKey()) {
						break;
					}
					heapArray[index] = heapArray[largerChild];
					index =largerChild;
					
			}
			heapArray[index] = top;
		}
		public void diplayHeap() {
			for(int i =0; i< currentSize ;i++) {
				System.out.println(" "+heapArray[i].getKey());
			}
		}
	}
	public static void main(String[] args) throws Exception {
		
		MinHeapAlgo algo = new MinHeapAlgo();
		Heap theHeap = algo.new Heap(31); // make a Heap; max size 31 boolean success;
		theHeap.insert(70); 
		theHeap.insert(40); 
		theHeap.insert(50); 
		theHeap.insert(20); 
		theHeap.insert(60); 
		theHeap.insert(100); 
		theHeap.insert(80); theHeap.insert(30); theHeap.insert(10); theHeap.insert(90);
		
		theHeap.insert(22);
		System.out.println("Heap after adding 22 is ");
		theHeap.diplayHeap();
		theHeap.remove();
		System.out.println("Heap after removing is ");
		theHeap.diplayHeap();
	}

}
