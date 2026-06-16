class TimeMap {

    Map<String, List<Tuple>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Tuple tuple = new Tuple(value, timestamp);
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(tuple);
    }
  
    public String get(String key, int timestamp) {
        String value = "";
        if(map.containsKey(key)) {
            List<Tuple> list = map.get(key);
            int maxT = -1; 
            for(Tuple tuple : list) {
                if(tuple.timestamp <= timestamp) {
                    value = tuple.value;
                }
            }
        }
        return value;
    }
}

class Tuple {
    String value;
    int timestamp;

    public Tuple(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}