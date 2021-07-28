
public class heap {

	private static final int k = 10; //Number of Children
	private static int heapSize; //Heap Size
	private static int[] arrayHeap; //Array heap is stored in
	
/**
 * 	Constructor : Makes Basic heap
 * @param size
 */
	public heap (int size) {
		heapSize = 0;
		//Creates heap with extra size, counteract Null argument
		arrayHeap = new int [size + 1]; 
	}
	
/**
 * Inserts Number into Heap
 * @param x
 */
	public static void insert(int x) {
		//Inserts x into next empty array
		arrayHeap[heapSize++] = x;
		//Fixes heap
		heapifyUp (heapSize -1);
	}

/**
 * Extracts Minimum, Deletes it
 * @return
 */
	public static int extractMin () {
		//Sets index to min
		int indexData = arrayHeap[0];
		//Delete what we are to extract
		delete(0);
		return indexData;
	}

/**
 * Deletes, then heapify down
 * @param index
 * @return
 */
	public static int delete (int index) {
		//Switching numbers, to eventually delete data at index 
		int indexData = arrayHeap[index];
		//Setting Max index to -1
		arrayHeap[index] = arrayHeap [heapSize - 1];
		heapSize--;
		//Fixes Heap
		heapifyDown(index);
		return indexData;
	}
	
/**
 * Fixes heap going Down
 * @param index
 */
	public static void heapifyDown(int index) {
		//Instantiating Child, using in future
		int child;
		//Creating temp variable to hold
		int temp = arrayHeap[index];
		
		//While index of child is less than heapsize
		while (indexOfKthChild(index, 1) < heapSize) {
			child = getMinChild (index);
			//If child is less than temp, Plug child into index
			if (arrayHeap[child] < temp) {
				arrayHeap [index] = arrayHeap[child];
			}
			else {break;}
			//Overall Swap
			index = child;
		}
		arrayHeap[index] = temp;
	}
	
/**
 * Fixes heap going up
 * @param childIndex
 */
	public static void heapifyUp (int childIndex) {
		int temp = arrayHeap[childIndex];
		//If child index is in the array, and less than parent; Child index less than parent
		while (childIndex > 0 && temp < arrayHeap[getParent(childIndex)]) {
			//Swap Child and parent Index
			arrayHeap[childIndex] = arrayHeap[getParent(childIndex)];
			//Swap child and parent data
			childIndex = getParent(childIndex);
		}
		arrayHeap[childIndex] = temp;
	}
	
/**
 * Gets Parent
 * @param index
 * @return
 */
	public static int getParent (int index) {
		return (index - 1)/k;
	}

/**
 * Gets Index of kth Child
 * @param i
 * @param m
 * @return
 */
	private static int indexOfKthChild (int i, int m) {
		return k * i + m;
	}

/**
 * Gets Min child (Aka best Child)
 * @param index
 * @return
 */
	public static int getMinChild (int index) {
		int best = indexOfKthChild (index, 1); //Best Child
		int d = 2;
		int position = indexOfKthChild (index, k);
		//While 2<= k, and indexofKthChild is less than heapSize (Out of bounds)
		while ((d <= k) && position < heapSize){
			if (arrayHeap[position] < arrayHeap[best]) {
				//Swap
				best = position; 
			}
			position = indexOfKthChild (index, d++);
		}
		return best;
	}

/**
 * Prints Heap, Used for testing heap
 */
	public void printTheHeap() {
		System.out.println("The heap =: ");
		for (int i = 0; i < heapSize; i++) {
			System.out.print(arrayHeap[i] + " ");
			System.out.print(", ");
		}
	}

}
