package src.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * ClassName：com.code.apache_poi.treeNode.TreePrinter1 <br>
 * Description：(二叉树算法层序输出)<br>
 * @author wangxiong <br>
 * date 2020/4/28 14:40<br>
 * @version v1.0 <br>
 */
public class TreePrinter1 {

    /**
     * Title: printTree<br>
     * Author: wangxiong<br>
     * Description: 层序：(层序遍历:所有深度为D的节点要在深度为D+1的节点之前进行处理，
     * 层序遍历与其他类型的遍历不同的地方在于它不是递归地执行的，它用到队列，而不使用递归所默示的栈。
     * 算法思想：
     * 1.定义节点 TreeNode lastNode指向当前行最有节点，TreeNode nlastNode指向下一行最右节点。
     * 2.利用队列，首先将根节点入队,再循环里出队,并将其子节点入队,定义TreeNode tmpNode节点指向当前出队列的节点，
     * 当tmpNode==lastNode时，代表当前行遍历结束，输出换行，
     * 再令lastNode=nlastNode，nlastNode在子节点入队列时指向下一行最右节点。
     * 循环直到对列为空就行)<br>
     * Date:  14:22 <br>
     * @param root
     * return: int[][]
     */
    public static int[][] printTree(TreeNode root) {
        List<List<Integer>> list = new ArrayList< List<Integer> >();
        list.add(new ArrayList<Integer> ());
        Queue<TreeNode> queue = new LinkedList<TreeNode> ();
        queue.add(root);
        TreeNode lastNode = root;    // 当前行最右节点
        TreeNode nlastNode = root;    // 下一行最右节点
        TreeNode tmpNode = null;
        int hight = 0;                // 树的高度
        while(!queue.isEmpty()){
            tmpNode = queue.poll();
            if(tmpNode!=null){
                list.get(hight).add(tmpNode.val);
            }
            if(tmpNode.left!=null){
                queue.add(tmpNode.left);
                nlastNode = tmpNode.left;
            }
            if(tmpNode.right!=null){
                queue.add(tmpNode.right);
                nlastNode = tmpNode.right;
            }
            if(tmpNode == lastNode){
                lastNode = nlastNode;
                hight++;
                list.add(new ArrayList<Integer>());
            }
        }
        int[][] data = new int[list.size()][];
        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.get(i).size();j++){
                data[i][j] = list.get(i).get(j);
            }
        }

        return data;
    }
    public static void main(String[] args) {
        TreeNode e = new TreeNode(1);
        TreeNode g = new TreeNode(2);
        TreeNode h = new TreeNode(3);
        TreeNode i = new TreeNode(4);
        TreeNode d = new TreeNode(5,null,g);
        TreeNode f = new TreeNode(6,h,i);
        TreeNode b = new TreeNode(7,d,e);
        TreeNode c = new TreeNode(8,f,null);
        TreeNode root = new TreeNode(9,b,c);

        /* 测试层序 */
        int[][] data  =TreePrinter1.printTree(root);
        for(int s=0;s<data.length;s++){
            for(int j=0;j<data[s].length;j++){
                System.out.print(data[s][j]+" ");
            }
            System.out.println();
        }
    }
}
