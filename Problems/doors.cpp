#include <bits/stdc++.h>
using namespace std;

inline void solve() {
    int n, x;
    cin >> n >> x;
    vector<int> a(n), b(n);
    
    for (int i = 0; i < n; i++)
        cin >> a[i];
    for (int i = 0; i < n; i++)
        cin >> b[i];

    vector<int> coins(n);
    for (int i = 0; i < n; i++) {
        coins[i] = a[i]*b[i];
    }
    sort(coins.rbegin(), coins.rend());

    int wallet = 0;
    int count = 0;

    /*for(auto &value:coins)
    {
        wallet+=value;
        count++;
        if(value>=wallet) break;
    }

    if (wallet >= x) 
        cout << count << endl; 
     else 
        cout << -1 << endl;*/
    for(auto &value:coins)
    {
        cout << value << " ";
    }
    
}

int main() {
    int t;
    cin >> t;
    while (t--) {
        solve();
    }
}