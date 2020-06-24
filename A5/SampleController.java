package application;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javax.xml.bind.JAXB;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class SampleController {
	
    // Holds the current selected color
    private Color fillColor = Color.BLACK;

    // holds the current selected radius
    private double radius = 10;

	//holds the current selected shape
    private boolean isCircle = true;

	//create an instance of container class
	private ListsOfCircle list = new ListsOfCircle();
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton rbBlack;

    @FXML
    private ToggleGroup togGrpColor;

    @FXML
    private RadioButton rbRed;

    @FXML
    private ToggleGroup groupDrawingColor;

    @FXML
    private RadioButton rbGreen;

    @FXML
    private RadioButton rbBlue;

    @FXML
    private RadioButton rbSmall;

    @FXML
    private ToggleGroup togGrpSize;

    @FXML
    private RadioButton rbMedium;

    @FXML
    private ToggleGroup groupDrawingColor1;

    @FXML
    private RadioButton rbLarge;

    @FXML
    private RadioButton rbCircle;

    @FXML
    private ToggleGroup togGrpShape;

    @FXML
    private RadioButton rbSquare;
    
    @FXML
    private Button btnUndo;
    
    @FXML
    private Button btnSerialize;

    @FXML
    private Button btnClear;

    @FXML
    private Pane paneDraw;

    /**
     * clears the drawing area
     * 
     * @param event
     */
    @FXML
    void btnClearClicked(ActionEvent event) {
        paneDraw.getChildren().clear();
        //clear all the circle data
        list = new ListsOfCircle();
    }
    
    //validate the input from the user
    private boolean isValid(String fileName) {
    	//regular expression
    	String regex = "[A-Z][a-zA-Z]{2,}\\d+[a-zA-Z]*.XML";
    	//covert regular expression into the Pattern class, 
    	//which make sure all the rules applied to the incoming 
    	//input string
    	Pattern p = Pattern.compile(regex);
    	//validate the input with the regular expression
    	if(p.matcher(fileName).matches()) {
    		return true;
    	}
    	return false;
    }
    
    @FXML
    void btnSerialize(ActionEvent event) {
    	//create a dialog that allow the user to input
    	TextInputDialog textDialog = new TextInputDialog();
    	//set up the description of dialog
    	textDialog.setTitle("File Name");
    	textDialog.setContentText("Enter a file name:");
    	textDialog.setHeaderText("File Name Format:\n"
    			+ "\t1.Starts with an uppercase letter\n" 
    			+ "\t2.Followed by two or more letter\n" 
    			+ "\t3.Followed by at least one number\n" 
    			+ "\t4.Followed by zero or more letters\n" 
    			+ "\t5.Ends with .XML");
    	
    	//display the window and wait for the user to input the string
    	Optional<String> result = textDialog.showAndWait();
    	//check if the user input enter or not and validate the 
    	//input if the user enter the file name
    	if(result.isPresent() && isValid(result.get())) {
    		//Serialize the object into XML format
    		Path path = Paths.get(result.get());
    		try(BufferedWriter output = Files.newBufferedWriter(path);){
    			JAXB.marshal(list, output);
    			//create an information dialog that print the message
        		Alert dialog = new Alert(AlertType.INFORMATION);
        		//set up the description of dialog
        		dialog.setHeaderText("Successfully written all circles to file " + result.get());
        		dialog.setTitle("Serilization");
        		dialog.show();
    		}catch(IOException e){
    			e.printStackTrace();
    		 }
    	}
    	else {
    		Alert dialog = new Alert(AlertType.INFORMATION);
    		dialog.setHeaderText("File serilization cancelled by user or does not match RegEx");
    		dialog.setTitle("Serilization cancelled");
    		dialog.show();
    	}	
    }
    
    


	/**
     * undo the last added shape
     * 
     * @param event
     */
    @FXML
    void btnUndo(ActionEvent event) {
        if (!paneDraw.getChildren().isEmpty()) {
        	//if the last element in the canvas is circle, remove
        	//the last circle in the container class ListsOfCircle
        	if(paneDraw.getChildren().get(paneDraw.getChildren().size() - 1) instanceof Circle) {
        		list.getListCircle().remove(list.getListCircle().size() - 1);
        	}
            paneDraw.getChildren().remove(paneDraw.getChildren().size() - 1);
        }
    }

    /**
     * Called when mouse is dragged on the drawing panel
     * 
     * @param event
     */
    @FXML
    void drawPaneMouseDrag(MouseEvent event) {
    	//When the pen shape is circle, draw a circle into canvas
    	//Also, add the data of circle into container class ListsOfCircle
    	if(isCircle) {
    		paneDraw.getChildren().add(new Circle(event.getX(), event.getY(), radius, fillColor));
    		A5Shape data = new A5Shape(event.getX(), event.getY(), radius);
    		list.getListCircle().add(data);
    	}
    	//Else, draw the square into canvas
    	else {
    		Rectangle square = new Rectangle(event.getX(), event.getY(), radius, radius);
    		square.setFill(fillColor);
    		paneDraw.getChildren().add(square);
    	}
    	
    }

    @FXML
    void initialize() {

    	assert rbBlack != null : "fx:id=\"rbBlack\" was not injected: check your FXML file 'Sample.fxml'.";
        assert togGrpColor != null : "fx:id=\"togGrpColor\" was not injected: check your FXML file 'Sample.fxml'.";
        assert rbRed != null : "fx:id=\"rbRed\" was not injected: check your FXML file 'Sample.fxml'.";
        assert rbGreen != null : "fx:id=\"rbGreen\" was not injected: check your FXML file 'Sample.fxml'.";
        assert rbBlue != null : "fx:id=\"rbBlue\" was not injected: check your FXML file 'Sample.fxml'.";
        assert rbSmall != null : "fx:id=\"rbSmall\" was not injected: check your FXML file 'Sample.fxml'.";
        assert togGrpSize != null : "fx:id=\"togGrpSize\" was not injected: check your FXML file 'Sample.fxml'.";
        assert rbMedium != null : "fx:id=\"rbMedium\" was not injected: check your FXML file 'Sample.fxml'.";
        assert rbLarge != null : "fx:id=\"rbLarge\" was not injected: check your FXML file 'Sample.fxml'.";
        assert rbCircle != null : "fx:id=\"rbCircle\" was not injected: check your FXML file 'Sample.fxml'.";
        assert togGrpShape != null : "fx:id=\"togGrpShape\" was not injected: check your FXML file 'Sample.fxml'.";
        assert rbSquare != null : "fx:id=\"rbSquare\" was not injected: check your FXML file 'Sample.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Sample.fxml'.";
        assert btnUndo != null : "fx:id=\"btnUndo\" was not injected: check your FXML file 'Sample.fxml'.";
        assert btnSerialize != null : "fx:id=\"btnSerialize\" was not injected: check your FXML file 'Sample.fxml'.";
        assert paneDraw != null : "fx:id=\"paneDraw\" was not injected: check your FXML file 'Sample.fxml'.";

        // change listener for the color toggle group
        togGrpColor.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {

                if (rbBlue.isSelected())
                    fillColor = Color.BLUE;
                else if (rbRed.isSelected())
                    fillColor = Color.RED;
                else if (rbGreen.isSelected())
                    fillColor = Color.GREEN;
                else
                    fillColor = Color.BLACK;
            }
        });

        // change listener for the size toggle group
        togGrpSize.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {

                if (rbLarge.isSelected())
                    radius = 15;
                else if (rbMedium.isSelected())
                    radius = 10;
                else
                    radius = 5;
            }
        });
        
        togGrpShape.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
            	//if the circle button is clicked, got the shape
            	//of pen into circle, otherwise square shape of pen
                if(rbCircle.isSelected()) {
                	isCircle = true;
                }
                else {
                	isCircle = false;
                }
            }
        });
    }
}