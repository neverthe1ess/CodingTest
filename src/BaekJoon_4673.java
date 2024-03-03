public class BaekJoon_4673 {
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= 10000; i++){
            if(i / 1 < 10){


            } else if (i / 10 < 10){

            } else if (i / 100 < 10 ){

            } else if (i / 1000 <= 10 ){

            } else {
                sb.append(i + "\n");
            }

        }

    }
}
