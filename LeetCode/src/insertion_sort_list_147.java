/**
 * 对链表进行插入排序
 * 思路:新建一个链表,遍历原链表，将每个节点加入新链表正确的位置
 */
public class insertion_sort_list_147 {
    public static void main(String[] args){
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(3);
        ListNode target = new insertion_sort_list_147().insertionSortList(listNode);
        while(target!=null){
            System.out.println(target.val+"-->");
            target = target.next;
        }
    }
    public ListNode insertionSortList(ListNode head) {
        ListNode dump = new ListNode(Integer.MIN_VALUE);
        ListNode pre = dump;
        ListNode cur = head;
        while(cur!=null){
            //保存当前节点的下一个节点
            ListNode next = cur.next;
            pre = dump;
            //找打当前节点正确位置的节点
            while(pre.next!=null && pre.next.val < cur.val){
                pre = pre.next;
            }
            //找到后，将当前节点加入到新链表中
            cur.next = pre.next;
            pre.next = cur;
            //处理下一节点
            cur = next;
        }

        return dump.next;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        this.val=x;
    }
}
