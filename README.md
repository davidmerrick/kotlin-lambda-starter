Starter project for Kotlin microservice on AWS Lambda

Features:
- CircleCI config
- Serverless framework
- Kotlin Gradle DSL
- TestNG
- KotlinTest
- Koin

# Usage

This repo is configured as a template repo. Use [this guide](https://help.github.com/en/articles/creating-a-repository-from-a-template)
to create a new repo using it.

# Deployment

CircleCI is already configured with a test and deployment workflow. Simply import the project into CircleCI and it'll work.

To manually deploy, use `./gradlew deploy` to deploy to dev or `./gradlew deployPrd` to deploy to prd.