package stringAndArray;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 用java统计一个文本文件中出现的频率最高的20个单词
 *
 * @author zc
 */
public class CountWordSumInFile {

    public static void main(String[] args) {
        CountWordSumInFile cwf = new CountWordSumInFile();
        cwf.method("E:\\笔记\\面试\\算法\\test.txt");
    }

    public void method(String filePath) {
        try (BufferedReader bf = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = bf.readLine()) != null) {
                sb.append(line);
            }

            Pattern p = Pattern.compile("[a-zA-Z]+");
            Matcher m = p.matcher(sb);
            Map<String, Integer> map = new HashMap<>();

            while (m.find()) {
                // 获取匹配的完整字符
                String word = m.group();
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }

            sortAndPrint(map);
        } catch (Exception e) {
            // 此种写法大错特错
            // System.out.println(e.printStackTrace());
            e.printStackTrace();
        }
    }

    public void sortAndPrint(Map<String, Integer> map) {
        if (map == null) {
            return;
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((e1, e2) -> e2.getValue() - e1.getValue());

        for (int i = 0; i < 10; i++) {
            System.out.println(list.get(i).getKey() + "  " + list.get(i).getValue());
        }
    }
}
