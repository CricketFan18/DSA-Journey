#include <bits/stdc++.h>
using namespace std;

// 1. Global Precomputation
unordered_set<long long> cubes;

void solve()
{
    long long x;
    cin >> x;

    for (long long a = 1; a <= 10000; a++) 
    {
        long long a3 = a * a * a; 
        long long b3 = x - a3;
        
        if (cubes.count(b3))
        {
            cout << "YES\n";
            return;
        }
    }
    cout << "NO\n";
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    for (long long i = 1; i <= 10000; i++) 
    {
        cubes.insert(i * i * i);
    }
    
    int t;
    cin >> t;
    while (t--)
    {
        solve();
    }

    return 0;
}