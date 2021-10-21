package com.stuffed.animal.api.designpatterns.state;

import com.stuffed.animal.api.designpatterns.builder.BearStuffedAnimalBuilder;
import com.stuffed.animal.api.models.Order;
import com.stuffed.animal.api.models.StuffedAnimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;

public class OrderStatePatternTest {
    @Test
    public void testOrderStatePatternHappyPath() {
        // given
        StuffedAnimal bear = new BearStuffedAnimalBuilder()
                .addColor("white")
                .addStuffing("cotton")
                .addStuffing("wood")
                .addFabric("plush")
                .addPrice(BigDecimal.valueOf(4L))
                .build();
        Order order = new Order();
        order.setId(1);
        order.setCustomerId(100);
        order.setTotalPrice(BigDecimal.valueOf(8L));
        order.setStuffedAnimals(Collections.singletonList(bear));

        // when
        OrderProcessor orderProcessor = new OrderProcessor(order);
        OrderState actualState = orderProcessor.getState();


        // then - expected order state is open state
        Assertions.assertTrue(actualState instanceof OpenState);

        //confirmed order
        orderProcessor.confirmOrder();
        OrderState actualState1 = orderProcessor.getState();
        Assertions.assertTrue(actualState1 instanceof OrderedState);

        //shipped order
        orderProcessor.shipOrder();
        OrderState actualState2 = orderProcessor.getState();
        Assertions.assertTrue(actualState2 instanceof ShippedState);

        //deliver order
        orderProcessor.deliverOrder();
        OrderState actualState3 = orderProcessor.getState();
        Assertions.assertTrue(actualState3 instanceof DeliveredState);
    }

    @Test
    public void testOrderStatePatternWithCancelOrder() {
        // given
        StuffedAnimal bear = new BearStuffedAnimalBuilder()
                .addColor("white")
                .addStuffing("cotton")
                .addStuffing("wood")
                .addFabric("plush")
                .addPrice(BigDecimal.valueOf(4L))
                .build();
        Order order = new Order();
        order.setId(1);
        order.setCustomerId(100);
        order.setTotalPrice(BigDecimal.valueOf(8L));
        order.setStuffedAnimals(Collections.singletonList(bear));

        // when
        OrderProcessor orderProcessor = new OrderProcessor(order);
        OrderState actualState = orderProcessor.getState();


        // then - expected order state is open state
        Assertions.assertTrue(actualState instanceof OpenState);

        //confirmed order
        orderProcessor.confirmOrder();
        OrderState actualState1 = orderProcessor.getState();
        Assertions.assertTrue(actualState1 instanceof OrderedState);

        //cancel order
        orderProcessor.cancelOrder();
        OrderState actualState2 = orderProcessor.getState();
        Assertions.assertTrue(actualState2 instanceof CancelledState);
    }
}
