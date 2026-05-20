class TimeMap {

    public TimeMap() {
        _map = new HashMap<>();
        Stamps = new HashMap<>();
    }
    
    private HashMap<String, HashMap<Integer, String>> _map;

    private HashMap<String,List<Integer>> Stamps; 

    public void set(String key, String value, int timestamp) {
        Stamps.computeIfAbsent(key, k-> new ArrayList<Integer>()).add(timestamp);
        if (_map.containsKey(key)){
            HashMap<Integer, String> map2 = _map.get(key);
            map2.put(timestamp, value);
        } else{
            HashMap<Integer, String> map2 = new HashMap<>();
            map2.put(timestamp, value);
            _map.put(key, map2);
        }
    }
    
    public String get(String key, int timestamp) {
        
        HashMap<Integer, String> map2 = _map.get(key);
        List<Integer> setStamps = Stamps.getOrDefault(key, new ArrayList<>());
        int l = 0;
        int r = setStamps.size()-1;
        
        while (l<=r){
            int mid = l+(r-l)/2;
            if (setStamps.get(mid) == timestamp){
                return map2.get(timestamp);
            } else if (setStamps.get(mid)<timestamp){
                l = mid+1;
            } else {
                r = mid-1;
            }
        }

        if (r<0) return "";

        return map2.getOrDefault(setStamps.get(r), "");
    }
}
