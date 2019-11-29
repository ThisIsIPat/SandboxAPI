package org.sandboxpowered.sandbox.api.block;

import org.sandboxpowered.sandbox.api.Registries;
import org.sandboxpowered.sandbox.api.block.entity.BaseBlockEntity;
import org.sandboxpowered.sandbox.api.block.entity.BlockEntity;
import org.sandboxpowered.sandbox.api.component.Component;
import org.sandboxpowered.sandbox.api.item.Item;
import org.sandboxpowered.sandbox.api.state.BlockState;
import org.sandboxpowered.sandbox.api.state.Properties;
import org.sandboxpowered.sandbox.api.state.StateFactory;
import org.sandboxpowered.sandbox.api.util.Direction;
import org.sandboxpowered.sandbox.api.util.Mono;
import org.sandboxpowered.sandbox.api.util.annotation.Internal;
import org.sandboxpowered.sandbox.api.util.math.Position;
import org.sandboxpowered.sandbox.api.world.WorldReader;

public class BaseBlock implements Block {
    private final Settings settings;
    private Mono<Item> itemCache;
    private StateFactory<Block, BlockState> stateFactory;
    private String translationKey;

    public BaseBlock(Settings settings) {
        this.settings = settings;
    }

    @Override
    public String getTranslationKey() {
        if (this.translationKey == null) {
            this.translationKey = Registries.BLOCK.getIdentity(this).asTranslation("block");
        }

        return this.translationKey;
    }

    @Override
    public final Settings getSettings() {
        return settings;
    }

    @Override
    public final StateFactory<Block, BlockState> getStateFactory() {
        return stateFactory;
    }

    @Internal
    public final void setStateFactory(StateFactory<Block, BlockState> stateFactory) {
        this.stateFactory = stateFactory;
    }

    @Override
    public Mono<Item> asItem() {
        if (itemCache == null) {
            itemCache = Registries.ITEM.get(Registries.BLOCK.getIdentity(this));
        }
        return itemCache;
    }

    @Override
    public final <X> Mono<X> getComponent(WorldReader world, Position position, BlockState state, Component<X> component) {
        return getComponent(world, position, state, component, Mono.empty());
    }

    @Override
    public final <X> Mono<X> getComponent(WorldReader world, Position position, BlockState state, Component<X> component, Direction side) {
        return getComponent(world, position, state, component, Mono.of(side));
    }

    @Override
    public <X> Mono<X> getComponent(WorldReader world, Position position, BlockState state, Component<X> component, Mono<Direction> side) {
        if (hasBlockEntity()) {
            BlockEntity entity = world.getBlockEntity(position);
            if (entity instanceof BaseBlockEntity)
                return ((BaseBlockEntity) entity).getComponent(component, side);
        }
        return Mono.empty();
    }

    public void appendProperties(StateFactory.Builder<Block, BlockState> builder) {
        if (this instanceof FluidContainer) {
            builder.add(Properties.WATERLOGGED);
        }
    }

    @Override
    public final BlockState getBaseState() {
        return stateFactory.getBaseState();
    }
}