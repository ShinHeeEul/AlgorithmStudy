#include<iostream>
#include<memory.h>
#include<vector>
#include<queue>
#include<unordered_map>
#include<algorithm>
#include<string>
#include<cmath>
#define INF 1e9
using namespace std;
using lld = long long int;
using pii = pair<int, int>;
int n, m, k;
 
 
 
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int b, e;
    char s[210];
    while (1) {
        cin >> b >> e;
        if (b == -1 && e == -1) break;
        cin.getline(s,205);
        b++; e++;
 
        vector<string> v;
        vector<string> v2; // 부분문자열 안에있는 태그
        bool flag = false; // 태그안의 문자열인지
        bool flag2 = false; // 닫는태그인지
        string tmp;
        string substr;
        int cnt = 0;
        for (int i = 1; i < e; i++) {
            if (!flag &&s[i] == '<') {
                flag = true;
                if (s[i + 1] == '/') flag2 = true;
            }
            else if (flag2) {
                if (s[i] == '>') {
                    if (i >= 1 && i < b) {
                        if (v.size() > 0) v.pop_back();
                        
                    }
                    else {
                        if (v2.size() > 0) v2.pop_back();
                        else if (v2.size() == 0) cnt++;
                    
                    }
                    flag2 = false;
                    flag = false;
                }
                else continue;
            }
            else if (flag){
                if (s[i] == '>') {
                    flag = false;
                    if (i >= 1 && i < b) {
                        v.push_back(tmp);
                    }
                    else {
                        v2.push_back(tmp);
                    }
                    tmp.clear();
                    
                }
                else {
                    tmp += s[i];
                }
            }
 
        }
 
 
        for (int i = b; i < e; i++) {
            substr += s[i];
        }
        
        for (int i = 0; i < v.size(); i++) {
            cout << "<" << v[i] << ">";
        }
        cout << substr;
 
        for (int i = v2.size() - 1; i >= 0; i--) {
            cout << "</" << v2[i] << ">";
        }
 
        for (int i = v.size() - 1-cnt; i >= 0; i--) {
            cout << "</" << v[i] << ">";
        }
        cout << "\n";
    }
    
    return 0;
}
