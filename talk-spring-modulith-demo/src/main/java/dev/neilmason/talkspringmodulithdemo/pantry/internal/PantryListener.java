package dev.neilmason.talkspringmodulithdemo.pantry.internal;

import dev.neilmason.talkspringmodulithdemo.ordering.OrderPlaced;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
class PantryListener {

    private static final Logger log = LoggerFactory.getLogger(PantryListener.class);

    @Async
    @EventListener
    void on(OrderPlaced event) {
        log.info("Pantry: dispensing {} for order [time={}, hoursCoding={}, onDeadline={}, vibe={}]",
            event.recommendation().coffee(),
            event.request().time(),
            event.request().hoursCoding(),
            event.request().onDeadline(),
            event.request().vibe()
        );
    }
}