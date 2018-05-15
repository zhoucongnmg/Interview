package Tree;

import java.util.*;

/**
 * 现有一个小写英文字母组成的字符串s和一个包含较短小写英文字符串的数组p，
 * 请设计一个高效算法，对于p中的每一个较短字符串，判断其是否为s的子串。
 *
 * @author zhoucong
 */
public class TrieTest {
    public static void main(String[] args) {
        String[] a = {"a", "b", "c", "ib"};
        String s = "bibs";
        TrieNode t = new TrieNode();
        //后缀树其实是对所有后缀建立trie树
        for (int i = 0; i < s.length(); i++) {
            t.insert(s.substring(i));
        }
        for (String s1 : a) {
            System.out.println(t.search(s1));
        }
    }
}

class TrieNode {
    // 同一层，且拥有相同的父节点的char位于同一个hashmap里
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
