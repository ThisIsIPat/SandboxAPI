package org.sandboxpowered.sandbox.api.component.components;

import org.sandboxpowered.sandbox.api.item.ItemStack;

public interface HungerComponent {
    default boolean canConsume() {
        return canConsume(false);
    }

    default void add(int food) {
        add(food, 0);
    }

    default void addSaturation(float saturation) {
        add(0, saturation);
    }

    void add(int food, float saturation);

    boolean eat(ItemStack stack);

    boolean canConsume(boolean ignoreMaxFood);

    boolean isFull();

    int getFood();

    void setFood(int amount);

    float getSaturation();

    void setSaturation(int amount);
}