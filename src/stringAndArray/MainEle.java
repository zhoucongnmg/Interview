package stringAndArray;

import java.util.*;
/**
 *leetcode169 ��Ԫ������
 */
public class MainEle {

    /**
    * �������ҳ����ִ�����������Ԫ��һ���Ԫ��
    */
    public int majorityElement(int[] a) {     
        if(a == null || a.length == 0)
            return -1;
        int count = 0;
        int mainEle = a[0];
        for(int i=0;i<a.length;i++){
            //ע���� �����ж�nb
            if(mainEle == a[i])
                count++;
            else if(count == 0){
            	mainEle = a[i];
                count = 1;
            }
            else 
                count--;
        }
        int times = 0;
        for(int i=0;i<a.length;i++){
            if(a[i] == mainEle)
                times++;
        }
        if(times > a.length/2)
            return mainEle;
        else 
            return -1;
    }

    /**
     *�������ҳ����ִ�������n/3��Ԫ�أ�nΪ���鳤��
     */
    public List<Integer> majorityElement2(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        
        if(nums == null || nums.length == 0)
            return list;
        int one = nums[0], two = nums[0];
        int count1 = 0 , count2 = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == one)
                count1++;
            else if(nums[i] == two)
                count2++;
            else if(count1 == 0){
                one = nums[i];
                count1 = 1;
            }
            else if(count2 == 0){
                two = nums[i];
                count2 = 1;
            }
            else{
                count1--;
                count2--;
            }
        }
        
        count1 = count2 = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == one)
                count1++;
            else if(nums[i] == two)
                count2++;
        }
        if(count1>nums.length/3)
            list.add(one);
        if(count2>nums.length/3)
            list.add(two);

        return list;
    }
}