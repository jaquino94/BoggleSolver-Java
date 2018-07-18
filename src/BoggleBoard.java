import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BoggleBoard extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/files/UIBoard.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("Boggle Solver");
        stage.setScene(scene);
        stage.show();

    }
}
