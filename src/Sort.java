import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Sort{


    public static void selectionSort(ArrayList<Integer> numbers){
        for(int i = 0; i < numbers.size(); i++){

            // Find the min value from index i to numbers.size()-1
            int minValue = Integer.MAX_VALUE;
            int minIndex = -1;
            for(int j = i; j < numbers.size(); j++){
                int currentValue = numbers.get(j);
                if(currentValue < minValue){
                    minValue = currentValue;
                    minIndex = j;
                }
            }

            // swap the values in i and minIndex
            numbers.set(minIndex, numbers.get(i));
            numbers.set(i, minValue);
        }
    }



    public static void main(String[] args){

        int numberOfValues = 10;
        int maxValue = 100;
//        int maxValue = Integer.MAX_VALUE;
        boolean printLists = true;

        long startTime;
        long endTime;
        long elapsedTime;


        /*** Setup unsorted data structure ***/

        startTime = System.currentTimeMillis();
        Random random = new Random();

        ArrayList<Integer> bigData = new ArrayList<>();
        for(int i = 0; i < numberOfValues; i++){
            bigData.add(random.nextInt(maxValue));
        }

        endTime = System.currentTimeMillis();
        elapsedTime = endTime - startTime;
        System.out.println("Building the data structure: " + elapsedTime + "ms\n");

        if(printLists){
            System.out.println("\nBefore Sorting:");
            System.out.println(bigData);
        }


        /*** Sort Timing ***/

        startTime = System.currentTimeMillis();

        selectionSort(bigData);
//        bigData = mergeSort(bigData);
//        Collections.sort(bigData);

        endTime = System.currentTimeMillis();
        elapsedTime = endTime - startTime;

        System.out.println("\nSort: " + elapsedTime + "ms");

        if(printLists){
            System.out.println("\nAfter sorting:");
            System.out.println(bigData);
        }

    }





    // Understanding Merge Sort is not required in CSE115

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> numbers){
        if(numbers.size() < 2){
            return numbers;
        }

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        int midpoint = numbers.size() / 2;

        for(int i = 0; i < numbers.size(); i++){
            if(i < midpoint){
                left.add(numbers.get(i));
            }else{
                right.add(numbers.get(i));
            }
        }

        return merge(mergeSort(left), mergeSort(right));
    }


    public static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right){
        ArrayList<Integer> merged = new ArrayList<>();
        int leftPointer = 0;
        int rightPointer = 0;

        while(true){

            if(leftPointer == left.size()){
                while(rightPointer < right.size()){
                    merged.add(right.get(rightPointer));
                    rightPointer++;
                }
                break;
            }

            if(rightPointer == right.size()){
                while(leftPointer < left.size()){
                    merged.add(left.get(leftPointer));
                    leftPointer++;
                }
                break;
            }

            if(left.get(leftPointer) < right.get(rightPointer)){
                merged.add(left.get(leftPointer));
                leftPointer++;
            }else{
                merged.add(right.get(rightPointer));
                rightPointer++;
            }

        }

        return merged;
    }

}
