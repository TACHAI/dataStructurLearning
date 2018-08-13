package LinkList;

/**
 * Created by @Author tachai
 * date 2018/8/10 23:40
 *
 * @Email 1206966083@qq.com
 */
public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e=e;
            this.next =next;
        }

        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }


        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedList(){
        head = null;
        size = 0;
    }
    //获得链表中的元素个数
    public int getSize(){
        return size;
    }
    //返回链表是否为空
    public boolean isEmpty(){
        return size==0;
    }

    public void addFirst(E e){
        Node node = new Node(e);
        node.next=head;
        head=node;
//        head=new Node(e,head);
        size++;
    }

    public void add(E e,int index){

        if(index<0||index>size){
            throw new IllegalArgumentException("Add failed.Illegal index.");
        }
        if(index==0){
            addFirst(e);
        }
        Node node = new Node(e);
        Node prev = head;
        for(int i=0;i<index-1;i++){
            prev=prev.next;
        }
        node.next=prev.next;
        prev.next=node;
//        prev.next= new Node(e,prev.next);
        size++;
    }

    //在链表末尾添加新的元素
    public void addLast(E e){
        add(e,size);
    }


}
