package dev.neilmason.talkspringmodulithdemo.menu;

import dev.neilmason.talkspringmodulithdemo.CoffeeRecommendationDTO;
import dev.neilmason.talkspringmodulithdemo.menu.internal.RecommendationEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    private static final Logger log = LoggerFactory.getLogger(MenuService.class);

    private final RecommendationEngine engine;

    public MenuService(RecommendationEngine engine) {
        this.engine = engine;
    }

    public CoffeeRecommendationDTO recommend(CoffeeOrderDTO order) {
        return engine.recommend(order);
    }
}
