import io.pivotal.pal.tracker.gradlebuild.DependenciesGraphPlugin

buildscript {
        ext {
        springBootVersion = "2.2.2.RELEASE"
        springVersion = "5.0.9.RELEASE"
        mysqlVersion = "8.0.13"
        jacksonVersion = "2.9.7"
        slf4jVersion = "1.7.25"
        mockitoVersion = "2.23.0"
        assertJVersion = "3.11.1"
        hikariVersion = "3.1.0"
        logbackVersion = "1.2.3"
        junitVersion = "4.12"
        okhttpVersion = "3.12.0"
        jsonPathVersion = "2.4.0"
        springCloudVersion = "Hoxton.RELEASE"
        springCloudServicesClientLibrariesVersion = "2.2.1.RELEASE"
        springCloudCommons = "2.0.0.RELEASE"
        }

        repositories {
        mavenCentral()
        jcenter()
        }

        dependencies {
        classpath "org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion"
        classpath "mysql:mysql-connector-java:$mysqlVersion"
        }
        }

        apply plugin: DependenciesGraphPlugin

        subprojects {
        group "io.pivotal.pal.tracker"

        apply plugin: "java"
        defaultTasks "clean", "build"

        repositories {
        mavenCentral()
        jcenter()
        }

        dependencies {
        compile "com.fasterxml.jackson.core:jackson-core:$jacksonVersion"
        compile "com.fasterxml.jackson.core:jackson-databind:$jacksonVersion"
        compile "com.fasterxml.jackson.core:jackson-annotations:$jacksonVersion"
        compile "org.slf4j:slf4j-api:$slf4jVersion"

        testCompile "junit:junit:$junitVersion"
        testCompile "org.mockito:mockito-core:$mockitoVersion"
        testCompile "org.assertj:assertj-core:$assertJVersion"
        }

        test {
        testLogging {
        exceptionFormat = 'full'
        }
        }
        }