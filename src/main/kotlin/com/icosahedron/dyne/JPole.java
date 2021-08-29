package com.icosahedron.dyne;

import java.util.Arrays;
import java.util.Random;

public class JPole {
}

//package com.icosahedron.dyne.explore;
//
//        import java.util.Arrays;
//        import java.util.Random;
//
//public final class Pole {
//    private final Actor anchor;
//    private final Actor mast;
//    private final int[] ray = new int[Actor.VALENCE];
//    private int radius;
//    private final double[][] weights = new double[Actor.VALENCE][Actor.VALENCE];
//    private double totalWeight;
//    private int anchorDirection;
//    private int mastDirection;
//
//    public Pole(final Actor anchor, final Actor mast) {
//        this.anchor = new Actor(anchor);
//        this.mast = new Actor(mast);
//
//        for (int n=0; n<Actor.VALENCE; n++) {
//            this.ray[n] = mast.locationAt(n) - anchor.locationAt(n);
//        }
//
//        computeWeights();
//    }
//
//    @SuppressWarnings("CopyConstructorMissesField")
//    public Pole(final Pole pole) {
//        this(new Actor(pole.anchor), new Actor(pole.mast));
//    }
//
//    public int getRadius() {
//        return radius;
//    }
//
//    public void move(final Random random) {
//        chooseDirection(random);
//        anchor.move(anchorDirection, mastDirection);
//        mast.move(mastDirection, anchorDirection);
//
//        if (anchorDirection == mastDirection) {
//            return;
//        }
//
//        ray[anchorDirection] = ray[anchorDirection] - 1;
//        ray[mastDirection] = ray[mastDirection] + 1;
//        computeWeights();
//    }
//
//    private void chooseDirection(final Random random) {
//        final double discriminant = random.nextDouble() * totalWeight;
//        double sum = 0;
//
//        for (anchorDirection=0; anchorDirection<Actor.VALENCE; anchorDirection++) {
//            for (mastDirection=0; mastDirection<Actor.VALENCE; mastDirection++) {
//                sum += weights[anchorDirection][mastDirection];
//                if (sum > discriminant) return;
//            }
//        }
//    }
//
//    private void computeWeights() {
//        this.radius = (Math.abs(ray[0]) + Math.abs(ray[1]) + Math.abs(ray[2]) + Math.abs(ray[3])) / 2;
//        this.totalWeight = 0;
//
//        for (int x=0; x<Actor.VALENCE; x++) {
//            for (int y=0; y<Actor.VALENCE; y++) {
//                weights[x][y] = computeWeight(x, y);
//                totalWeight += weights[x][y];
//            }
//        }
//    }
//
//    private double computeWeight(final int x, final int y) {
//        final double radialFactor = computeRadialFactor(x, y);
//        return radialFactor * anchor.inertiaAt(x) * mast.inertiaAt(y);
//    }
//
//    private double computeRadialFactor(final int x, final int y) {
////        return 1.0;
//
//        if (ray[x] <= 0 && ray[y] >= 0) {
//            return 1.0 / (radius + 1);
//        }
//
//        if (ray[x] > 0 && ray[y] < 0) {
//            return radius == 1 ? 1.0 : 1.0 / (radius - 1);
//        }
//
//        return 1.0 / radius;
//    }
//
//    @Override
//    public String toString() {
//        return "Pole{" +
//                "anchor=" + anchor +
//                ", mast=" + mast +
//                ", ray=" + Arrays.toString(ray) +
//                ", radius=" + radius +
//                '}';
//    }
//}
//
