package com.zte.string;

import com.sun.deploy.net.MessageHeader;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 */
public class Q257_binaryTreePaths {
    public static void main(String[] args) {

    }


    private static List<String> paths = new ArrayList<String>();

    private static List<String> binaryTreePaths(TreeNode root) {

        // dfs 深度优先搜索 回溯

        String line = "";
        dfs(root, line);
        return paths;
    }


    private static void dfs(TreeNode root, String path) {

        if (root == null) {
            return;
        }
        path += String.valueOf(root.val);
        if (root.left == null && root.right == null) {
            paths.add(path);
            return;
        }

        path = path + "->";
        dfs(root.left, path);
        dfs(root.right, path);

    }


//    -------------------------------其他深度dfs写法------------------------------------------------

    private void dfs1(List<String> res, TreeNode node, StringBuilder sb) {

        if (node == null) {
            return;
        }

        sb.append(node.val);
        if (node.left == null && node.right == null) {
            res.add(sb.toString());
            return;
        }

        // 注意
        if (node.left != null) {
            dfs1(res, node.left, new StringBuilder(sb).append("->"));
        }
        if (node.right != null) {
            dfs1(res, node.right, new StringBuilder(sb).append("->"));
        }
    }


//    -------------------利用剪枝-------------------

    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();


    private void dfs2(TreeNode root) {

        if (root == null) {
            return;
        }

        int t = path.length();
        path.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(path.toString());
        }

        path.append("->");
        dfs2(root.left);
        dfs2(root.right);

//StringBuilder是引用类型，而且是可变的，当然要每次递归中创建一个新的，不然可能会用上次递归的同一个StringBuilder。
// String类型也是引用类型，但是它是不可变的，每次修改底层会重新创建一个对象，所以使用String的话倒不用考虑这么多。
        // 所以这里要删除掉
        path.delete(t,path.length());

    }

//    -----------------------------广度优先搜索---------------------------------------------------

//    利用队列来保存路径，每次队首的拿出来判断是否是叶子节点，不是放最后

    private static  List<String> binaryTreePaths1(TreeNode root) {

        List<String> paths = new ArrayList<String>();
        if (root == null) {
            return paths;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<String> pathQueue = new LinkedList<String>();


        nodeQueue.offer(root);
        pathQueue.offer(Integer.toString(root.val));


        while (!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.poll();
            String path = pathQueue.poll();


            if (node.left == null && node.right == null) {
                paths.add(path);
            }else {
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    pathQueue.offer(new StringBuffer(path).append("->").append(node.left.val).toString());
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    pathQueue.offer(new StringBuffer(path).append("->").append(node.right.val).toString());
                }
            }

        }
        return paths;
    }




}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
