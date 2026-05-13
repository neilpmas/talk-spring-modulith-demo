package dev.neilmason.talkspringmodulithdemo.pantry.internal;

/**
 * DEMO: This class is public — Java has no problem with anyone importing it.
 * But it's in an internal package. Modulith will fail verify() if anything
 * outside pantry tries to use it.
 */
public class BadPublicApi {

    public String doSomething() {
        return "I'm public but you shouldn't be here";
    }
}
