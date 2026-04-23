class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length()<=1 || s.length()%2!=0) return false;
        HashMap<Character, Character> open = new HashMap<>();
        open.put('(', ')');
        open.put('{', '}');
        open.put('[', ']');

        ArrayList<Character> openStack = new ArrayList<Character>();

        for (int i = 0; i<s.length(); i++){
            if (open.keySet().contains(s.charAt(i))){
                openStack.add(s.charAt(i));
            } else{
                if (openStack.size() < 1 || open.get(openStack.get(openStack.size()-1))!=s.charAt(i)){
                    return false;
                }else{
                    openStack.remove(openStack.size()-1);
                }
            }
        }

        if (openStack.size()==0){
            return true;
        } else{
            return false;
        }
    }
}
