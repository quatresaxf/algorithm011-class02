/**
 * 115. 不同的子序列
 * 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
 * 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 * 题目数据保证答案符合 32 位带符号整数范围。
 * 示例 1：
 * 输入：S = "rabbbit", T = "rabbit"
 * 输出：3
 * 解释：
 * 如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * 示例 2：
 * 输入：S = "babgbag", T = "bag"
 * 输出：5
 * 解释：
 * 如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 *   ^  ^^
 * babgbag
 *     ^^^
 */
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        // 动态规划
        // dp[i][j]代表 t 前 i 字符串可以由 s 前 j 字符串组成最多个数
        int[][] dp = new int[t.length()+1][s.length()+1];
        for(int i = 0; i <= s.length(); i++) {
            dp[0][i] = 1;
        }
        for(int i = 1; i <= t.length(); i++) {
            for(int j = i; j <= s.length(); j++) {
                if(t.charAt(i-1) == s.charAt(j-1)) {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}
