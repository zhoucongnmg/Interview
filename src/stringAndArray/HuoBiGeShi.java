package stringAndArray;

/**
 * 输入合法的数字字符串，输出货币字符，就是每隔3位加个逗号，考虑边界处理
 * @author zc
 *
 */
public class HuoBiGeShi {
	public static void main(String[] args){
		HuoBiGeShi h = new HuoBiGeShi();
		System.out.println(h.huoBi("1234567890.12312"));
	}
	public String huoBi(String s){
		if(s == null)
			return null;
		//注意此处一定要用\\.匹配才可以，而不能直接用.匹配
		String[] a = s.split("\\.");
		if(a.length > 2)
			return null;
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for(int i=a[0].length()-1;i>=0;i--){
			char c = a[0].charAt(i);
			if(!Character.isDigit(c))
				return null;
			sb.append(c);
			count++;
			if(count == 3){
				sb.append(',');
				count = 0;
			}
		}
		sb.reverse();
		sb.append('.');
		count = 0;
		for(int i=0;i<a[1].length();i++){
			char c = a[1].charAt(i);
			if(!Character.isDigit(c))
				return null;
			sb.append(c);
			count++;
			if(count == 3){
				sb.append(',');
				count = 0;
			}
		}
		return sb.toString();
	}
}
