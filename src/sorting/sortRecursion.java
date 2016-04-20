/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import sortType.RecursionSortType;
import sortType.FastSortType;
import java.util.Arrays;
import sortType.SortTypeInterface;

/**
 *
 * @author pretorian42
 */
public class sortRecursion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        FastSortType sortType = new FastSortType();
        RecursionSortType sortType = new RecursionSortType();
        sortType.setSortingCondition(new SortBase());
        
        Integer[] array = {200,60,12,8, 3, 20 , 10, 40, 50, 58, 96,43};
//                int[] array = {3,0,2};

        sortType.setArray(array);
        System.out.println(Arrays.toString(sortType.getArray()));
        sortType.action();
        System.out.println(Arrays.toString(sortType.getArray()));
    }

    
}
