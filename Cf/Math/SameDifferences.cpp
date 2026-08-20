#include <bits/stdc++.h>
using namespace std;

void solve()
{
    unordered_map<int,long long> freq;
    int n; 
    cin >> n;
    for(int i=0;i<n;i++)
    {
        int a;
        cin >> a;
        freq[a-i]++;
    }
    long long count = 0;
    for(auto [key,value] : freq)
    {
        count += (value * (value-1))/2;
    }
    cout << count << endl;

}
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int t;
    cin >> t;
    while (t--)
    {
        solve();
    }
    return 0;
}