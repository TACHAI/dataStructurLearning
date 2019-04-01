package LinkList;

/**
 * Create by tachai on 2019-04-01 20:56
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i=0;i<5;i++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(66,2);

        System.out.println(linkedList.toString());

    }
}
