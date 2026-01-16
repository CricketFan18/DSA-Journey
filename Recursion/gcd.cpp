#include<bits/stdc++.h>
using namespace std;

int gcd(int a,int b)
{
    if(b%a==0)
    return a;
    else
    return gcd(b%a,a);
}

int main()
{
    int a,b;
    cin >> a >> b;
    int sum=gcd(a,b);
    cout << sum << endl;
}