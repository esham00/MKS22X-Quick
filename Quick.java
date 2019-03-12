import java.util.*;
public class Quick {
    public static int partition(int[] data, int start, int end) {
	Random rand = new Random();
	int a = Math.abs(rand.nextInt()%data.length);
	//System.out.println(data[a] + " Random Index:" + a);
	int old = data[0];
	data[0] = data[a];
	data[a] = old;
	while(start < end) {
	    //System.out.println("old start, old end: " + start + ", " + end);
	    if (data[start] < data[0]) {
		start++;
	    } else {
		old = data[start];
		data[start] = data[end];
		data[end] = old;
		end--;
	    }
	    //System.out.println("new start, new end: " + start + ", " + end);
	}
	if (data[start] > data[0]) {
	    old = data[start-1];
	    data[start-1] = data[0];
	    data[0] = old;
	    return start-1;
	} else {
	    old = data[start];
	    data[start] = data[0];
	    data[0] = old;
	    return start;
       }
    }
    public static String toString(int[] data) {
	String output = "";
	for(int i = 0; i < data.length; i++) {
	    output += data[i] + " ";
	}
	return output;
    }
    public static int quickSelect(int[] data, int k) {
	int start = 1;
	int end = data.length-1;
	int value = partition(data, start, end);
	while (value != k) {
	    if (value < k) {
		end = end/2;
	    } else {
		start = end/2;
	    }
	    value = partition(data, start, end);
	}
	return data[value];
    }
    public static void main(String[] args) {
	int[] data = new int[] {4,3,2,1,6,5,7};
	// System.out.println(partition(data, 1, data.length-1));
	// System.out.println(toString(data));
	System.out.println(quickSelect(data, 3));
	System.out.println(toString(data));
	System.out.println(quickSelect(data, 4));
	System.out.println(quickSelect(data, 5));
	System.out.println(quickSelect(data, 2));
	System.out.println(toString(data));
    }
}
