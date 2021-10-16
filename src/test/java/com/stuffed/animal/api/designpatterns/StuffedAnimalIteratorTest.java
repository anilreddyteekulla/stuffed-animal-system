package com.stuffed.animal.api.designpatterns;

import com.stuffed.animal.api.designpatterns.builderpattern.BearStuffedAnimalBuilder;
import com.stuffed.animal.api.designpatterns.iterator.StuffedAnimalIterator;
import com.stuffed.animal.api.models.StuffedAnimal;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StuffedAnimalIteratorTest {
    @Test
    public void testHasNextMethodOnAnEmptyCollectionReturnFalse() {
        // given: empty collection
        List<StuffedAnimal> stuffedAnimalList = Collections.emptyList();

        // when: create iterator with an empty collection
        StuffedAnimalIterator stuffedAnimalIterator = new StuffedAnimalIterator(Collections.emptyList());

        // then
        assertFalse(stuffedAnimalIterator.hasNext());
    }

    @Test
    public void testNextMethodOnAnEmptyCollectionThrowsException() {
        // given: empty collection
        List<StuffedAnimal> stuffedAnimalList = Collections.emptyList();

        // when: create iterator with an empty collection
        StuffedAnimalIterator stuffedAnimalIterator = new StuffedAnimalIterator(Collections.emptyList());

        // then
        assertThrows(IndexOutOfBoundsException.class, stuffedAnimalIterator::next);
    }

    @Test
    public void testWithAStuffedAnimalCollectionWithSeveralItems() {
        // given: create one StuffedAnimal object
        StuffedAnimal bear = new BearStuffedAnimalBuilder()
                .addColor("white")
                .addStuffing("cotton")
                .addStuffing("plush")
                .addFabric("plush")
                .addPrice(BigDecimal.valueOf(4L))
                .build();

        // when: create an iterator with one item
        StuffedAnimalIterator iterator = new StuffedAnimalIterator(Collections.singletonList(bear));


        // then
        assertTrue(iterator.hasNext());
        StuffedAnimal expectedResponse = iterator.next();
        assertNotNull(expectedResponse);
        assertEquals("Bear", expectedResponse.getName());
        assertFalse(iterator.hasNext());
    }
}
