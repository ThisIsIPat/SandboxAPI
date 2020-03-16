package org.sandboxpowered.sandbox.api.world.chunk;

import org.sandboxpowered.sandbox.api.state.BlockState;
import org.sandboxpowered.sandbox.api.world.World;

/**
 * Represents blocks within a specified area with a position in a world
 */
public interface Chunk {
    public BlockState getBlockAt(int relX, int relY, int relZ);
    public void setBlockAt(int relX, int relY, int relZ, BlockState blockState);

    /**
     * @return world the chunk is located in
     */
    public World getWorld();

    public int getX();
    public int getY();
    public int getZ();

    public int getXSize();
    public int getYSize();
    public int getZSize();
}
