/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        // if(s.length()==0||s==null) return null;
        // s=s.trim();
        // s = reverse(s, 0, s.length());
        // 再反转每一个的值
        s = s.trim();
        if (s.equals("")) {
            return "";
        }
        // 把字符串的每一个按照split进行切分
        String[] sp = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = sp.length - 1; i >= 0; i--) {
            sp[i]=sp[i].trim();//这里为啥能这么用呢？
            if (sp[i].equals("")) { //String中的“”与“ ”的区别。第一个是什么都没了，第二个是还有个空格
                //因为切分了trim所以都没了
                continue;
            }
            sb.append(sp[i]);
            sb.append(" ");
        }
        return sb.toString().substring(0, sb.length() - 1);//去掉最后的空格
        //这个题利用api即可

    }

    private void reverse(String s, int start, int end) {
        char[] chars = s.toCharArray();
        while (start < end) {
            // char tmp = s.charAt(start);
            // s.charAt(start)= s.charAt(end);
            // s.charAt(end) =tmp; 字符串是final的
            // StringBuilder sb = new StringBuilder(s);
            // char tmp = sb.charAt(start);
            // sb.charAt(start) = sb.charAt(end);
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
        // return chars.toString();
    }

    private int removeSpaces(char[] chas) {// 在反转之前去掉空格！
        int content = 0;
        for (int i = 0; i < chas.length; i++) {
            if (chas[i] != ' ') {
                if (content != 0) {
                    chas[content++] = ' ';
                }
                while (i < chas.length && chas[i] != ' ') {
                    chas[content++] = chas[i++];// 数组原地修改内容，这个方法好巧妙啊
                }
            }
        }
        return content;
    }
}
// @lc code=end
