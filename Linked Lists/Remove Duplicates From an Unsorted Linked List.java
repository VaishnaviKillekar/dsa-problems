// Link to problem - https://www.codingninjas.com/studio/problems/remove-duplicates-from-unsorted-linked-list_1069331

/**
 * Intuition - Store elements discovered for the first time in set. When a duplicate is found,
 * use prev and curr pointers to eliminate it such that prev always points to the last unique
 * element in the list. Advance prev only when a unique element is found (not after removing duplicate).
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
public class Solution {
	
	public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {

        LinkedListNode<Integer> prev = head;        // Points to last unique element
        LinkedListNode<Integer> curr = head.next;   // Points to current element
        Set<Integer> set = new HashSet<>();
        
        // Add head to set
        set.add(head.data);

        while(curr != null) {
            if(set.contains(curr.data)) {
                // Duplicate - remove
                prev.next = curr.next;
            }
            else {
                // Unique element
                set.add(curr.data);
                prev = curr;
            }
            curr = curr.next;
        }

        return head;
	}

}
