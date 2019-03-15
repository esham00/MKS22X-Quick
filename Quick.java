import java.util.*;
public class Quick {
    public static int partition(int[] data, int start, int end) {
	Random rand = new Random();
	int a = Math.abs(rand.nextInt()%(end - start+1))+ start;
	//System.out.println(data[a]);
	int old = data[start];
	int index = start;
	data[start] = data[a];
	data[a] = old;
	if (end != start) {
	    start++;
	}
	//System.out.println(data[index]);
	while(start < end) {
	    // System.out.println(Arrays.toString(data));
	    //System.out.println("old start, old end: " + start + ", " + end);
	    if (data[start] < data[index]) {
		start++;
	    } else {
		old = data[start];
		data[start] = data[end];
		data[end] = old;
		end--;
	    }
	    //System.out.println("new start, new end: " + start + ", " + end);
	}
	if (data[start] > data[index]) {
	    old = data[start-1];
	    data[start-1] = data[index];
	    data[index] = old;
	    //System.out.println(Arrays.toString(data));
	    return start-1;
	} else {
	    old = data[start];
	    data[start] = data[index];
	    data[index] = old;
	    //System.out.println(Arrays.toString(data));

	    return start;
       }
    }
    public static String toString(int[] data){
	String output = "";
	for(int i = 0; i < data.length; i++) {
	    output += data[i] + " ";
	}
	return output;
    }
    public static String toString(int[] data, int start, int end) {
	String output = "";
	for(int i = start; i <= end; i++) {
	    output += data[i] + " ";
	}
	return output;
    }
    public static int quickSelect(int[] data, int k) {
	int start = 0;
	int end = data.length-1;
	// System.out.println(toString(data, 0, data.length-1));
	int value = partition(data, start, end);
	// System.out.println(toString(data, 0, data.length-1));
	while (value != k) {
	    if (value < k) {
		start = value;
	    } else {
		end = value;
	    }
	    value = partition(data, start, end);
	    // System.out.println(data[start] + " , " + data[end]);
	    // System.out.println(toString(data, 0, data.length-1));

	}
	//System.out.println(k + " vs. " +  value);
	return data[value];
    }
    public static void quicksortH(int[] data, int start, int end) {
	if (start >= end) {
	    //System.out.println("Start: " + start + ", End: " + end);
	    //System.out.println(toString(data,start,end));
	    return;
	} else {
	    //System.out.println("Start: " + start + ", End: " + end);
	    //System.out.println(toString(data,start,end));
	    int pivot = partition(data, start, end);
	    //System.out.println(toString(data, start, end));
	    //System.out.println(toString(data, start, end));
	    quicksortH(data, start, pivot-1);
	    quicksortH(data, pivot+1, end);
	}
    }
    public static void quicksort(int[] data) {
	quicksortH(data, 0, data.length-1);
    }
    public static void main(String[] args) {
    	//int[] data = new int[] {4,6,3,8, 2, 999, 1,6,999,5,7};
    	// System.out.println(partition(data, 1, data.length-1));
    	// System.out.println(toString(data));
    	//System.out.println(quickSelect(data, 3));
    	//System.out.println(partition(data, 0, data.length-1));
        //System.out.println(toString(data,0,data.length-1));
    	//System.out.println(quickSelect(data, 5));
        //System.out.println(quickSelect(data, 2));
        //System.out.println(toString(data));
	//quickSort(data, 0, data.length-1);
	//System.out.println(Arrays.toString(data));
	System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
	int[]MAX_LIST = {1000000000,500,10};
	for(int MAX : MAX_LIST){
	    for(int size = 31250; size < 2000001; size*=2){
		long qtime=0;
		long btime=0;
		//average of 5 sorts.
		for(int trial = 0 ; trial <=5; trial++){
		    int []data1 = new int[size];
		    int []data2 = new int[size];
		    for(int i = 0; i < data1.length; i++){
			data1[i] = (int)(Math.random()*MAX);
			data2[i] = data1[i];
		    }
		    long t1,t2;
		    t1 = System.currentTimeMillis();
		    quicksort(data2);
		    t2 = System.currentTimeMillis();
		    qtime += t2 - t1;
		    t1 = System.currentTimeMillis();
		    Arrays.sort(data1);
		    t2 = System.currentTimeMillis();
		    btime+= t2 - t1;
		    if(!Arrays.equals(data1,data2)){
			System.out.println("FAIL TO SORT!");
			System.exit(0);
		    }
		}
		System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
	    }
	    System.out.println();
	}
    }

}
