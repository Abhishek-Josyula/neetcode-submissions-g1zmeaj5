class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<strs.size(); i++){
            String delimiter = strs.get(i).length()+"#";
            sb.append(delimiter);
            sb.append(strs.get(i));
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        ArrayList<String> ans = new ArrayList<>();
        int left = 0;

        while (left < str.length()){
           
                int i = left;
                while(i < str.length() && Character.isDigit(str.charAt(i))){
                    i++;
                }

                if (str.charAt(i)=='#'){
                    int length = Integer.parseInt(str.substring(left, i));
                    left = i+1;
                    String s = str.substring(left, left+length);
                    ans.add(s);
                    left+=length;
                }

            
        }


        return ans;
    }
}
