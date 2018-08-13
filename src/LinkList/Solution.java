package LinkList;

/**
 * Created by @Author tachai
 * date 2018/8/13 22:28
 * GitHub https://github.com/TACHAI
 * Email 1206966083@qq.com
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
