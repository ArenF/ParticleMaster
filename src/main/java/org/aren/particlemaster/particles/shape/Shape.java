package org.aren.particlemaster.particles.shape;

import org.aren.particlemaster.coordinate.RotationMatrix;
import org.bukkit.Location;
import org.bukkit.util.Vector;

import java.util.List;

public abstract class Shape {

    Vector vector;

    public Shape() {
        vector = new Vector(0, 0, 0);
    }

    public void addVector(Vector vector) {
        this.vector.add(vector);
    }

    public void setVector(Vector vector) {
        this.vector = vector;
    }

    public Vector getVector() {
        return vector;
    }

    public abstract List<Location> getShapesLocation(Location location);

}
