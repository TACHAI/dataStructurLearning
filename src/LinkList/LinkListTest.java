package LinkList;

/**
 * Create by tachai on 2019-03-28 18:53
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class LinkListTest <T>{
    private class Node{
        public T data;
        public Node next;

        public Node(T t,Node next){
            this.data=t;
            this.next=next;
        }

        public Node(T t){
            this(t,null);
        }
        public Node(){
            this(null,null);
        }
    }
    private Node head;
    private int size;



    //初始化

    public LinkListTest(){
        head=null;
        size=0;
    }
    //大小
    public int getSize(){
        return size;
    }
    //是否为空
    public boolean isEmpty(){
        return size==0;
    }

    //增

    public void addfirst(T t){
        Node node = new Node(t);
        node.next=head;
        size++;
    }

    public void add(int index,T t){
        if(index<0||index>size){
            throw new IllegalArgumentException("add failed require index>=0 and index < size");
        }

        if(index==0){
            addfirst(t);
        }

        Node node =new Node(t);
        Node pre =head;
        for(int i=0;i<index-1;i++){
            pre =pre.next;
        }
        node.next=pre;
        pre.next=node;
        size++;

    }
    //删

    //改
    //查

}
