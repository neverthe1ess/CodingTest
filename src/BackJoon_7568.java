import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        Person[] p = new Person[count];

        for(int i = 0; i < count; i++){
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);

            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            p[i] = new Person(weight, height);
        }
        for(int i = 0; i < count; i++){
            for(int j = 0; j < count; j++){
                if((p[i].weight < p[j].weight) && (p[i].height < p[j].height)){
                    p[i].rank++;
                }
            }
        }
        for(int i = 0; i < count; i++){
            sb.append(p[i].rank+ " ");
        }
        System.out.println(sb);
    }
}

class Person{
    int weight;
    int height;

    int rank;

    Person(int weight, int height){
        this.weight = weight;
        this.height = height;
        this.rank = 1;
    }

}
