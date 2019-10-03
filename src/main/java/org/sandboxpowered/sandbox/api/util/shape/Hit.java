package org.sandboxpowered.sandbox.api.util.shape;

import org.sandboxpowered.sandbox.api.util.Direction;
import org.sandboxpowered.sandbox.api.util.math.Position;
import org.sandboxpowered.sandbox.api.util.math.Vec3d;

public interface Hit {

    Vec3d getHitPosition();

    interface BlockHit extends Hit {
        Direction getDirection();

        Position getPosition();

        boolean didMiss();

        boolean isInside();
    }
}
