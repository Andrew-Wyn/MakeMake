package com.makemake;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class MakeMakePlugin implements Plugin<Project> {
    public void apply(Project project) {
        project.getTasks().create("hello", MakeMake.class, (task) -> {
            task.setMessage("Hello");
            task.setRecipient("World");
        });
    }
}
