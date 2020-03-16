package org.sandboxpowered.sandbox.api.world.generator;

import org.sandboxpowered.sandbox.api.util.math.Vec3i;
import org.sandboxpowered.sandbox.api.world.WorldReader;
import org.sandboxpowered.sandbox.api.world.chunk.ChunkData;

import java.util.Random;

public interface WorldGenerator {
    ChunkData generateChunkData(WorldReader world, Random random, Vec3i chunkPos); // How to handle biomes?
}
