import java.util.*;
import java.io.*;
public class shellgame {
	public static int N;
    public static BufferedReader reader;
    public static int[] ord = new int[3], cnt = new int[3];
    public static void main(String[] args) throws IOException
    {
        reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i=0;i<3;++i)
            ord[i]=i;
        N=Integer.parseInt(reader.readLine());
        System.out.println();
        for(int i=0;i<N;++i)
        {
            st = new StringTokenizer(reader.readLine());
            int a=Integer.parseInt(st.nextToken())-1;
            int b=Integer.parseInt(st.nextToken())-1;
            int g=Integer.parseInt(st.nextToken())-1;
            int t=ord[b];
            ord[b]=ord[a];
            ord[a]=t;
            ++cnt[ord[g]];
            
            System.out.println(i + ":" + ord[0] + " " + ord[1] + " " + ord[2]);
            System.out.println(i + ":" + ord[g] + " " + cnt[ord[g]]);
        }
        System.out.println(Math.max(cnt[0], Math.max(cnt[1], cnt[2])));
        reader.close();
    }
}
