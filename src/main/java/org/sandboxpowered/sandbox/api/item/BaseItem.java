package org.sandboxpowered.sandbox.api.item;

import org.sandboxpowered.sandbox.api.Registries;

public class BaseItem implements Item {
    private final Settings settings;
    private String translationKey;

    public BaseItem(Settings settings) {
        this.settings = settings;
    }

    @Override
    public Settings getSettings() {
        return settings;
    }

    @Override
    public String getTranslationKey() {
        if (this.translationKey == null) {
            this.translationKey = Registries.ITEM.getIdentity(this).asTranslation("item");
        }

        return this.translationKey;
    }
}