/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

/**
 *
 * @author pretorian42
 */
public class SortBase implements  SortClosureInterface{
    
    public boolean check(Integer[] array, int firstPossition, int secondPossition) {
        return array[firstPossition] > array[secondPossition];
    }

    @Override
    public boolean checkActual(int first, int second) {
        return first > second;
    }
    
}
