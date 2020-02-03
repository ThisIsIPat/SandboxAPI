package org.sandboxpowered.sandbox.api.world;

import org.sandboxpowered.sandbox.api.block.entity.BlockEntity;
import org.sandboxpowered.sandbox.api.state.BlockState;
import org.sandboxpowered.sandbox.api.state.FluidState;
import org.sandboxpowered.sandbox.api.util.math.Position;

import javax.annotation.Nullable;

public interface WorldReader {
    BlockState getBlockState(Position position);

    @Nullable
    BlockEntity getBlockEntity(Position position);

    FluidState getFluidState(Position position);

    default boolean isPositionInBounds(Position position) {
        return isHeightInBounds(position.getY()) &&
                position.getX() >= -30000000 &&
                position.getZ() >= -30000000 &&
                position.getX() < 30000000 &&
                position.getZ() < 30000000;
    }

    default boolean isHeightInBounds(int height) {
        return height > 0 && height < 256;
    } // Remove vanilla impl?
}