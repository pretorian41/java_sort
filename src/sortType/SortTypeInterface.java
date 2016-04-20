/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortType;

import sorting.SortClosureInterface;

/**
 *
 * @author pretorian42
 */
public interface SortTypeInterface<type> {

    /**
     *
     * @param array
     */
    public void setArray(Integer [] array);
    public Integer[] getArray();
    public void setSortingCondition(SortClosureInterface sortCondition);
}
