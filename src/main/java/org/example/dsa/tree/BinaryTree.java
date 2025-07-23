package org.example.dsa.tree;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int data){
        this.val = data;
    }
}
public class BinaryTree {
    TreeNode root = null;

    public void insert(int data){
        root = insertRec(root, data);
    }

    public TreeNode insertRec(TreeNode root, int data){
        if (root == null){
            root = new TreeNode(data);
        } else if (data < root.val) {
            root.left = insertRec(root.left, data);
        } else if (data > root.val) {
            root.left = insertRec(root.right, data);
        }

        return root;
    }

    public void printTree(){
        inOrder(root);
    }


    public void inOrder(TreeNode root){
        if(root != null){
            inOrder(root.left);
            System.out.println(root.val + " ");
            inOrder(root.right);
        }
    }

    public void preOrder(TreeNode root){
        if(root != null){
            System.out.println(root.val + " ");
            inOrder(root.left);
            inOrder(root.right);
        }
    }

    public void postOrder(TreeNode root){
        if(root != null){
            inOrder(root.left);
            inOrder(root.right);
            System.out.println(root.val + " ");

        }
    }
}
