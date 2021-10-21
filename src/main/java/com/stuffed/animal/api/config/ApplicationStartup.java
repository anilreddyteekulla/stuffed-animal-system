package com.stuffed.animal.api.config;

import com.stuffed.animal.api.designpatterns.builder.BearStuffedAnimalBuilder;
import com.stuffed.animal.api.designpatterns.builder.BunnyStuffedAnimalBuilder;
import com.stuffed.animal.api.designpatterns.builder.KangarooStuffedAnimalBuilder;
import com.stuffed.animal.api.designpatterns.builder.KoalaStuffedAnimalBuilder;
import com.stuffed.animal.api.designpatterns.iterator.StuffedAnimalIterator;
import com.stuffed.animal.api.models.StuffedAnimal;
import com.stuffed.animal.api.repositories.StuffedAnimalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {
    private final Logger log = LoggerFactory.getLogger(ApplicationStartup.class);

    private final StuffedAnimalRepository stuffedAnimalRepository;

    public ApplicationStartup(StuffedAnimalRepository stuffedAnimalRepository) {
        this.stuffedAnimalRepository = stuffedAnimalRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        loadStuffedAnimalData();
    }

    private void loadStuffedAnimalData() {
        // create stuffed animals using builder pattern
        StuffedAnimal bear = new BearStuffedAnimalBuilder()
                .addColor("white")
                .addStuffing("cotton")
                .addStuffing("wood")
                .addFabric("plush")
                .addPrice(BigDecimal.valueOf(4L))
                .build();

        StuffedAnimal bunny = new BunnyStuffedAnimalBuilder()
                .addColor("brown")
                .addStuffing("beans")
                .addStuffing("plush")
                .addFabric("cloth")
                .addPrice(BigDecimal.valueOf(4L))
                .build();

        StuffedAnimal kangaroo = new KangarooStuffedAnimalBuilder()
                .addColor("dark brown")
                .addStuffing("synthetic fiber")
                .addFabric("cloth")
                .addPrice(BigDecimal.valueOf(4L))
                .build();

        StuffedAnimal koala = new KoalaStuffedAnimalBuilder()
                .addColor("brown")
                .addStuffing("wood")
                .addFabric("plush")
                .addPrice(BigDecimal.valueOf(4L))
                .build();

        // create a list with the all stuffed animal objects
        List<StuffedAnimal> stuffedAnimalList = new ArrayList<>();
        stuffedAnimalList.add(bear);
        stuffedAnimalList.add(bunny);
        stuffedAnimalList.add(kangaroo);
        stuffedAnimalList.add(koala);
        // add stuffed animal list to the iterator to travers and save each stuffed animal object in the DB
        StuffedAnimalIterator stuffedAnimalIterator = new StuffedAnimalIterator(stuffedAnimalList);
        while (stuffedAnimalIterator.hasNext()) {
            StuffedAnimal savedObj = stuffedAnimalRepository.save(stuffedAnimalIterator.next());
            log.info(savedObj.getName() + " has been saved in the DB");
        }
    }

}
