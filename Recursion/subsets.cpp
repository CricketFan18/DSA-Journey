#include<bits/stdc++.h>
using namespace std;

class Solution
{
public:
vector<vector<int>> ans;
void help(int i,vector<int>& nums,vector<int>& temp)
{
    if(i>=nums.size())
    {    
        ans.push_back(temp);
        return;
    }
    temp.push_back(nums[i]);
    help(i+1,nums,temp);
    temp.pop_back();
    help(i+1,nums,temp);

}

vector<vector<int>> subsets(vector<int>& nums)
{   
    vector<int> temp;
    help(0,nums,temp);
    return ans;
}

};

int main()
{
    int n;
    cin >> n;
    vector<int> v(n);
    for(auto &num:v)
        cin >> num;
        
    Solution ob;
    vector<vector<int>> ans = ob.subsets(v);
    for (const auto &row : ans)
    {
        for (int val : row)
        {
            cout << val << " ";
        }
        cout << endl;
    }
}

