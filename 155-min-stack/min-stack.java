class MinStack {
    Stack<Long> st=new Stack<>();
    long min=0;
    public MinStack() {
        
    }
    
    public void push(int val) {
        long x=(long)val;
        if(st.isEmpty()) {
            st.push(x);
            min=x;
        }else{
        if(x<min){
            st.push(2*x-min);
            min=x;
        }else st.push(x);
        }
    }
    
    public void pop() {
        if(st.peek()>=min) st.pop();
        else {
            min=2*min-st.peek();
            st.pop();
        }
    }
    
    public int top() {
        long q=st.peek();
        if(q>min) return (int)q;
        else {
            return (int)min;
        }
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */