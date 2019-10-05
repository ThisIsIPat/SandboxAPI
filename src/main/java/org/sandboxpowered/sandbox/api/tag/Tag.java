package org.sandboxpowered.sandbox.api.tag;

import org.sandboxpowered.sandbox.api.util.Identity;

import java.util.Collection;
import java.util.Random;

public interface Tag<T> {
    boolean contains(T val);

    Collection<T> values();

    T getRandom(Random rand);

    Identity getIdentity();
}