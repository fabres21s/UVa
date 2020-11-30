/**
*	10132 - File Fragmentation
*
*
*	Submission:	9565793
*	Date:		2011-12-16 13:45:45
*	Runtime:	0.032
*	Ranking:	2273 / 2638
*/
public class Main10132 {

	public static void main(String[] args) {
		//TODO Resuelto en C++ - Intentar en Java - File Fragmentation
	}

}

/*
#include <iostream>
#include <string>
#include <vector>
 
using namespace std;
 
bool dentro (vector <int> N, int x, int y)
{
    for (int i = 0; i < N.size(); i++)
    {
        if (x == N[i]) return 1;
        if (y == N[i]) return 1;
    }
    return 0;
}

 
bool comprobar (vector <string> A, string str1, int a, int b)
{
    vector <int> n;
    n.push_back (a);
    n.push_back (b);
 
    for (int i = 0; i < A.size(); i++)
    {
        for (int j = 0; j < A.size (); j++)
        {
            int x, y;
            if (i != j && ! (dentro (n, i, j)))
            {
                string tmp = A[i] + A[j];
                if (tmp == str1)
                {
                    n.push_back (i);
                    n.push_back (j);
                }
            }
        }
    }
    if (A.size () == n.size ()) return 1;
    else return 0;
}
 
string todo (vector <string> A)
{
    int n = 0;
    for (int i = 0; i < A.size(); i++)
    {
        n += A[i].length();
    }
    n = n / (A.size()/2);
    for (int i = 0; i < A.size (); i++)
    {
        for (int j = 0; j < A.size (); j++)
        {
            if (i != j)
            {
                string tmp = A[i] + A[j];
                if (tmp.length() == n)
                {
                    if (comprobar (A, tmp, i, j))
                    {
                        return tmp;
                    }
                }
            }
        }
    }
    return "";
}
 
int main ()
{
 
        string str1;
        int c;
        cin >> c;
        getline (cin, str1);
        getline (cin, str1);
        for (int i = 0; i < c; i++)
        {
            if (i > 0) cout << endl;
            vector <string> A;
 
            while (getline (cin,str1))
            {
                if (str1.length() > 0)
                {
                    A.push_back (str1);
                }else break;
            }
            cout << todo (A)  << endl;
        }
    return 0;
}
*/