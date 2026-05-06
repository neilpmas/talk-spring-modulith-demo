package dev.neilmason.talkspringmodulithdemo.menu.internal;

import dev.neilmason.talkspringmodulithdemo.OrderRequest;
import dev.neilmason.talkspringmodulithdemo.Vibe;
import dev.neilmason.talkspringmodulithdemo.menu.CoffeeRecommendation;
import org.springframework.stereotype.Component;

@Component
public class RecommendationEngine {

    public CoffeeRecommendation recommend(OrderRequest request) {
        int hour = parseHour(request.time());

        // 3am or later AND been coding for more than 4 hours
        if (hour >= 0 && hour < 5 && request.hoursCoding() > 4) {
            return new CoffeeRecommendation("TRIPLE_ESPRESSO",
                "It's " + request.time() + " and you've been coding for " + request.hoursCoding() + " hours. You need this.");
        }

        // Everything is on fire
        if (request.vibe() == Vibe.EVERYTHING_IS_ON_FIRE) {
            return new CoffeeRecommendation("DOUBLE_ESPRESSO", "No time for milk.");
        }

        // Someone starred your repo
        if (request.vibe() == Vibe.GITHUB_STAR) {
            return new CoffeeRecommendation("MACADAMIA_MILK_LATTE", "Someone noticed. You've earned the macadamia milk.");
        }

        // On a deadline
        if (request.onDeadline()) {
            return new CoffeeRecommendation("ESPRESSO", "Get back to work.");
        }

        // Stressed
        if (request.vibe() == Vibe.STRESSED) {
            return new CoffeeRecommendation("LONG_BLACK", "Breathe. Then drink this.");
        }

        // Default — you're fine
        return new CoffeeRecommendation("FLAT_WHITE", "You're doing great. Treat yourself.");
    }

    private int parseHour(String time) {
        try {
            return Integer.parseInt(time.split(":")[0]);
        } catch (Exception e) {
            return 12; // default to midday if we can't parse
        }
    }
}