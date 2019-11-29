package org.sandboxpowered.sandbox.api.util;

public interface Identity {

    static Identity of(String namespace, String path) {
        return Functions.identityFunction.apply(namespace + ":" + path);
    }

    String getNamespace();

    String getPath();

    default String asTranslation() {
        return asTranslation("");
    }

    default String asTranslation(String prefix) {
        if (prefix.isEmpty())
            return String.format("%s.%s", getNamespace(), getPath());
        return String.format("%s.%s.%s", prefix, getNamespace(), getPath());
    }
}