package dev.neilmason.talkspringmodulithdemo;

public record OrderRequest(String time, int hoursCoding, boolean onDeadline, Vibe vibe) {}