package other;

/**
 * µ¥ÀýÄ£Ê½
 * @author zc
 *
 */
public class Singleton {
	
	public static void main(String[] args){
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s1==s2);
	}
	
	public static volatile Singleton instance = null; 
	
	private Singleton(){
	}
	
	public static Singleton getInstance(){
		if(instance == null){
			synchronized(Singleton.class){
				if(instance == null)
					instance = new Singleton();
			}
		}
		return instance;
	}
	
}
