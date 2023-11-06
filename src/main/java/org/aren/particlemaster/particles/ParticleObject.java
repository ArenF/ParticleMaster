package org.aren.particlemaster.particles;

import org.aren.particlemaster.particles.shape.Shape;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class ParticleObject {

    List<Shape> structures = new ArrayList<>();
    Location location;


    public ParticleObject(Location location) {
        this.location = location;
    }

    public void addStructures(Shape shape) {
        structures.add(shape);
    }

    public List<Shape> getStructures() {
        return structures;
    }

    public Location getLocation() {
        return location;
    }

    public void setStructures(List<Shape> structures) {
        this.structures = structures;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
