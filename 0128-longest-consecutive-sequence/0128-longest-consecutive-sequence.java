class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int max = 0;
        int count;
        for(int element: set){
            count = 0;
            if(!set.contains(element - 1)){
                for(int i = element; i <= 100_000_000_0; i++){
                    if(set.contains(i)){
                        count++;
                    } else {
                        break;
                    }
                }
            }
            max = Math.max(count, max);
        }
    return max;
    }
}