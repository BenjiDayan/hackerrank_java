package main.java.minimum_swaps_2;

import java.io.*;
import java.util.*;

// Pair class
class Pair<U, V>
{
    public final U first;   	// first field of a Pair
    public final V second;  	// second field of a Pair

    // Constructs a new Pair with specified values
    private Pair(U first, V second)
    {
        this.first = first;
        this.second = second;
    }

    @Override
    // Checks specified object is "equal to" current object or not
    public boolean equals(Object o)
    {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Pair<?, ?> pair = (Pair<?, ?>) o;

        // call equals() method of the underlying objects
        if (!first.equals(pair.first))
            return false;
        return second.equals(pair.second);
    }

    @Override
    // Computes hash code for an object to support hash tables
    public int hashCode()
    {
        // use hash codes of the underlying objects
        return 31 * first.hashCode() + second.hashCode();
    }

    @Override
    public String toString()
    {
        return "(" + first + ", " + second + ")";
    }

    // Factory method for creating a Typed Pair immutable instance
    public static <U, V> Pair <U, V> of(U a, V b)
    {
        // calls private constructor
        return new Pair<>(a, b);
    }
}

public class Solution {

    static int minimumSwaps(int[] arr) {
        List<Integer> seen = new ArrayList<Integer>;
        for (int i1=0; i1 < arr.length; i1++) {
            int index = Collections.binarySearch(seen, i1+1);
            if (index > 0) {
                seen = seen.add(index, arr[i1]);
            }
        }

        int[] output = new int[arr.length];
        for (int i=0; i<arr.length; i++) {
            output[i] = seen.get(i).intValue();
        }
        return output
    }

    // Gives index behind which to insert
    static int binary_insertion_point (int[] arr) {

    }

//    // Complete the minimumSwaps function below.
//    static int minimumSwaps(int[] arr) {
//        System.out.println("Hi");
//        int length = arr.length;
////        while (true) {
////
////        }
//
////        for (int i=0; i < length; i++) {
////            System.out.println(arr[i]);
////        }
//        Pair<Integer[], Integer> my_pair = first_sort(arr);
//        int[] temp_arr = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(my_pair.first[i]);
//            //temp_arr[i] = my_pair.first[i];
//        }
//        int final_swaps_made = my_pair.second;
//        boolean touched = false;
//        for (int i = 0; i < arr.length; i++) {
//            if (my_pair.first[i] != i + 1) {
//                final_swaps_made++;
//                touched = true;
//            }
//        }
//        if (touched) {
//            final_swaps_made--;
//        }
//        System.out.println("num_swaps: " + Integer.toString(final_swaps_made));
//        return final_swaps_made;
//    }


    static Pair<Integer[], Integer> first_sort(int[] arr) {
        int swaps_made = 0;
        int[] new_arr = arr.clone();
//        List<Integer> intList = new ArrayList<Integer>();
//        for (int i=0; i<arr.length; i++) {
//            intList.add(arr[i]);
//        }
        for (int start_index = 0; start_index < arr.length; start_index++) {
            // no need to swap
            if (new_arr[start_index] == start_index + 1) {
                start_index++;
                continue;
            }
            // See if can do simple swap
            if (new_arr[new_arr[start_index] - 1] == start_index + 1) {
                new_arr[new_arr[start_index] - 1] = new_arr[start_index];
                new_arr[start_index] = start_index + 1;
                swaps_made++;
            }
            start_index++;
        }
        Integer[] out_arr = Arrays.stream( new_arr ).boxed().toArray( Integer[]::new );
        Integer swaps_made_out = new Integer(swaps_made);
        Pair<Integer[], Integer> output = Pair.of(out_arr, swaps_made_out);
        return (output);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
