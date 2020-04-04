package assignment5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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
        grid.add(setSeedButton, 4, 1);

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

        final ComboBox selectCritterType = new ComboBox();
        selectCritterType.getItems().addAll(
            "assignment5.MyCritter1",
            "assignment5.MyCritter2",
            "assignment5.MyCritter3",
            "assignment5.MyCritter4",
            "assignment5.MyCritter5",
            "assignment5.MyCritter6",
            "assignment5.MyCritter7",
            "assignment5.Clover",
            "assignment5.Goblin"
        );
        grid.add(selectCritterType, 1, 4);



        Label numCritters = new Label("Number of Critters: ");  
        grid.add(numCritters, 0, 5);
        TextField numCrittersField = new TextField();               //input text
        grid.add(numCrittersField, 1,5);

        Button addCrittersButton = new Button();                    //button
        addCrittersButton.setText("Add Critters");
        grid.add(addCrittersButton, 4, 5);

        Label addCritterLabel = new Label();    //output label
        grid.add(addCritterLabel, 1,6);


        addCrittersButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                String addCritters = "";
                addCritters += numCrittersField.getText();
                addCritters += " ";
                addCritters += selectCritterType.getValue();
                addCritters += " added";
                addCritterLabel.setText(addCritters);
                //actually add the critters
                String critter = selectCritterType.getValue().toString();
                int numCritters = Integer.parseInt(numCrittersField.getText());
                for(int i = 0; i < numCritters; i++)
                {
                    try{
                        Critter.createCritter(critter);
                    }
                    catch(InvalidCritterException e)
                    {
                        e.printStackTrace();
                    }
                }
                //System.out.println(Critter.getPop());
            }
        });
/*************************************************************************************************************/
/**Time Step */

        Label numSteps = new Label("Number of Steps (default 1): ");         //instruction label
        grid.add(numSteps, 0, 7);
        Label numStepsLabel = new Label();   //output label
        grid.add(numStepsLabel, 1,8);

        TextField numStepsField = new TextField();               //input text
        grid.add(numStepsField, 1,7);

        Button numStepsButton = new Button();                    //button
        numStepsButton.setText("Time Step");
        grid.add(numStepsButton, 4, 7);

        numStepsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                String numSteps = "";
                numSteps += numStepsField.getText();
                numSteps += " time steps completed. ";
                numStepsLabel.setText(numSteps);
                //actually do a time step
                int steps;
                if(numStepsField.getText().equals(""))
                    steps = 1;
                else
                    steps = Integer.parseInt(numStepsField.getText());
                for(int i = 0; i < steps; i++)
                {
                    Critter.worldTimeStep();
                }

                // for(int a = 0; a < world.getMaxWidth(); a ++)//clears the grid
                // {
                //     for(int b = 0; b < world.getMaxHeight(); b++)
                //     {
                //         Rectangle rectangle = new Rectangle(30,30, Color.WHITE);
                //         world.add(rectangle, a,b);
                //     }
                // }
                clearWorld(world);
                Critter.displayWorld(world);
            }
        });

/**********************************************************************************************************/
/**Quit button */

        Button quitButton = new Button();                    //button
        quitButton.setText("Quit");
        grid.add(quitButton, 1, 10);

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
        grid.add(displayWorldButton, 0, 10);

        displayWorldButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                //world.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");
                //call Critter.displayWorld(); with a pane object
                clearWorld(world);
                Critter.displayWorld(world);
            }
        });


        Scene scene = new Scene(grid, 550, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

        Scene scene2 = new Scene(world, 600, 600);
        secondStage.setScene(scene2);
        secondStage.show();


/************************************************************************************** */
/************************************************************************************** */
/************************************************************************************** */






    }

    public void clearWorld(GridPane world)
    {
        for(int i = 0; i < world.getMaxWidth(); i ++)
        {
            for(int j = 0; j < world.getMaxHeight(); j++)
            {
                Rectangle rectangle = new Rectangle(30,30, Color.WHITE);
				world.add(rectangle, i,j);
            }
        }
        world.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");
    }
}
