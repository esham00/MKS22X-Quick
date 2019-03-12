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
		end = value;
	    } else {
		start = value;
	    }
	    value = partition(data, start, end);
	}
	return data[value];
    }
    public static void quickSort(int[] data, int start, int end) {
    }
    // public static void main(String[] args) {
    // 	int[] data = new int[] {4,3,2,1,6,5,7};
    // 	// System.out.println(partition(data, 1, data.length-1));
    // 	// System.out.println(toString(data));
    // 	System.out.println(quickSelect(data, 3));
    // 	System.out.println(toString(data));
    // 	System.out.println(quickSelect(data, 4));
    // 	System.out.println(toString(data));
    // 	System.out.println(quickSelect(data, 5));
    // 	System.out.println(quickSelect(data, 2));
    // 	System.out.println(toString(data));
    // }
        public static boolean test(int[] data, int k, int start, int end) {
        for (int i = start; i < end; i++) {
            if (i < k) {
                if (data[i] > data[k]) {
                    return false;
                }
            } else if (i > k) {
                if (data[i] < data[k]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] data1 = {10, 80, 30, 90, 40, 50, 70};
        //System.out.println(Arrays.toString(data1));
        int index1a = partition(data1, 1, 6);
        System.out.println("1a: " + test(data1, index1a,1,6));
        //System.out.println(Arrays.toString(data1) + " "+index1a+"\n");
        //System.out.println(Arrays.toString(data1));
        int index1b = partition(data1, 2, 5);
        System.out.println("1b: " + test(data1, index1b,2,5));
        //System.out.println(Arrays.toString(data1) + " "+index1b+"\n");

        int[] data2 = {6, 3, 7, -1, 7, 4, 10, -21};
        //System.out.println(Arrays.toString(data2));
        int index2a = partition(data2, 2, 7);
        System.out.println("2a: " + test(data2, index2a,2,7));
        //System.out.println(Arrays.toString(data2) + " " + index2a+"\n");
        //System.out.println(Arrays.toString(data2));
        int index2b = partition(data2, 1, 4);
        System.out.println("2b: " + test(data2, index2b,1,4));
        //System.out.println(Arrays.toString(data2) + "\n");

        int[] data3 = {78};
        //System.out.println(Arrays.toString(data3));
        int index3 = partition(data3, 0, 0);
        System.out.println("3: " + test(data3, index3,0,0));
        //System.out.println(Arrays.toString(data3) + "\n");

        int[] data4 = {3, 1};
        int index4 = partition(data4, 0, 1);
        //System.out.println(Arrays.toString(data4));
        System.out.println("4: " + test(data4, index4,0,1));
        //System.out.println(Arrays.toString(data4) + "\n");

        for (int i = 0; i < 100; i++) {
            try {
                Random gen = new Random();
                int[] test = new int[i * 1000 + 1];
                for (int j = 0; j < test.length; j++) {
                    test[j] = gen.nextInt();
                }
                int start = Math.abs(gen.nextInt()) % test.length;
                int end = start + Math.abs(gen.nextInt()) % (test.length - start);
                //System.out.println(start + ", " + end);
                //System.out.println(Arrays.toString(test));
                int index = partition(test, start, end);
                if (!test(test, index,start,end)) {
                    System.out.print("FAILURE ON LENGTH " + (i * 1000 + 1));
                    System.exit(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.print("FAILURE ON LENGTH " + (i * 1000 + 1));
                System.exit(1);
            }
        }
        System.out.println("R: SUCCESS"); //R for random
    }

}














