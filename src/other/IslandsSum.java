package other;

/**
 * 给一个01矩阵，求不同的岛屿的个数。
 * 0代表海，1代表岛，如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。
 * @author zc
 *
 */
public class IslandsSum {
	
	public int islandSum(int[][] a){
		if(a == null || a.length == 0 || a[0] == null || a[0].length == 0)
			return 0;
		int sum = 0;
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[0].length;j++){
				if(a[i][j] == 1){
					dfs(a,i,j);
					sum++;
				}
			}
		}
		return sum;
	}
	public void dfs(int[][] a,int i,int j){
		a[i][j] = 0;
		if(i-1 >= 0 && a[i-1][j] == 1)
			dfs(a,i-1,j);
		if(i+1 < a.length && a[i+1][j] == 1)
			dfs(a,i+1,j);
		if(j-1 >= 0 && a[i][j-1] == 1)
			dfs(a,i,j-1);
		if(j+1 < a[0].length && a[i][j+1] == 1)
			dfs(a,i,j+1);
	}
}
