package stringAndArray;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ��javaͳ��һ���ı��ļ��г��ֵ�Ƶ����ߵ�20������
 *
 * @author zc
 */
public class CountWordSumInFile {

    public static void main(String[] args) {
        CountWordSumInFile cwf = new CountWordSumInFile();
        cwf.method("E:\\�ʼ�\\����\\�㷨\\test.txt");
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
                // ��ȡƥ��������ַ�
                String word = m.group();
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }

            sortAndPrint(map);
        } catch (Exception e) {
            // ����д������ش�
            // System.out.println(e.printStackTrace());
            e.printStackTrace();
        }
    }

    //����ʹ�ö�
    public void sortAndPrint(Map<String, Integer> map) {
        if (map == null) {
            return;
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((e1, e2) -> e2.getValue() - e1.getValue());
//        list.sort(new Comparator<Map.Entry<String, Integer>>() {
//            @Override
//            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                return o2.getValue()-o1.getValue();
//            }
//        });

        for (int i = 0; i < 10; i++) {
            System.out.println(list.get(i).getKey() + "  " + list.get(i).getValue());
        }
    }
}
