## AWS_Cloud_School_toy_project
AWS Cloud School 토이 플젝 06.17 ~ 06.21

## 주제
1. CI/CD Automation Deployment with Jenkins
1. 젠킨스를 활용한 CI/CD 자동화 구축

2. Automate log collection with AWS Lambda functions
2. AWS Lambda 를 활용한 로그 수집 자동화

3. Monitoring System with Grafana
3. Grafana를 활용한 컴퓨팅 리소스 모니터링

## 아키텍처 구성도
![토이프로젝트_구성도](https://github.com/user-attachments/assets/61e2c8cd-4f90-43a4-acde-0e1900ee000e)

## 프로젝트 개요
우리 팀은 CI/CD 자동화, 로그 수집 자동화, 그리고 리소스 모니터링을 목표로 삼아 AWS 환경에서 다양한 DevOps 툴을 사용하여 배포 시스템을 구축하고 자동화하는 프로젝트를 진행했습니다. 이번 프로젝트에서는 Jenkins, AWS Lambda, Grafana를 사용해 효율적이고 자동화된 배포 및 모니터링 시스템을 구현하였습니다.

### 1. CI/CD Automation Deployment with Jenkins
젠킨스를 활용한 CI/CD 자동화 구축
개발 및 배포 단계에서 발생하는 반복적인 작업을 자동화하고, 지속적인 통합과 배포를 통해 소프트웨어의 무중단 배포를 실현하고자 Jenkins를 사용했습니다. 프로젝트에서는 Docker 이미지를 생성하고, 이를 AWS ECR에 푸시한 후, ECS에서 태스크로 띄우는 과정이 수동으로 이루어졌는데, Jenkins를 통해 이를 자동화하였습니다.

Dockerfile을 기반으로 docker 이미지 생성
Docker 이미지에 태그를 부여
AWS ECR에 이미지 업로드
ECS에서 태스크로 배포
위의 과정들이 Jenkins 파이프라인을 통해 자동으로 실행되며, 코드 변경 사항이 있을 때마다 자동으로 빌드, 테스트, 배포가 이루어집니다. 이를 통해 무중단 CI/CD 자동화 배포 시스템을 구축했습니다.

### 2. Automate Log Collection with AWS Lambda Functions
AWS Lambda를 활용한 로그 수집 자동화
ECS에서 실행되는 컨테이너들이 생성하는 로그를 효율적으로 수집하고 분석하기 위해 AWS Lambda 함수를 활용했습니다. Lambda는 일정 주기로 ECS 태스크에서 발생하는 로그를 수집하고, 이를 S3 버킷에 저장하는 역할을 합니다. 이렇게 자동화된 로그 수집 시스템은 중앙 집중화된 로그 저장소를 제공하여 문제 발생 시 신속하게 로그를 확인하고 대응할 수 있도록 돕습니다.

ECS에서 발생하는 로그 수집
AWS Lambda를 통한 로그 처리 및 S3 저장소에 저장
이 방식은 로그 데이터를 자동으로 저장하고 관리함으로써 로그 모니터링의 효율성을 높였습니다.

### 3. Monitoring System with Grafana
Grafana를 활용한 컴퓨팅 리소스 모니터링
프로젝트의 마지막 부분은 시각화 도구를 활용한 모니터링 시스템 구축입니다. AWS CloudWatch를 통해 수집한 메트릭을 Grafana 대시보드에서 시각화하여 실시간으로 시스템 성능을 모니터링할 수 있도록 구성했습니다. 특히 Grafana는 사용자 정의 대시보드 기능을 제공하여 시스템의 다양한 리소스 상태를 직관적으로 파악할 수 있습니다.

AWS CloudWatch에서 메트릭 수집
Grafana를 통한 모니터링 대시보드 구현
실시간 리소스 상태 모니터링 및 경고 설정

### 초기 개발 아이디어
소스코드는 시간날때 꾸미는 용도, 별로 안중요함 -> **간단한 예제 코드로 진행해도 될듯**

배경:
ecs안에 java 언어를 기반으로 작동하는 lambda 함수가 존재함
이 lambda 함수 코드들도 지속적으로 개발이 되는 중 -> **jenkins나 git action과 같은 ci-cd툴로 빌드 자동화 → 시간이 난다면, 여러 언어를 기반으로 하는 lambda함수들로 추가**

ecs안에 모니터링을 하는 컨테이너들도 같이 위치함 이 모니터링 컨테이너들은 인스턴스로 존재하고 조합은 prometeus+grafana or ELK

**시간이 난다면**, ddos공격 -> 트래픽 증가 -> 모니터링 시각화 툴로 보여주면서 waf를 통한 공격 방지하는 거 보여줄 수도
