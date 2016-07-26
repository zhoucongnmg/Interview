package link;

/**
 * 给定任意双向链表，按从小到大顺序输出。要求时间复杂度O(nlogn)，空间复杂度O(1)
 * @author zc
 *
 */
public class PrintDoubleLinked {

	public static void main(String[] args){
		DoubleLinkedNode n1 = new DoubleLinkedNode(5);
		DoubleLinkedNode n2 = new DoubleLinkedNode(6);
		DoubleLinkedNode n3 = new DoubleLinkedNode(3);
		DoubleLinkedNode n4 = new DoubleLinkedNode(2);
		DoubleLinkedNode n5 = new DoubleLinkedNode(10);
		n1.next = n2;
		n2.pre = n1;
		n2.next = n3;
		n3.pre = n2;
		n3.next = n4;
		n4.pre = n3;
		n4.next = n5;
		n5.pre = n4;
		PrintDoubleLinked p = new PrintDoubleLinked();
		p.sortDoubleLink(n1);

	}
	
	public void sortDoubleLink(DoubleLinkedNode head){
		DoubleLinkedNode root = convertTree(head);
		
		inOrder(root);
	}
	//双向链表转化为二叉树
	public DoubleLinkedNode convertTree(DoubleLinkedNode head){
		if(head == null || head.next == null)
			return head;
		DoubleLinkedNode root = null,temp = null;
		while(head != null){
			temp = head.next;
			head.pre = null;
			head.next = null;
			root = insertNode(root,head);
			head = temp;
		}
		return root;
	}
	
	public DoubleLinkedNode insertNode(DoubleLinkedNode root , DoubleLinkedNode node){
		if(root == null)
			return node;
		if(root.val > node.val)
			root.pre = insertNode(root.pre,node);
		else
			root.next = insertNode(root.next,node);
		return root;
	}
	
	//中序遍历
	public void inOrder(DoubleLinkedNode root){
		if(root == null)
			return;
		inOrder(root.pre);
		System.out.print(root.val+" ");
		inOrder(root.next);
	}
}
