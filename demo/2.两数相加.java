/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //设置一个进位，如果有进位就给后面的元素向上加一位
        if(l1==null&&l2==null)
        {
            //如果都是null，那么直接返回null
            return null;
        }
         //返回一个新的链表
        ListNode head=new ListNode(0);
        //将head指向头
        ListNode point = head;
        int carry = 0;
        //设置公共指针，说明两个链表都是有元素的
        while(l1 != null && l2!=null){
            int sum = carry + l1.val + l2.val;
            point.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            point = point.next;
        }
        //当第二个链表的元素，遍历完后还有剩余的话
        while(l1 != null) {
            int sum =  carry + l1.val;
            point.next = new ListNode(sum % 10);
            carry = sum /10;
            l1 = l1.next;
            point = point.next;
        }
        //当第一个链表的元素，便利完后还有剩余的话
        while(l2 != null) {
            int sum =  carry + l2.val;
            point.next = new ListNode(sum % 10);
            carry = sum /10;
            l2 = l2.next;
            point = point.next;
        }
        //如果最后还有可以进位的元素的话，放在链表头
        if (carry != 0) {
            point.next = new ListNode(carry);
        }
        //返回这个新的链表
        return head.next;
    }
}
// @lc code=end

