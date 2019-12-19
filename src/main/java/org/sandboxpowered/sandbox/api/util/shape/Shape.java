package org.sandboxpowered.sandbox.api.util.shape;

import org.sandboxpowered.sandbox.api.util.Functions;
import org.sandboxpowered.sandbox.api.util.math.Position;
import org.sandboxpowered.sandbox.api.util.math.Vec3d;

import java.util.List;

public interface Shape {

    static Shape empty() {
        return Functions.getInstance().emptyShape();
    }

    static Shape full() {
        return Functions.getInstance().fullShape();
    }

    static Shape cube(double x, double y, double z, double x2, double y2, double z2) {
        return cube(Functions.getInstance().createBoundingBox(x,y,z,x2,y2,z2));
    }

    static Shape cube(BoundingBox box) {
        return Functions.getInstance().shapeFromBox(box);
    }

    Hit.BlockHit trace(Vec3d start, Vec3d end, Position position);

    boolean isEmpty();

    BoundingBox asBoundingBox();

    List<BoundingBox> getBoundingBoxes();

    boolean contains(double x, double y, double z);
}