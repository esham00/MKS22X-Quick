import java.util.*;
public class Quick {
    public static int partition(int[] data, int start, int end) {
	Random rand = new Random();
	int a = Math.abs(rand.nextInt()%data.length);
	System.out.println(data[a] + " Random Index:" + a);
	int old = data[0];
	data[0] = data[a];
	data[a] = old;
	while(start < end) {
	    System.out.println("old start, old end: " + start + ", " + end);
	    if (data[start] < data[0]) {
		start++;
	    } else {
		old = data[start];
		data[start] = data[end];
		data[end] = old;
		end--;
	    }
	    System.out.println("new start, new end: " + start + ", " + end);
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
    public static void main(String[] args) {
	int[] data = new int[] {999,4,1,0,3,2};
	System.out.println(partition(data, 1, data.length-1));
	System.out.println(toString(data));
    }
}
