package com.icosahedron.dyne;

import com.icosahedron.dyne.*;

import java.util.concurrent.ThreadLocalRandom;

public final class DPole {
//    private final long frequency;
//    private final Event origin;
//    private final Event endpoint;
////    private final Tetray separation;
//
//    public DPole(final Tetray originInertia, final Tetray endpoint, final Tetray endpointInertia) {
//        this.frequency = originInertia.sum() * endpointInertia.sum();
//
//        final Location originLocation = new Location(new Tetray(0,0,0,0));
//        final Action<Direction> originStep = new Action<>(this.frequency);
//        final Inertia originInertia = new Inertia()
//        this.origin = new Event(originLocation, originInertia)
//        final Location endpointLocation = new Location(endpoint);
//
//        this.origin = originLocation
//        this.origin = new Event()
//        final Location location, final Inertia inertia
//    }
//
//    public void move(final Direction direction0, final Direction direction1) {
//        event0.move(direction0);
//        event1.move(direction1);
//    }
//
//    public boolean pickAndExecuteMove() {
//        final long bound = event0.totalWeight() * event1.totalWeight();
//        final long discriminant = ThreadLocalRandom.current().nextLong(bound);
//        final Acceleration change = chooseChange(discriminant);
//
////        if (!canMove(change)) {
////            return false;
////        }
////
////        move(change);
//        return true;
//    }
//
//    public Acceleration chooseChange(long discriminant) {
//        for (final Direction directionFrom : Direction.values()) {
//            for (final Direction directionTo : Direction.values()) {
//                discriminant -= event0.weight(directionFrom) * event1.weight(directionTo);
//
//                if (discriminant <= 0) {
//                    return new Acceleration(directionFrom, directionTo);
//                }
//            }
//        }
//
//        throw new IllegalArgumentException("Discriminant is too large: " + discriminant);
//    }
//
}