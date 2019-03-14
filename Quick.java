import java.util.*;
public class Quick {
    public static int partition(int[] data, int start, int end) {
	Random rand = new Random();
	int a = Math.abs(rand.nextInt()%(end+1));
	// System.out.println(data[a]);
	int old = data[start];
	int index = start;
	data[index] = data[a];
	data[a] = old;
	if (end != start) {
	    start++;
	}
	while(start < end) {
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
	    return start-1;
	} else {
	    old = data[start];
	    data[start] = data[index];
	    data[index] = old;
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
    public static void quickSort(int[] data, int start, int end) {
	if (start >= end) {
	    return;
	} else {
	    int pivot = partition(data, start, end);
	    //System.out.println("Start: " + start + ", End: " + end);
	    //System.out.println(toString(data, start, end));
	    //System.out.println(toString(data, start, end));
	    quickSort(data, start, pivot-1);
	    quickSort(data, pivot + 1, end);
	}
    }
    public static void main(String[] args) {
    	int[] data = new int[] {4,6,3,8, 2, 999, 1,6,999,5,7};
    	// System.out.println(partition(data, 1, data.length-1));
    	// System.out.println(toString(data));
    	//System.out.println(quickSelect(data, 3));
    	//System.out.println(partition(data, 0, data.length-1));
        //System.out.println(toString(data,0,data.length-1));
    	//System.out.println(quickSelect(data, 5));
        //System.out.println(quickSelect(data, 2));
        //System.out.println(toString(data));
	quickSort(data, 0, data.length-1);
	System.out.println(toString(data));
    }
}
