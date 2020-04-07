package chapter1_exercise1to500.section3_exercise101to150;

import commons.TreeNode;

/*Given a binary tree, flatten it to a linked list in-place.*/
public class Ex114_FlattenBinaryTreeToLinkedList {
    //元素升序
    //分治递归

    //0ms 击败100%  梦游中写下该题
    public void flatten(TreeNode root) {
        if (root == null) return;
        flattenWorker(root);
    }

    //真正做事的
    public TreeNode flattenWorker(TreeNode root) {

        if (root.left == null && root.right == null) return root;
        if (root.left != null && root.right != null) {
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode leftNodes = flattenWorker(root.right);
            leftNodes.right = temp;
            return flattenWorker(temp);
        } else if (root.left == null) {
            return flattenWorker(root.right);
        }
        if (root.right == null) {
            root.right=root.left;
            root.left=null;
            return flattenWorker(root.right);
        }
        return null;
    }
}