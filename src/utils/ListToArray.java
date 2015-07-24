package utils;

import java.util.List;

public class ListToArray {
	
	public static Integer[] toArray(List<Integer> list) {
        return list.toArray(new Integer[list.size()]);
    }

}
