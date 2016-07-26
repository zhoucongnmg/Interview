package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *  二叉树遍历
 * @author zc
 *
 */
public class TreeOrder {
	
	public static void main(String[] args){
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(6);
		TreeNode t4 = new TreeNode(1);
		TreeNode t5 = new TreeNode(3);

		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		
		TreeOrder to = new TreeOrder();
		
//		System.out.println("后序遍历为");
//		to.postOrder(t1);
		
//		System.out.println("中序遍历为");
//		to.inOrder(t1);
		
//		System.out.println("先序遍历为");
//		to.preOrder(t1);

//		System.out.println("层次遍历为");
//		to.levelOrder(t1);
//		to.levelOrder2(t1);
		System.out.println("层次遍历输出偶数层");
		to.printEvenLevel(t1);
	}
	
	/**
	 * 后根遍历
	 */
	public void postOrder(TreeNode root){
		if(root == null)
			return;
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		TreeNode temp = null;
		while(!s.isEmpty()){
			temp = s.pop();
			temp.popTimes++;
			if(temp.popTimes == 3){
				System.out.print(temp.val + " ");
				continue;
			}
			s.push(temp);
			if(temp.popTimes == 1){
				if(temp.left != null)
					s.push(temp.left);
				continue;
			}
			if(temp.popTimes == 2){
				if(temp.right != null)
					s.push(temp.right);
				continue;
			}
		}
		System.out.println();
	}
	/**
	 * 中序遍历递归
	 */
	public void inOrder(TreeNode root){
		if(root == null)
			return;
		TreeNode temp = null;
		Stack<TreeNode> s= new Stack<TreeNode>();
		s.push(root);
		while(!s.isEmpty()){
			temp = s.pop();
			temp.popTimes++;
			if(temp.popTimes == 2){
				System.out.print(temp.val + " ");
				if(temp.right != null)
					s.push(temp.right);
				continue;
			}
			s.push(temp);
			if(temp.popTimes == 1){
				if(temp.left != null)
					s.push(temp.left);
			}
		}
		System.out.println();
	}
	
	/**
	 * 先根遍历
	 */
	public void preOrder(TreeNode root){
		if(root == null)
			return;
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		TreeNode temp = null;
		while(!s.isEmpty()){
			temp = s.pop();
			System.out.print(temp.val + " ");
			if(temp.right != null)
				s.push(temp.right);
			if(temp.left != null)
				s.push(temp.left);
		}
		System.out.println();
	}
	
	/**
	 * 层次遍历，非递归
	 */
	public void levelOrder(TreeNode root){
		if(root == null)
			return;
		TreeNode temp = null;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while(!q.isEmpty()){
			temp = q.poll();
			System.out.print(temp.val+" ");
			if(temp.left != null)
				q.offer(temp.left);
			if(temp.right != null)
				q.offer(temp.right);
		}
		System.out.println();
	}
	
	/**
	 * 层次遍历，递归,这道题我不会做TT
	 */
	public void levelOrder2(TreeNode root){
		if(root == null)
			return;
		BinarySearchTree bst = new BinarySearchTree();
		int height = bst.getHeight(root);
		for(int i=1;i<=height;i++)
			levelOrder2(root,i);
	}
	public void levelOrder2(TreeNode root,int level){
		if(root == null || level < 1)
			return;
		if(level == 1){
			System.out.print(root.val + " ");
			return;
		}
		levelOrder2(root.left,level-1);
		levelOrder2(root.right,level-1);
	}
	
	/**
	 * 层次遍历输出偶数层  
	 */
	public void printEvenLevel(TreeNode root){
		if(root == null)
			return;
		List<TreeNode> list = new ArrayList<TreeNode>();
		list.add(root);
		int cur = 0 , last = list.size();
		int level = 1;
		TreeNode temp = null;
		while(cur < list.size()){
			while(cur < last){
				temp = list.get(cur);
				if(level % 2 == 0)
					System.out.print(temp.val + " ");
				if(temp.left != null)
					list.add(temp.left);
				if(temp.right != null)
					list.add(temp.right);
				cur++;
			}
			last = list.size();
			level++;
		}
		System.out.println();
	}
}
