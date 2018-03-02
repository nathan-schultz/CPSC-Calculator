import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.geometry.*;

public class ConfirmBox{
  static boolean answer;
  public static boolean display(String title, String message){
    Stage alertWindow = new Stage();
    alertWindow.initModality(Modality.APPLICATION_MODAL);
    alertWindow.setTitle(title);
    alertWindow.setMinWidth(300);
    Label label = new Label();
    label.setText(message);

    Button yesButton = new Button("YES");
    Button noButton = new Button("NO");

    yesButton.setOnAction(e -> {
      answer = true;
      alertWindow.close();
    });

    noButton.setOnAction(e -> {
      answer = false;
      alertWindow.close();
    });

    VBox layout = new VBox(10);
    layout.getChildren().addAll(label, yesButton, noButton);
    layout.setAlignment(Pos.CENTER);
    Scene scene = new Scene(layout);
    alertWindow.setScene(scene);
    alertWindow.showAndWait();
    return answer;
  }
}
