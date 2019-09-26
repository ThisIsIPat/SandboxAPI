package org.sandboxpowered.sandbox.api.block;

import com.hrznstudio.sandbox.api.entity.player.Player;
import com.hrznstudio.sandbox.api.item.IItem;
import com.hrznstudio.sandbox.api.item.ItemStack;
import com.hrznstudio.sandbox.api.state.BlockState;
import com.hrznstudio.sandbox.api.util.Mono;
import com.hrznstudio.sandbox.api.world.World;
import jdk.nashorn.internal.ir.Block;
import org.sandboxpowered.sandbox.api.item.PlantSeed;
import org.sandboxpowered.sandbox.api.util.math.Position;
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
    Mono<PlantableFailure> canBePlanted(WorldReader world, Position position);

    Mono<PlantableFailure> placePlant(WorldReader world, Position position, ItemStack seeds, Mono<Player> player);

    boolean canHarvest(WorldReader world, Position position, BlockState state, Mono<Player> player);

    Set<ItemStack> harvest(World world, Position position, BlockState state, Mono<Player> player);

    boolean fertilize(World world, Position position, BlockState state, ItemStack fertilizer);

    PlantSeed asSeed();

    @Nullable
    @Override
    default IItem asItem() {
        return asSeed();
    }

    enum PlantableFailure {
        OTHER,
        LIGHT,
        SPACE,
        INVALID_SOIL,
        REQUIRES_TILLING
    }
}