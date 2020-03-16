package org.sandboxpowered.sandbox.api.world;

import org.sandboxpowered.sandbox.api.block.entity.BlockEntity;
import org.sandboxpowered.sandbox.api.state.BlockState;
import org.sandboxpowered.sandbox.api.state.FluidState;
import org.sandboxpowered.sandbox.api.util.math.Position;
import org.sandboxpowered.sandbox.api.world.chunk.Chunk;

import javax.annotation.Nullable;

/**
 * Read-only view of a world
 */
public interface WorldReader {
    int getChunkXSize();
    int getChunkYSize();
    int getChunkZSize();

    Chunk getChunkAt(int chunkX, int chunkY, int chunkZ);

    BlockState getBlockState(Position position);

    @Nullable
    BlockEntity getBlockEntity(Position position);

    FluidState getFluidState(Position position);

    default boolean isPositionInBounds(Position position) {
        return isHeightInBounds(position.getY()) &&
                position.getX() >= -30_000_000 &&
                position.getZ() >= -30_000_000 &&
                position.getX() < 30_000_000 &&
                position.getZ() < 30_000_000;
    }

    default boolean isHeightInBounds(int height) {
        return height > 0 && height < 256;  // Vanilla limitation
    }
}