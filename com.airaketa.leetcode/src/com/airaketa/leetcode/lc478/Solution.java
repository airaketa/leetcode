package com.airaketa.leetcode.lc478;

/**
 * https://leetcode.com/problems/generate-random-point-in-a-circle/
 */
class Solution {
    private final double centerX, centerY, radius;

    public Solution(double radius, double x_center, double y_center) {
        centerX = x_center;
        centerY = y_center;
        this.radius = radius;
    }

    public double[] randPoint() {
        double randomRadius = Math.sqrt(Math.random() * radius * radius);
        double angle = Math.random() * 2 * Math.PI;
        return new double[]{randomRadius * Math.cos(angle) + centerX, randomRadius * Math.sin(angle) + centerY};
    }


//    private final double centerX;
//    private final double centerY;
//    private final double minX;
//    private final double minY;
//    private final double radius;
//    private final double radiusSquare;
//
//    public Solution(double radius, double x_center, double y_center) {
//        centerX = x_center;
//        centerY = y_center;
//        minX = x_center - radius;
//        minY = y_center - radius;
//        this.radius = radius;
//        radiusSquare = radius * radius;
//    }
//
//    public double[] randPoint() {
//        double[] coords = new double[]{radius + 1, radius + 1};
//
//        while (!isInCircle(coords[0], coords[1])) {
//            coords[0] = randomCoordinate(minX);
//            coords[1] = randomCoordinate(minY);
//        }
//        return coords;
//    }
//
//    private boolean isInCircle(double x, double y) {
//        double xDiff = x - centerX;
//        double yDiff = y - centerY;
//        return xDiff * xDiff + yDiff * yDiff <= radiusSquare;
//    }
//
//    private double randomCoordinate(double min) {
//        return Math.random() * radius * 2 + min;
//    }
}