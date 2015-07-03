package cmo.leetcode;

public class SortList {
	public ListNode sortList(ListNode head) {
        return this.getRoot(head);
    }
	private ListNode getRoot(ListNode head){
		if(head==null||head.next==null){
			return head;
		}
		ListNode a = head;
		ListNode b = head;
		while(b.next!=null&&b.next.next!=null){
			a = a.next;
			b = b.next.next;
		}
		b = a.next;
		a.next = null;
		head = this.getRoot(head);
		b = this.getRoot(b);
		return this.merge(head, b);
	}
	private ListNode merge(ListNode l1,ListNode l2){
		if(l1==null){
			return l2;
		}else if(l2==null){
			return l1;
		}
        ListNode a = null;
        if(l1.val<l2.val){
    		a = l1;
    		l1 = l1.next;
    	}else{
    		a = l2;
    		l2 = l2.next;
    	}
        ListNode b = null;
        b = a;
        while(l1!=null&&l2!=null){
        	if(l1.val<l2.val){
        		b.next = l1;
        		l1 = l1.next;
        	}else{
        		b.next = l2;
        		l2 = l2.next;
        	}
        	b = b.next;
        }
        if(l1!=null){
        	b.next = l1;
        }else{
        	b.next = l2;
        }
        return a;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
