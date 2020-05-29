
import java.util.*;
import java.lang.*;
import java.io.*;

class knapsack {
	public static void main (String[] args) 
	{
		int wt[]={10,40,20,30,15};      // weight of the products
		int val[]={60,40,100,120,140};  // value of the products 
		int capacity=70;                //capacity that knapsack can hold
		
		//calculate the maximum value knapsack can hold
		int n=wt.length;
		double r[]=new double[n];    // array to store val/wt ratio
		for(int i=0;i<n;i++)
		{
		     r[i]=(double)val[i]/(double)wt[i];
		}
		// sorting based on ratio of val/wt in ascending order
		for(int i=0;i<n-1;i++)
		{
		    for(int j=i+1;j<n;j++)
		    {
		        if(r[i]>r[j])
		        {
		            double temp=r[i];
		            r[i]=r[j];
		            r[j]=temp;
		            int tem=wt[i];
		            wt[i]=wt[j];
		            wt[j]=tem;
		            tem=val[i];
		            val[i]=val[j];
		            val[j]=tem;
		        }
		    }
		}
		int maxval=0;
		int i=n-1;
		while(capacity>0&&i>=0)
		{
		    
		    if(capacity>wt[i]) 
		    {
		        // if capacity is greater than weight(so that knapsack can hold it completly)
		        maxval+=val[i];
		        capacity-=wt[i];
		        i--;
		    }
		    else
		    {
		        // if capacity is less than weight(only fraction of product can be added in knapsack)
		       
		        maxval+=(val[i]*capacity/wt[i]);
		        capacity=0;
		        i--;
		    }
		}
		System.out.println(maxval);
	}
}
