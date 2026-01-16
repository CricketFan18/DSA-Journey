#include<bits/stdc++.h>
using namespace std;

void toBin(int num)
{   
   if (num == 0) return; // base case
    toBin(num / 2);
    cout << num % 2;
}

int main()
{
    int a;
    cin >> a;
    toBin(a);
    cout << endl;
}