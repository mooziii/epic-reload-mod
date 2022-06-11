plugins {
    kotlin("jvm") version "1.6.21"
    id("fabric-loom") version "0.12-SNAPSHOT"
    java
}

group = "me.obsilabor"
version = "1.1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    minecraft("com.mojang:minecraft:1.19")
    mappings("net.fabricmc:yarn:1.19+build.2")
    modImplementation("net.fabricmc:fabric-loader:0.14.6")
    modImplementation("net.fabricmc:fabric-language-kotlin:1.7.4+kotlin.1.6.21")
}
