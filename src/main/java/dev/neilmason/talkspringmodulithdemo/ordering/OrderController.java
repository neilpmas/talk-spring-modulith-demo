package dev.neilmason.talkspringmodulithdemo.ordering;

import dev.neilmason.talkspringmodulithdemo.CoffeeRecommendationDTO;
import dev.neilmason.talkspringmodulithdemo.menu.CoffeeOrderDTO;
import dev.neilmason.talkspringmodulithdemo.menu.MenuService;
// DEMO: uncomment to show verify() failing — BadPublicApi is public but internal
// import dev.neilmason.talkspringmodulithdemo.pantry.internal.BadPublicApi;
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
    public CoffeeRecommendationDTO order(@RequestBody CoffeeOrderDTO order) {
        CoffeeRecommendationDTO recommendation = menuService.recommend(order);
        events.publishEvent(new OrderPlaced(recommendation));
        // DEMO: uncomment to show verify() failing — BadPublicApi is public but internal
//         new BadPublicApi().doSomething();
        return recommendation;
    }
}
