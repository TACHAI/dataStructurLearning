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

//    private Node head;
    private int size;

    private Node dummyHead;

//    {
//        dummyHead.e=null;
//    }


    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }


//    public LinkedList()
    //获得链表中的元素个数
    public int getSize(){
        return size;
    }
    //返回链表是否为空
    public boolean isEmpty(){
        return size==0;
    }

    public void addFirst(E e){
        dummyHead.next=new Node(e,dummyHead.next);
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
        Node prev = dummyHead;
        for(int i=0;i<index;i++){
            prev=prev.next;
        }
        prev.next=new Node(e,prev.next);
//        prev.next= new Node(e,prev.next);
        size++;
    }

    //在链表末尾添加新的元素
    public void addLast(E e){
        add(e,size);
    }


    public E get(int index){
        if(index<0||index>=size)
            throw new IllegalArgumentException("Add failed.Illegal index.");
//        Node cur = du
        Node cur= dummyHead.next;
        for(int i=0;i<index;i++){
            cur=cur.next;
        }
        return cur.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size-1);
    }


    public void set (int index,E e){
        Node cur = dummyHead.next;
        for(int i=0;i<index;i++){
            cur = cur.next;
        }
        cur.e=e;
    }

    //  true 包含 false 不包含
    public boolean contain(E e){
        Node cur = dummyHead.next;
//        for (int i=0;i<size;i++){
//            if(cur.e.equals(e)){
//                return true;
//            }
//            cur=cur.next;
//        }
//
        while (cur!=null){
            if(cur.e.equals(e)){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
//        Node cur = dummyHead.next;
//        while (cur!=null){
//            cur=cur.next;
//        }

        for(Node cur = dummyHead.next;cur!=null;cur=cur.next)
            res.append(cur+"->");


        res.append("NULL");
        return res.toString();
    }
}
