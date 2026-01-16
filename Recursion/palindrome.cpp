#include<bits/stdc++.h>
using namespace std;

bool palindrome(string str)
{
    int len = str.length();
    if (len <= 1)
        return true;
    if (str[0] != str[len - 1])
        return false;
    return palindrome(str.substr(1, len - 2));
}

int main()
{
    string s;
    cin >> s;
    cout << palindrome(s) << endl;
}