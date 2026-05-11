package dev.neilmason.talkspringmodulithdemo.menu.internal;

import dev.neilmason.talkspringmodulithdemo.CoffeeRecommendationDTO;
import dev.neilmason.talkspringmodulithdemo.Vibe;
import dev.neilmason.talkspringmodulithdemo.menu.CoffeeOrderDTO;
import org.springframework.stereotype.Component;

@Component
public class RecommendationEngine {

    public CoffeeRecommendationDTO recommend(CoffeeOrderDTO request) {
        int hour = parseHour(request.time());

        // 3am or later AND been coding for more than 4 hours
        if (hour >= 0 && hour < 5 && request.hoursCoding() > 4) {
            return new CoffeeRecommendationDTO("TRIPLE_ESPRESSO",
                "It's " + request.time() + " and you've been coding for " + request.hoursCoding() + " hours. You need this.");
        }

        // Everything is on fire
        if (request.vibe() == Vibe.EVERYTHING_IS_ON_FIRE) {
            return new CoffeeRecommendationDTO("DOUBLE_ESPRESSO", "No time for milk.");
        }

        // On a deadline
        if (request.onDeadline()) {
            return new CoffeeRecommendationDTO("ESPRESSO", "Get back to work.");
        }

        // Stressed
        if (request.vibe() == Vibe.STRESSED) {
            return new CoffeeRecommendationDTO("LONG_BLACK", "Breathe. Then drink this.");
        }

        // Default — you're fine
        return new CoffeeRecommendationDTO("FLAT_WHITE", "You're doing great. Treat yourself.");
    }

    private int parseHour(String time) {
        try {
            return Integer.parseInt(time.split(":")[0]);
        } catch (Exception e) {
            return 12; // default to midday if we can't parse
        }
    }
}
