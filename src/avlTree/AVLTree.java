package avlTree;

/**
 * Created by @Author tachai
 * date 2018/10/8 23:10
 * GitHub https://github.com/TACHAI
 * Email 1206966083@qq.com
 */
public class AVLTree<K extends Comparable<K>,V> {

    private class Node{
        public K key;
        public V value;
        public Node left,right;
        public int height;

        public Node(K key,V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height = 1;
        }
    }

    private Node root;
    private int size;

    public AVLTree(){
        root = null;
        size =0 ;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }
    private int getHeight(Node node){
        if(node == null){
            return 0;
        }
        return node.height;
    }
    // 获得节点node的平衡因子
    private int getBalanceFactor(Node node){
        if(node==null){
            return 0;
        }
        return getHeight(node.left)-getHeight(node.right);
    }
    //添加元素（key,value)
    public void add(K key,V value){
        root = add(root,key,value);
    }
    // 向以node为根的树中插入元素（key,value）递归算法
    // 返回插入新节点后树的根
    private Node add(Node node,K key,V value){
        if(node==null){
            size++;
            return new Node(key,value);
        }
        if(key.compareTo(node.key)<0){
            node.left = add(node.left,key,value);
        }else if(key.compareTo(node.key)>0){
            node.right = add(node.right,key,value);
        }else {
            node.value = value;
        }
        // 更新height
        node.height = 1 + Math.max(getHeight(node.left),getHeight(node.right));

        // 计算平衡因子
        int balanceFactor = getBalanceFactor(node);
        if(Math.abs(balanceFactor)>1){
            //todo
        }
        return node;
    }
}
