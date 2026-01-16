#include <bits/stdc++.h>
using namespace std;

string rev(string str)
{
  if (str.length() == 1)
    return str;
  else
    return rev(str.substr(1)) + str[0];
}

int main()
{
  string s;
  cin >> s;
  s = rev(s);
  cout << s << endl;
}