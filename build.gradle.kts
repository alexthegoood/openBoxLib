/*
 * Copyright 2025 alexthegoood. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the LICENSE file.
 */

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.gradle.kotlin.dsl.paperPluginYaml
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.shadow)
    alias(libs.plugins.resources)
    `maven-publish`
}

project.group = "net.box.openboxlib"
project.version = "1.1.0"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly(libs.paper)
    implementation(libs.kaml)
}

kotlin {
    jvmToolchain(21)
    compilerOptions {
        languageVersion = KotlinVersion.KOTLIN_2_2
        apiVersion = KotlinVersion.KOTLIN_2_2
    }
}

tasks {
    jar { enabled = false }
    build { dependsOn("shadowJar") }
    withType<ShadowJar> {
        archiveBaseName = rootProject.name
        archiveClassifier = null
        minimize()
    }
}

paperPluginYaml {
    main = "${project.group}.OpenBoxLib"
    author = "AlexTheGoood"
    apiVersion = libs.versions.paper.api
    setConventionsFromProjectMeta(project)
}

publishing.publications.create<MavenPublication>("maven") {
    groupId = project.group.toString()
    artifactId = project.name
    version = project.version.toString()
    from(components["shadow"])
}
