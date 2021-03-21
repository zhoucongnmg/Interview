package Tree;

/**
 * ¶þ²æÊ÷½Úµã
 * @author zc
 *
 */
public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public int popTimes = 0;
	
	public TreeNode(int val){
		this.val = val;
	}

	@Override
	public String toString() {
		return "TreeNode{" +
				"val=" + val +
				'}';
	}
}
