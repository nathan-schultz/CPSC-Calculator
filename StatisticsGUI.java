import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.WindowEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;



public class StatisticsGUI extends Application{

  Button submitButton;
  TextField variableName;
  Scene scene;
  TextField dataEntry;
  Button enterData;
  Button homeButton;
  Button closeButton;
  Stage window;

  /*the list that starts the process of calculating the operations
  mean, median, mode, standard deviation, Q1, Q3. Holds the dataEntry*/
  private ArrayList<Double> list1 = new ArrayList<Double>();

  public static void main(String []args){
    launch(args);
  }

  @Override
  public void start (Stage primaryStage) throws Exception{
    window = primaryStage;
    window.setTitle("Statistic Calculator");
    window.setOnCloseRequest(e -> { // if user trys to close the program
      e.consume();// instead of default close, closeApp alert will pop-up
      closeApp();
    });

    submitButton = new Button("Submit");
    enterData = new Button("Enter Data");
    homeButton = new Button("Home");
    variableName = new TextField("Enter the name of your variable...");
    dataEntry = new TextField( "Example: 123 456 789...");
    closeButton = new Button("Close");

    enterData.setOnAction(e -> isString(dataEntry, dataEntry.getText()));
    submitButton.setOnAction(e -> System.out.println("Your variable name is: " + variableName.getText()));
    closeButton.setOnAction(e -> closeApp());

    //Positions, Style, Size and Color
    submitButton.setTranslateY(-170);
    variableName.setTranslateY(-200);
    homeButton.setTranslateY(-200);
    homeButton.setTranslateX(-350);
    closeButton.setTranslateY(-173);
    closeButton.setTranslateX(-350);
    variableName.setMaxSize(300, 10);
    variableName.setStyle("-fx-text-fill: grey;");
    dataEntry.setMaxSize(600, 200);
    dataEntry.setTranslateY(-50);
    dataEntry.setTranslateX(50);
    enterData.setTranslateY(70);
    enterData.setTranslateX(-200);
    dataEntry.setAlignment(Pos.TOP_LEFT);
    dataEntry.setStyle("-fx-text-fill: grey; -fx-font-size: 24 arial;");



    // Layout
    StackPane layout = new StackPane();
    layout.getChildren().addAll(variableName, dataEntry, enterData, homeButton, submitButton, closeButton);


    Scene scene = new Scene(layout, 800, 450);
    window.setScene(scene);
    window.show();
  }
  // to make sure the input is all numbers with the exception of spaces

  private boolean isString(TextField input, String message){
    String valid = "[0-9\\s]+";
    if (message.matches(valid)){
      System.out.println("entered data is valid");
      //splits the string at spaces and converts each number to a double
      List<String> Varlist1 = new ArrayList<String>(Arrays.asList(message.split("\\s+")));
      for (String s: Varlist1) {
  			double newVal = Double.valueOf(s);
        list1.add(newVal);
  		}
      System.out.println(list1);
      return true;
    }else{
      System.out.println("entered data is invalid, input all numbers and spaces");
      return false;
    }
  }


  /*If user enters yes, the window will close
  ConfirmBox is a new stage created that pops up when this method is run */
  private void closeApp(){
    Boolean answer = ConfirmBox.display("ALERT!!", "Sure you want to exit?");
    if (answer)
      window.close();
  }

}
