package queue;

import LinkList.LinkedList;

/**
 * Created by @Author tachai
 * date 2018/8/12 17:50
 * GitHub https://github.com/TACHAI
 * Email 1206966083@qq.com
 */
public class LinkedListQueue<E> implements Queue<E>  {

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
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

    private Node head,tail;
    private int size;



    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void enqueue(E e) {
        if(tail == null){
            tail = new Node(e);
            head=tail;
        }else {
            tail.next=new Node(e);
            tail=tail.next;
        }
        size++;
    }
    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue empty queue");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if(head == null){
            tail=null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFornt() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue empty queue");
        }
        return head.e;
    }

    @Override
    public String toString(){
        StringBuilder res= new StringBuilder();
        res.append("Queue:front");
        Node cur = head;
        while (cur!=null){
            res.append(cur+"->");
            cur=cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }
}
