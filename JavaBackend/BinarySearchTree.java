
public class BinarySearchTree {
   
    public static class Node {
        double score;
        String name;
        Node left;
        Node right;

        public Node(String name, double score) {
           
            this.score = score;
            this.name = name;
            this.left = null;
            this.right = null;
        }
    }

   
    public static Node root;
    public static boolean flag = false;

    public BinarySearchTree(Node root) {
        this.root = root;
    }

   
   
    
    public void insert(Node rootNode, double score, String name) {
        if (score < rootNode.score) {
            if (rootNode.left != null) {
                insert(rootNode.left, score, name);
            } else {

                rootNode.left = new Node(name, score);
            }
        } else if (score > rootNode.score) {
            if (rootNode.right != null) {
                insert(rootNode.right, score, name);
            } else {

                rootNode.right = new Node(name, score);
            }
        }
    }

    public static Node searchNode(Node temp, String name) {
        
        if (temp == null) {
            System.out.println("Tree is empty");
            return temp;
        } else {
           
            if (temp.name.equals(name)) {
                flag = true;
                return temp;
            }
           
            if (flag == false && temp.left != null) {
                searchNode(temp.left, name);
            }
           
            if (flag == false && temp.right != null) {
                searchNode(temp.right, name);
            }
        }
        return temp;
    }

   

}