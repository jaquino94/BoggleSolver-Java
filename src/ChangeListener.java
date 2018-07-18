import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

/*
    The purpose of this class is for the program to only allow one character per text field. This allows us to fix the
    issue of the user being able to input multiple characters per text fields on the board.

    This class also allows to us to convert the user input to upper case letters.
    NOTE: The letters appearing as upper case is purely for cosmetics only.
    The program will convert the letters back to lower case once the user presses the 'Solve' button
 */
public class ChangeListener implements javafx.beans.value.ChangeListener<String> {

    private int maxLength;
    private TextField textField;

    public ChangeListener(TextField tf, int length){
        this.textField = tf;
        this.maxLength = length;
    }

    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

        if(newValue == null){
            return;
        }

        if(newValue.length() > maxLength){
            textField.setText(oldValue);
            textField.setText(textField.getText().toUpperCase());
        }
        else{
            textField.setText(newValue);
            textField.setText(textField.getText().toUpperCase());
        }

    }
}
