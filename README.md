# Select

A minimalist GUI library for Bukkit

## Usage

Build the source code:

```shell
git clone git@github.com:PhoenixUHC/Select
cd Select
gradle build
gradle publishToMavenLocal
```

Move `build/libs/select-*-all.jar` to your plugins directory

Add Select as a dependency to your plugin:

```kotlin
dependencies {
    implementation("io.phoenix.select:select-api:1.0-SNAPSHOT")
}
```

## Create a basic menu

Brief API demo

```kotlin
val menu = Select.getInstance().createMenu("My Menu", 27) // Create a menu with custom title and size
menu.elements[5] = object: Element() {
    var i = 1

    fun onDisplay(viewer: Player) {
        return ItemStack(Material.APPLE, i)
    }

    fun onClick(who: Player) {
        who.sendMessage("Hello, World!")
        i += 1
    }
}

menu.open(somePlayer)
```
