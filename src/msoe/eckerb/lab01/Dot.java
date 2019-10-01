/*
 * Course: CS2852 - 071
 * Spring 2019
 * Lab 1 - Dot 2 Dot Generator
 * Name: Brendan Ecker
 * Created: 3/5/2019
 */
package msoe.eckerb.lab01;

/**
 * The Dot class that has a x and y coordinate
 */

public class Dot {

    private final double xCoord;
    private final double yCoord;

    /**
     * The constructor of the dot object
     *
     * @param xCoord    The x coordinate of where the dot will be drawn.
     * @param yCoord    The y coordinate of where the dot will be drawn.
     */

    public Dot(double xCoord, double yCoord){
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    /**
     * Retrieves the x coordinate of the dot.
     *
     * @return  The x coordinate
     */

    public double getxCoord() {
        return xCoord;
    }

    /**
     * Retrieves the y coordinate of the dot.
     *
     * @return  The y coordinate
     */

    public double getyCoord() {
        return yCoord;
    }
}
