class MinStack {

    public MinStack() {
        stack = new ArrayList<>();
        prefixSum = new ArrayList<>();
    }

    ArrayList<Integer> stack;

    ArrayList<Integer> prefixSum;
    
    public void push(int val) {

        if (stack.size()>0){
            int min = Math.min(prefixSum.get(stack.size()-1), val);
            stack.add(val);
            prefixSum.add(min);
        } else {
            stack.add(val);
            prefixSum.add(val);
        }
    }
    
    public void pop() {
        stack.remove(stack.size()-1);
        prefixSum.remove(prefixSum.size()-1);
    }
    
    public int top() {
        return stack.get(stack.size()-1);
    }
    
    public int getMin() {
        return prefixSum.get(stack.size()-1);
    }
}
