
**NOTE:** 
Converted the C++ code from another repository into Java code and created the GUI using JavaFX.

**How it works:** 
It works the same way the C++ program does, but since in Java, there are only references, we assign each references to each indices that the values corrolate to. 

The Dictionary class creates a tree data structure where each level is an array of TreeNode references/objects.
```Java
//charArr is an array of TreeNode objects. 
 this.charArr = new TreeNode[MAX_SIZE];
 ```
 We keep doing this for each character of the strings, so instead storing each word from the text file that we are reading from, we are reading each letter and have the index that correspond to that letter to the next TreeNode reference.

**OUTPUT:**

![](https://github.com/jaquino94/BoggleSolver-Java/blob/origin/master/imgs/JavaUI.png "The GUI made through JavaFX")

![](https://github.com/jaquino94/BoggleSolver-Java/blob/origin/master/imgs/Output.png "Boggle Board with user inputs, and the found words")
