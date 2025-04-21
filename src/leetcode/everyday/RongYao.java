package leetcode.everyday;

import java.util.*;
import java.util.regex.*;

public class RongYao {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = Integer.parseInt(sc.nextLine());

            // 存储原始输入的键值对
            Map<String, String> rawMap = new LinkedHashMap<>();
            // 存储最终展开的值
            Map<String, String> resolvedMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String line = sc.nextLine();
                int idx = line.indexOf('=');
                String key = line.substring(0, idx);
                String value = line.substring(idx + 1);
                rawMap.put(key, value);
            }

            // 展开所有变量
            for (String key : rawMap.keySet()) {
                resolveValue(key, rawMap, resolvedMap);
            }

            // 打印最后一个变量的值
            String lastKey = "";
            for (String key : rawMap.keySet()) {
                lastKey = key;
            }
            System.out.println(resolvedMap.get(lastKey));
        }

        // 递归替换${xxx}
        public static String resolveValue(String key, Map<String, String> rawMap, Map<String, String> resolvedMap) {
            if (resolvedMap.containsKey(key)) return resolvedMap.get(key);

            String value = rawMap.get(key);
            Pattern pattern = Pattern.compile("\\$\\{(.*?)}");
            Matcher matcher = pattern.matcher(value);
            StringBuffer sb = new StringBuffer();

            while (matcher.find()) {
                String var = matcher.group(1);
                String replacement = resolveValue(var, rawMap, resolvedMap);
                matcher.appendReplacement(sb, Matcher.quoteReplacement(replacement));
            }
            matcher.appendTail(sb);
            String resolved = sb.toString();
            resolvedMap.put(key, resolved);
            return resolved;
        }

}
