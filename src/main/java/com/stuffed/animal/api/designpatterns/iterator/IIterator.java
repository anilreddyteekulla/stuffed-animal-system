package com.stuffed.animal.api.designpatterns.iterator;

/**
 * An iterator is used to traverse an element and access the T's elements
 */
public interface IIterator<T> {
    T next();

    boolean hasNext();
}
