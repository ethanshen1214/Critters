/* CRITTERS Critter.java
 * EE422C Project 5 submission by
 * Replace <...> with your actual data.
 * Ethan Shen
 * es38348
 * 16295
 * Osama Iqbal
 * oi723
 * 16295
 * Slip days used: <0>
 * Spring 2020
 */
package assignment5;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.control.*;

public class Main extends Application{


    private static int numTimeSteps = 0;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10,10,10,10));

        

        Label title = new Label("Welcome to Critters");
        title.setFont(new Font("Arial", 24));
        grid.add(title, 0,0);

        Stage secondStage = new Stage();                        //second stage for the critter grid
        GridPane world = new GridPane();
        //world.setPrefSize(750, 750);
        world.setMaxSize(Params.WORLD_WIDTH, Params.WORLD_HEIGHT);
        clearWorld(world);
        //world.setGridLinesVisible(true);
        //world.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");

        Stage thirdStage = new Stage();
        GridPane runStats = new GridPane();
        

/****************************************************************************************************************/ 
/**Set Seed */       

        Label seed = new Label("Set Seed (Integer): ");         //instruction label
        grid.add(seed, 0, 1);
        Label newSeedLabel = new Label();   //output label
        grid.add(newSeedLabel, 1,2);

        TextField setSeedField = new TextField();               //input text
        grid.add(setSeedField, 1,1);

        Button setSeedButton = new Button();                    //button
        setSeedButton.setText("Set Seed");
        grid.add(setSeedButton, 2, 1);

        setSeedButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                
                String newSeed = "Seed set to ";
                newSeed += setSeedField.getText();
                newSeedLabel.setText(newSeed);
                //actually set the seed
                long seed = Long.parseLong(setSeedField.getText());
                Critter.setSeed(seed);
            }
        });
/*******************************************************************************************************************/
/**Create Critters  */

        Label critterType = new Label("Critter Name (e.g. Clover): ");         //instruction label
        grid.add(critterType, 0, 4);


        TextField selectCritterType = new TextField();
        grid.add(selectCritterType, 1, 4);



        Label numCritters = new Label("Number of Critters: ");  
        grid.add(numCritters, 0, 5);
        TextField numCrittersField = new TextField();               //input text
        grid.add(numCrittersField, 1,5);

        Button addCrittersButton = new Button();                    //button
        addCrittersButton.setText("Add Critters");
        grid.add(addCrittersButton, 2, 5);

        Label addCritterLabel = new Label();    //output label
        grid.add(addCritterLabel, 1,6);


        addCrittersButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {

                                String addCritters = "";
                addCritters += numCrittersField.getText();
                addCritters += " ";
                addCritters += selectCritterType.getText();
                addCritters += " added";
                addCritterLabel.setText(addCritters);
                //actually add the critters
                String critter = "assignment5.";
                critter += selectCritterType.getText();
                int numCritters = Integer.parseInt(numCrittersField.getText());
                for(int i = 0; i < numCritters; i++)
                {
                    try{
                        Critter.createCritter(critter);
                    }
                    catch(InvalidCritterException e)
                    {
                        addCritterLabel.setText(selectCritterType.getText() + " is not a valid Critter type");
                    }
                }
            }
        });
/*************************************************************************************************************/
/**Time Step */

        Label numSteps = new Label("Number of Steps (default 1): ");         //instruction label
        grid.add(numSteps, 0, 7);
        Label numStepsLabel = new Label();   //output label
        grid.add(numStepsLabel, 1,8);
        Label totalStepsLabel = new Label();   //output label
        grid.add(totalStepsLabel, 1,9);

        TextField numStepsField = new TextField();               //input text
        grid.add(numStepsField, 1,7);

        Button numStepsButton = new Button();                    //button
        numStepsButton.setText("Time Step");
        grid.add(numStepsButton, 2, 7);

        numStepsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                String numSteps = "";
                int steps;
                if(numStepsField.getText().equals(""))
                {
                    steps = 1;
                    numSteps += "1";
                    numSteps += " time step completed.";
                    numTimeSteps += 1;
                } 
                else
                {
                    steps = Integer.parseInt(numStepsField.getText());
                    numSteps += numStepsField.getText();
                    numSteps += " time steps completed. ";
                    numTimeSteps += Integer.parseInt(numStepsField.getText());
                }
                numStepsLabel.setText(numSteps);
                totalStepsLabel.setText("Time: " + Integer.toString(numTimeSteps));

                //actually do a time step    
                for(int i = 0; i < steps; i++)
                {
                    Critter.worldTimeStep();
                }

                clearWorld(world);
                Critter.displayWorld(world);
            }
        });

/**********************************************************************************************************/
/**Quit button */

        Button quitButton = new Button();                    //button
        quitButton.setText("Quit");
        grid.add(quitButton, 1, 12);

        quitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                System.exit(0);
            }
        });

/**********************************************************************************************************/
/**Display World */



        Button displayWorldButton = new Button();                    //button
        displayWorldButton.setText("Display World");
        grid.add(displayWorldButton, 0, 12);

        displayWorldButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                //call Critter.displayWorld(); with a pane object
                clearWorld(world);
                Critter.displayWorld(world);
            }
        });

/**********************************************************************************************************/
/**Run animation */                                                                      //NOT DONE
        Button runButton = new Button();                    //button
        runButton.setText("Run");
        grid.add(runButton, 0, 10);

        Button stopButton = new Button();
        stopButton.setText("Stop");
        grid.add(stopButton, 1, 10);

        Slider slider = new Slider(1, 10, 0);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(1f);
        slider.setSnapToTicks(true);
        grid.add(slider, 2, 10);


        AtomicInteger speed = new AtomicInteger(1);

        slider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(
               ObservableValue<? extends Number> observableValue, 
               Number oldValue, 
               Number newValue) { 
                    speed.set(newValue.intValue());
                    //System.out.println(speed.get());
              }
        });

        AnimationTimer animationRunner = new AnimationTimer(){
            private long lastUpdate = 0;
            @Override
            public void handle(long now) {
                // TODO Auto-generated method stub
                if(now - lastUpdate >= 500_000_000)
                {
                    for(int i = 0; i < speed.get(); i++)
                    {
                        Critter.worldTimeStep();
                    }
                    clearWorld(world);
                    Critter.displayWorld(world);
                    lastUpdate = now;
                }
            }
        };

        runButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                runButton.setDisable(true);
                setSeedButton.setDisable(true);
                addCrittersButton.setDisable(true);
                numStepsButton.setDisable(true);
                quitButton.setDisable(true);
                displayWorldButton.setDisable(true);               
                //start the timer
                animationRunner.start();
            }
        });

        stopButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                runButton.setDisable(false);
                setSeedButton.setDisable(false);
                addCrittersButton.setDisable(false);
                numStepsButton.setDisable(false);
                quitButton.setDisable(false);
                displayWorldButton.setDisable(false);  
                //stop the timer
                animationRunner.stop();
            }
        });

/**********************************************************************************************************/
/**runstats */                                                  //NOT DONE

/////use the third gridpane called runStats. it should show up on the third blank window



/************************************************************************************** */
/************************************************************************************** */
/************************************************************************************** */


        Scene scene = new Scene(grid, 550, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

        Scene scene2 = new Scene(world, 800, 800);
        secondStage.setScene(scene2);
        secondStage.show();

        Scene scene3 = new Scene(runStats, 550, 300);
        thirdStage.setScene(scene3);
        thirdStage.show();

    }

    public void clearWorld(GridPane world)
    {
        double height = (800/ Params.WORLD_HEIGHT);
		double width = (800/ Params.WORLD_WIDTH);
        
        for(int i = 0; i < world.getMaxWidth(); i ++)
        {
            for(int j = 0; j < world.getMaxHeight(); j++)
            {
                Rectangle rectangle = new Rectangle(width,height, Color.WHITE);
                rectangle.setStroke(javafx.scene.paint.Color.BLACK);
				world.add(rectangle, i,j);
            }
        }
        //world.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");
       
    }


}
