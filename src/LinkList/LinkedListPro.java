package LinkList;

/**
 * Created by @Author tachai
 * date 2018/8/10 23:40
 *
 * @Email 1206966083@qq.com
 */
public class LinkedListPro<E> {

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
    //虚拟节点
    private Node dummyHead;
    private int size;

    public LinkedListPro(){
        dummyHead = new Node(null,null);
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
     add(e,0);
        size++;
    }

    public void add(E e,int index){

        if(index<0||index>size){
            throw new IllegalArgumentException("Add failed.Illegal index.");
        }
        Node node = new Node(e);
        Node prev = dummyHead;
        for(int i=0;i<index;i++){
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

    //获得链表的第index个位置的元素
    //在链表中不是一个常用的操作，练习用
    public E get(int index){
        if(index <0 || index>=size)
            throw new IllegalArgumentException("Get faild.Illegal index.");

        Node cur = dummyHead.next;
        for(int i= 0; i<index;i++){
            cur=dummyHead.next;
        }
        return cur.e;
    }
    //获得链表的第一个元素
    public E getFirst(){
        return get(0);
    }
    //获得链表的最后一个元素
    public E getLast(){
        return get(size-1);
    }
    //修改链表的第index（0-base）个位置的元素为e
    //在链表中不是一个常用的操作，练习用：）
    public void set(int index,E e){
        if(index <0 || index>=size)
            throw new IllegalArgumentException("Get faild.Illegal index.");
        Node cur = dummyHead.next;
        for (int i=0;i<index;i++){
            cur=cur.next;
        }
        cur.e=e;
    }

    public boolean find(E e){
        Node cur = dummyHead.next;
        for (int i=0;i<size;i++){
            if(cur.e.equals(e)){
                return true;
            }
            cur=cur.next;
        }
//        while (cur !=null){
//            if(cur.e.equals(e)){
//                return true;
//            }
//            cur=cur.next;
//        }
        return false;
    }


    public E remove(int index){
        if(index <0 || index>=size)
            throw new IllegalArgumentException("Get faild.Illegal index.");
        //注意
        Node cur = dummyHead;
        for(int i=0;i<index;i++){
            cur = cur.next;
        }
        Node res=cur.next;
        cur.next=res.next;
        res.next=null;
        size--;
        return res.e;
    }

    public E removeFist(){
       return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null){
            res.append(cur + "->");
            cur=cur.next;
        }

//        for(Node cur =dummyHead.next;cur!=null;cur=cur.next){
//            res.append(cur + "->");
//        }
        res.append("NULL");
        return res.toString();
    }
}
