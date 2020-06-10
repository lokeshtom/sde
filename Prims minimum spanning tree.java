import java.util.*; 
import java.lang.*; 
import java.io.*; 
class PRIMSmst
{
    public static void main (String[] args) 
    {
        Scanner tj=new Scanner(System.in);
        int n=tj.nextInt();
        int a[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                a[i][j]=tj.nextInt();
            }
        }
        int parent[] = new int[n]; 
        int key[] = new int[n]; 
        Boolean Set[] = new Boolean[n]; 
        for (int i = 0; i < n; i++) 
        { 
            key[i] = Integer.MAX_VALUE; 
            Set[i] = false; 
        } 
        key[0] = 0; 
        parent[0] = -1;
        for (int i = 0; i < n - 1; i++)
        { 
            int min = Integer.MAX_VALUE, min_index = -1; 
            for (int v = 0; v < n; v++)
            {
                if (Set[v] == false && key[v] < min) 
                { 
                    min = key[v]; 
                    min_index = v; 
                } 
            }
            int u=min_index;
            Set[u] = true; 
            for (int v = 0; v < n; v++) 
            {
                if (a[u][v] != 0 && Set[v] == false && a[u][v] < key[v]) 
                { 
                    parent[v] = u; 
                    key[v] = a[u][v]; 
                } 
            } 
        }
        System.out.println("Edge \tWeight"); 
        for (int i = 1; i < n; i++) 
            System.out.println(parent[i] + " - " + i + "\t" + a[i][parent[i]]); 

    }
}
