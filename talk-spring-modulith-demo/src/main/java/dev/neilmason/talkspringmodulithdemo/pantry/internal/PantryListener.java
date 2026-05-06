package dev.neilmason.talkspringmodulithdemo.pantry.internal;

import dev.neilmason.talkspringmodulithdemo.ordering.OrderPlaced;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
class PantryListener {

    @EventListener
    void on(OrderPlaced event) {
        // stock decrement coming in next phase
    }
}