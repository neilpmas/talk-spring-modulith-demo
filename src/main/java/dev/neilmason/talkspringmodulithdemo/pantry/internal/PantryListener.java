package dev.neilmason.talkspringmodulithdemo.pantry.internal;

import dev.neilmason.talkspringmodulithdemo.ordering.OrderPlaced;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
class PantryListener {

    private static final Logger log = LoggerFactory.getLogger(PantryListener.class);

    // DEMO: @Async makes the pantry log appear *after* the HTTP response.
    // Remove @Async to show sync behaviour (response waits 2s for pantry to finish).
    @Async
    @ApplicationModuleListener
    void on(OrderPlaced event) throws InterruptedException {
        Thread.sleep(2000); // DEMO: makes the async flip visible on stage — do not remove
        log.info("Pantry: dispensing {}", event.recommendation().coffee());
    }
}
