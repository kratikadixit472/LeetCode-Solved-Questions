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
        int n = lists.length;
        if(n == 0) return null;
        return divideAndConcur(lists, 0, n-1);
    }
    private ListNode divideAndConcur(ListNode[] lists, int l, int r) {
        if(l == r) return lists[l];

        int mid = (l + r) / 2;
        return merge(divideAndConcur(lists, l, mid), divideAndConcur(lists, mid+1, r));   
    }
    private ListNode merge(ListNode list1, ListNode list2) {
        
        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;

        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            }
            else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        curr.next = (list1 != null ? list1 : list2);

        return dummyNode.next;
    }
}