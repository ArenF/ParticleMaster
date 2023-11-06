package org.aren.particlemaster.particles.shape;

import org.bukkit.Location;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class Line extends Shape {

    double length;
    int multiple;

    public Line(double length, int multiple) {
        this.length = length;
        this.multiple = multiple;
    }

    @Override
    public List<Location> getShapesLocation(Location location) {
        List<Location> result = new ArrayList<>();

        for (double i = 0; i < length; i += (multiple / length)) {
            addVector(new Vector(0, 0, i));
            Location loc = new Location(
                    location.getWorld(),
                    location.getX() + vector.getX(),
                    location.getY() + vector.getY(),
                    location.getZ() + vector.getZ()
            );
            result.add(loc);
        }
        return result;
    }
}
