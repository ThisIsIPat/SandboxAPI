package org.sandboxpowered.sandbox.api.world.chunk;

import org.sandboxpowered.sandbox.api.state.BlockState;
import org.sandboxpowered.sandbox.api.util.math.Position;
import org.sandboxpowered.sandbox.api.util.math.Vec3i;
import org.sandboxpowered.sandbox.api.world.World;

/**
 * Represents blocks within a specified area with a position in a world
 */
public interface Chunk {
    BlockState getBlockState(Position position);
    void setBlockState(Position position, BlockState blockState);

    /**
     * @return world the chunk is located in
     */
    World getWorld();

    int getX();
    int getY();
    int getZ();

    int getXSize();
    int getYSize();
    int getZSize();
}
