package org.sandboxpowered.sandbox.api.component.components;

import org.sandboxpowered.sandbox.api.item.ItemStack;
import org.sandboxpowered.sandbox.api.util.Mono;

public interface HungerManager {
    default void addFood(int food) {
        add(food, 0);
    }

    default void addSaturation(float saturation) {
        add(0, saturation);
    }

    void add(int food, float saturation);

    boolean eat(ItemStack stack);

    default boolean canConsume() {
        return canConsume(Mono.empty());
    }

    default boolean canConsume(ItemStack stack) {
        return canConsume(Mono.of(stack));
    }

    boolean canConsume(Mono<ItemStack> stackMono);

    boolean isFull();

    int getFood();

    void setFood(int amount);

    float getSaturation();

    void setSaturation(int amount);
}