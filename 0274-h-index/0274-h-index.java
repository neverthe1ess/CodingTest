class Solution {
    public int hIndex(int[] citations) {
        int[] counts = new int[1001];
        for(int i = 0; i < citations.length; i++){
            int index = citations[i];
            counts[index]++;
        }

        int count = 0;
        for(int i = 1000; i >= 0; i--){
            count += counts[i];
            if(i <= count){
                return i;
            }
        }
        return 0;
    }
}