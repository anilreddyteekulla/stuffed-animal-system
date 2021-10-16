package com.stuffed.animal.api.designpatterns.iterator;

import com.stuffed.animal.api.models.StuffedAnimal;

/**
 * An iterator is used to traverse an element and access the T's elements
 */
public interface IIterator {
    StuffedAnimal next();

    boolean hasNext();
}
