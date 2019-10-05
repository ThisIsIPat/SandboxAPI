package org.sandboxpowered.sandbox.api.tag;

import org.sandboxpowered.sandbox.api.util.Identity;
import org.sandboxpowered.sandbox.api.util.Mono;

import java.util.Collection;

public interface TagManager<T> {
    Mono<Tag<T>> get(Identity identity);

    Tag<T> getOrCreate(Identity identity);

    Collection<Identity> getApplicableTags(T t);
}