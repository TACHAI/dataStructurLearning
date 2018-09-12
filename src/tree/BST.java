package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by @Author tachai
 * date 2018/8/16 22:38
 * GitHub https://github.com/TACHAI
 * Email 1206966083@qq.com
 */
//二分搜索树
public class BST<E extends Comparable<E>> {
    private class Node{
        public E e;
        public Node left,right;

        public Node(E e){
            this.e=e;
            left=null;
            right=null;
        }
    }


    private Node root;
    private int size;

    public BST(){
        root=null;
        size=0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    //向二分搜索树中添加新的元素e
    public void add(E e){
       root = add(root,e);
    }
   //向以node为根的二分搜索树插入元素e
    //返回插入新节点后二分搜索树的根
    private Node add(Node node,E e){
        if(node==null){
            node=new Node(e);
            size++;
            return node;
        }
        if(e.compareTo(node.e)>0) {
            node.right = add(node.right,e);
        }else if(e.compareTo(node.e)<0){
           node.left=add(node.left,e);
        }
        return node;
    }

    public Node find(Node root,E e){
        if(e.equals(root.e)){
            return root;
        }
        if(e==null){
            return null;
        }
        if(e.compareTo(root.e)>0){
           root=find(root.right,e);
        }else
        root=find(root.left,e);
        return root;
    }
    public boolean contains(E e){
        return contains(root,e);
    }
    private boolean contains(Node node,E e){
        if(node == null)
            return false;
        if(e.compareTo(node.e)==0)
            return true;
        if(e.compareTo(root.e)>0){
            return contains(root.right,e);
        }else
            return contains(root.left,e);

    }

    //二分搜索树的前序遍历
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if(node==null)
            return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){

        if(node==null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node==null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }
    public void chen(){
        System.out.println(root.e);
        chen(root.left,root.right);
    }

    private void chen(Node left,Node right){
        if(left==null){
            return;
        }
        if (right==null)
            return;
        System.out.println(left.e);
        System.out.println(right.e);
        chen(left.left,left.right);
        chen(right.left,right.right);
    }


    public void levelOrder(){
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);
            if(cur.left!=null)
                queue.add(cur.left);
            if(cur.right!=null)
                queue.add(cur.right);
        }
    }

    //非递归遍历
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            if(cur.right!=null)
            stack.push(cur.right);
            if(cur.left!=null)
            stack.push(cur.left);
        }
    }


    //寻找二分搜索树最小数
    public E minmum(){
        if(root==null);
        return minmum(root).e;
    }



    private Node minmum(Node node){
        if (node.left==null)
            return node;
        return minmum(node.left);
    }
    //删除最小数
    public E removeMin(){
        E ret = minmum();
        removeMin(root);
        return ret;
    }
    private Node removeMin(Node node){
        if(node.left==null){
            Node rightNode = node.right;
            node.right=null;
            return rightNode;
        }
        node.left=removeMin(node.left);
        return node;
    }

    //寻找二分搜索树最大数
    public E manmum(){
        if(root==null);
        return manmum(root).e;
    }

    //删除最大数
    public E removeMan(){
        E ret = manmum();
        removeMan(root);
        return ret;
    }
    private Node removeMan(Node node){
        if(node.right==null){
            Node leftNode = node.left;
            node.left=null;
            return leftNode;
        }
        node.right=removeMan(node.right);
        return node;
    }
    private Node manmum(Node node){
        if (node.right==null)
            return node;
        return manmum(node.right);
    }


    //从二分搜索树中删除元素为e的节点
    public void remove(E e){
        root = remove(root,e);
    }

    //删除以node为根的二分搜索树中值为e的节点
    //返回删除节点后新的二分搜索树的根
    private Node remove(Node node,E e){
        if(node==null)
            return null;

        if(e.compareTo(node.e)<0){
            node.left=remove(node.left,e);
            return node;
        }else if(e.compareTo(node.e)>0){
            node.right=remove(node.right,e);
            return node;
        }else {//e==node.e
            //待删除节点左子树为空的情况
            if(node.left==node){
                Node rightNode =node.right;
                node.right=null;
                size--;
                return rightNode;
            }
            //待删除节点右子树为空的情况
            if(node.right==null){
                Node leftNode = node.left;
                node.left=null;
                size--;
                return leftNode;
            }
            //带删除节点左右植树均不为空
            //找到比待删除节点大的最小，即待删除节点右子树的最小节点
            //用这个节点顶替带删除节点的位置
            Node successor = minmum(node.right);
            successor.right = removeMin(node.right);
            size++;
            successor.left= node.left;
            node.left=node.right=null;
            size--;
            return successor;
        }

    }

    //生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generaterBSTString(Node node,int depth,StringBuilder res){
        if(node==null){
            res.append(generateDepthString(depth)+"null\n");
        return;
        }
        res.append(generateDepthString(depth)+node.e+"\n");
        generaterBSTString(node.left,depth+1,res);
        generaterBSTString(node.right,depth+1,res);
    }


    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i=0;i<depth;i++)
            res.append("--");
        return res.toString();
    }

}
