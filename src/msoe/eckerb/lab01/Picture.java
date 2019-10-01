/*
 * Course: CS2852 - 071
 * Spring 2019
 * Lab 1 - Dot 2 Dot Generator
 * Name: Brendan Ecker
 * Created: 3/5/2019
 */
package msoe.eckerb.lab01;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The picture class that has a load, drawDots, and drawLines
 * methods. These methods read the file and makes dots with
 * the x and y coordinates from the file and makes a dot object
 * with those coordinates, then draws the dots on the canvas,
 * and draws lines in between the dots.
 */

public class Picture {

    private ArrayList<Dot> dots = null;
    final private int WIDTH = 500;
    final private int HEIGHT = 500;

    /**
     * Gets a file that is at the specified path
     * and goes through the text and adds dots to
     * an ArrayList of dots.
     *
     * @param path  The path of the .dot file on the computer
     */

    public void load(Path path) throws IOException, NumberFormatException{
        dots = new ArrayList<>();

        try {
            Scanner in = new Scanner(path);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                String[] twoDots = line.split(",");
                double xCoord = Double.parseDouble(twoDots[0].trim());
                double yCoord = Double.parseDouble(twoDots[1].trim());
                Dot dot = new Dot(xCoord,yCoord);
                dots.add(dot);
            }


        }catch(IOException e){
            throw new IOException();
        } catch(NumberFormatException e){
            throw new NumberFormatException();
        }
    }

    /**
     * Goes through the ArrayList of dots from the load
     * method and draws ovals at the x and y coordinates
     * of the dots in the ArrayList
     *
     * @param canvas    The canvas where the ovals will be drawn
     */

    void drawDots(Canvas canvas){
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        graphicsContext.setFill(Color.BLACK);
        for (int i = 0; i < dots.size(); i ++) {
            graphicsContext.fillOval((dots.get(i).getxCoord()*WIDTH)-4, HEIGHT - (dots.get(i).getyCoord()*HEIGHT)-4, 8, 8);
        }

    }

    /**
     * Draws a path between the dots in the ArrayList
     *
     * @param canvas    The canvas where the lines will be drawn
     */

    void drawLines(Canvas canvas) {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        graphicsContext.setFill(Color.BLACK);
        graphicsContext.beginPath();
        graphicsContext.moveTo((dots.get(0).getxCoord()*WIDTH), HEIGHT - (dots.get(0).getyCoord()*HEIGHT));
        for (int i = 1; i < dots.size(); i ++){
            graphicsContext.lineTo((dots.get(i).getxCoord()*WIDTH), HEIGHT-(dots.get(i).getyCoord()*HEIGHT));
        }
        graphicsContext.closePath();
        graphicsContext.stroke();
    }
}
