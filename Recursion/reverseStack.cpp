#include<bits/stdc++.h>
using namespace std;

void insertAtBottom(stack<int>& st, int x)
{
    if (st.empty())
    {
        st.push(x);
        return;
    }

    int top = st.top();
    st.pop();
    insertAtBottom(st, x);
    st.push(top);
}

void rev(stack<int>& st)
{
    if (st.empty())
        return;

    int x = st.top();
    st.pop();
    rev(st);
    insertAtBottom(st, x);
}

int main()
{

    return 0;
}