import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_11723 {

    public static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        arr = new int[20];

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()){
                case "add":
                    break;
                case "check":
                    break;
                case "remove":
                    break;
                case "toggle":
                    break;
                case "all":
                    break;
                case "empty":
                    break;
            }
        }
    }
    public static void add(int x){


    }
    public static void remove(int x){


    }
    public static void check(int x){

    }

    public static void toggle(int x){


    }
    public static void all(){

    }
    public static void empty(){


    }



}
