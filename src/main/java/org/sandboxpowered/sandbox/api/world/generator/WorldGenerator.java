package org.sandboxpowered.sandbox.api.world.generator;

import org.sandboxpowered.sandbox.api.world.WorldReader;
import org.sandboxpowered.sandbox.api.world.chunk.Chunk;

import java.util.Random;

public interface WorldGenerator {
    Chunk.ChunkData generateChunkData(WorldReader world, Random random, int chunkX, int chunkY, int chunkZ); // How to handle biomes?
}
