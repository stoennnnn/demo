package src.tree;

/**
 *
 * ClassName：com.code.apache_poi.treeNode.TreePrinter <br>
 * Description：(二叉树算法)<br>
 * @author wangxiong <br>
 * date 2020/4/28 14:33<br>
 * @version v1.0 <br>
 *
 * 图片见：resources/TreeNode.webp
 */
public class TreePrinter {

    //树的结构的代码实现：
    public static void main(String[] args) {
        /*TreeNode e = new TreeNode(1);
        TreeNode g = new TreeNode(2);
        TreeNode h = new TreeNode(3);
        TreeNode i = new TreeNode(4);
        TreeNode d = new TreeNode(5,null,g);
        TreeNode f = new TreeNode(6,h,i);
        TreeNode b = new TreeNode(7,d,e);
        TreeNode c = new TreeNode(8,f,null);
        TreeNode root = new TreeNode(9,b,c);*/

        TreeNode g = new TreeNode(7);
        TreeNode d = new TreeNode(4,g,null);
        TreeNode e = new TreeNode(5);
        TreeNode b = new TreeNode(2,d,e);
        TreeNode h = new TreeNode(8);
        TreeNode a = new TreeNode(9);
        TreeNode f = new TreeNode(6,h,a);
        TreeNode c = new TreeNode(3,null,f);
        TreeNode root = new TreeNode(1,b,c);

        /* 测试后序 */
        printTree1 ( root );
        /* 测试中序 */
        printTree2 ( root );
        /* 测试前序 */
        printTree3 ( root );
    }


    /**
     * Title: printTree1<br>
     * Author: wangxiong<br>
     * Description: 中序：(先处理左子树，然后处理当前节点，再处理右子树。
     * 对于一颗二叉查找树，所有的信息都是有序排列的，中序遍历可以是信息有序输出，且运行时间为O（n）)<br>
     * Date:  14:21 <br>
     * @param t
     * return: void
     */
    public static void printTree1(TreeNode t){
        if(t!=null){
            printTree1(t.left);
            System.out.print("中序："+ t.val+" ");
            printTree1(t.right);
        }
    }

    /**
     * Title: printTree2<br>
     * Author: wangxiong<br>
     * Description: 后序： (先处理左右子树，然后再处理当前节点，运行时间为O（n）)<br>
     * Date:  14:19 <br>
     * @param t
     * return: void
     */
    public static void printTree2(TreeNode t){
        if(t!=null){
            printTree2(t.left);
            printTree2(t.right);
            System.out.print("后序："+t.val+" ");
        }
    }

    /**
     * Title: printTree3<br>
     * Author: wangxiong<br>
     * Description: 先序：(先处理当前节点，在处理左右子树)<br>
     * Date:  14:19 <br>
     * @param t
     * return: void
     */
    public static void printTree3(TreeNode t){
        if(t!=null){
            System.out.print("先序："+t.val+" ");
            printTree3(t.left);
            printTree3(t.right);
        }
    }

}
