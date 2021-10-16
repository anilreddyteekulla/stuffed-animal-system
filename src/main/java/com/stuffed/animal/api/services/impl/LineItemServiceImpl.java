package com.stuffed.animal.api.services.impl;

import com.stuffed.animal.api.models.LineItem;
import com.stuffed.animal.api.repositories.LineItemRepository;
import com.stuffed.animal.api.services.LineItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LineItemServiceImpl implements LineItemService {
    @Autowired
    private LineItemRepository lineItemRepository;

    @Override
    public void addLineItem(LineItem lineItem) {
        lineItemRepository.save(lineItem);
    }
}
