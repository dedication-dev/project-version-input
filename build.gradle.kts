// This task is up-to-date even when the project version changes
// i.e. using the env var ORG_GRADLE_PROJECT_version=2
tasks.register<Copy>("copyMessageBroken") {
    group = "test"
    description = "the up-to-date check for this task is broken"

    from(layout.projectDirectory.file("important-message.txt"))
    expand("PROJECT_VERSION" to project.version)
    into(layout.buildDirectory.dir("broken-message"))
}

// Declaring the project.version explicitly as an input works,
// but leaves me with an odd feeling
tasks.register<Copy>("copyMessageWorking") {
    group = "test"
    description = "the up-to-date check for this task is broken"

    inputs.property("project version", project.version)

    from(layout.projectDirectory.file("important-message.txt"))
    expand("PROJECT_VERSION" to project.version)
    into(layout.buildDirectory.dir("working-message"))
}
