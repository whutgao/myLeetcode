package com.zte.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class Q20_IsValidBrackets {

    public static void main(String[] args) {
        boolean valid = isValid("([)]");
        System.out.println(valid);
    }

    // 注意： 相同类型，正确顺序
    private static boolean isValid(String s) {

        if (s==null || s.length()==0){
            return false;
        }
//       用栈 从左至右，必须满足一对
        Map<Character,Character> map= new HashMap<>(3);

        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            Character nowC = s.charAt(i);

            if (stack.isEmpty()|| nowC.equals('(')||nowC.equals('[')||nowC.equals('{')){
                stack.push(nowC);
            }else {
               if (map.get(nowC).equals(stack.peek())){
                   stack.pop();
               }else {
                   return false;
               }
            }
        }
        return stack.isEmpty();

    }

    // 时间复杂度：O(n) 空间复杂度：O(n + |O(n+∣Σ∣)，其中 Σ 表示字符集，本题中字符串只包含 6 种括号，
    // ∣Σ∣=6。栈中的字符数量为 O(n)，而哈希表使用的空间为O(∣Σ∣)，相加即可得到总空间复杂度。


}
