pipeline {
    agent any

    // 1. Define UI inputs inside Jenkins so you can switch settings without editing code
    parameters {
        choice(name: 'BROWSER', choices: ['chrome', 'firefox', 'edge'], description: 'Select the target browser for execution')
        choice(name: 'ENVIRONMENT', choices: ['staging', 'production', 'dev'], description: 'Select the test environment')
        string(name: 'THREAD_COUNT', defaultValue: '3', description: 'Number of parallel threads for TestNG execution')
    }

    tools {
        // Must match the exact name of the Maven installation configured in Jenkins (Global Tool Configuration)
        maven 'MAVEN_HOME' 
        // Must match the exact name of the JDK installation configured in Jenkins
        jdk 'JAVA_HOME'
    }

    stages {
        stage('Checkout Code') {
            steps {
                // Pulls the latest test code from your connected Git repository
                checkout scm
            }
        }

        stage('Execute Automation Tests') {
            steps {
                script {
                    // Triggers the Maven lifecycle execution. 
                    // It passes Jenkins parameter choices directly down into system properties (-D)
                    bat "mvn clean test -DsuiteXmlFile=testng.xml -Dbrowser=chrome -Denv=prod -Ddataproviderthreadcount=1"
                }
            }
        }
    }

    post {
        always {
            // 2. Publish the standard TestNG results XML to generate dashboard trend charts inside Jenkins
            // Requires the 'TestNG Results Plugin' installed on Jenkins
            junit testResults: '**/testng-results.xml', allowEmptyResults: true
            
            // 3. Archive and publish your Extent Spark HTML Report cleanly on the build panel
            // Requires the 'HTML Publisher Plugin' installed on Jenkins
            publishHTML([
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'target/SparkReport',
                reportFiles: 'Spark.html',
                reportName: 'Extent Execution Report',
                reportTitles: 'Automation Execution Status'
            ])
        }
        success {
            echo '🎉 All Automation Scenarios Executed and Passed Successfully!'
        }
        failure {
            echo '❌ Automation Suite Execution Detected Failures. Review the Extent Report or TestNG logs.'
        }
    }
}