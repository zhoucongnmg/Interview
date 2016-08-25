package searchAndSort;

import java.util.Stack;

/**
 * ���������㷨
 * @author zc
 *
 */
public class SortMethod {

	public static void main(String[] args){
		SortMethod sm = new SortMethod();
		Integer[] a = {5,4,3,2,1,1};
		String[] s = {"d","c","b","a"};
//		sm.maopaoSort(a);
		sm.mergeSort(s,0,s.length-1);
//		 sm.quickSort(a,0,a.length-1);
//		sm.quickSort(a);
		sm.heapSort(a);
		sm.printArray(a);
		sm.printArray(s);
	}
	
	/**
	 * ð������
	 * ��Ҫ�����ܹ�ʹ��compareTo������������������
	 * @param a
	 */
	public <T extends Comparable<T>> void maopaoSort(T[] a){
		if(a == null || a.length == 0)
			return;
		for(int i=0;i<a.length;i++){
			for(int j=a.length-1;j>i;j--){
				if(a[j].compareTo(a[j-1]) < 0)
					swap(a,j,j-1);
			}
		}
	}
	
	/**
	 * �鲢����
	 */
	public <T extends Comparable<T>> void mergeSort(T[] a,int start,int end){
		if(a == null)
			return;
		if(start >= end)
			return;
		int mid = (start + end)/2;
		
		mergeSort(a,start,mid);
		mergeSort(a,mid+1,end);
		
		merge(a,start,end);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Comparable<T>> void merge(T[] a,int start,int end){
		
		int mid = (start + end)/2;
		int len = end - start + 1;
		T[] temp = (T[])new Comparable[len];
		int i = start , j = mid+1;
		int index = 0;
		
		while(i <= mid && j <= end){
			if(a[i].compareTo(a[j]) < 0)
				temp[index++] = a[i++];
			else
				temp[index++] = a[j++];
		}
		while(i <= mid)
			temp[index++] = a[i++];
		while(j <= end)
			temp[index++] = a[j++];
		
		System.arraycopy(temp, 0, a, start, end-start+1);
	}
	
	/**
	 * �ݹ����
	 */
	public <T extends Comparable<T>> void quickSort(T[] a,int start,int end){
		if(a == null || start >= end)
			return;
		if(end - start <= 2){
			setMid(a,start,end);
			return;
		}
		int pivot = getPivot(a,start,end);
		quickSort(a,start,pivot-1);
		quickSort(a,pivot+1,end);
	}
	
	public <T extends Comparable<T>> void setMid(T[] a,int start,int end){
		int mid = (start + end)/2;
		if(a[start].compareTo(a[mid]) > 0)
			swap(a,start,mid);
		if(a[start].compareTo(a[end]) > 0)
			swap(a,start,end);
		if(a[mid].compareTo(a[end]) > 0)
			swap(a,mid,end);
		swap(a,mid,end-1);
	}
	
	public <T extends Comparable<T>> int getPivot(T[] a,int start,int end){
		setMid(a,start,end);
		int i = start, j = end-2;
		//�˴���Ҫע�⣬Ϊend-1��������end-2
		T k = a[end-1];
		while(i < j){
			while(a[i].compareTo(k) < 0)
				i++;
			while(a[j].compareTo(k) > 0)
				j--;
			if(i < j)
				swap(a,i,j);
		}
		swap(a,i,end-1);
		return i;
	}
	
	/**
	 * �ǵݹ����
	 */
	public <T extends Comparable<T>> void quickSort(T[] a){
		if(a == null)
			return;
		int start = 0 , end = a.length - 1;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(end);
		stack.push(start);
		while(!stack.isEmpty()){
			start = stack.pop();
			end = stack.pop();
			if(start >= end)
				continue;
			if(end - start <= 2){
				setMid(a,start,end);
				continue;
			}
			int pivot = getPivot(a,start,end);
			stack.push(pivot-1);
			stack.push(start);
			stack.push(end);
			stack.push(pivot+1);
		}
	}
	
	/**
	 * �ݹ������
	 */
	
	public <T extends Comparable<T>> void heapSort(T[] a){
		if(a == null || a.length == 0 || a.length == 1)
			return;
		int len = a.length;
		for(int i=len/2-1;i>=0;i--)
			buildHeap(a,i,len-1);
		for(int i=len-1;i>0;i--){
			swap(a,i,0);
			buildHeap(a,0,i-1);
		}
	}
	
	//������
	public <T extends Comparable<T>> void buildHeap(T[] a,int foo,int len){
		int child = foo*2 + 1;
		if(child > len)
			return;
		if(child+1 <= len && a[child+1].compareTo(a[child]) > 0)
			child++;
		if(a[child].compareTo(a[foo]) > 0){
			swap(a,child,foo);
			buildHeap(a,child,len);
		}
	}
	
	//����
	//�����У��򷽷������У�ʹ�÷��ͱ���1���ڷ�������ֵǰ�������ͣ�����2����������������������
	public <T> void swap(T[] a,int i,int j){
		T temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	//��ӡ
	public <T> void printArray(T[] a){
		for(T i : a)
			System.out.print(i+" ");
		System.out.println();
	}
}
