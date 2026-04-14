#include <ios>
#include <iostream>
#include <string>

using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int p;
    cin >> p;
    int max = -1;
    string maxPlayer;

    string player;
    int value;
    for (int j = 0; j < p; j++) {
      cin >> value >> player;
      if (max < value) {
        max = value;
        maxPlayer = player;
      }
    }
    cout << maxPlayer << "\n";
  }
}