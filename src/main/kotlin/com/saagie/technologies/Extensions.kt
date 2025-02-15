/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2019-2021.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.saagie.technologies

import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

fun File.checkYamlExtension() =
    this.path
        .replace(".yaml", "")
        .replace(".yml", "")
        .let { path ->
            when {
                Files.exists(Paths.get("$path.yaml")) -> Paths.get("$path.yaml").toFile()
                Files.exists(Paths.get("$path.yml")) -> Paths.get("$path.yml").toFile()
                else -> this
            }
        }

fun Path.checkYamlExtension() = this.toFile().checkYamlExtension().toPath()

fun String.checkYamlExtension() = Paths.get(this).checkYamlExtension().toUri().path
