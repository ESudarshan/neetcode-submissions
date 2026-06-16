class TimeMap {

    Map<String, List<Tuple>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)) {
            List<Tuple> list = map.get(key);
            list.add(new Tuple(value, timestamp));
        } else {
            List<Tuple> list = new ArrayList<>();
            list.add(new Tuple(value, timestamp));
            map.put(key, list);
        }
    }
  
    public String get(String key, int timestamp) {
        String value = "";
        if(map.containsKey(key)) {
            List<Tuple> list = map.get(key);
            int maxT = -1; 
            for(Tuple tuple : list) {
                if(tuple.timestamp <= timestamp && tuple.timestamp > maxT) {
                    maxT = tuple.timestamp;
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