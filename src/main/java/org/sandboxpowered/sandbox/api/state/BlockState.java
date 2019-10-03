package org.sandboxpowered.sandbox.api.state;

import org.sandboxpowered.sandbox.api.block.Block;
import org.sandboxpowered.sandbox.api.block.Material;
import org.sandboxpowered.sandbox.api.component.Component;
import org.sandboxpowered.sandbox.api.entity.Entity;
import org.sandboxpowered.sandbox.api.util.Direction;
import org.sandboxpowered.sandbox.api.util.Mirror;
import org.sandboxpowered.sandbox.api.util.Mono;
import org.sandboxpowered.sandbox.api.util.Rotation;
import org.sandboxpowered.sandbox.api.util.math.Position;
import org.sandboxpowered.sandbox.api.util.shape.Shape;
import org.sandboxpowered.sandbox.api.world.WorldReader;

public interface BlockState extends PropertyContainer<BlockState> {
    Block getBlock();

    default boolean isAir() {
        return getBlock().isAir(this);
    }

    default Material.PistonInteraction getPistonInteraction() {
        return getBlock().getPistonInteraction(this);
    }

    default boolean canReplace() {
        return getBlock().canReplace(this);
    }

    default BlockState rotate(Rotation rotation) {
        return getBlock().rotate(this, rotation);
    }

    default BlockState mirror(Mirror mirror) {
        return getBlock().mirror(this, mirror);
    }

    default Shape getShape(WorldReader world, Position position, BlockState state) {
        return getShape(world, position, state, Mono.empty());
    }

    default Shape getShape(WorldReader world, Position position, BlockState state, Mono<Entity> entity) {
        return getBlock().getShape(world, position, state, entity);
    }

    default Shape getCollisionShape(WorldReader world, Position position, BlockState state) {
        return getCollisionShape(world, position, state, Mono.empty());
    }

    default Shape getCollisionShape(WorldReader world, Position position, BlockState state, Mono<Entity> entity) {
        return getBlock().getCollisionShape(world, position, state, entity);
    }

    default Shape getOutlineShape(WorldReader world, Position position, BlockState state) {
        return getOutlineShape(world, position, state, Mono.empty());
    }

    default Shape getOutlineShape(WorldReader world, Position position, BlockState state, Mono<Entity> entity) {
        return getBlock().getOutlineShape(world, position, state, entity);
    }

    default <X> Mono<X> getComponent(WorldReader world, Position position, Component<X> component) {
        return getComponent(world, position, component, Mono.empty());
    }

    default <X> Mono<X> getComponent(WorldReader world, Position position, Component<X> component, Direction side) {
        return getComponent(world, position, component, Mono.of(side));
    }

    default <X> Mono<X> getComponent(WorldReader world, Position position, Component<X> component, Mono<Direction> sideMono) {
        return getBlock().getComponent(world, position, this, component, sideMono);
    }
}