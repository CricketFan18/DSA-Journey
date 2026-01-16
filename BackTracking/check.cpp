#include <bits/stdc++.h>
using namespace std;
int main()
{
    string s = "025525511135";
    for (int i = 0; i < 3; i++)
    {
        int ip = atoi(s.substr(0, i + 1).c_str());
        cout << ip << endl;
    }
    return 0;
}