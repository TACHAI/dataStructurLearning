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
}
