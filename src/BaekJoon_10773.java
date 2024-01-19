import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int arr[] = new int[k];
        int sum = 0;
        int index = 0;


        for(int i = 0; i < k; i++){
            int input = Integer.parseInt(br.readLine());

            if(input == 0){
                index--;
                arr[index] = 0;
            } else {
                arr[index] = input;
                index++;
            }
        }

        for(int s : arr){
            sum += s;
        }
        System.out.println(sum);

    }
}
