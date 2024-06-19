pipeline {
    agent any
    environment {
        ECR_REPO_URL = '132464628555.dkr.ecr.ap-northeast-2.amazonaws.com'
        CLUSTER_NAME = 'ecs-cluster'
        SERVICE_NAME = 'ecs-srv'
    }
    triggers {
        githubPush() // GitHub hook trigger for GITScm polling.
    }
    options {
        // 빌드를 5개만 유지
        buildDiscarder logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '5', numToKeepStr: '5')
        // github 프로젝트 설정
        githubProjectProperty(displayName: '', projectUrlStr: 'https://github.com/rttitity/AWS_Cloud_School_toy_project')

    }
    stages {
        stage('Checkout') {
            steps {
               git branch: 'main', credentialsId: 'github-token', url: 'https://github.com/rttitity/AWS_Cloud_School_toy_project'
            }
        }
        stage('Build') {
            steps {
                // dir("projects/spring-app"){
                //     sh './gradlew build'
                //     sh 'docker build -t myjavaapp:latest .'
                // }
                dir("java-instance"){
                    sh './gradlew build'
                    sh 'docker build -t myjavaapp:1 .'
                }
            }
        }
        stage('Tag') {
            steps {
                sh "docker tag myjavaapp:1 ${env.ECR_REPO_URL}/myjavaapp:1"
            }
        }
        stage('Push') {
            steps {
                withAWS(credentials: 'aws-credentials', region: 'ap-northeast-2') {
                    sh "aws ecr get-login-password --region ap-northeast-2 | docker login --username AWS --password-stdin ${env.ECR_REPO_URL}"
                    sh "docker push ${env.ECR_REPO_URL}/myjavaapp:1"
                }
            }
        }
        stage('Deploy') {
            steps {
                withAWS(credentials: 'aws-credentials', region: 'ap-northeast-2') {
                    sh "aws ecs update-service --region ap-northeast-2 --cluster ${CLUSTER_NAME} --service ${SERVICE_NAME} --force-new-deployment"
                }
            }
        }
    }
}
