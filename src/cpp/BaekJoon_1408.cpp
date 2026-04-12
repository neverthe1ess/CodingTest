#include <iostream>

int main() {
  int hourCur, minuteCur, secondCur;
  int hourStart, minuteStart, secondStart;

  scanf("%d:%d:%d", &hourCur, &minuteCur, &secondCur);
  scanf("%d:%d:%d", &hourStart, &minuteStart, &secondStart);

  int totalSecondCur = hourCur * 3600 + minuteCur * 60 + secondCur;
  int totalStartCur = hourStart * 3600 + minuteStart * 60 + secondStart;

  int finalTime = totalStartCur - totalSecondCur;
  if (finalTime < 0) {
    finalTime += 86400;
  }

  int finalHour = finalTime / 3600;
  int finalMinute = (finalTime % 3600) / 60;
  int finalSecond = (finalTime % 3600) % 60;

  printf("%02d:%02d:%02d", finalHour, finalMinute, finalSecond);
}
