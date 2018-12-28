import java.util.Arrays;
/*
 * we implement heap using arrays here
 * left child = (parentIndex *2 )+1
 * right child = (parentIndex * 2) +2
 * parent index = (index -1)/2
 */
public class MaxHeapImplementation {
	int capacity ; // the capacity to which heap is initialized
	int size; // points to the current element in the heap
	int[] items;
	public void expandHeap() {
		if (size == capacity) {
			items = Arrays.copyOf(items, capacity*2);
			capacity *= capacity;
		}
	}
	public int getLeftChildIndex (int pIndex) {
		return (pIndex * 2) +1;
	}
	public int getRightChildIndex (int pIndex) {
		return (pIndex * 2) +2;
	}
	public int getParentIndex (int index) {
		return (index - 1) / 2;
	}
	
	public boolean hasLeftChild(int parentIndex) {
		return getLeftChildIndex(parentIndex) < size;
	}
	public boolean hasRightChild(int parentIndex) {
		return getRightChildIndex(parentIndex) < size;
	}
	public boolean hasParent(int index) {
		return getParentIndex(index) >=0;
	}
	
	public int getLeftChild(int index) {
		return (hasLeftChild(index) ? items[getLeftChildIndex(index)] : -1);
	}
	public int getRightChild (int index) {
		return (hasRightChild(index) ? items[getRightChildIndex(index)] : -1);
	}
	public int getParent (int index) {
		return (hasParent(index) ? items[getParent(index)] : -1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
}
