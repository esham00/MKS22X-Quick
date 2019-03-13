import java.util.*;
public class Quick {
    public static int partition(int[] data, int start, int end) {
	Random rand = new Random();
	int a = Math.abs(rand.nextInt()%(end+1));
	// System.out.println(data[a]);
	int old = data[0];
	data[0] = data[a];
	data[a] = old;
	if (start == 0 && end != 0) {
	    start = 1;
	}
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
    }
    public static void main(String[] args) {
    	int[] data = new int[] {4,3,8, 999, 2,1,6,5,7, 999, 10};
    	// System.out.println(partition(data, 1, data.length-1));
    	// System.out.println(toString(data));
    	System.out.println(quickSelect(data, 3));
    	//System.out.println(partition(data, 0, data.length-1));
        System.out.println(toString(data,0,data.length-1));
    	//System.out.println(quickSelect(data, 5));
        //System.out.println(quickSelect(data, 2));
        //System.out.println(toString(data));
    }
}
