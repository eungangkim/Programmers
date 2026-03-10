#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
/*
    아이디어 1. 1초마다 신호등의 상태를 추적 -> 모든 신호등이 노란색인 경우 리턴
                시간 복잡도:O(무한)

    아이디어 2. 주기적인 시간들의 최소 공배수를 구한다.
*/

int gcd(int a, int b)
{
    // a가 b보다 크지 않을 때 a값이 b보다 크게 만들기 위한 코드
    if (a < b) {
        int temp = a;
        int a = b;
        int b = temp;
    }
    // 유클리드 알고리즘
    while (b != 0) {
        int r;
        r = a % b;
        a = b;
        b = r;
    }
    return a;
}
int lcm(int a, int b)
{
    return (a * b) / gcd(a, b);
}


// signals_rows는 2차원 배열 signals의 행 길이, signals_cols는 2차원 배열 signals의 열 길이입니다.
int solution(int** signals, size_t signals_rows, size_t signals_cols) {
    int answer = 0;
    // 동적 할당으로 states 배열 생성
    int** states = (int**)malloc(sizeof(int*) * signals_rows);
    for (size_t i = 0; i < signals_rows; i++) {
        states[i] = (int*)malloc(sizeof(int) * 2);
        states[i][0] = 0; // 상태 초기화
        states[i][1] = 0; // 상태 초기화
    }
    int maxCount = signals[0][0]+signals[0][1]+signals[0][2];
    for (int i = 0; i < signals_rows; i++) {
        int period = signals[i][0] + signals[i][1] + signals[i][2];
        maxCount = lcm(maxCount, period);
    }
    for (int i = 0; i < maxCount; i++) {
        for (size_t j = 0; j < signals_rows; j++) {
            if (states[j][1] + 1 > signals[j][states[j][0]]) {
                states[j][0] = (states[j][0] + 1) % 3;
                states[j][1] = 1;
            }
            else {
                states[j][1]++;
            }
        }
		bool allYellow = true;
        for(int j=0; j < signals_rows; j++) {
            if(states[j][0] != 1) {
                allYellow = false;
                break;
			}
		}
        if (allYellow) {
            return i+1;
        }
    }
    for (size_t i = 0; i < signals_rows; i++) {
        free(states[i]);
    }
    free(states);
    return -1;
}

