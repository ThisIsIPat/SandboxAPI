package org.sandboxpowered.sandbox.api.data;

import org.sandboxpowered.sandbox.api.block.Block;

import java.util.Map;
import java.util.TreeMap;

public class LanguageProvider implements DataProvider {
    private final Map<String, String> data = new TreeMap<>();
    private final String id;
    private final String locale;

    public LanguageProvider(String id, String locale) {
        this.id = id;
        this.locale = locale;
    }

    @Override
    public void write(DataFile file) {

    }

    @Override
    public String getName() {
        return String.format("Lang (%s:%s)", id, locale);
    }

    public void add(Block block, String value) {
        add(block.getTranslationKey(), value);
    }

    public void add(String key, String value) {
        if (data.put(key, value) != null)
            throw new IllegalStateException("Duplicate translation key " + key);
    }
}