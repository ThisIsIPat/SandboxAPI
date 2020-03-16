package org.sandboxpowered.sandbox.api.world;

import org.sandboxpowered.sandbox.api.entity.Entity;
import org.sandboxpowered.sandbox.api.state.BlockState;
import org.sandboxpowered.sandbox.api.util.math.Position;

import javax.annotation.Nullable;

/**
 * Write-only view of a world
 */
public interface WorldWriter {
    /**
     * Sets a {@link BlockState}
     *
     * @param position block position
     * @param state block state
     * @return true if the block state has been set successfully
     */
    default boolean setBlockState(Position position, BlockState state) {
        return setBlockState(position, state, BlockFlag.DEFAULT);
    }

    /**
     * Sets a {@link BlockState}
     *
     * @param position block position
     * @param state block state
     * @param flags additional steps to be performed when setting the block state
     * @return true if the block state has been set successfully
     */
    boolean setBlockState(Position position, BlockState state, BlockFlag... flags);

    /**
     * Triggers {@link org.sandboxpowered.sandbox.api.event.BlockEvent.Break}
     *
     * @param position block position
     * @param drop true if the block is supposed to drop items when broken
     * @return true if the block has been broken
     */
    default boolean breakBlock(Position position, boolean drop) {
        return breakBlock(position, drop, null);
    }

    /**
     * Triggers {@link org.sandboxpowered.sandbox.api.event.BlockEvent.Break}
     *
     * @param position block position
     * @param drop true if the block is supposed to drop items when broken
     * @param breakingEntity responsible entity
     * @return true if the block has been broken
     */
    boolean breakBlock(Position position, boolean drop, @Nullable Entity breakingEntity);
}