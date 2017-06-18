package LeetCode.Problems.AddTwoNumbers;

/**
 * Created by Rachel on 6/18/2017.
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode (int[] list){

        this.val= list[0];
        ListNode currentNode = this;

        int i=1;
        while(i<list.length){
            currentNode.next= new ListNode(list[i]);
            currentNode = currentNode.next;
            i++;
        }
    }

   public String ToString(){

       ListNode currentNode = this;
       String result = "[" ;
       while(currentNode!=null){
           result = result + currentNode.val ;
           currentNode = currentNode.next;
           if(currentNode!= null)
               result = result + "," ;
       }


       result = result + "]";

       return result;


    }

}