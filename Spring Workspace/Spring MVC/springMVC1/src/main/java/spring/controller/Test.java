package spring.controller;
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class Test {

    // Method to add two numbers represented by linked lists
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            int digit = sum % 10;
            temp.next = new ListNode(digit);
            temp = temp.next;
        }

        return dummyHead.next;
    }

    // Helper method to create a linked list from an array
    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        for (int num : arr) {
            temp.next = new ListNode(num);
            temp = temp.next;
        }
        return dummy.next;
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // Main method to test the logic
    public static void main(String[] args) {
        int[] list1 = {4, 5, 2}; // represents 254
        int[] list2 = {5, 3, 1}; // represents 135

        ListNode l1 = createList(list1);
        ListNode l2 = createList(list2);

        System.out.print("List 1: ");
        printList(l1);

        System.out.print("List 2: ");
        printList(l2);

        ListNode result = addTwoNumbers(l1, l2);

        System.out.print("Result : ");
        printList(result); // should print 9 -> 8 -> 3
    }
}
