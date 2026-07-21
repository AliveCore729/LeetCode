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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null||k==0) return head;
        int count=1;
        ListNode tail=head;
        while(tail.next!=null){
            tail=tail.next;
            count++;
        }
        k%=count;
        if(k==0) return head;
        tail.next=head;
        int n=count-k;
        ListNode newt=head;
        for(int i=1;i<n;i++){
            newt=newt.next;
        }
        head=newt.next;
        newt.next=null;

        return head;

    }
}