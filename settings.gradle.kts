/*
 * Copyright 2025 alexthegoood. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the LICENSE file.
 */

rootProject.name = "openBoxLib"

dependencyResolutionManagement {
    versionCatalogs.create("libs").from(files("libs.versions.toml"))
}
