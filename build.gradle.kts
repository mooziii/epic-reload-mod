plugins {
    kotlin("jvm") version "1.6.10"
    id("fabric-loom") version "0.12-SNAPSHOT"
    java
}

group = "me.obsilabor"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    minecraft("com.mojang:minecraft:1.18.2")
    mappings("net.fabricmc:yarn:1.18.2+build.2")
    modImplementation("net.fabricmc:fabric-loader:0.13.3")
    modImplementation("net.fabricmc:fabric-language-kotlin:1.7.1+kotlin.1.6.10")
}
