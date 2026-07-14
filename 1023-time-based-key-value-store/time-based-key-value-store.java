class TimeMap {

    private final Map<String, List<Pair>> map = new HashMap<>();

    private static class Pair {
        int timestamp;
        String value;

        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    public TimeMap() {}

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>())
           .add(new Pair(timestamp, value));
    }
    public String get(String key, int timestamp) {

        List<Pair> list = map.get(key);

        if (list == null)
            return "";

        int left = 0;
        int right = list.size()-1;

        String result = "";

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (list.get(mid).timestamp <= timestamp) {

                result = list.get(mid).value;
                left = mid + 1;

            } else {

                right = mid - 1;
            }
        }
        return result;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */