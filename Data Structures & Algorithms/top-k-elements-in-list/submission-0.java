class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // Store key + frequency
        int[][] arr = new int[map.size()][2];

        int index = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            arr[index][0] = entry.getKey();
            arr[index][1] = entry.getValue();
            index++;
        }

        // Bubble sort descending by frequency
        for (int m = 0; m < arr.length - 1; m++) {
            for (int n = 0; n < arr.length - 1 - m; n++) {

                if (arr[n][1] < arr[n + 1][1]) {

                    int[] temp = arr[n];
                    arr[n] = arr[n + 1];
                    arr[n + 1] = temp;
                }
            }
        }

        // Take first k elements
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = arr[i][0];
        }

        return result;
    }
}