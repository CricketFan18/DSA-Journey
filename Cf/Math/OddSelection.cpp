#include <bits/stdc++.h>
using namespace std;

void solve()
{
    int n, x;
    cin >> n >> x;
    int odd = 0;
    int even = 0;
    for (int i = 0; i < n; i++)
    {
        int a;
        cin >> a;
        if (a % 2 == 0)
            even++;
        else
            odd++;
    }
    for(int i=1;i<= min(x,odd);i+=2)
    {
        int need = x-i;
        if(need <= even)
        {
            cout <<"YES\n";
            return;
        }
    }
    cout << "NO\n";
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