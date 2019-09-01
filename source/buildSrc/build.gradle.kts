/*repositories {
    mavenCentral()
    maven {
        url 'http://dl.bintray.com/cjstehno/public'
    }
}*/

buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", version = "1.3.21"))
        classpath("org.jetbrains.kotlin:kotlin-stdlib")
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



//configurations {
//    releaseJars
//}

dependencies {

    compile("gradle-templates:gradle-templates:1.5")
    compile(gradleApi())
    compile("org.jetbrains.kotlin:kotlin-stdlib")

    testCompile(gradleTestKit())
    testCompile("junit:junit:4.12")
}
/*
dependencies {
    compile 'gradle-templates:gradle-templates:1.5'
    compile gradleApi()

    testCompile gradleTestKit()
    testCompile group: 'junit', name: 'junit', version: '4.12'

    //releaseJars 'gradle-templates:gradle-templates:1.4.1'
    //configurations.compile.extendsFrom(configurations.releaseJars)
}*/

//create a single Jar with all dependencies
//task fatJar(type: Jar) {
//    baseName = project.name + '-all'
//    from { configurations.compile.collect { it.isDirectory() ? it : zipTree(it) } }
//    with jar
//}