/*
 * Copyright 2025 alexthegoood
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.shadow)
    alias(libs.plugins.paper.yaml)
    `maven-publish`
}

repositories { maven("https://repo.papermc.io/repository/maven-public/") }
dependencies { compileOnly(libs.paper) }

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
    shadowJar { archiveClassifier = null }
    test { useJUnitPlatform() }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = libs.boxlib.get().group
            artifactId = libs.boxlib.get().name
            version = libs.boxlib.get().version
            from(components["shadow"])
        }
    }
}

paperPluginYaml {
    main = "${libs.boxlib.get().group}.OpenBoxLib"
    name = libs.boxlib.get().name
    author = "AlexTheGoood"
    apiVersion = libs.versions.paper.api
    version = libs.boxlib.get().version
}
