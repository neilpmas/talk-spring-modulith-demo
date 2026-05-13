package dev.neilmason.talkspringmodulithdemo.pantry.internal;

import dev.neilmason.talkspringmodulithdemo.ordering.OrderPlaced;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Component
public class PantryListener {

    private static final Logger log = LoggerFactory.getLogger(PantryListener.class);

    // DEMO: replace @EventListener with @ApplicationModuleListener to flip sync → async
    @EventListener
    void on(OrderPlaced event) throws InterruptedException {
        Thread.sleep(2000); // makes the async flip visible on stage — do not remove
        log.info("Pantry: dispensing {}", event.recommendation().coffee());
    }
}
