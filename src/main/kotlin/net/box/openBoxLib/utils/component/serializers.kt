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

package net.box.openBoxLib.utils.component

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.serializer.ComponentSerializer
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer

/**
 * Serializes this [Component] into a [String] using the provided serializer.
 *
 * @param serializer the [ComponentSerializer] to use for serialization, defaults to [PlainTextComponentSerializer].
 * @return the serialized [String] representation of the component.
 */
fun Component.serialize(
    serializer: ComponentSerializer<Component, *, String> = PlainTextComponentSerializer.plainText()
): String = serializer.serialize(this)

/**
 * Deserializes this [String] into a [Component] using the provided serializer.
 *
 * @param serializer the [ComponentSerializer] to use for deserialization, defaults to [PlainTextComponentSerializer].
 * @return the deserialized component.
 */
fun String.deserialize(
    serializer: ComponentSerializer<Component, *, String> = PlainTextComponentSerializer.plainText()
) : Component = serializer.deserialize(this)
