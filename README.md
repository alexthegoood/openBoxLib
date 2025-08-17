### OpenBoxLib

A compact Kotlin utility library for Minecraft plugin development, providing helpful extensions for Bukkit/Spigot and Adventure APIs. This library is specifically designed to work with **PaperMC** and its forks.

### Features

- **Listener Registration**: A simple one-line function to register one or more listeners.
- **Adventure Component Utils**: Extension functions for convenient serialization/deserialization and text replacement within Adventure `Component`s.

---

### Installation

Add the repository and dependency to your `build.gradle.kts`:

```kotlin
repositories {
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("com.github.alexthegoood:openBoxLib:{version}")
}
```

***Note:** Replace `{version}` with the latest version.*

---

### Usage Examples

#### Registering Listeners

```kotlin
class ExamplePlugin : JavaPlugin() {
    override fun onEnable() {
        registerListeners(
            PlayerJoinListener(),
            BlockBreakListener()
        )
    }
}

class PlayerJoinListener : Listener {
    // Listener implementation
}

class BlockBreakListener : Listener {
    // Listener implementation
}
```

#### Working with Components

```kotlin
// Serialize a component to a string
val serializedString: String = text("Hello World").serialize(
    // any ComponentSerializer
    // default PlainTextComponentSerializer.plainText()
) // return string "Hello World"

// Deserialize a string to a component
val deserializedComponent: Component = "Hello World".deserialize(
    // any ComponentSerializer
    // default PlainTextComponentSerializer.plainText()
) // return component "Hello World"

// Replace a literal string within a component
val replacedLiteral: Component = "Hello World".replaceLiteral(
    "World", // String only
    "Kitty" // String or ComponentLike
) // return component "Hello Kitty"

// Replace text using a regex pattern or String
val replacedPattern: Component = "Hello World".replacePattern(
    "Hello", // String or Pattern
    "Hi" // String or ComponentLike
) // return component "Hi World"
```
