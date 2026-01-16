#include <bits/stdc++.h>
using namespace std;

void swap(int a, int b)
{
    printf("a: %d,b: %d\n", a, b);
    a = a ^ b;
    b = a ^ b;
    a = a ^ b;
    printf("a: %d,b: %d\n", a, b);
}

void extractIthBit(int k, int i)
{
    if ((k & (1 << i)) == 0)
        cout << "0\n";
    else
        cout << "1\n";
}

void setIthBit(int k, int i)
{
    k = k | (1 << i);
    cout << k << endl;
}

void toggleIthBit(int k, int i)
{
    k = k ^ (1 << i);
    cout << k << endl;
}

void removeLastSetBIt(int k)
{
    k = k & k - 1;
}

void powerOfTwo(int k)
{
    if ((k & k - 1) == 0)
        cout << "Yes\n";
    else
        cout << "No\n";
}

void countSetBits(int k)
{
    int count=0;
    while(k!=0)
    {
        count += k & 1;
        k=k>>1;
    }
    cout << "count: " << count << endl;
}



int main()
{
    countSetBits(31);
    return 0;
}