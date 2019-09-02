package com.makemake

import org.codehaus.groovy.runtime.DefaultGroovyMethods.leftShift
import org.gradle.api.Plugin
import org.gradle.api.Project

import templates.GradlePluginTemplatesPlugin

import java.io.File
import java.io.InputStream
import java.net.URL
import java.net.URLConnection

class MakeMakekotlin : Plugin<Project> {

    private val loader: ClassLoader = this::class.java.classLoader

    // issues -> blank files are seen like a directory, change check from number of bytes available from

    private var offset = ""

    private fun occurrences(str: String, ch: Char): Int{

        var frequency = 0
        for (i in 0 until str.length) {
            if (ch == str[i]) {
                ++frequency
            }
        }
        return frequency

    }

    private fun copyFile(from: String, to: String) {

        var resource: URL? = loader.getResource(from) // find the source with the given name
        try {

            var inputURL = resource
            var conn: URLConnection? = inputURL?.openConnection()
            var inputStream: InputStream? = conn?.getInputStream()

            var output = File(to)
            if ( output.exists() ) {
                output.delete()
            }

            var fileName = output.path.split("/")[output.path.split("/").size-1]


            val occSlash = occurrences(output.toString(), '/')

            for(i in 0 until occSlash){
                print("     ")
            }

            if(inputStream?.available() == 0){
                output.mkdirs()

                if(occSlash == 0){
                    print("     ")
                } else {
                    print("+--- ")
                }

                println(fileName)
            } else {
                output.parentFile.mkdirs()
                leftShift(output, inputStream) // modify
                println("+ " + fileName)
                Runtime.getRuntime().exec("chmod 777 " + output)
            }

            Runtime.getRuntime().exec("chown 1000:1000 " + output)

        } catch (e: Exception) {
            println(e.message)
        }
    }

    override fun apply(project: Project) {
        project.task("create"){
            println("___  ___      _       ___  ___      _        \n" +
                    "|  \\/  |     | |      |  \\/  |     | |       \n" +
                    "| .  . | __ _| | _____| .  . | __ _| | _____ \n" +
                    "| |\\/| |/ _` | |/ / _ \\ |\\/| |/ _` | |/ / _ \\\n" +
                    "| |  | | (_| |   <  __/ |  | | (_| |   <  __/\n" +
                    "\\_|  |_/\\__,_|_|\\_\\___\\_|  |_/\\__,_|_|\\_\\___|\n" +
                    "                                             \n" +
                    "                                             ")

            var projectName : String? = null // nullable String

            while(projectName == null){
                println("Project Name: ")
                projectName = readLine()
            }


            val resourcePath: String = System.getProperty("user.dir")+"/buildSrc/build/resources/main/templates"

            File(resourcePath).walkTopDown().forEach {
                val iterPath = it.path.replace(resourcePath, "")
                copyFile("templates$iterPath", "$projectName$iterPath")
            }

            println("\n\n\nproject structure created with success, you should be happy now.\n ... oh now i am very tired ...\n- see you next time -")

        }
    }
}