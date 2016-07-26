package Tree;

/**
 * 二叉查找树的查找插入删除操作
 * @author zc
 *
 */
public class BinarySearchTree {
	TreeNode root;

	//构造函数
	public BinarySearchTree() {
		root = null;
	}
	public BinarySearchTree(TreeNode root){
		this.root = root;
	}
	
	//查找值为value的节点
	public TreeNode find(int value){
		return find(root,value);
	}
	public TreeNode find(TreeNode node,int value){
		if(node == null)
			return null;
		if(node.val == value)
			return node;
		else if(node.val > value)
			return find(node.left,value);
		else
			return find(node.right,value);
	}
	
	//插入值为value的节点，每次递归都是向以node为根的树插入，返回插入完新树的根
	public TreeNode insert(int value){
		return insert(root,value);
	}
	public TreeNode insert(TreeNode node,int value){
		if(node == null)
			return new TreeNode(value);
		if(node.val > value)
			node.left = insert(node.left,value);
		else
			node.right = insert(node.right,value);
		return node;
	}
	
	//删除值为value的节点   每次递归都是以删除以node为根的树的节点，返回新树的根
	public TreeNode delete(int value){
		return delete(root,value);
	}
	public TreeNode delete(TreeNode node,int value){
		if(node == null)
			return null;
		if(node.val > value)
			node.left = delete(node.left,value);
		else if(node.val < value)
			node.right = delete(node.right,value);
		//能走到这说明找到要删除的节点
		//当有两个孩子时
		else if(node.left != null && node.right != null){
			//找到右子树的最小节点
			node.val = findMin(node.right).val;
			node.right = deleteMin(node.right);
		}
		//有一个或0个孩子,可以直接用孩子替换该节点
		else
			node = node.left == null ? node.right : node.left;
		return node;
	}
	public TreeNode findMin(TreeNode node){
		if(node == null)
			return null;
		while(node.left != null)
			node = node.left;
		return node;
	}
	public TreeNode deleteMin(TreeNode node){
		if(node == null)
			return null;
		//如果左子树不为空，则删除左子树的最小节点，并将根作为node的左孩子
		if(node.left != null)
			node.left = deleteMin(node.left);
		//如果左子树为空，则该节点为最小节点，返回树的根为该节点的右孩子
		else
			node = node.right;
		return node;
	}
	
	//二叉树高度(递归),非递归可以采用后根遍历，栈的最大size即为二叉树高度
	public int getHeight(){
		return getHeight(root);	
	}
	public int getHeight(TreeNode node){
		if(node == null)
			return 0;
		return Math.max(getHeight(node.left),getHeight(node.right))+1;	
	}
}
