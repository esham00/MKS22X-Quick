import java.util.*;
public class Quick {
    //partition
    public static int partition(int[] data, int start, int end) {
	//random
	Random rand = new Random();
	//generating random index
	int a = Math.abs(rand.nextInt()%(end - start+1))+ start;
	//swapped chosen values
	int old = data[start];
	int index = start;
	data[start] = data[a];
	data[a] = old;
	if (end - start < 10) {
	    insertionsort(data, start, end, data[a], start);
	    return start;
	}
	//adding 1 to the start so it would go onto the next value to compare
	if (end != start) {
	    start++;
	}
	while(start < end) {
	    //compare if chosen value is more than the comparison value move onto the next value
	    if (data[start] <  data[index]) {
		start++;
	    } else if (data[start] == data[index]) {
		if (Math.abs(rand.nextInt()) % 2 == 1) {
		    start++;
		} else {
		    old = data[start];
		    data[start] = data[end];
		    data[end] = old;
		    end--;
		}
	    } else {
		//otherwise swap places at the end
		old = data[start];
		data[start] = data[end];
		data[end] = old;
		end--;
	    }
	}
	//if the index at start is larger than the chosen value then swap indices with the index 1 before the start
	if (data[start] > data[index]) {
	    old = data[start-1];
	    data[start-1] = data[index];
	    data[index] = old;
	    return start-1;
	} else {
	    //otherwise swap indices 
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
    //quickSelect
    public static int quickselect(int[] data, int k) {
	//start,end, index
	int start = 0;
	int end = data.length-1;
	int value = partition(data, start, end);
	//if the index is not k, then 
	while (value != k) {
	    //if the index is less than k then set start as the index
	    if (value < k) {
		start = value+1;
	    } else {
		//if the index is more than k then set end as the index
		end = value-1;
	    }
	    //update index
	    value = partition(data, start, end);
	}
	//finally at index is the proper value
	return data[value];
    }
    //quicksort
    public static void quicksortH(int[] data, int start, int end) {
	//if the start>= end return nothing
	if (start >= end) {
	    return;
	} else {
	    //set pivot as a random index
	    int pivot = partition(data, start, end);
	    //quicksort both sides of the pivot
	    quicksortH(data, start, pivot-1);
	    quicksortH(data, pivot+1, end);
	}
    }
    public static void quicksort(int[] data) {
	if (data.length == 0) {
	    return;
	}
	quicksortH(data, 0, data.length-1);
    }
    // public static void quicksortDutch(int[] data) {
    // 	quicksortDutchH(data, 0, data.length-1);
    // }
    // public static void quicksortDutchH(int[] data, int start, int end) {
    // 	if (start >= end) {
    // 	    return;
    // 	} else {
    // 	    int[] pivot = partitionDutch(data, start, end);
    // 	    System.out.println("lt: " + pivot[0] + " gt: " + pivot[1]);
    // 	    quicksortDutchH(data, start, pivot[0]-1);
    // 	    quicksortDutchH(data, pivot[1]+1, end);
    // 	}
    // }
    // public static int[] partitionDutch(int[] data, int start, int end) {
    // 	int lt = 0;
    // 	int gt = 0;
    // 	//random
    // 	Random rand = new Random();
    // 	//generating random index
    // 	int a = Math.abs(rand.nextInt()%(end - start+1))+ start;
    // 	//swapped chosen values
    // 	int old = data[start];
    // 	int index = start;
    // 	data[start] = data[a];
    // 	data[a] = old;
    // 	//adding 1 to the start so it would go onto the next value to compare
    // 	if (end != start) {
    // 	    start++;
    // 	}
    // 	while(start < end) {
    // 	    //compare if chosen value is more than the comparison value move onto the next value
    // 	    if (data[start] <  data[index]) {
    // 		start++;
    // 	    } else if (data[start] == data[index]) {
    // 		if (lt < start) {
    // 		    lt = start;
    // 		}
    // 		start++;
    // 	    } else {
    // 		//otherwise swap places at the end
    // 		old = data[start];
    // 		data[start] = data[end];
    // 		data[end] = old;
    // 		end--;
    // 	    }
    // 	}
    // 		//if the index at start is larger than the chosen value then swap indices with the index 1 before the start
    // 	if (data[start] > data[index]) {
    // 	    old = data[start-1];
    // 	    data[start-1] = data[index];
    // 	    data[index] = old;
    // 	    gt = start-1;
    // 	    return new int[]{lt,gt};
    // 	} else {
    // 	    //otherwise swap indices 
    // 	    old = data[start];
    // 	    data[start] = data[index];
    // 	    data[index] = old;
    // 	    gt = start;
    // 	    return new int[] {lt, gt};
    // 	}
    // }

    // //  public static void main(String[] args) {
    // //    int[] data = new int[] {4,6,3,8, 2, 999, 1,6,999,5,7};
    // // // 	// System.out.println(partition(data, 1, data.length-1));
    // // // 	// System.out.println(toString(data));
    // // // 	//System.out.println(quickSelect(data, 3));
    // // // 	//System.out.println(partition(data, 0, data.length-1));
    // // //     //System.out.println(toString(data,0,data.length-1));
    // // // 	//System.out.println(quickSelect(data, 5));
    // // //     //System.out.println(quickSelect(data, 2));
    // // //     //System.out.println(toString(data));
    // // 	System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
    // // 	int[]MAX_LIST = {1000000000,500,10};
    // // 	for(int MAX : MAX_LIST){
    // // 	    for(int size = 31250; size < 2000001; size*=2){
    // // 		long qtime=0;
    // // 		long btime=0;
    // // 		//average of 5 sorts.
    // // 		for(int trial = 0 ; trial <=5; trial++){
    // // 		    int []data1 = new int[size];
    // // 		    int []data2 = new int[size];
    // // 		    for(int i = 0; i < data1.length; i++){
    // // 			data1[i] = (int)(Math.random()*MAX);
    // // 			data2[i] = data1[i];
    // // 		    }
    // // 		    long t1,t2;
    // // 		    t1 = System.currentTimeMillis();
    // // 		    quicksort(data2);
    // // 		    t2 = System.currentTimeMillis();
    // // 		    qtime += t2 - t1;
    // // 		    t1 = System.currentTimeMillis();
    // // 		    Arrays.sort(data1);
    // // 		    t2 = System.currentTimeMillis();
    // // 		    btime+= t2 - t1;
    // // 		    if(!Arrays.equals(data1,data2)){
    // // 			System.out.println("FAIL TO SORT!");
    // // 			System.exit(0);
    // // 		    }
    // // 		}
    // // 		System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    // // 	    }
    // // 	    System.out.println();
    // // 	}
    // // }
    // // private static final int INCREASE = 0;
    // // private static final int DECREASE = 1;
    // // private static final int STANDARD = 2;
    // // private static final int SMALL_RANGE = 3;

    // // private static String name(int i){
    // // 	if(i==INCREASE)return "Increassing";
    // // 	if(i==DECREASE)return "Decreassing";
    // // 	if(i==STANDARD)return "Normal Random";
    // // 	if(i==SMALL_RANGE)return "Random with Few Values";
    // // 	return "Error categorizing array";

    // // }

    // // private static int create(int min, int max){
    // // 	return min + (int)(Math.random()*(max-min));
    // // }

    // // private static int[]makeArray(int size,int type){
    // // 	int[]ans =new int[size];
    // // 	if(type == STANDARD){
    // // 	    for(int i = 0; i < size; i++){
    // // 		ans[i]= create(-1000000,1000000);
    // // 	    }
    // // 	}
    // // 	else if(type == INCREASE){
    // // 	    int current = -5 * size;
    // // 	    for(int i = 0; i < size; i++){
    // // 		ans[i]= create(current,current + 10);
    // // 		current += 10;
    // // 	    }
    // // 	}
    // // 	else if(type == DECREASE){
    // // 	    int current = 5 * size;
    // // 	    for(int i = 0; i < size; i++){
    // // 		ans[i]= create(current,current + 10);
    // // 		current -= 10;
    // // 	    }
    // // 	}
    // // 	else if(type == SMALL_RANGE){
    // // 	    for(int i = 0; i < size; i++){
    // // 		ans[i]= create(-5,5);
    // // 	    }
    // // 	}
    // // 	else{
    // // 	    ans = new int[0];//empty is default
    // // 	}
    // // 	return ans;
    // // }
    public static void insertionsort(int[] data, int lo, int hi, int old, int index) {
    	for(int i = lo+1; i < hi+1; i++) {
    	    int current = data[i];
    	    int j = i-1;
    	    while(j >= lo && current < data[j]) {
    		if (current == old) {
    		    index = j;
    		}
    		data[j+1] = data[j];
    		j--;
    	    }
    	    if (current == old) {
    		index = j+1;
    	    }
    	    data[j+1] = current;
    	}
    }
    public static void insertionsort(int[] data) {
    	for(int i = 1; i < data.length; i++) {
    	    int current = data[i];
    	    int j = i-1;
    	    while(j >= 0 && current < data[j]) {
    		data[j+1] = data[j];
    		j--;
    	    }
    	    data[j+1] = current;
    	}
    }
	

    // public static void main(String[]args){
    // 	if(args.length < 2)return;
    
    // 	int size =  Integer.parseInt(args[0]);
    // 	int type =   Integer.parseInt(args[1]);

    // 	int [] start = makeArray(size,type);
    // 	int [] result = Arrays.copyOf(start,start.length);
    // 	Arrays.sort(result);
    
    // 	long startTime = System.currentTimeMillis();
    // 	/*
    // 	 * Test your sort here //yoursort(start);
    // 	 * Add code to switch which sort is tested by changing one of the args!
    // 	 */
    // 	long elapsedTime = System.currentTimeMillis() - startTime;
    // 	if(Arrays.equals(start,result)){
    // 	    System.out.println("PASS Case "+name(type)+"\t array, size:"+start.length+"\t"+elapsedTime/1000.0+"sec ");
    // 	}else{
    // 	    System.out.println("FAIL ! ERROR ! "+name(type)+" array, size:"+size+"  ERROR!");
    // 	}
    // }
}
