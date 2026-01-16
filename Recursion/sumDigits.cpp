#include<bits/stdc++.h>
using namespace std;

int sumdigits(int num)
{
    if(num<10)
    return num;
    else
    return num%10+sumdigits(num/10);

}

int main()
{
    int a=12345;
    int sum=sumdigits(a);
    cout << sum << endl;
}