#include<bits/stdc++.h>
using namespace std;

int bs(int a[],int l,int h,int key)
{
    if(l<=h)
    {
        int mid=((h-l)/2)+l;
        if(a[mid]==key)
            return mid;
        else if(key<a[mid])
            return bs(a,l,mid-1,key);
        else
            return bs(a,mid+1,h,key);
    }
    return l;
}

int main()
{
    int ar[]={2,4,6,8,10,12,14,16,18};
    int x=4,y=9;
    int i=bs(ar,0,8,x);
    int j=bs(ar,0,8,y);
    if(x==ar[i] || y==ar[j])
    cout << j-i-1 << endl;
    else
    cout << j-i << endl;
}