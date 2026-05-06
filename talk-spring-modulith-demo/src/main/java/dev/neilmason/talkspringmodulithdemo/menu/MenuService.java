package dev.neilmason.talkspringmodulithdemo.menu;

import dev.neilmason.talkspringmodulithdemo.OrderRequest;
import dev.neilmason.talkspringmodulithdemo.menu.internal.RecommendationEngine;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    private final RecommendationEngine engine;

    public MenuService(RecommendationEngine engine) {
        this.engine = engine;
    }

    public CoffeeRecommendation recommend(OrderRequest request) {
        return engine.recommend(request);
    }
}