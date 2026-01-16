#include <bits/stdc++.h>
using namespace std;

int myPow(int x, int y)
{
    if (y == 0)
        return 1; // Correct base case: x^0 = 1
    else if (y < 0)
        return (1 / x * myPow(x, y + 1));
    else
        return x * myPow(x, y - 1);
}

double help(double x, long long exp, double ans)
{
    if(exp <= 0) return 1;
    if (exp % 2 == 1)
        return help(x,exp-1,ans*x);
    else
        return help(x*x,exp/2,ans);
}

double power(double x, int n)
{
    long long exp = n;
    if (n < 0)
    {
        x = 1 / x;
        exp = -exp;
    }
    return help(x,exp,1);
}

int main()
{
    int a = 2;
    int b = 5;
    int sum = myPow(a, b);
    cout << sum << endl;
}