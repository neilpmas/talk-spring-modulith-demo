package dev.neilmason.talkspringmodulithdemo.ordering;

import dev.neilmason.talkspringmodulithdemo.CoffeeRecommendation;
import dev.neilmason.talkspringmodulithdemo.OrderRequest;

public record OrderPlaced(OrderRequest request, CoffeeRecommendation recommendation) {}
