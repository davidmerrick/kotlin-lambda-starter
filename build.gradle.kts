group = "com.merricklabs.lambda"

plugins {
    kotlin("jvm") version Versions.org_jetbrains_kotlin
    id("de.fayard.buildSrcVersions") version Versions.de_fayard_buildsrcversions_gradle_plugin
    id("com.github.johnrengelman.shadow") version Versions.com_github_johnrengelman_shadow_gradle_plugin
}

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(Libs.kotlin_stdlib_jdk8)
    implementation(Libs.kotlin_logging)
    implementation(Libs.aws_lambda_java_core)
    implementation(Libs.aws_lambda_java_events)
    implementation(Libs.aws_lambda_java_log4j2)
    implementation(Libs.jackson_module_kotlin)
    implementation(Libs.jackson_core)
    implementation(Libs.jackson_databind)
    implementation(Libs.jackson_annotations)
    implementation(Libs.slf4j_api)
    implementation(Libs.slf4j_jdk14)
    implementation(Libs.koin_core)
    implementation(Libs.httpcore)

    // JAX-B dependencies for JDK 9+
    implementation(Libs.jaxb_api)
    implementation(Libs.jaxb_core)
    implementation(Libs.jaxb_impl)
    implementation(Libs.activation)

    testImplementation(Libs.koin_test)
    testImplementation(Libs.kotlin_test)
    testImplementation(Libs.kotlintest_runner_junit5)
    testImplementation(Libs.testng)
    testImplementation(Libs.mockito_kotlin)
}

tasks {

    val deployPrd by creating(Exec::class) {
        commandLine = listOf("serverless", "deploy", "--stage=prd")
        dependsOn("shadowJar")
    }

    val deployDev by creating(Exec::class) {
        commandLine = listOf("serverless", "deploy", "--stage=dev")
        dependsOn("shadowJar")
    }

    val deploy by creating {
        dependsOn(deployDev)
    }

    test {
        useTestNG()
    }

    val buildZip by creating(Zip::class) {
        from(compileKotlin)
        from(processResources)
        into("lib") {
            from(configurations.runtimeClasspath)
        }
    }

    build {
        dependsOn(buildZip)
    }

    compileKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}