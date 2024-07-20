node {
  stage('SCM') {
    checkout scm
  }
  stage('SonarQube Analysis') {
    def mvn = tool 'Default Maven';
    withSonarQubeEnv() {
      sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=soyunmate-org_AppManageEventsOrg_1ea4b228-15bf-44a3-9154-a8a05e6dc9d0 -Dsonar.projectName='AppManageEventsOrg'"
    }
  }
}
