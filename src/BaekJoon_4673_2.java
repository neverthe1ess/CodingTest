public class BaekJoon_4673_2 {
    public static void main(String[] args){
        boolean[] self = new boolean[10001];
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= 10000; i++){
            String n = Integer.toString(i);
            int sum = i;
            for(int j = 0; j < n.length(); j++){
                sum += n.charAt(j) - '0';
            }
            if(sum <= 10000) self[sum] = true;
        }
        for(int i = 1; i <= 10000; i++){
            if(!self[i]){
                sb.append(i + "\n");
            }
        }
        System.out.println(sb);
    }
}
