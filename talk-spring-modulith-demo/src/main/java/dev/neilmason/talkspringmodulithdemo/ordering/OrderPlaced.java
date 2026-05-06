package dev.neilmason.talkspringmodulithdemo.ordering;

import dev.neilmason.talkspringmodulithdemo.OrderRequest;
import dev.neilmason.talkspringmodulithdemo.menu.CoffeeRecommendation;

public record OrderPlaced(OrderRequest request, CoffeeRecommendation recommendation) {}