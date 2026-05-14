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

/* Linear Search     
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
*/

//  Binary Search    
    public String get(String key, int timestamp) {
        String value = "";
        if(map.containsKey(key)) {
            List<Tuple> list = map.get(key);
            int n = list.size();
            int l = 0;
            int r = n - 1;
            while(l <= r) {
                int mid = l + ((r - l) / 2);
                Tuple tuple = list.get(mid);
                if(tuple.timestamp == timestamp) {
                    return tuple.value;
                } else if(tuple.timestamp > timestamp) {
                    r = mid - 1;
                } else if(tuple.timestamp < timestamp) {
                    value = tuple.value;
                    l = mid + 1;
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