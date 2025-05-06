package com.informationretrieval;

import java.util.LinkedList;
import java.util.ListIterator;

public class DoclistOrdered<T> extends LinkedList<T> {
    public boolean addSort(T doc){
        ListIterator<T> iterator = this.listIterator();
        while (iterator.hasNext()) {
            T temp = iterator.next();
            // System.out.println(temp);
            
            if (((Comparable) temp).compareTo(doc) > 0) {
                iterator.previous();
                iterator.add(doc);
                return true;
            }
        }
        iterator.add(doc);
        // System.out.println(iterator.previous());
        // System.out.println("===========================");
        return true;
    }
}
