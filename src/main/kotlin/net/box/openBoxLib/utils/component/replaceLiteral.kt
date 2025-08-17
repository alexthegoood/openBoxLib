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
