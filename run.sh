#!/bin/bash

# 사용법 체크: 입력값이 없으면 안내 메시지 출력
if [ -z "$1" ]; then
  echo "사용법: ./run.sh <소스파일명(확장자 제외)>"
  echo "예시: ./run.sh BaekJoon_1977"
  exit 1
fi

FILE_NAME=$1
SRC_FILE="src/cpp/${FILE_NAME}.cpp"
OUT_FILE="out/${FILE_NAME}"

# 찾으려는 소스 파일이 존재하는지 검사
if [ ! -f "$SRC_FILE" ]; then
  echo "❌ 오류: $SRC_FILE 파일을 찾을 수 없습니다."
  exit 1
fi

# 만약 out 폴더가 없으면 에러 안나게 알아서 생성 (-p 옵션)
mkdir -p out

echo "🛠️ 컴파일 진행 중: $SRC_FILE  -->  $OUT_FILE"
# out 풀더로 떨어지게 컴파일 진행
g++ -std=c++17 "$SRC_FILE" -o "$OUT_FILE"

# 방금 전 명령(g++)이 성공했는지 체크 (성공이면 0)
if [ $? -eq 0 ]; then
  echo "✅ 컴파일 성공! 프로그램을 실행합니다."
  echo "========================================="
  
  # 자동으로 input.txt 가 있으면 리다이렉션으로 먹여주는 센스 꿀팁!
  if [ -f "input.txt" ]; then
    echo "📄 (input.txt 에서 입력을 자동으로 읽어왔습니다)"
    "$OUT_FILE" < "input.txt"
  else
    # 없으면 평소처럼 직접 입력 대기
    "$OUT_FILE"
  fi
  
  echo ""
  echo "========================================="
else
  echo "❌ 컴파일 실패. 코드의 오타나 문법을 다시 한 번 확인해 주세요!"
fi
