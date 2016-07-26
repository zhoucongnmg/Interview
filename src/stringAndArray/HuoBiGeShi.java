package stringAndArray;

/**
 * ����Ϸ��������ַ�������������ַ�������ÿ��3λ�Ӹ����ţ����Ǳ߽紦��
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
		//ע��˴�һ��Ҫ��\\.ƥ��ſ��ԣ�������ֱ����.ƥ��
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
