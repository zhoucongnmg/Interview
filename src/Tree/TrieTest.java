package Tree;

import java.util.*;

/**
 * ����һ��СдӢ����ĸ��ɵ��ַ���s��һ�������϶�СдӢ���ַ���������p��
 * �����һ����Ч�㷨������p�е�ÿһ���϶��ַ������ж����Ƿ�Ϊs���Ӵ���
 *
 * @author zhoucong
 */
public class TrieTest {
    public static void main(String[] args) {
        String[] a = {"a", "b", "c", "ib"};
        String s = "bibs";
        TrieNode t = new TrieNode();
        //��׺����ʵ�Ƕ����к�׺����trie��
        for (int i = 0; i < s.length(); i++) {
            t.insert(s.substring(i));
        }
        for (String s1 : a) {
            System.out.println(t.search(s1));
        }
    }
}

class TrieNode {
    // ͬһ�㣬��ӵ����ͬ�ĸ��ڵ��charλ��ͬһ��hashmap��
    Map<Character, TrieNode> map = new HashMap<>();

    public void insert(String s) {
        if (s == null || s.length() == 0) {
            return;
        }
        char c = s.charAt(0);
        TrieNode child = null;
        if (map.containsKey(c)) {
            child = map.get(c);
        } else {
            child = new TrieNode();
            map.put(c, child);
        }
        child.insert(s.substring(1));
    }

    public boolean search(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        char c = s.charAt(0);
        if (map.containsKey(c)) {
            return map.get(c).search(s.substring(1));
        } else {
            return false;
        }
    }
}
