#include <bits/stdc++.h>
using namespace std;

void backtrack(int n, string& path, vector<string>& result, char prev) {
    if (path.length() == n) {
        result.push_back(path);
        return;
    }

    // Always allowed to add '0'
    path.push_back('0');
    backtrack(n, path, result, '0');
    path.pop_back();

    //  path.push_back('1');
    //     backtrack(n, path, result, '1');
    //     path.pop_back();

    // // Add '1' only if previous was '0'
    if (prev == '0') {
        path.push_back('1');
        backtrack(n, path, result, '1');
        path.pop_back();
    }
}

vector<string> generateBinaryStrings(int n) {
    vector<string> result;
    string path;
    backtrack(n, path, result, '0');  // Initially safe to consider previous as '0'
    return result;
}

int main() {
    int n;
    cin >> n;
    vector<string> result = generateBinaryStrings(n);

    for (auto& s : result) {
        cout << s << endl;
    }

    return 0;
}
