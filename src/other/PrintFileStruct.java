package other;

import java.io.File;
import java.util.Stack;

/**
 * 打印文件结构
 * @author zc
 *
 */
public class PrintFileStruct {

	public static void main(String[] args){
		PrintFileStruct pf = new PrintFileStruct();
		File f = new File("D:/test");
		pf.printFileStruct(f);
		System.out.println();
		pf.printFileStruct2(f);
	}
	
	//非递归实现
	public void printFileStruct(File f){
		if(f == null)
			return;
		Stack<File> s = new Stack<File>();
		File temp = null;
		s.push(f);
		while(!s.isEmpty()){
			temp = s.pop();
			System.out.print(temp.getName()+" ");
			if(temp.isDirectory()){
				for(File c : temp.listFiles())
					s.push(c);
			}
		}
	}
	//递归实现
	public void printFileStruct2(File f){
		System.out.print(f.getName()+ " ");
		if(f.isDirectory()){
			for(File c : f.listFiles())
				printFileStruct2(c);
		}
	}
}
