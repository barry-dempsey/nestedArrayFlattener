package com.dempsey.nestedarray;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class NestedArray {
	Object[] objArray;
	
	public NestedArray() {
		/*
		 * sample nested array is [[1,2,[3]],4]
		 * with 2 elements
		 */
		objArray = new Object[2];
	}
	
	/**
	 * Construct the nested array 
	 * @return the flattened array
	 */
	public List<Integer> constructTheNestedArray() {
		/*
		 * within the first element there is 
		 * a nested array of 3 elements
		 */
		objArray[0] = new Object[3];
		/*
		 * the zero'th index of the nested array
		 * contains Integer object of value 1 and
		 * the index 1 contains Integer object of value 2
		 */
		((Object[]) objArray[0])[0] = new Integer(1);
		((Object[]) objArray[0])[1] = new Integer(2);
		/*
		 * index 2 contains a nested array of type Integer
		 * which will contain 1 element 2-levels deep
		 * and contains a value of 3
		 */
		((Object[]) objArray[0])[2] = new Integer[1];
		((Object[])((Object[]) objArray[0])[2])[0] = new Integer(3);
		/*
		 * index 1 of the object array 
		 * stores an Integer value 4
		 */
		objArray[1] = new Integer(4);
		/*
		 * using priorityqueue here to keep the Integer
		 * values in sorted order and store in interface type
		 * queue reference
		 */
		return flatten(objArray);
		
	}
	
	/**
	 * uses recursive calls to access the
	 * Integer values contained in the nested array
	 * and adds these to a new List.
	 * @param nestedNumbers
	 * @return list of Integers in a flat array
	 */
	public List<Integer> flatten(Object[] nestedNumbers) {
		/*
		 * if the array is null return null
		 */
        if (nestedNumbers == null) return null;

        /*
         * create an arraylist to hold the integers
         * recovered from the nested array
         */
        List<Integer> flattenedNumbers = new ArrayList<>();

        /*
         * for each element in nestedNumbers array
         */
        for (Object element : nestedNumbers) {
            if (element instanceof Integer) {
            	/*
            	 * if the element is of type Integer
            	 * add this to the list making sure
            	 * to cast this element to Integer
            	 */
                flattenedNumbers.add((Integer)element);
            } else {
            	/*
            	 * if the element is of type Object[]
            	 * make a recursive call to flatten -
            	 * passing in the Object[] element. Causes us
            	 * to move in 1 level; i.e. [*[1,2,[3]],4]
            	 * next recursive call we move in another level [[*1,2,[3]],4]
            	 * until we get to Integer values.
            	 */
                flattenedNumbers.addAll(flatten((Object[]) element));
            }
        }
        return flattenedNumbers;
    }
}
