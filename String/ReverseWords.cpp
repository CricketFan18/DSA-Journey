#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    static string reverseWords(string s) 
    {
        string ans="";
        string word="";
        s=s+" ";
        for(int i=0;i<s.size();i++)        {
            
            char ch = s.at(i);            
            if(ch!=' ') {
                word=word+ch;                
            } else if(!word.empty()) {
               ans = word + " " + ans;
               word="";
            }
        }
        return ans.substr(0,ans.size()-1);
    }
};

int main()
{
    string s = "the sky is blue";
    cout << Solution::reverseWords(s) << "."<< endl;
    return 0;
}