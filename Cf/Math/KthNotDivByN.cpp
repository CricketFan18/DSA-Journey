#include <bits/stdc++.h>
using namespace std;

void solve()
{
    long long n, k;
    cin >> n >> k;
    // long long low = 0; 
    // long long high = 2e9 + 7; 

    // while(low + 1 < high)
    // {
    //     long long mid = low + (high - low) / 2;
    //     long long idx = mid - (mid / n);
        
    //     if(idx < k) 
    //         low = mid;
    //     else 
    //         high = mid;
    // }
    // cout << high << "\n";
    cout << k + (k-1)/(n-1) << endl;
}

int main() {
    // Fast I/O
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int t;
    cin >> t;
    while(t--)
    {
        solve();
    }
    return 0;
}