public class TreeNode {
    private final int MAX_SIZE = 32;
    private TreeNode charArr[];
    private boolean isAWord;

    public TreeNode(){
        this.charArr = new TreeNode[MAX_SIZE];
        this.isAWord = false;
    }

    public TreeNode getCharArr(int index) {
        return charArr[index];
    }

    public void setCharArr(int index, TreeNode treeNode) {
        this.charArr[index] = treeNode;
    }

    public boolean isAWord() {
        return isAWord;
    }

    public void setAWord(boolean AWord) {
        isAWord = AWord;
    }
}

