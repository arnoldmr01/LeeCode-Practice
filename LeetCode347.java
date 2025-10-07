/*
Q1. Is the given array sorted?
Q2. Can the array be empty?
Q3. Can k be larger than the number of unique elements in the array? if so, return as many as possible?
*/

class Solution {
    public static class Pair{
        int value;
        int count;
        
        class Pair(int value, int count){
            this.value = value;
            this.count = count;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> maxCountQueeue = new PriorityQueue<>((a, b) -> Integer.compare(b.count, a.count));
        int left = 0;
        Arrays.sort(nums);
        for (int right = 0; right < nums.length; right ++){
            if (nums[right] != nums[left]){
                int count = right - left;
                maxCountQueeue.offer(new Pair(nums[left], count));
                left = right;
            }
        }

        maxCountQueue.offer(new Pair(nums[left], nums.length - left));

        int limit = Math.min(k, maxCountQueue.size());
        int[] result = new int[limit];
        for (int i = 0; i < limit; i ++){
            result[i] = maxCountQueue.poll().value;
        }

        return result;    
    }
}