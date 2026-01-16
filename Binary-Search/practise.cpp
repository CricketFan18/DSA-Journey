#include <bits/stdc++.h>
using namespace std;

bool isPossible(vector<int> &bloomDay, int m, int k, long long days)
{
    long long flowerInBouquet = 0;
    for (int flower : bloomDay)
    {
        if (flower <= days)
        {
            flowerInBouquet++;
            if (flowerInBouquet == k)
            {
                m--;
                flowerInBouquet = 0;
            }
        }
        else
        {
            flowerInBouquet = 0;
        }

        if (m == 0)
            return true;
    }
    return false;
}

int minDays(vector<int> &bloomDay, int m, int k)
{
    int n = bloomDay.size();
    if (n < m * k)
        return -1;
    long long low = *min_element(bloomDay.begin(), bloomDay.end()) - 1; // bad
    long long high = *max_element(bloomDay.begin(), bloomDay.end());    // good
    while (low + 1 < high)
    {
        long long mid = low + (high - low) / 2;
        if (isPossible(bloomDay, m, k, mid))
            high = mid;
        else
            low = mid;
    }
    return high;
}

int main()
{
    return 0;
}