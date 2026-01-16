#include<bits/stdc++.h>
using namespace std;
char helper(string str,int k)
{
    if(str.size()>=k)
    return str.at(k-1);
    else
    {
        string ap="";
        for(int i=0;i<str.size();i++)
        {
            char ch=str.at(i);
            ap =ap + (++ch);
        }
        
        str = str + ap;
        cout << str << endl;
        return helper(str,k);
    }
}

char kthCharacter(int k) 
{
    return helper("a",k);        
}



int main()
{
    cout << kthCharacter(5) << endl;
}