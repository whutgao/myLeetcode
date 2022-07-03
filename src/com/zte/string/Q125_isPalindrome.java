package com.zte.string;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 */
public class Q125_isPalindrome {


    public static void main(String[] args) {
        String s = "race a car";
        boolean palindrome = isPalindrome3(s);
        System.out.println(palindrome);

    }


    private static boolean isPalindrome(String s) {

        String s1 = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            if (('0' <= s1.charAt(i) && s1.charAt(i) <= '9') || ('a' <= s1.charAt(i) && s1.charAt(i) <= 'z')) {
                sb.append(s1.charAt(i));
            }
        }
        String res = sb.toString();
        for (int i = 0; i < res.length(); i++) {
            if (res.charAt(i) != res.charAt(res.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }


    private static boolean isPalindrome2(String s) {


        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        System.out.println(sgood.toString());
        StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
        System.out.println(sgood_rev.toString());
        return sgood.toString().equals(sgood_rev.toString());
    }


// 双指针 相向移动 相遇为true
    private static boolean isPalindrome3(String s) {
        int left = 0;
        int right = s.length()-1;

        while (left<right){
            char l = s.charAt(left);
            char r = s.charAt(right);
            if (!Character.isLetterOrDigit(l)){
                left++;
            }
            if (!Character.isLetterOrDigit(r)){
                right--;
            }
            if (Character.isLetterOrDigit(l)&&Character.isLetterOrDigit(r)){
                if (Character.toLowerCase(l)!=Character.toLowerCase(r)){
                    return false;
                }
                left++;
                right--;
            }

        }

       return true;
        // 时间复杂度：O(|S|) 字符串长度 空间复杂度：O(1)
    }

}
