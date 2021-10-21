package com.stuffed.animal.api.designpatterns.builder;

import com.stuffed.animal.api.models.StuffedAnimal;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StuffedAnimalBuilderTest {
    @Test
    public void testStuffedAnimalBuilder() {
        // when: create stuffed animals using builder pattern
        StuffedAnimal bear = new BearStuffedAnimalBuilder()
                .addColor("white")
                .addStuffing("beans")
                .addStuffing("wood")
                .addFabric("plush")
                .addPrice(BigDecimal.valueOf(4L))
                .build();
        // then: verify response
        assertNotNull(bear);
        assertEquals("Bear", bear.getName());
        assertEquals("plush", bear.getFabric());
        assertEquals("white", bear.getColor());
        assertEquals(2, bear.getStuffings().size());
        assertEquals(BigDecimal.valueOf(4L), bear.getPrice());

        // when: create stuffed animals using builder pattern
        StuffedAnimal kangaroo = new KangarooStuffedAnimalBuilder()
                .addColor("dark brown")
                .addStuffing("synthetic fiber")
                .addFabric("cloth")
                .addPrice(BigDecimal.valueOf(4L))
                .build();
        // then: verify response
        assertNotNull(kangaroo);
        assertEquals("Kangaroo", kangaroo.getName());
        assertEquals("cloth", kangaroo.getFabric());
        assertEquals("dark brown", kangaroo.getColor());
        assertEquals(1, kangaroo.getStuffings().size());
        assertEquals(BigDecimal.valueOf(4L), kangaroo.getPrice());

        // when: create stuffed animals using builder pattern
        StuffedAnimal koala = new KoalaStuffedAnimalBuilder()
                .addColor("brown")
                .addStuffing("wood")
                .addFabric("plush")
                .addPrice(BigDecimal.valueOf(4L))
                .build();
        // then: verify response
        assertNotNull(kangaroo);
        assertEquals("Koala", koala.getName());
        assertEquals("plush", koala.getFabric());
        assertEquals("brown", koala.getColor());
        assertEquals(1, koala.getStuffings().size());
        assertEquals(BigDecimal.valueOf(4L), koala.getPrice());

    }
}
