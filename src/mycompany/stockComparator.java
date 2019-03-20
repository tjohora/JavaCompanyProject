/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompany;

import java.util.Comparator;

/**
 *
 * @author D00186562
 */
public class stockComparator implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }
            return o1.compareTo(o2);
        }

}
