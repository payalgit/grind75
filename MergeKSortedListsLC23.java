/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];
        ListNode result = new ListNode(0);
        ListNode head = result;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.val,b.val));

        for(ListNode list: lists)
        {
            if(list != null)
                pq.offer(list);
        }


       while(!pq.isEmpty())
       {
        ListNode node = pq.poll();
        head.next = node;
        head = head.next;

        if(node.next != null)
        {
            pq.offer(node.next);
        }
       }
       return result.next;

    }
}
