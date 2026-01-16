#include<bits/stdc++.h>
using namespace std;

int help(string s,int index,int ans,bool neg)
{
    if(index >= s.length())  return neg ? -ans : ans;
    char ch=s.at(index);
    if(!isdigit(ch))  return neg ? -ans : ans;
    int digit = ch-'0';
    if (ans > (INT_MAX - digit) / 10) {
        return neg ? INT_MIN : INT_MAX;
    }
    return help(s, index + 1, ans * 10 + digit, neg);
}

int myAtoi(string s) 
{    
    int index=0;
    bool neg=false;
    while(index < s.length() && s.at(index)==' ') index++;
    if (index >= s.length()) return 0;
    if(s.at(index)=='-' || s.at(index)=='+')
    {
        neg = s.at(index)=='-';
        index++;
    }
    return help(s,index,0,neg);
}

int main()
{
    return 0;
}