package dev.neilmason.talkspringmodulithdemo.pantry;

/**
 * DEMO: Public class in pantry's public API — perfectly legal Java.
 * But calling it from ordering creates a cycle: pantry already depends on
 * ordering (via OrderPlaced), so ordering → pantry → ordering.
 * Modulith will fail verify() on the circular dependency.
 */
public class BadPublicApi {

    public String doSomething() {
        return "I'm public but you shouldn't be here";
    }
}
