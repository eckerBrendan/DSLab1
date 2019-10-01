/*
 * Course: CS2852 - 071
 * Spring 2019
 * Lab 1 - Dot 2 Dot Generator
 * Name: Brendan Ecker
 * Created: 3/5/2019
 */
package msoe.eckerb.lab01;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import java.io.IOException;

/**
 * This is the controller class of the Dot2Dot.fxml
 * file which has the responses of the Open, Close,
 * Lines Only, Dots Only, and Draw Both options.
 */

public class Dot2DotController {
    @FXML
    Menu drawMenu;
    @FXML
    Canvas canvas;
    private Picture picture = new Picture();
    final private double WIDTH = 500;
    final private double HEIGHT = 500;
    final private int ZERO_COORDS = 0;

    /**
     * Opens a file chooser to allow the user to choose a dot file
     * to draw the dots and lines of the image in the dot file.
     *
     * @param e     The action event when the open option is pressed
     */

    @FXML
    public void openResponse(ActionEvent e){
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillRect(ZERO_COORDS,ZERO_COORDS,WIDTH,HEIGHT);
        try {
            FileChooser fileChooser = new FileChooser();

            picture.load(fileChooser.showOpenDialog(null).toPath());
            picture.drawDots(canvas);
            picture.drawLines(canvas);
            drawMenu.setDisable(false);
        }catch(IOException e1){
            Alert ioAlert = new Alert(Alert.AlertType.ERROR);
            ioAlert.setTitle("IOException");
            ioAlert.setHeaderText("IOException");
            ioAlert.setContentText("There was a problem will the file that was chosen.");
            ioAlert.showAndWait();
        }catch (NumberFormatException e1){
            Alert numberException = new Alert(Alert.AlertType.ERROR);
            numberException.setTitle("Number Format Exception");
            numberException.setHeaderText("Number Format Exception");
            numberException.setContentText("The numbers in the file is not correctly formatted. The numbers must be positive and between 0 and 1.");
        }

    }

    /**
     * Closes the program when the close option is pressed
     *
     * @param e     The action event
     */

    @FXML
    public void closeResponse(ActionEvent e){
        Platform.exit();
    }

    /**
     * Clears the canvas of everything on it and then
     * uses the draw lines method in the picture class
     * to draw the lines on the canvas when the Lines Only
     * option is pressed.
     *
     * @param e     The action event when the Lines Only option is pressed
     */

    @FXML
    public void drawLines(ActionEvent e){
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillRect(ZERO_COORDS,ZERO_COORDS,WIDTH,HEIGHT);
        picture.drawLines(canvas);
    }

    /**
     * Clears the canvas of everything on it and then
     * uses the draw dots method in the picture class
     * to draw the dots on the canvas when the Dots Only
     * option is pressed.
     *
     * @param e     The action event when the Dots Only option is pressed
     */

    @FXML
    public void drawDots(ActionEvent e){
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillRect(ZERO_COORDS,ZERO_COORDS,WIDTH,HEIGHT);
        picture.drawDots(canvas);
    }

    /**
     * Clears the canvas of everything on it and then
     * uses the draw lines and draw dots method in the picture class
     * to draw the lines and dots on the canvas when the Draw Both
     * option is pressed.
     *
     * @param e     The action event when the Draw Both option is pressed
     */

    @FXML
    public void drawBoth(ActionEvent e){
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillRect(ZERO_COORDS,ZERO_COORDS,WIDTH,HEIGHT);
        picture.drawDots(canvas);
        picture.drawLines(canvas);
    }
}
