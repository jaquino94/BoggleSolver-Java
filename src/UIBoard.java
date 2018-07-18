import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class UIBoard implements Initializable {

    private Dictionary dictionary;
    private Dictionary foundWords;
    private BoggleSolver solver;
    private char charBoard[][];
    private int stepBoard[][];

    @FXML
    private BorderPane boggleBoard;

    @FXML
    private TextField t1;

    @FXML
    private TextField t2;

    @FXML
    private TextField t3;

    @FXML
    private TextField t4;

    @FXML
    private TextField t5;

    @FXML
    private TextField t6;

    @FXML
    private TextField t8;

    @FXML
    private TextField t7;

    @FXML
    private TextField t9;

    @FXML
    private TextField t10;

    @FXML
    private TextField t11;

    @FXML
    private TextField t12;

    @FXML
    private TextField t13;

    @FXML
    private TextField t14;

    @FXML
    private TextField t15;

    @FXML
    private TextField t16;

    @FXML
    private Button solveButton;

    @FXML
    private Button quitButton;

    @FXML
    private TextArea wordsFound;

    @FXML
    private TextField totalWords;

    @FXML
    void quitButtonPressed(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void solveButtonPressed(ActionEvent event) {
        charBoard[0][0] = t1.getText().toLowerCase().charAt(0);
        charBoard[0][1] = t2.getText().toLowerCase().charAt(0);
        charBoard[0][2] = t3.getText().toLowerCase().charAt(0);
        charBoard[0][3] = t4.getText().toLowerCase().charAt(0);
        charBoard[1][0] = t5.getText().toLowerCase().charAt(0);
        charBoard[1][1] = t6.getText().toLowerCase().charAt(0);
        charBoard[1][2] = t7.getText().toLowerCase().charAt(0);
        charBoard[1][3] = t8.getText().toLowerCase().charAt(0);
        charBoard[2][0] = t9.getText().toLowerCase().charAt(0);
        charBoard[2][1] = t10.getText().toLowerCase().charAt(0);
        charBoard[2][2] = t11.getText().toLowerCase().charAt(0);
        charBoard[2][3] = t12.getText().toLowerCase().charAt(0);
        charBoard[3][0] = t13.getText().toLowerCase().charAt(0);
        charBoard[3][1] = t14.getText().toLowerCase().charAt(0);
        charBoard[3][2] = t15.getText().toLowerCase().charAt(0);
        charBoard[3][3] = t16.getText().toLowerCase().charAt(0);

        foundWords = new Dictionary();
        wordsFound.setText("");
        solver.SolveBoard(dictionary, foundWords, wordsFound, charBoard, stepBoard, totalWords);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dictionary = new Dictionary("wordslc.txt");
        solver = new BoggleSolver();
        charBoard = new char[4][4];
        stepBoard = new int[4][4];

        //We have to manually individually set each textfield to only have one character input.
        t1.textProperty().addListener(new ChangeListener(t1,1));
        t2.textProperty().addListener(new ChangeListener(t2,1));
        t3.textProperty().addListener(new ChangeListener(t3,1));
        t4.textProperty().addListener(new ChangeListener(t4,1));
        t5.textProperty().addListener(new ChangeListener(t5,1));
        t6.textProperty().addListener(new ChangeListener(t6,1));
        t7.textProperty().addListener(new ChangeListener(t7,1));
        t8.textProperty().addListener(new ChangeListener(t8,1));
        t9.textProperty().addListener(new ChangeListener(t9,1));
        t10.textProperty().addListener(new ChangeListener(t10,1));
        t11.textProperty().addListener(new ChangeListener(t11,1));
        t12.textProperty().addListener(new ChangeListener(t12,1));
        t13.textProperty().addListener(new ChangeListener(t13,1));
        t14.textProperty().addListener(new ChangeListener(t14,1));
        t15.textProperty().addListener(new ChangeListener(t15,1));
        t16.textProperty().addListener(new ChangeListener(t16,1));

    }
}

