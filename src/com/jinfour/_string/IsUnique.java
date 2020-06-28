package com.jinfour._string;

public class IsUnique {
    /**
     * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
     *
     * 示例 1：
     *
     * 输入: s = "leetcode"
     * 输出: false
     * 示例 2：
     *
     * 输入: s = "abc"
     * 输出: true
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/is-unique-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param astr
     * @return
     */

    public static boolean isUnique(String astr) {
        int len = astr.length();
        for(int i = 0; i < len; i++) {
            int j = len - 1;
            for (;;) {
                if (j == i) {
                    break;
                }
                if (astr.charAt(i) == astr.charAt(j--)) {
                    return false;
                }
            }
        }
        return true;
    }

    //位运算
    public static boolean isUnique_bit(String astr) {
        int len = astr.length();
        int mark = 0;
        int start = (int)'a';
        for(char ch : astr.toCharArray()) {
            if((mark & (1 << ((int)ch - start))) != 0) {
                return false;
            }else {
                mark = mark | (1 << ((int)ch - start));
            }
        }
        return true;
    }

    public static void main(String[] args){
        String s = "dbb";
        System.out.println(isUnique_bit(s));
        System.out.println((int)'a');
        System.out.println((int)'z');
        System.out.println((int)'A');
        System.out.println((int)'Z');
    }
}
