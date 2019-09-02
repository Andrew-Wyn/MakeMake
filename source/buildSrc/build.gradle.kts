buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", version = "1.3.21"))
    }
}

repositories {
    jcenter()
    mavenCentral()
    maven { setUrl("http://dl.bintray.com/cjstehno/public") }
}

plugins {
    kotlin("jvm") version "1.3.21"
}

dependencies {

    compile("gradle-templates:gradle-templates:1.5")
    compile(gradleApi())

    compile("org.jetbrains.kotlin:kotlin-stdlib")

    testCompile(gradleTestKit())
    testCompile("junit:junit:4.12")
}