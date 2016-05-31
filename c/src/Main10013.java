
/**
*	10010 - Where's Waldorf?
*
*
*	Submision:	9615657
*	Date:		2012-01-03 21:44:15
*	Runtime:	0.912
*	Ranking:	1389
*/

public class Main10013 {

	public static void main(String[] args) {
		// TODO Resuelto en C++ - Intentar en Java
	}

}
/*

#include<stdio.h>
int main()
{
  long int n,m,i,add,count=0;
  int a[1000050],b[1000050];
  scanf("%ld",&n);


while(n>0)
{
  n--;

  if(count>0)
  printf("\n");
  scanf("%ld",&m);
  for(i=0;i<m;i++)
  scanf("%d %d",&a[i],&b[i]);

  add=0;
  for(i=m-1;i>=0;i--)
  {
  add=a[i]+b[i]+add;
  a[i]=add%10;
  add=add/10;
  }

  for(i=0;i<m;i++)
  printf("%d",a[i]);
  printf("\n");

  count++;
  }
  return 0;
}
 



#include "stdio.h"
#define M 1000002


void main()
{
     int a[M];
int b[M];
int res[M];
    int t,c,m,i;
    scanf("%d",&t);
    while(t--)
    {
        scanf("%d",&m);
        c=0;
        for(i=0;i<m;i++)
            scanf("%d %d",&a[i],&b[i]);
        for(i=m-1;i>=0;i--)   
        {
            res[i]=(a[i]+b[i]+c)%10;
            c=(a[i]+b[i]+c)/10;
        }
        for(i=0;i<m;i++)
            printf("%d",res[i]);
        if(t)
            printf("\n\n");
        else
            printf("\n");
    }
} */


