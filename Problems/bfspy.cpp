#include <bits/stdc++.h>
using namespace std;

vector<int> bfs(int start,const vector<vector<int>> &adjList, int n)
{
    vector<int> dist(n, -1);
    queue<int> q;
    q.push(start);
    dist[start] = 0;
    while (q.size() > 0)
    {
        int u = q.front();
        q.pop();
        for (int v : adjList[u])
        {
            if (dist[v] == -1)
            {
                dist[v] = dist[u] + 1;
                q.push(v);
            }
        }
    }
    return dist;
}

bool validatePY(int a, int b, int c)
{
    return ((a*a) + (b*b)) == (c*c);
}

int specialNodes(int n, vector<vector<int>> &edges, int x, int y, int z)
{
    vector<vector<int>> adjList(n);
    for (auto row : edges)
    {
        int u = row[0];
        int v = row[1];
        adjList[u].push_back(v);
        adjList[v].push_back(u);
    }
    vector<int> distX = bfs(x, adjList, n);
    vector<int> distY = bfs(y, adjList, n);
    vector<int> distZ = bfs(z, adjList, n);
    // for (const auto &element : distX)
    // {
    //     cout << element << " ";
    // }
    // cout << endl;
    // for (const auto &element : distY)
    // {
    //     cout << element << " ";
    // }
    // cout << endl;
    // for (const auto &element : distZ)
    // {
    //     cout << element << " ";
    // }
    // cout << endl;
    int counter = 0;
    for (int i = 0; i < n; i++)
    {
        vector<int> temp = {distX[i], distY[i], distZ[i]};
        sort(temp.begin(), temp.end());
        for (const auto &element : temp)
        {
            cout << element << " ";
        }
        cout << endl;
        if (validatePY(temp[0], temp[1], temp[2]))
            counter++;
    }
    return counter;
}

int main()
{
    vector<vector<int>> v = {
        {0, 1}, {1, 2}, {1, 3}};
    cout << specialNodes(4, v, 1, 3, 0);
    return 0;
}