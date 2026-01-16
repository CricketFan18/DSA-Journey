#include<bits/stdc++.h>
using namespace std;

void insertAtSorted(stack<int>& st, int x)
{
    if(st.empty() || st.top()<x)
    {
        st.push(x);
        return;
    }

    int top = st.top(); st.pop();
    insertAtSorted(st,top);
    st.push(top);
}


void sortStack(stack<int>& st)
{
    if(st.empty())
    {
        return;
    }

    int top = st.top(); st.pop();
    sortStack(st);
    insertAtSorted(st,top);
}

int main()
{
    return 0;
}