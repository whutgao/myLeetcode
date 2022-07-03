package com.zte.string;



/**
 * 罗马数字包含以下七种字符:I，V，X，L，C，D和M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做II，即为两个并列的 1 。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，
 * 所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给定一个罗马数字，将其转换成整数。
 */
public class Q13_romanToInt {

    public static void main(String[] args) {

        int iii = romanToInt("MCMXCIV");
        System.out.println(iii);
    }

    public static int romanToInt(String s) {

        // 思考：是正着读取数字还是倒着读取数字？
        // 倒序： I V X L C D M
         // 双指针法
//        int res = 0;
//        if (s != null && s.length() != 0){
//            // 4: IV
//            // 6: VI
//            // 9 IX
//            // 11: XI
//            //14: XIV
//            // 思路：从右开始遍历，当左小于右时，是减去左，否则一直加左；
//
//            res = romanNumberEnum.getRomanNumber(String.valueOf(s.charAt(s.length()-1)));
//            boolean flag;
//            for (int i = s.length()-2; i >=0; i--) {
//                Integer left = romanNumberEnum.getRomanNumber(String.valueOf(s.charAt(i)));
//                // 只有i为-1时才停止
//                Integer right = romanNumberEnum.getRomanNumber(String.valueOf(s.charAt(i+1)));
//                if (left>=right){
//                    res= res + left;
//                }else {
//                    res = res - left;
//                }
//            }
//        }

//        ============================
        int ans= 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int val = romanNumberEnum.getRomanNumber(String.valueOf(s.charAt(i)));
            if (i<len-1 && val < romanNumberEnum.getRomanNumber(String.valueOf(s.charAt(i+1)))){
                ans-= val;
            }else {
                ans+=val;
            }

        }
        return  ans;
        // 时间复杂度：O(n) 空间复杂度：O(1)
//        return res;
    }


    enum romanNumberEnum{
        /**
         * 罗马数字枚举
         */
        I ("I",1),
        V ("V",5),
        X ("X",10),
        L ("L",50),
        C ("C",100),
        D ("D",500),
        M ("M",1000);



        private String s;
        private Integer i;
        private romanNumberEnum(String s,Integer i){
            this.s = s;
            this.i = i;
        }

        public static Integer getRomanNumber(String s){

            for (romanNumberEnum r: romanNumberEnum.values()
                 ) {
                if (s.equals(r.getS())){
                    return r.getI();
                }
            }

            return null;
        }


        public String getS() {
            return s;
        }

        public void setS(String s) {
            this.s = s;
        }

        public Integer getI() {
            return i;
        }

        public void setI(Integer i) {
            this.i = i;
        }
    }

}
