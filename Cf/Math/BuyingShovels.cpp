#include <bits/stdc++.h>
using namespace std;

void solve()
{
    long long n, k;
    cin >> n >> k;
    long long ans = 1;
    for (long long i = 1; i * i <= n; i++)
    {
        if (n % i == 0)
        {
            if (n / i <= k)
                ans = max(ans, n / i);
            else if (i <= k)    
                ans = max(ans, i);
        }
    }
    cout << ans << endl;
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