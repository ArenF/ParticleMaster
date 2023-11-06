package org.aren.particlemaster.particles.shape;

import org.bukkit.Location;

import java.util.Collections;
import java.util.List;

public class Dot extends Shape {

    @Override
    public List<Location> getShapesLocation(Location location) {

        return Collections.singletonList(new Location(location.getWorld(),
                location.getX() + vector.getX(),
                location.getY() + vector.getY(),
                location.getZ() + vector.getZ()));

    }

//    public Dot(Location location) {
//        super(location);
//    }
//
//    @Override
//    public List<Location> getShapesLocation() {
//        return Collections.singletonList(location);
//    }

}
