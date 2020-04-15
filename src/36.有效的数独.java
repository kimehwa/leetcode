import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 用hash表来做，找到映射关系，hashmap前面是字符后面是出现的个数，这个编码的关键是3个hashmap
        // 如何正确的放到对应的hashmap中
        // 初始化3个hashmap
        HashMap<Integer, Integer>[] rows = new HashMap[9];// 这个写法第一次见
        HashMap<Integer, Integer>[] columns = new HashMap[9];// 这个写法第一次见
        HashMap<Integer, Integer>[] boxes = new HashMap[9];// 这个写法第一次见
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // 再算box的索引
                char num = board[i][j];
                if (num != '.') {
                    int n = (int) num;
                    int box_index = (i / 3) * 3 + j / 3;// 是整除
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;

    }
}
// @lc code=end
