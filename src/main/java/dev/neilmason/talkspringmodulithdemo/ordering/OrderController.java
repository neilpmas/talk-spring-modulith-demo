package dev.neilmason.talkspringmodulithdemo.ordering;

import dev.neilmason.talkspringmodulithdemo.menu.CoffeeOrderDTO;
import dev.neilmason.talkspringmodulithdemo.menu.CoffeeRecommendationDTO;
import dev.neilmason.talkspringmodulithdemo.menu.MenuService;
// DEMO: uncomment to show verify() failing — BadPublicApi is public but internal
// import dev.neilmason.talkspringmodulithdemo.pantry.BadPublicApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    private final MenuService menuService;
    private final ApplicationEventPublisher events;

    public OrderController(MenuService menuService, ApplicationEventPublisher events) {
        this.menuService = menuService;
        this.events = events;
    }

    @PostMapping
    public CoffeeRecommendationDTO order(@RequestBody CoffeeOrderDTO order) {
        CoffeeRecommendationDTO recommendation = menuService.recommend(order);
        events.publishEvent(new OrderPlaced(recommendation.coffee()));
        // DEMO: uncomment to show verify() failing — BadPublicApi is public but internal
//         new BadPublicApi().doSomething();
        log.info("Menu: recommending {} — {}", recommendation.coffee(), recommendation.reason());
        return recommendation;
    }
}
