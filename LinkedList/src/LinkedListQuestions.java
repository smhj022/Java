/*

---------------------------------------------------------------------------

Question 1

LL: Find Middle Node

Implement a method called findMiddleNode that returns the middle node
of the linked list.

If the list has an even number of nodes, the method should return the
second middle node.

ODD Condition:
When the linked list has an odd number of nodes, like 1 -> 2 -> 3 -> 4 -> 5,
the function will find the exact middle node. In this case, it will return
the node containing the value 3.

EVEN Condition:
For example, if the linked list is 1 -> 2 -> 3 -> 4 -> 5 -> 6, the two middle
nodes are 3 and 4. The function will return the node containing the value 4.


//Floyd's Tortoise and Hare algorithm

Floyd’s cycle finding algorithm or Hare-Tortoise algorithm is a pointer algorithm
that uses only two pointers, moving through the sequence at different speeds.
This algorithm is used to find a loop in a linked list. It uses two pointers one
moving twice as fast as the other one. The faster one is called the fast pointer
and the other one is called the slow pointer


---------------------------------------------------------------------------

Question 2:

Implement a method called hasLoop that checks whether the list contains
a loop or not.If the list contains a loop, the method should return true;
otherwise, it should return false.

-------------------------------------------------------------------------

Question 3: Find Kth node from the end of a singly linked list

Singly Linked list does not have tail.

Implement a method called findKthFromEnd that returns the k-th node from the
end of the list. If the list has fewer than k nodes, the method should return null.

Note: This implementation of the Linked List class does not have the length attribute.
So length variable can not be used.

-------------------------------------------------------------------------------------

Question 4: Partition List

You have a singly linked list that DOES NOT HAVE A TAIL POINTER
(which will make this method simpler to implement).

Given a value x you need to rearrange the linked list such that all nodes with a
value less than x come before all nodes with a value greater than or equal to x.

Additionally, the relative order of nodes in both partitions should remain
unchanged.

Constraints:

The solution should traverse the linked list at most once.

The solution should not create a new linked list.


-------------------------------------------------------------------------------------

Question 5: Remove Duplicates

You are given a singly linked list that contains integer values, where some of these
values may be duplicated.

Your task is to implement a method called removeDuplicates() within the LinkedList
class that removes all duplicate values from the list.

Your method should not create a new list, but rather modify the existing list in-place,
 preserving the relative order of the nodes.

----------------------------------------------------------------------------------------

Question 6: Binary to Decimal Linked List

You have a linked list where each node represents a binary digit (0 or 1).
The goal of the binaryToDecimal function is to convert this binary number,
represented by the linked list, into its decimal equivalent.

e.g. -> 101 -> 1 * 2^0 + 0 * 2^1 + 1 * 2^2 = 5

------------------------------------------------------------------------------------

Question 7: Reverse a linked list between indices
 */


