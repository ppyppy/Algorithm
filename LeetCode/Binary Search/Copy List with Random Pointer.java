//A linked list is given such that each node contains an additional random pointer which could point to any node
//in the list or null.


public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null)
            return null;
        RandomListNode p = head;
        RandomListNode q = null, h = null, pre = null;
        while(p!=null){
            q = new RandomListNode(p.label);
            if(h==null)
                h = q;
            if(pre!=null)
                pre.next = q;
            pre = q;
            p = p.next;
        }
        
        p=head; q=h;
        RandomListNode pn = null, qn = null;
        while(p!=null && q!=null){
            pn = p.next;
            qn = q.next;
            p.next = q;
            q.next = pn;
            p = pn;
            q = qn;
        }
        
        p=head; q=head.next;
        while(p!=null && q!=null){
            if(p.random!=null)
                q.random = p.random.next;
            if(p.next!=null)
                p = p.next.next;
            if(q.next!=null)
                q = q.next.next;
        }
        
        p=head; q=head.next;
        h=q;
        while(p!=null && q!=null){
            pn = q.next;
            p.next = pn;
            if(q.next!=null){
                q.next = q.next.next;
                q = q.next;
            }
            p = pn;
        }
        return h;
    }
}
