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

Question 3: Find Kth node from the end

Implement a method called findKthFromEnd that returns the k-th node from the
end of the list. If the list has fewer than k nodes, the method should return null.

Note: This implementation of the Linked List class does not have the length attribute.
So length variable can not be used.

 */


