# CodingTestStudy

## 개요

1. 취업(혹은 이직)을 목표로 하는 코딩테스트 스터디
2. 코드리뷰, 회의 등 소통은 GitHub와 Discord 사용
3. 2~3일에 한 번씩 과제를 수행하는 형식으로 진행
4. 적극적인 질문, 공격적인 코드리뷰

---

## 멤버

- 유석환(Swift)
- 정권호(Java)
- 정우빈(Java)
- 김경훈(Javascript)

기타 추가하고픈 사람있으면 언제든지 얘기

로직이 중요한 것이고 전공자들이여서 언어가 달라도 상관없을 것으로 예상하고 있긴한데, 몇번 진행해보고 문제가 있다고 생각되면 대책 강구

코드를 설명할 때 해당 언어를 모르는 사람에게도 이해시킬 수 있을 정도의 설명을 준비해야 함

본인이 사용하는 언어 고유의 특징은 당연히 본인이 알아서 공부

---

## 코드리뷰

1. 코드 리뷰 및 과제 제출은 GitHub를 통해 진행한다.
2. 코드설명은 Discord 화면공유를 통해 진행하며 한 문제를 한 사람이 대표로 설명한다.
설명을 들은 사람들은 피드백을 진행한다. (개선점, 다른 풀이방법 제시, 질문 등)

- GitHub 코드리뷰 진행 방법(파일 및 디렉터리는 예시임)
    1. 문제 제공자는 Baekjoon/QuestionList.md에 문제 링크를 추가하고 Push한다.
    Commit Message는 "Add Question: Baekjoon Q2557" 혹은 "Add Questions: Baekjoon Q2557 ~ Q2558"
    문제 내용을 수정할 경우는 "Update Question: Baekjoon Q2557"
    2. 구성원들은 Baekjoon/홍길동/에 Baekjoon/홍길동/Q2557.java을 작성해서 Push한다.
    최초 제출이므로 Commit Message는 "Submit Baekjoon/홍길동/Q2557.java"
    3. 솔루션을 제출한 사람은 Discord를 통해 구성원들에게 코드리뷰를 요청하고, 구성원들은 피드백을 한다.
    4. 만약 코드의 수정이 필요한 경우 Baekjoon/홍길동/Q2557.java를 수정한 후 Push한다.
    이때 Commit Message는 "Update Baekjoon/홍길동/Q2557.java: A를 B로 변경"

---

## 1단계 - 언어 숙달하기

먼저 코딩테스트를 응시할 언어를 정한 뒤, BOJ의 구현 문제들을 먼저 풀어본다. ([링크](https://www.acmicpc.net/problemset?sort=ac_desc&algo=102))

1. 이 단계에서는 본인의 언어에 대한 구현능력을 기르는 것에 집중
2. 문제가 상대적으로 쉬우므로 이 단계에서 GitHub 사용에 적응하고 코드리뷰, 코드설명을 어떻게 해야 더 효율적일지 고민

## 2단계 - 유형별로 겉핥기

대부분의 인원들이 초심자이므로 스터디 초반에는 유형별로 공부

스터디의 커리큘럼은 책(참고 1)의 커리큘럼을 그대로 따라하며, 순서는 다음과 같다.

- 유형
    1. 그리디
    2. 구현
    3. DFS/BFS
    4. 정렬
    5. 이진 탐색
    6. 다이나믹 프로그래밍
    7. 최단 경로
    8. 그래프 이론

해당 유형의 이론을 간단하게 익히고 백준 등에서 같은 유형의 문제를 가져와 푸는 방식으로 진행

→ 길고 어려운 문제보다 직관적이고 단순한 문제 위주로 푸는 것을 목표로 함

## 3단계 - 자력으로 공부할 수 있는 능력 기르기?

LeetCode, 프로그래머스 등의 문제들을 가져와서 풀고 코드리뷰

3단계가 완료되면 삼성SW역량, 카카오 기출문제 등에 도전할만한 정도를 목표로 함(제발)

3단계를 어떻게 진행할 지에 대한 내용은 2단계를 마무리할 때 쯤에 다시 고민해보자

---

### 참고

1. 나동빈, 「이것이 취업을 위한 코딩 테스트다 with 파이썬」, 한빛미디어(2020)
2. [https://velog.io/@wannte/코딩테스트-공부-방법-LeetCode-May-Daily-Challenge-Complete](https://velog.io/@wannte/%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EA%B3%B5%EB%B6%80-%EB%B0%A9%EB%B2%95-LeetCode-May-Daily-Challenge-Complete)
3. [https://covenant.tistory.com/220](https://covenant.tistory.com/220)
