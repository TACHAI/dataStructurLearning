package Map;

import tree.BST;

import java.security.Key;

/**
 * Created by @Author tachai
 * date 2018/9/6 22:26
 * GitHub https://github.com/TACHAI
 * Email 1206966083@qq.com
 */
public class BSTMap<K extends Comparable<K>,V >implements Map<K,V> {

    private class Node{
        public K key;
        public V value;
        public Node left;
        public Node right;

        public Node(K key,V value){
            this.key=key;
            this.value=value;
            left=null;
            right=null;
        }
        @Override
        public String toString(){
            return key+":"+value;
        }
    }
    private Node root;
    private int size;

    public BSTMap(){
        root=null;
        size=0;
    }


    @Override
    public void add(K key, V value) {
        root =add(root,key,value);
    }

    @Override
    public V remove(K k) {
        Node node =getNode(root,k);
        if(node!=null){
            root = remove(root ,k);
            return node.value;
        }
        return null;
    }

    @Override
    public boolean contains(K k) {
        return getNode(root,k)!=null;
    }

    @Override
    public V get(K k) {
        Node node = getNode(root,k);
        return node==null?null:node.value;
    }

    @Override
    public void set(K k, V v) {
        Node node =getNode(root,k);
        if(node==null){
            throw new IllegalArgumentException(k+"does't exit");
        }
        node.value = v;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
    private Node add(Node node,K key,V value){
        if(node==null){
            size++;
            return new Node(key,value);
        }
        if(key.compareTo(node.key)<0){
            node.left=add(node.left,key,value);
        }else if(key.compareTo(node.key)>0){
            node.right = add(node.right,key,value);
        }else {
            node.value=value;
        }
        return node;
    }

    private Node getNode(Node node,K key){
        if(node==null){
            return null;
        }

        if(key.compareTo(node.key)==0){
            return node;
        }
        if(key.compareTo(node.key)<0){
            return getNode(node.left,key);
        }else {
            return getNode(node.right,key);
        }

    }

    private Node remove(Node node ,K key){
        if (node==null){
            return null;
        }
        if(key.compareTo(node.key)<0){
            node.left = remove(node.left,key);
            return node;
        }else if(key.compareTo(node.key)>0){
            node.right=remove(node.right,key);
            return node;
        }else {
            if(node.left==null){
                Node rightNode = node.right;
                node.right=null;
                size--;
                return rightNode;
            }
            if(node.right==null){
                Node leftNode = node.left;
                node.left=null;
                size--;
                return leftNode;    
            }
        }
        Node successor = minmum(node.right);
        successor.right = removeMin(node.right);
        size++;
        successor.left= node.left;
        node.left=node.right=null;
        size--;
        return successor;
    }
    private Node minmum(Node node){
        if (node.left==null)
            return node;
        return minmum(node.left);
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

}
