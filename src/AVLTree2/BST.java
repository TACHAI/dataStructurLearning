package AVLTree2;

/**
 * 二分搜索树
 * Create by tachai on 2020-11-04 19:48
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
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

    private int size;

    private Node root;


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



    public void add(E e){
        if(root==null){
            root= new Node(e);
            size++;
        }else {
            add(root,e);
        }
    }

    private void add(Node root,E e){
        Node node= new Node(e);
        ee(root,node);
    }


    private void ee(Node root,Node node){
        if(node.e.compareTo(root.e)==0){
            return;
        }
        if(node.e.compareTo(root.e)>0){
            if(root.right==null){
                root.right=node;
                size++;
            }else {
                ee(root.right,node);
            }
        }else {
            if(root.left==null){
                root.left=node;
            }else {
                ee(root.left,node);
            }
        }


    }


    public boolean contains(E e){

        return contains(root,e);
    }

    private boolean contains(Node node,E e){
        if(node==null){
            return false;
        }
        if(e.compareTo(node.e)==0){
            return true;

        }else if(e.compareTo(node.e)<0){
            return contains(node.left,e);
        }else {
            return contains(node.right,e);
        }
    }


    private Node removeMin(){
        Node min= NodeMin(root);
        //
        root = removeMin(root);

        return min;

    }

    private Node removeMax(){
        Node max= NodeMax(root);

        root= removeMax(root);
        return max;
    }

    private Node removeMin(Node node){
        if(node.left==null){
            size--;
            Node rightNode=node.right;
            node.right=null;
            return rightNode;
        }
        node.left=removeMin(node.left);
        return node;
    }

    private Node removeMax(Node node){
        if(node.right==null){
            size--;
            Node nodeLeft  = node.left;
            node.left=null;
            return nodeLeft;
        }
        node.right=removeMax(node.right);
        return node;
    }

    private Node NodeMin(Node node){
        if (node.right==null){
            return node;
        }
        return NodeMin(node.right);
    }


    private Node NodeMax(Node node){
        if(node.left==null){
            return node;
        }
        return NodeMax(node);
    }

    public void delete(E e){
        del(root,e);
    }

    private void del(Node root,E e){

    }
}
