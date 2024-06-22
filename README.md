## AWS_Cloud_School_toy_project
AWS Cloud School 토이 플젝 06.17 ~ 06.21


## 초기 개발 아이디어
소스코드는 시간날때 꾸미는 용도, 별로 안중요함 -> **간단한 예제 코드로 진행해도 될듯**

배경:
ecs안에 java 언어를 기반으로 작동하는 lambda 함수가 존재함
이 lambda 함수 코드들도 지속적으로 개발이 되는 중 -> **jenkins나 git action과 같은 ci-cd툴로 빌드 자동화 → 시간이 난다면, 여러 언어를 기반으로 하는 lambda함수들로 추가**

ecs안에 모니터링을 하는 컨테이너들도 같이 위치함 이 모니터링 컨테이너들은 인스턴스로 존재하고 조합은 prometeus+grafana or ELK

**지이이인짜 시간이 난다면**, ddos공격 -> 트래픽 증가 -> 모니터링 시각화 툴로 보여주면서 waf를 통한 공격 방지하는 거 보여줄 수도
