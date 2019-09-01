package com.makemake

import org.gradle.api.Plugin
import org.gradle.api.Project

import templates.*
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.nio.file.FileSystems

class MakeMakekotlin : Plugin<Project> {
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

            var projectName : String? = null

            while(projectName == null)
                projectName = Template sPlugin.prompt("Project Name: ")

            println(projectName)

        }
    }
}