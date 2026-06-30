import java.util.Stack;
class MinStack {
    Stack<Integer> st;
    Stack<Integer> minStack;
    public MinStack() {
        st = new Stack<>();
        minStack = new Stack<>();
    }
    public void push(int val) {
        st.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    public void pop() {
        if (st.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        st.pop();
    }
    public int top() {
        return st.peek();
    }
    public int getMin() {
        return minStack.peek();
    }
}