class Solution {
    public int evalRPN(String[] tokens) {
        ArrayList<Integer> operands = new ArrayList<>();
        int start = 0;
        while (start<tokens.length){

            switch (tokens[start]){
                case "+":
                int size = operands.size();
                int op1 = operands.get(size-1);
                int op2 = operands.get(size-2);
                operands.remove(size-1);
                operands.remove(size-2);
                operands.add(op2+op1);
                break;
                case "-":
                size = operands.size();
                op1 = operands.get(size-1);
                op2 = operands.get(size-2);
                operands.remove(size-1);
                operands.remove(size-2);
                operands.add(op2-op1);
                break;
                case "*":
                size = operands.size();
                op1 = operands.get(size-1);
                op2 = operands.get(size-2);
                operands.remove(size-1);
                operands.remove(size-2);
                operands.add(op2*op1);
                break;
                case "/":
                size = operands.size();
                op1 = operands.get(size-1);
                op2 = operands.get(size-2);
                operands.remove(size-1);
                operands.remove(size-2);
                operands.add(op2/op1);
                break;
                default:
                operands.add(Integer.parseInt(tokens[start]));
                break;
            }

            start++;
        }
        return operands.get(0);
    }
}
