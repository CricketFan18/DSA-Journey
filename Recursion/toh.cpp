#include<bits/stdc++.h>
using namespace std;

void toh(int n,char Source,char Auxil,char Destination)
{
    if(n==1)
    {
        printf("%c -> %c\n",Source,Destination);
    }
    else
    {
        toh(n-1,Source,Destination,Auxil);
        printf("%c -> %c\n",Source,Destination);
        toh(n-1,Auxil,Source,Destination);
    }
    
}

int main()
{
    int n;
    cin >> n;
    toh(n,'A','B','C');
}