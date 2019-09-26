package org.sandboxpowered.sandbox.api.block;

import org.sandboxpowered.sandbox.api.entity.player.PlayerEntity;
import org.sandboxpowered.sandbox.api.item.Item;
import org.sandboxpowered.sandbox.api.item.ItemStack;
import org.sandboxpowered.sandbox.api.item.PlantSeed;
import org.sandboxpowered.sandbox.api.state.BlockState;
import org.sandboxpowered.sandbox.api.util.Mono;
import org.sandboxpowered.sandbox.api.util.math.Position;
import org.sandboxpowered.sandbox.api.world.World;
import org.sandboxpowered.sandbox.api.world.WorldReader;

import javax.annotation.Nullable;
import java.util.Set;

public interface Plant extends Block {
    /**
     * @return 0-1 for plant growth.
     */
    float getGrowthProgress(WorldReader world, Position position, BlockState state);

    /**
     * @return Empty mono if can be planted, otherwise mono with the correct failure
     */
    Mono<PlantingFailure> canBePlanted(WorldReader world, Position position);

    Mono<PlantingFailure> placePlant(WorldReader world, Position position, ItemStack seeds, Mono<PlayerEntity> player);

    boolean canHarvest(WorldReader world, Position position, BlockState state, Mono<PlayerEntity> player);

    Set<ItemStack> harvest(World world, Position position, BlockState state, Mono<PlayerEntity> player);

    boolean fertilize(World world, Position position, BlockState state, ItemStack fertilizer);

    PlantSeed asSeed();

    @Nullable
    @Override
    default Mono<Item> asItem() {
        return Mono.of(asSeed());
    }

    enum PlantingFailure {
        OTHER,
        LIGHT,
        SPACE,
        INVALID_SOIL,
        REQUIRES_TILLING
    }
}