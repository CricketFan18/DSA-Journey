#include<bits/stdc++.h>
using namespace std;

int main()
{
    string str;
    getline(cin,str);
    int n=0;
    bool neg=false;
    for(int i=0;i<str.size();i++)
    {
        char ch=str.at(i);
        if(isdigit(ch))
        {
            n=(n*10)+((int)(ch-48));
        }
        else
        {
            if(n!=0) break;
            if(ch=='-' && n==0) neg=true;
            else break;
        }
    }   
    if(neg)
    n=-n;

    cout << n << endl;
}