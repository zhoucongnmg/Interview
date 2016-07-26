package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树从根节点到叶节点路径上数字之和为一特定数
 * @author zc
 *
 */
public class TreePathSum {
	
	public static void main(String[] args){
		TreeNode t1 = new TreeNode(10);
		TreeNode t2 = new TreeNode(5);
		TreeNode t3 = new TreeNode(12);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(7);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		TreePathSum tp = new TreePathSum();
		List<TreeNode> path = tp.getPathSumIsK(t1,19);
		if(path == null){
			System.out.println("没有找到相关路径");
			return;
		}
		for(TreeNode t : path)
			System.out.print(t.val + " ");
	}
	public List<TreeNode> getPathSumIsK(TreeNode root,int sum){
		if(root == null)
			return null;
		List<TreeNode> path = new ArrayList<TreeNode>();
		if(getPathSumIsK(root,sum,path))
			return path;
		else
			return null;
	}
	public boolean getPathSumIsK(TreeNode root,int sum,List<TreeNode> path){
		if(root == null)
			return false;
		path.add(root);
		if(root.left == null && root.right == null && root.val == sum)
			return true;
		if(getPathSumIsK(root.left,sum-root.val, path))
			return true;
		if(getPathSumIsK(root.right, sum-root.val,path))
			return true;
		path.remove(path.size()-1);
		return false;
	}
}
