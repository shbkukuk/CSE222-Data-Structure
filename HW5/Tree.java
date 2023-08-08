import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Queue;
import java.util.Stack;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;


/**
 * The Tree class represents a tree data structure and provides methods for performing
 * various types of traversal on the tree.
 */

public class Tree{

    private String FILENAME = "src/data.txt"; // The file path to read data from
    private static final String DELIMITER = ";"; // The delimiter used in the data file to separate nodes
    private JTree jt; //The JTree object representing the tree
    private JFrame f; // The JFrame object containing the JTree

    /**
     * Creates a new Tree object and initializes the tree by reading data from a file and
     * creating a tree structure using the data.
     */
    public Tree()
    {
        /* Read context from txt and create  Map  */
        ArrayList<String> data = new ArrayList<>();
        try
        {
            File txt = new File(FILENAME); // Read txt
            Scanner myScanner = new Scanner(txt); // Create Scanner object
            // Create HashMap so we can check Key added just ones.
            
            //Create while loop untill nextline is empty
            
            while(myScanner.hasNextLine())
            {
                String line = myScanner.nextLine();
                data.add(line);
            } 
            myScanner.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        

        /* Create Tree Section  */
        Map<String, DefaultMutableTreeNode> information = new HashMap<>(); 
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        for (String line:data)
        {
            String[] nodes = line.split(DELIMITER);
            DefaultMutableTreeNode parent = root;
            for (String node : nodes) {
                if (!information.containsKey(node)) {
                    
                    DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(node);
                   
                    parent.add(newNode);
                    
                    information.put(node, newNode);
                }
                
                parent = information.get(node);
            }
        }
     
        f = new JFrame();
        jt = new JTree(root);
        f.add(jt);
        f.setSize(200, 200);
        f.setVisible(true);
    }


    /**
     * Uses breadth-first search to search for a node with the specified value in the tree.
     *
     * @param search the value to search for in the tree
     */
    public void bfs(String search)
    {
        System.out.println("Using BFS to find"+"'" +search+ "'"+ " in the Tree.");
        int step = 1; // Create for Print each Step 
        Queue<DefaultMutableTreeNode> queue = new LinkedList<>();
        queue.add((DefaultMutableTreeNode)jt.getModel().getRoot()); // Change TreeRoot type with DefaultMutableTreeNode
        while (!queue.isEmpty()) {
            DefaultMutableTreeNode node = queue.poll();
            if (node.toString().equals(search)) {
                System.out.println("Step ->"+step+" "+node.toString()+"(found)");
                return;
            }
            for (int i = 0; i < node.getChildCount(); i++) {
                queue.add((DefaultMutableTreeNode)node.getChildAt(i)); // Change TreeRoot type with DefaultMutableTreeNode
            }
            System.out.println("Step ->"+step+" "+node.toString());
            step++;
        }
        System.out.println("Node not found!");
    }


    /**
     * Uses depth-first search to search for a node with the specified value in the tree.
     *
     * @param search the value to search for in the tree
     */
    public void dfs(String search) {
        System.out.println("Using DFS to find " + "'" + search + "'" + " in the Tree.");
        int step = 1; // Create for Print each Step
        Stack<DefaultMutableTreeNode> stack = new Stack<>();
        stack.push((DefaultMutableTreeNode) jt.getModel().getRoot()); // Change TreeRoot type with DefaultMutableTreeNode
        while (!stack.isEmpty()) {
            DefaultMutableTreeNode node = stack.pop();
            if (node.getUserObject().equals(search)) {
                System.out.println("Step ->" + step + " " + node.toString() + "(found)");
                return;
            } else {
                System.out.println("Step ->" + step + " " + node.toString());
            }
            for (int i = node.getChildCount() - 1; i >= 0; i--) {
               stack.push((DefaultMutableTreeNode)node.getChildAt(i)); // Change TreeRoot type with DefaultMutableTreeNode
            }
            step++;
        }
            
        System.out.println("Node not found!");

    }

    /**
     * Uses post-order traversal to search for a node with the specified value in the tree.
     *
     * @param search the value to search for in the tree
     */
    public void postOrderTraverse(String search)
    {
    System.out.println("Using Post-order Traversal to find " + "'" + search + "'" + " in the Tree.");
    Stack<DefaultMutableTreeNode> stack = new Stack<>();
    DefaultMutableTreeNode node = (DefaultMutableTreeNode) jt.getModel().getRoot(); // Change TreeRoot type with DefaultMutableTreeNode
    DefaultMutableTreeNode lastVisitedNode = null;
    int step=1;
    stack.push(node);
    while (!stack.isEmpty()) {
        node = stack.peek();
        if (node.toString().equals(search)) {
            System.out.println("Step ->" + step + " " + node.toString() + "(found)");
            return;
        }
        else
        {
            System.out.println("Step ->"+step+" "+node.toString());
        }
        if (node.isLeaf() || lastVisitedNode == node.getLastChild()) {
            lastVisitedNode = stack.pop();
        } else {
            for (int i = node.getChildCount() - 1; i >= 0; i--) {
                stack.push((DefaultMutableTreeNode) node.getChildAt(i)); // Change TreeRoot type with DefaultMutableTreeNode
            }
        }
        step++;

    }
    System.out.println("Node not found!");
}


    public static void main(String[] args) throws Exception {
        Tree tree = new Tree();
        tree.postOrderTraverse("NOT");

    }
}
