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
//    @ApplicationModuleListener
    void on(OrderPlaced event) throws InterruptedException {
        Thread.sleep(1000);
        log.info("Pantry: Looking at Hacker News...");
        Thread.sleep(1000);
        log.info("Pantry: Thinking about new JVM talks...");
        Thread.sleep(1000);
        log.info("Pantry: need to refresh {} ingredients", event.coffee());
    }
}
