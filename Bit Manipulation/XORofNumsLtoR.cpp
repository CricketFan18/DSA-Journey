#include<bits/stdc++.h>
using namespace std;

int xorToN(int n)
{
    if( n % 4 == 1 )        return 1 ;
    else if( n % 4 == 2 )   return n+1 ;
    else if( n % 4 == 3 )   return 0 ;
    else                    return n;
}

int main()
{
    int l=4;
    int r=8;
    int ans = xorToN(l-1) ^ xorToN(r);
    cout << ans << endl;
    return 0;
}