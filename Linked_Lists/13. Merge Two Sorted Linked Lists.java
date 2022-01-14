/*
You have been given two sorted(in ascending order) singly linked lists of integers.
Write a function to merge them in such a way that the resulting singly linked list is also sorted(in ascending order) and return the new head to the list.

Note :
Try solving this in O(1) auxiliary space.

No need to print the list, it has already been taken care.

Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.
The first line of each test case or query contains the elements of the first sorted singly linked list separated by a single space. 
The second line of the input contains the elements of the second sorted singly linked list separated by a single space. 

Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element

Output :
For each test case/query, print the resulting sorted singly linked list, separated by a single space.
Output for every test case will be printed in a seperate line.

Constraints :
1 <= t = 10^2
0 <= N <= 10 ^ 4
0 <= M <= 10 ^ 4
Where N and M denote the sizes of the singly linked lists. 
Time Limit: 1sec

Sample Input 1 :
1
2 5 8 12 -1
3 6 9 -1
Sample Output 1 :
2 3 5 6 8 9 12 

Sample Input 2 :
2
2 5 8 12 -1
3 6 9 -1
10 40 60 60 80 -1
10 20 30 40 50 60 90 100 -1

Sample Output 2 :
2 3 5 6 8 9 12 
10 10 20 30 40 40 50 60 60 60 80 90 100
*/



//Solution class that contains functional codeto merege the given two sorted linked lists
/*

    Following is the Node class already written for the Linked List

    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;
    
        public LinkedListNode(T data) {
            this.data = data;
        }
    }

*/

public class Solution {
    
   
    public static LinkedListNode<Integer> mergeTwoSortedLinkedLists(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
         if(head1==null)
        return head2;
    
         if(head2==null)
        return head1;
     
        
          LinkedListNode<Integer> temp1=head1;
          LinkedListNode<Integer> temp2=head2;
          LinkedListNode<Integer> temp=null;
          LinkedListNode<Integer> ans=null;
        
        if(head1.data<head2.data)
        {
            ans=head1;
            temp=ans;
            temp1=head1.next;
        }
        
        else 
        {
            ans=head2;
            temp=ans;
            temp2=head2.next;
        }
        
        
        while(temp1!=null && temp2!=null)
        {
            if(temp1.data<temp2.data)
            {
                temp.next=temp1;
                temp1=temp1.next;
                temp=temp.next;
            }
            
            else
            {
                temp.next=temp2;
                temp2=temp2.next;
                temp=temp.next;
            }
            
        }
   
        if(temp1==null)
            temp.next=temp2;
        
        else if(temp2==null)
            temp.next=temp1;
        
    
    return ans;
    }
}



// Main Code
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;
    
    public LinkedListNode(T data) {
        this.data = data;
    }
}

public class Runner {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static LinkedListNode<Integer> takeInput() throws IOException {
        LinkedListNode<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while(i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
            if(head == null) {
                head = newNode;
                tail = newNode;
            }
            else {
                tail.next = newNode;
                tail = newNode;
            }
            i += 1;
        }

        return head;
    }
    
    public static void print(LinkedListNode<Integer> head){
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {
            
            LinkedListNode<Integer> head1 = takeInput(); 
            LinkedListNode<Integer> head2 = takeInput(); 

            LinkedListNode<Integer> newHead = Solution.mergeTwoSortedLinkedLists(head1, head2);
            print(newHead);
            
            t -= 1;
        }

    }
}