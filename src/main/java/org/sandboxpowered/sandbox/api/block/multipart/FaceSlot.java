package org.sandboxpowered.sandbox.api.block.multipart;

import org.sandboxpowered.sandbox.api.util.Direction;
import org.sandboxpowered.sandbox.api.util.Identity;

public enum FaceSlot implements Slot {
    DOWN(Direction.DOWN),
    UP(Direction.UP),
    NORTH(Direction.NORTH),
    SOUTH(Direction.SOUTH),
    WEST(Direction.WEST),
    EAST(Direction.EAST);

    private static final FaceSlot[] SLOTS = values();
    private final Direction direction;
    private final Identity identity;

    FaceSlot(Direction direction) {
        this.direction = direction;
        this.identity = Identity.of("sandbox", direction.getName());
    }

    public static FaceSlot from(Direction direction) {
        return SLOTS[direction.ordinal()];
    }

    public Direction getDirection() {
        return direction;
    }

    public Identity getIdentity() {
        return identity;
    }
}