class Solution {
    private static int[] arr;
    private static String[] words;
    private static int length;
    private static String digit;
    private static List<String> result; 

    public List<String> letterCombinations(String digits) {
        length = digits.length();
        result = new ArrayList<>();
        words = new String[10];
        digit = digits;
        arr = new int[length];
        words[2] = "abc";
        words[3] = "def";
        words[4] = "ghi";
        words[5] = "jkl";
        words[6] = "mno";
        words[7] = "pqrs";
        words[8] = "tuv";
        words[9] = "wxyz";
        dfs(0);
        return result;
    }

    private static void dfs(int depth){
        if(depth == length){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < depth; i++){
                int index = arr[i];
                int target = digit.charAt(i) - '0';
                if(words[target].length() <= index){
                    return;
                }
                sb.append(words[target].charAt(index));
            }
            result.add(sb.toString());
            return;
        }
        for(int i = 0; i < 4; i++){
            arr[depth] = i;
            dfs(depth + 1);
        }

    }
}