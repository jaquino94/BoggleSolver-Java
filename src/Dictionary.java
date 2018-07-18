import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Dictionary {
    public TreeNode root;
    public int wordCount;

    public Dictionary(){
        root = new TreeNode();
        wordCount = 0;
    }

    public Dictionary(String file){
        root = new TreeNode();
        wordCount = 0;
        try {
            Scanner scanner = new Scanner(new FileReader(getClass().getResource("/files/" + file).getFile()));

            while(scanner.hasNext()){
                addWord(scanner.next());
            }
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND");
            e.printStackTrace();
        }
    }

    public void addWord(String word){
        TreeNode currNode = root;
        for(int i = 0; i < word.length(); i++){
            int index = (int)word.charAt(i) - (int)'a';

            if(currNode.getCharArr(index) == null){
               currNode.setCharArr(index, new TreeNode());
            }
            currNode = currNode.getCharArr(index);
        }
        currNode.setAWord(true);
        wordCount++;
    }

    //The isAWord() and isAPrefix() may be combined into just one function.
    //The only difference is that isAWord() returns the node's boolean flag, while isAPrefix() only returns boolean.
    public boolean isAWord(String word){
        TreeNode tempNode = root;
        for(int i = 0; i < word.length(); i++){
            int index = calculateIndex(word.charAt(i));

            if(tempNode.getCharArr(index) == null){
                return false;
            }
            tempNode = tempNode.getCharArr(index);
        }
        return tempNode.isAWord();
    }

    public boolean isAPrefix(String prefix){
        TreeNode tempNode = root;
        for(int i = 0; i < prefix.length(); i++){
            int index = calculateIndex(prefix.charAt(i));

            if(tempNode.getCharArr(index) == null){
                return false;
            }
            tempNode = tempNode.getCharArr(index);
        }
        return true;
    }

    private int calculateIndex(char letter){
       return (int)letter - (int)'a';
    }
}
