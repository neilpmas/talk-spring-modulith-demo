package dev.neilmason.talkspringmodulithdemo.menu;

import org.springframework.stereotype.Service;

@Service
public class MenuService {

    public CoffeeRecommendation recommend(Object request) {
        return new CoffeeRecommendation("FLAT_WHITE", "Not implemented yet");
    }
}