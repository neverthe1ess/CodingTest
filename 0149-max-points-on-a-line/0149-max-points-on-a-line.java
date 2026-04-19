class Solution {
    public int maxPoints(int[][] points) {
        int result = 0;
        for(int i = 0; i < points.length; i++){
            HashMap<String, Integer> map = new HashMap<>();
            int max = 0;
            for(int j = i + 1; j < points.length; j++){
                int[] pivot = points[i];
                int[] target = points[j];
                int dx = target[0] - pivot[0];
                int dy = target[1] - pivot[1];

                if(dx == 0){
                    String key = "0" + "/" + "1";
                    map.put(key, map.getOrDefault(key, 0) + 1);
                    max = Math.max(max, map.get(key));
                    continue;
                }

                if(dy == 0){
                    String key = "1" + "/" + "0";
                    map.put(key, map.getOrDefault(key, 0) + 1);
                    max = Math.max(max, map.get(key));
                    continue;
                }

                int Adx = Math.abs(dx);
                int Ady = Math.abs(dy);

                if(dx < 0) {
                    dx = -dx;
                    dy = -dy;
                }

                int div = 0;
                if(Adx < Ady) {
                    div = gcd(Adx, Ady);
                } else {
                    div = gcd(Ady, Adx);
                }
                dx = dx / div;
                dy = dy / div;
                String key = dx +"/" + dy;
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
            result = Math.max(result, max + 1);
        }
        return result;
    }
    private static int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a % b);
    }
}