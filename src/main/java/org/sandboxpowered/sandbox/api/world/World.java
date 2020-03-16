package org.sandboxpowered.sandbox.api.world;

import org.sandboxpowered.sandbox.api.entity.Entity;
import org.sandboxpowered.sandbox.api.util.Side;
import org.sandboxpowered.sandbox.api.world.chunk.Chunk;

import java.util.Collections;
import java.util.List;

public interface World extends WorldReader, WorldWriter {

    Side getSide();

    default List<Entity> getEntities() {
        return Collections.emptyList();
    }
}
