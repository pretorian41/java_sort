/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortType;

import java.util.Arrays;
import sorting.SortClosureInterface;

/**
 *
 * @author pretorian42
 */
public class RecursionSortType implements SortTypeInterface{

    private SortClosureInterface sortCondition;
    private Integer[] array;
    @Override
    public void setArray(Integer[] array) {
        this.array = array;
    }

    @Override
    public Integer[] getArray() {
        return this.array;
    }

    @Override
    public void setSortingCondition(SortClosureInterface sortCondition) {
        this.sortCondition = sortCondition;
    }
    
    public void action(){
        int length = this.array.length;
        this.doSort(0, length -1);
    }
    
    private void doSort(int firstPosition, int secondPosition){
        System.out.println(firstPosition+ ">"+secondPosition);
        int diff = secondPosition-firstPosition;
        switch(diff){
            case 0:
                break;
            case 1:
                
                if(sortCondition.check(this.array, firstPosition, secondPosition)){
                    
//                    System.out.println(firstPosition+ ">"+secondPosition);
//                    System.out.println(array[firstPosition]+ ">"+array[secondPosition]);
                    this.swap(firstPosition, secondPosition);
                } else {
//                    System.out.println(firstPosition+ "<="+secondPosition);
//                    System.out.println(array[firstPosition]+ "<="+array[secondPosition]);
                }
                break;
            default:
                int change = diff/2;
                this.doSort(firstPosition, firstPosition+change);
                this.doSort(secondPosition-change, secondPosition);
                System.out.println(
                        firstPosition+":"+ (firstPosition+change) +"|"
                        + (secondPosition-change) + ":"+secondPosition
                );
//                
                this.mergeMid(firstPosition,  secondPosition-change, secondPosition);
                System.out.println(Arrays.toString(array));
        }

        
    }
    
    
    private void mergeMid(int start, int mid, int end){
        int i=start;
        while(i<=mid){
                if(sortCondition.check(this.array, i, mid+1)){
                        this.swap(i,mid+1);
                        this.swap(mid+1,end);
                }			
                i++;
        }

    }

    private void swap(Integer firstPossition, Integer secondPossition) {
        int boofer = this.array[firstPossition];
//        System.out.println(
//                this.array[firstPossition]
//                        + "'swap'"
//                        + this.array[secondPossition]
//                                );
        this.array[firstPossition] = this.array[secondPossition];
        this.array[secondPossition] = boofer;
    }
    
    
}
