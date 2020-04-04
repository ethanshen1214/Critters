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

public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
/********************************************************************************/
        

        Label title = new Label("Welcome to Critters");
        title.setFont(new Font("Arial", 24));
        grid.add(title, 0,0);

        Label seed = new Label("Set Seed (Integer): ");         //instruction label
        grid.add(seed, 0, 1);
        Label newSeedLabel = new Label();
        grid.add(newSeedLabel, 2,2);

        TextField setSeedField = new TextField();               //input text
        grid.add(setSeedField, 2,1);

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
            }
        });
/********************************************************************************/

        Scene scene = new Scene(grid, 500, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
