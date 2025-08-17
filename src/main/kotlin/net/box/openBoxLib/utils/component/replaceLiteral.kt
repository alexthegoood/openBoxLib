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
import net.kyori.adventure.text.ComponentLike

/**
 * Replaces all occurrences of a literal string within this component.
 *
 * @param literal The literal string to be replaced.
 * @param replace The replacement string.
 * @return A new component with all occurrences of the literal string replaced.
 */
fun Component.replaceLiteral(
    literal: String,
    replace: String
) : Component {
    return replaceText { builder ->
        builder.matchLiteral(literal).replacement(replace)
    }
}

/**
 * Replaces all occurrences of a literal string within this component.
 *
 * @param literal The literal string to be replaced.
 * @param replace The replacement component.
 * @return A new component with all occurrences of the literal string replaced.
 */
fun Component.replaceLiteral(
    literal: String,
    replace: ComponentLike
) : Component {
    return replaceText { builder ->
        builder.matchLiteral(literal).replacement(replace)
    }
}
