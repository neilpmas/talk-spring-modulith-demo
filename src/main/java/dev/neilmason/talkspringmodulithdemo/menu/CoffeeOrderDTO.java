package dev.neilmason.talkspringmodulithdemo.menu;

import dev.neilmason.talkspringmodulithdemo.Vibe;

public record CoffeeOrderDTO(String time, int hoursCoding, boolean onDeadline, Vibe vibe) {}
