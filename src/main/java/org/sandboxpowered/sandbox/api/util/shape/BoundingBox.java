package org.sandboxpowered.sandbox.api.util.shape;

import org.sandboxpowered.sandbox.api.util.Functions;
import org.sandboxpowered.sandbox.api.util.math.Vec3d;

public interface BoundingBox {

    static BoundingBox from(double x, double y, double z, double x2, double y2, double z2) {
        return Functions.getInstance().createBoundingBox(x,y,z,x2,y2,z2);
    }

    static BoundingBox from(Vec3d min, Vec3d max) {
        return from(min.getX(), min.getY(), min.getZ(), max.getX(), max.getY(), max.getZ());
    }

    double getMinX();

    double getMinY();

    double getMinZ();

    double getMaxX();

    double getMaxY();

    double getMaxZ();

    Vec3d getMin();

    Vec3d getMax();
}