package String.Calculation;

import java.util.Stack;

public class BasicCalculatorIII {
    boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
//op2是先被pop出来的
    int calc(int op2, int op1, char ch) {
        switch(ch) {
            case '-': return op1 - op2;
            case '+': return op1 + op2;
            case '/': return op1 / op2;
            case '*': return op1 * op2;
        }
        return 0;
    }
    boolean higherPriority(char op1, char op2) {
        //先返回true了
        if ((op1 =='*') || (op1 =='/'))
            return true;
        if ((op2 =='+') || (op2 =='-'))
            return true;
        return false;

    }

    int simpleCalculator(String exp) {

        Stack<Integer> st = new Stack<>();
        Stack<Character> op = new Stack<>();
        int digit = 0;
        boolean hasDigit = false;
        for (int i = 0; i < exp.length(); i++) {
            if (isDigit(exp.charAt(i))) {
                hasDigit = true;
                digit = digit*10 + (exp.charAt(i) - '0');
            } else {
                if(hasDigit) {
                    hasDigit = false;
                    st.push(digit);
                    digit = 0;
                }
                if (exp.charAt(i) == '(') {
                    op.push('(');
                } else if(exp.charAt(i) == ')') {
                    while (op.peek() != '(') {
                        st.push(calc(st.pop(), st.pop(), op.pop()));
                    }
                    //pop掉（
                    op.pop();

                } else {//计算符号，把之前的计算符号算掉
                    //while stack不是空，而且也没有到（，而且
                    while (!op.isEmpty() && op.peek() != '(' && higherPriority(op.peek(), exp.charAt(i))) {
                        st.push(calc(st.pop(), st.pop(), op.pop()));
                    }

                    op.push(exp.charAt(i));
                }
            }
        }
        if(hasDigit)
            st.push(digit);
        while(!op.isEmpty()) {
            st.push(calc(st.pop(), st.pop(), op.pop()));
        }
        return st.peek();
    }

    public static void main(String[] args){
        BasicCalculatorIII sol = new BasicCalculatorIII();
        int res = sol.simpleCalculator("((4/0))");
        System.out.println(res);
    }
}

