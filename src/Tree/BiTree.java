package Tree;

/**
 * @author ZhouPan
 * @date 2019/10/9 20:26.
 */

import java.util.ArrayList;
import java.util.List;

public class BiTree {
    public BiTree left;
    public BiTree right;
    public BiTree root;
    //    数据域
    private Object data;
    //    存节点
    public List<BiTree> datas;

    public BiTree(BiTree left, BiTree right, Object data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    //    将初始的左右孩子值为空
    public BiTree(Object data) {
        this(null, null, data);
    }

    public BiTree() {

    }

    public void creat(Object[] objs) {
        datas = new ArrayList<BiTree>();
        //        将一个数组的值依次转换为Node节点
        for (Object o : objs) {
            datas.add(new BiTree(o));
        }
//        第一个数为根节点
        root = datas.get(0);
//        建立二叉树
        for (int i = 0; i < objs.length / 2; i++) {
//            左孩子
            datas.get(i).left = datas.get(i * 2 + 1);
//            右孩子
            if (i * 2 + 2 < datas.size()) {//避免偶数的时候 下标越界
                datas.get(i).right = datas.get(i * 2 + 2);
            }

        }

    }

    //先序遍历
    public void preorder(BiTree root) {
        if (root != null) {
            System.out.println(root.data);
            preorder(root.left);
            preorder(root.right);
        }

    }

    //中序遍历
    public void inorder(BiTree root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }

    }

    //    后序遍历
    public void afterorder(BiTree root) {
        if (root != null) {
            System.out.println(root.data);
            afterorder(root.left);
            afterorder(root.right);
        }

    }

    public static void main(String[] args) {
        BiTree bintree = new BiTree();
        Object[] a = {2, 4, 5, 7, 1, 6, 12, 32, 51, 22};
        bintree.creat(a);
//        bintree.preorder(bintree.root);
        bintree.inorder(bintree.root);
    }
}

