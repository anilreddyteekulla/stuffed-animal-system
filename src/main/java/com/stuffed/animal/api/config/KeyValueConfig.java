package com.stuffed.animal.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.keyvalue.core.KeyValueAdapter;
import org.springframework.data.keyvalue.core.KeyValueOperations;
import org.springframework.data.keyvalue.core.KeyValueTemplate;
import org.springframework.data.map.MapKeyValueAdapter;

import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class KeyValueConfig {

    @Bean
    public KeyValueOperations mapKeyValueTemplate() {
        return new KeyValueTemplate(keyValueAdapter());
    }

    @Bean
    public KeyValueAdapter keyValueAdapter() {
        return new MapKeyValueAdapter(ConcurrentHashMap.class);
    }
}
