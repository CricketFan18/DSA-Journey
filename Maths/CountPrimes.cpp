#include<bits/stdc++.h>
using namespace std;
int main()
{
    int n;
    cin >> n;
    vector<int> num(n,1);
    int count = 0;;
    for(int i=2;i<n;i++)
    {
        if(num[i] == 1)
        {
            count++;
            cout << i << " ";
            int k=2;
            while(i*k < n)
            {
                num[i*k] = 0;
                k++;
            }
        }
    }
    cout << endl;
    cout << count << endl;
    return 0;
}