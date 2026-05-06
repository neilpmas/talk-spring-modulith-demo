package dev.neilmason.talkspringmodulithdemo.ordering;

import dev.neilmason.talkspringmodulithdemo.CoffeeRecommendation;
import dev.neilmason.talkspringmodulithdemo.OrderRequest;
import dev.neilmason.talkspringmodulithdemo.menu.MenuService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final MenuService menuService;
    private final ApplicationEventPublisher events;

    public OrderController(MenuService menuService, ApplicationEventPublisher events) {
        this.menuService = menuService;
        this.events = events;
    }

    @PostMapping
    public CoffeeRecommendation order(@RequestBody OrderRequest request) {
        CoffeeRecommendation recommendation = menuService.recommend(request);
        events.publishEvent(new OrderPlaced(request, recommendation));
        return recommendation;
    }
}
