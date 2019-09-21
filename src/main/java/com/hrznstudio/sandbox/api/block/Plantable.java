package com.hrznstudio.sandbox.api.block;

import com.hrznstudio.sandbox.api.state.BlockState;
import com.hrznstudio.sandbox.api.util.math.Position;
import com.hrznstudio.sandbox.api.world.World;

public interface Plantable extends IBlock {
    /**
     * @return true if plant can be planted on this block
     */
    default boolean canPlantHere(World world, Position position, BlockState state, Plant plant) {
        return false;
    }
}