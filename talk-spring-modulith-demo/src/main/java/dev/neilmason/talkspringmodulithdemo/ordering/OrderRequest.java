package dev.neilmason.talkspringmodulithdemo.ordering;

public record OrderRequest(String time, int hoursCoding, boolean onDeadline, Vibe vibe) {}