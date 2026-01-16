#include <bits/stdc++.h>
using namespace std;

void backtrack(vector<vector<int>> &result, vector<int> &path,vector<int> &candidates,int pos)
{
    if (path.size() == candidates.size())
    {
        result.push_back(path);
        return;
    }

    for (int i = pos; i < candidates.size();++i)
    {
        path.push_back(candidates[i]);
        backtrack(result, path,candidates,i+1);
        path.pop_back();
    }
}

vector<vector<int>> combinations(vector<int> &candidates)
{
    vector<vector<int>> result;
    vector<int> path;
    backtrack(result, path, candidates,0);
    return result;
}

int main()
{
    int n;
    cin >> n;
    vector<int> v(n);
    for(auto &num:v)
        cin >> num;

    vector<vector<int>> ans = combinations(v);
    for(const auto& row:ans)
    {
        for(int val: row)
        {
            cout << val << " ";
        }
        cout << endl;
    }
    return 0;
}