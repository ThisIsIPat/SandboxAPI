package com.hrznstudio.sandbox.api.item;

import com.hrznstudio.sandbox.api.block.Plant;
import com.hrznstudio.sandbox.api.entity.player.Player;
import com.hrznstudio.sandbox.api.state.BlockState;
import com.hrznstudio.sandbox.api.util.Mono;
import com.hrznstudio.sandbox.api.util.math.Position;
import com.hrznstudio.sandbox.api.world.WorldReader;

public interface PlantSeed extends IItem {
    Plant asPlant();

    BlockState getPlantState(WorldReader world, Position position, ItemStack seeds, Mono<Player> player);

    boolean placePlant(WorldReader world, Position position, ItemStack seeds, Mono<Player> player);

    default Mono<Plant.PlantableFailure> canBePlanted(WorldReader world, Position position, BlockState state) {
        return asPlant().canBePlanted(world, position, state);
    }
}