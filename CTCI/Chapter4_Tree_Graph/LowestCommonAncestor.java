/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 import java.util.Stack;
public class LowestCommonAncestor {

    /** Another method is find the path to p and q and store the trace in stack, list and return last similar node in both list **/

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
    Stack<TreeNode> s1 = new Stack<TreeNode>();

    Stack<TreeNode> s2 = new Stack<TreeNode>();

        //Find path
        findPath(root,p,s1);
        findPath(root,q,s2);
        TreeNode lca = null;
        while(!(s1.empty() && s2.empty())){
            if(s1.peek() != s2.peek()){
                break;
            }
            s1.pop();
            s2.pop();
        }
        return lca;


    }
    public void findPath(TreeNode root, TreeNode p, Stack<TreeNode> stack){
        if(root == null){
            return;
        }
        stack.push(root);
        if(root == p) return;
        findPath(root.left, p, stack);
        findPath(root.right,p,stack);
        stack.pop();
    }

    /** Most efficient solution  O(N) time and O(1) space*/
    /*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return null;
        if(root == p  || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null  && right == null) return null;
        if(left != null && right != null) return root;
        return (left!=null)? left:right;


    }*/
    /*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        //if(!(isPresent(root, p) && isPresent(root, q))) return null;
        return firstCA(root, p, q);
    }

    public TreeNode firstCA(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return null;
        if(root == p || root == q) return root;
        boolean left_p = isPresent(root.left, p);
        boolean left_q = isPresent(root.left,q);
        if(left_p && left_q) return firstCA(root.left,p,q);
        else if(left_p || left_q) return root;
        else{
            return firstCA(root.right, p, q);
        }
    }

    public boolean isPresent(TreeNode root, TreeNode node){
        if(root == null) return false;
        if(root == node) return true;
        return isPresent(root.left, node) || isPresent(root.right,node);
    }*/
}
