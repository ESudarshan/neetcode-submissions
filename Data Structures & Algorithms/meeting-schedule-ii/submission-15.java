

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return 0;
        }

        int n = intervals.size();
        int[] startTimes = new int[n];
        int[] endTimes = new int[n];

        // 1. Extract start and end times
        for (int i = 0; i < n; i++) {
            startTimes[i] = intervals.get(i).start;
            endTimes[i] = intervals.get(i).end;
        }

        // 2. Sort both arrays chronologically
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int minRooms = 0;
        int activeRooms = 0;
        int startPointer = 0;
        int endPointer = 0;

        // 3. Use two pointers to simulate the timeline
        while (startPointer < n) {
            // If a new meeting starts before the current earliest meeting ends
            if (startTimes[startPointer] < endTimes[endPointer]) {
                activeRooms++;
                startPointer++;
            } else { 
                // A meeting has ended, freeing up a room
                activeRooms--;
                endPointer++;
            }
            // Track the peak number of rooms needed concurrently
            minRooms = Math.max(minRooms, activeRooms);
        }

        return minRooms;
    }
}
