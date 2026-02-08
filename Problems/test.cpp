#include <bits/stdc++.h>
using namespace std;

vector<int> rotateElements(vector<int> &nums, int k)
{
    vector<int> pos;
    for (int num : nums)
    {
        if (num >= 0)
            pos.push_back(num);
    }
    if(pos.size() == 0)
        return nums;
    k = k % pos.size();
    reverse(pos.begin(), pos.begin() + k);
    for (const auto& element : pos) {
        cout << element << " ";
    }
    cout << endl;
    reverse(pos.end() - k, pos.end());
    for (const auto& element : pos) {
        cout << element << " ";
    }
    cout << endl;
    reverse(pos.begin(), pos.end());
    for (const auto& element : pos) {
        cout << element << " ";
    }
    cout << endl;
    int i = 0;
    for (int &num : nums)
    {
        if (num >= 0)
        {
            num = pos.at(i++);
        }
    }
    for (const auto& element : nums) {
        cout << element << " ";
    }
    cout << endl;
    return nums;
}

int main()
{
    vector<int> v = {3,11};
    rotateElements(v,27812);
    return 0;
}