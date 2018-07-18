import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class BoggleSolver {
    private final int BOARD_MAX_SIZE = 4;

    private void SolveBoggle(int startRow, int startCol, Dictionary dictionary, Dictionary foundWords, TextArea words, int stepBoard[][],
                            int step, char charBoard[][], String currentPrefix){

        if(startRow < 0 || startCol < 0){
            return;
        }

        if(startRow >= BOARD_MAX_SIZE || startCol >= BOARD_MAX_SIZE){
            return;
        }

        if(stepBoard[startRow][startCol] != 0){
            return;
        }

        if(!dictionary.isAPrefix(currentPrefix)){
            return;
        }

        if(dictionary.isAWord(currentPrefix)){
            if(!foundWords.isAWord(currentPrefix)) {
                foundWords.addWord(currentPrefix);
                words.appendText(currentPrefix.toUpperCase() + "\n");
            }
        }

        stepBoard[startRow][startCol]= ++step;

        //UP
        SolveBoggle(startRow-1, startCol, dictionary, foundWords, words, stepBoard
                    ,step, charBoard, (currentPrefix + charBoard[startRow][startCol]));

        //DOWN
        SolveBoggle(startRow+1, startCol, dictionary, foundWords, words, stepBoard
                ,step, charBoard, (currentPrefix + charBoard[startRow][startCol]));

        //LEFT
        SolveBoggle(startRow, startCol-1, dictionary, foundWords, words, stepBoard
                ,step, charBoard, (currentPrefix + charBoard[startRow][startCol]));

        //RIGHT
        SolveBoggle(startRow, startCol+1, dictionary, foundWords, words, stepBoard
                ,step, charBoard, (currentPrefix + charBoard[startRow][startCol]));

        //UP-RIGHT
        SolveBoggle(startRow-1, startCol+1, dictionary, foundWords, words, stepBoard
                ,step, charBoard, (currentPrefix + charBoard[startRow][startCol]));

        //UP-LEFT
        SolveBoggle(startRow-1, startCol-1, dictionary, foundWords, words, stepBoard
                ,step, charBoard, (currentPrefix + charBoard[startRow][startCol]));

        //DOWN-LEFT
        SolveBoggle(startRow+1, startCol-1, dictionary, foundWords, words, stepBoard
                ,step, charBoard, (currentPrefix + charBoard[startRow][startCol]));

        //DOWN-RIGHT
        SolveBoggle(startRow+1, startCol+1, dictionary, foundWords, words, stepBoard
                ,step, charBoard, (currentPrefix + charBoard[startRow][startCol]));

        stepBoard[startRow][startCol] = 0;
    }

    public void SolveBoard(Dictionary dictionary, Dictionary foundWords, TextArea words, char charBoard[][],int stepBoard[][], TextField totalWords){
       String currentPrefix = "";
       int step = 0;
       int wordCount = 0;

       for(int startRow = 0; startRow < BOARD_MAX_SIZE; startRow++){
            for(int startCol = 0; startCol < BOARD_MAX_SIZE; startCol++) {
               SolveBoggle(startRow,startCol, dictionary, foundWords, words, stepBoard, step, charBoard, currentPrefix);
               step = 0;
            }
        }

        totalWords.setText(Integer.toString(foundWords.wordCount));
       }

}
