class Solution {
    public int longestConsecutive(int[] nums) {
        // Q1. Does it has duplicate number in array nums?
        // Q2. Can you give me an example?
        
        // Tips:
        // 1. Use HashSet to store the numbers in the array. This will help us check if nums + 1 and nums - 1 exist.
        Set<Integer> set = new HashSet<>();
        int result = 0;
        for (int num : nums){
            set.add(num);
        }

        for (int num : set){
            if (!set.contains(num - 1)){
                int currentLength = 1;
                while(set.contains(num + currentLength)){
                    currentLength ++;
                }

                result = Math.max(result, currentLength);
            }
        }

        return result;
    }
}