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

        

        Label title = new Label("Welcome to Critters");
        title.setFont(new Font("Arial", 24));
        grid.add(title, 0,0);

/********************************************************************************/        

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
            }
        });
/********************************************************************************/

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
                //actually add the critter
            }
        });
/********************************************************************************/


        Scene scene = new Scene(grid, 500, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
