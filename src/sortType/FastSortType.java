/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortType;
import java.lang.Integer;
import java.util.Arrays;
import java.util.Iterator;
import sorting.SortClosureInterface;
import java.util.LinkedList;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import sortType.SortTypeInterface;
/**
 *
 * @author pretorian42
 */
public class FastSortType implements SortTypeInterface{

    private SortClosureInterface sortCondition;
    private Integer[] array;
    
//    private static int countSortIterationDefault = 5;
    
    public void setArray(Integer[] array) {
        this.array = array;
    }
    
    public Integer[] getArray() {
        return this.array;
    }

    public void setSortingCondition(SortClosureInterface sortCondition) {
        this.sortCondition = sortCondition;
    }
    
    private Integer[] doSort(Integer[] arr, Integer value){
        
        System.out.println(value + "middle");
        if(arr.length <= 2){
            return arr;
        } 
        switch(arr.length){
            case 0:
            case 1:
                return arr;
            case 2:
                Integer [] newArr = new Integer[2];
                if(!this.sortCondition.checkActual(arr[0], arr[1])){
                    Integer buffer = arr[0];
                    arr[0] = arr[1];
                    arr[1] = buffer;
                }
                return arr;
            default: 
                return this.doSortMultiply(arr, value);
        
        }
    } 
    
    private Integer[] doSortMultiply(Integer [] arr, Integer value){
        Boolean moveRight = false;
        Boolean moveLeft = false;
        
        List <Integer>listFirst = new ArrayList<Integer>();
        List <Integer>listSecond = new ArrayList<Integer>() ;
//        if(countSortIterationDefault == 0){
        for(int i=0; i < arr.length; i++) {
//                System.out.println(value);
//                System.out.println(value);
            if(this.sortCondition.checkActual(arr[i], value)){
                listFirst.add(arr[i]);
                moveRight = true;
                System.out.println(arr[i] +"-");
//                    arrfirst = this.doSort(arr, value);
            } else {
//                    arrSecond = this.doSort(arr, value);
                listSecond.add(arr[i]);
                moveLeft = true;
                System.out.println(arr[i] +"+");
            }

        }
        
        Integer[] arrFirst = listFirst.toArray(new Integer[listFirst.size()]);
        Integer[] arrSecond = listSecond.toArray(new Integer[listSecond.size()]);
        Integer [] result = (moveRight && moveLeft)
                ? this.concating(
                    this.doSort(arrFirst, this.getMiddleElement(arrFirst)),
                    this.doSort(arrSecond, this.getMiddleElement(arrSecond))
                    )
                : this.concating(
                    arrFirst,
                    arrSecond
                    )
                ;

        return result;
    }
    
    public void action(){
        
        this.setArray(this.doSort(
                this.getArray(),
                this.getMiddleElement(
                        this.getArray()
                )
        ));
    }
    
    public int getMiddleElement(Integer[] array) {
        
                System.out.println(Arrays.toString(array));

        return array.length > 1 
                ? array[(array.length+1)/2]
                : 0 ;
    }
    
    public int getRandomElement(Integer[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
    
    public Integer[] concating(Object[] a, Object[] b) {
        int aLen = a.length;
        int bLen = b.length;
        Integer[] c= new Integer[aLen+bLen];
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);
        return c;
    }

}
