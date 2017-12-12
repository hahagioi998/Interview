package String.Calculation;

import java.util.Stack;

//["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//        ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<Integer>();
        String operators = "+-*/";
        for(String token : tokens){
            if(!operators.contains(token)){ //区别数字和operator的方法,只push数字
                s.push(Integer.valueOf(token));
                continue;
            }
            // 每次只处理 num1 operator num2
            int a = s.pop();
            int b = s.pop();
            // 区别对待
            if(token.equals("+")) {
                s.push(b + a);
            } else if(token.equals("-")) {
                s.push(b - a);
            } else if(token.equals("*")) {
                s.push(b * a);
            } else {
                s.push(b / a);
            }
        }
        //答案就pop出来
        return s.pop();
    }
}

