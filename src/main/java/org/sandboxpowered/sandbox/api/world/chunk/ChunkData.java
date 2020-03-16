package org.sandboxpowered.sandbox.api.world.chunk;

import org.sandboxpowered.sandbox.api.state.BlockState;
import org.sandboxpowered.sandbox.api.util.math.Position;
import org.sandboxpowered.sandbox.api.util.math.Vec3i;
import org.sandboxpowered.sandbox.api.world.World;

public interface ChunkData {
    Chunk createChunk(World world, Vec3i chunkPos);

    BlockState getBlockState(Position relPos);
    void setBlockState(Position relPos, BlockState blockState);
}
