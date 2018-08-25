import java.util.Stack;

/**
 * 最长有效括号：
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 */
public class longestValidParentheses_32 {
    public static void main(String[] args){
        String str = ")(()())())";
        int result = new longestValidParentheses_32().longestValidParentheses(str);
        System.out.println(result);
    }

    /*
    借助栈来求解，需要定义个start变量来记录合法括号串的起始位置，
    我们遍历字符串，如果遇到左括号，则将当前下标压入栈，
    如果遇到右括号，如果当前栈为空，则将下一个坐标位置记录到start，
    如果栈不为空，则将栈顶元素取出，此时若栈为空，
    则更新结果和i - start + 1中的较大值，
    否则更新结果和i - 栈顶元素中的较大值
     */
    public int longestValidParentheses(String s) {
        int len = s.length();
        if(len <= 1){
            return 0;
        }
        int start = 0;//记录合法括号串的起始位置
        int ret = 0;
        Stack<Integer> stack = new Stack<>();
        char[] cs = s.toCharArray();
        for (int i = 0; i < len; i++) {
            if(cs[i]=='('){
                stack.push(i);
            }else if(cs[i]==')'){
                if(stack.empty()){
                    start = i+1;
                }
                else{
                    int x = stack.pop();
                    ret = stack.empty()? Math.max(ret, i-start+1): Math.max(ret, i-stack.peek());//i-x+1或者i-stack.peek()
                }
            }

        }
        return ret;
    }
}
