/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class MSTKruskals
{
    static Scanner tj= new Scanner(System.in);
    static int n=5;
    static int parent[]=new int[n];
    static int find(int k)
    {
	    while(parent[k]!=k)
        {
		    k=parent[k];
        }
	    return k;
    }
    static int union(int k,int l)
    {
	    if(k!=l)
        {
		    parent[l]=k;
		    return 1;
	    }
	    return 0;
    }
    static void kruskals()
    {
	    int mincost=0,edges=1;
        int a=0,b=0,u=0,v=0;
	    int cost[][]=new int[n+1][n+1];
	    for(int i=1;i<=n;i++)
        {
		    for(int j=1;j<=n;j++)
            {
			    cost[i][j]=tj.nextInt();
			    if((cost[i][j]==0)||(i==j))
                {
				    cost[i][j]=999;
			    }
		    }
	    }
	    while(edges<n)
        {
		    int min=999;
		    for(int i=1;i<=n;i++)
            {
			    for(int j=1;j<=n;j++)
                {
				    if(cost[i][j]<min)
                    {
					    min=cost[i][j];
					    a=i;
					    b=j;
				    }
			    }
		    }
		    u=find(a);
		    v=find(b);
		    union(a,b);
		    System.out.println("Edge "+(edges++) +"=("+a+","+b+")\t cost="+min);
		    mincost+=min;
		    cost[a][b]=999;
		    cost[b][a]=999;
	    }
	    System.out.println(mincost);
    }
	public static void main (String[] args) throws java.lang.Exception
	{
	    
	    int ver=tj.nextInt();
	    n=ver;
	    kruskals();
	}
}
