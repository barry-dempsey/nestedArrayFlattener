package tests;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import utils.ListToArray;

import com.dempsey.nestedarray.NestedArray;

/**
 * Unit tests for NestedArrayFlattener
 * @author Barry Dempsey
 *
 */
public class UnitTests {

	@Test
	public void performTests() {
		NestedArray na = new NestedArray();
		
		/*
		 * test for null
		 */
		assertNull(na.flatten(null));

		/*
		 * test for un-nested array
		 */
    	assertArrayEquals(
                new Integer[]{1,2,3,4,5},
                ListToArray.toArray(na.flatten(
                		new Object[]{1,2,3,4,5})));
        
        /*
         * test for nested array
         */
        assertArrayEquals(new Integer[]{1,2,3,4,5,6}, 
        		ListToArray.toArray(na.flatten(new Object[]{1,2, 
        				new Object[]{3,4},5,6})));
        
        /*
         * test for deeper level nested array
         */
        assertArrayEquals(new Integer[]{1,2,3,4,5,6}, 
        		ListToArray.toArray(na.flatten(new Object[]{1,2, 
        				new Object[]{3, new Object[]{4}},5,6})));
	}
}
