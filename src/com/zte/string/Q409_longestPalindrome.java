package com.zte.string;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Q409_longestPalindrome {

    public static void main(String[] args) {
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        int i = longestPalindrome(s);
        System.out.println(i);
    }


    private static  int longestPalindrome(String s) {

        // s 是偶数的都可以作为返回 是奇数的只取一个

        HashMap<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < s.length() ; i++) {
            Character c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int max = 0;
        int sum = 0;
        boolean flag = false;
        for (Map.Entry<Character,Integer> m:map.entrySet()
             ) {

            if (m.getValue()>1){
                sum+= m.getValue()/2*2;
            }
            if (m.getValue()%2==1){
                flag=true;
            }

        }

        return flag? sum+max+1:sum+max;
        // 时间复杂度：O(N) 字符串长度 空间复杂度：O(m) 字符集大小 
    }
}
