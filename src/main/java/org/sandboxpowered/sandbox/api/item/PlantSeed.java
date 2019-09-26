package org.sandboxpowered.sandbox.api.item;

import org.sandboxpowered.sandbox.api.block.Plant;
import org.sandboxpowered.sandbox.api.entity.player.PlayerEntity;
import org.sandboxpowered.sandbox.api.state.BlockState;
import org.sandboxpowered.sandbox.api.util.Mono;
import org.sandboxpowered.sandbox.api.util.math.Position;
import org.sandboxpowered.sandbox.api.world.WorldReader;

public interface PlantSeed extends Item {
    Plant asPlant();

    BlockState getPlantState(WorldReader world, Position position, ItemStack seeds, Mono<PlayerEntity> player);
}