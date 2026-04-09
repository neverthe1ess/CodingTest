#include <iostream>
using namespace std;

int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);

  int a, b;
  cin >> a >> b;
  int min = -1;
  int sum = 0;
  bool isFind = false;

  for (int i = 1; i <= 100; i++) {
    int square = i * i;
    if (a <= square && b >= square) {
      sum += square;
      if (!isFind) {
        min = square;
        isFind = true;
      }
    }
  }
  if (!isFind) {
    cout << min;
  } else {
    cout << sum << '\n';
    cout << min;
  }

  return 0;
}