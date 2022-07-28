plugins {
    kotlin("jvm") version "1.7.10"
    id("fabric-loom") version "0.12-SNAPSHOT"
    id("com.modrinth.minotaur") version "2.+"
    java
}

val mcVersion = "1.19.1"
group = "me.obsilabor"
version = "1.2.0+mc$mcVersion"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    minecraft("com.mojang:minecraft:$mcVersion")
    mappings("net.fabricmc:yarn:1.19.1+build.1")
    modImplementation("net.fabricmc:fabric-loader:0.14.8")
    modImplementation("net.fabricmc:fabric-language-kotlin:1.8.2+kotlin.1.7.10")
}

tasks {
    processResources {
        val properties = mapOf(
            "version" to project.version,
            "mcVersion" to mcVersion
        )
        inputs.properties(properties)
        filesMatching("fabric.mod.json") {
            expand(properties)
        }
    }
    compileJava {
        options.encoding = "UTF-8"
        options.release.set(17)
    }
    compileKotlin {
        kotlinOptions.jvmTarget = "17"
    }
}

modrinth {
    token.set(System.getenv("MODRINTH_TOKEN"))
    projectId.set("c09UniiT")
    versionNumber.set(project.version.toString())
    versionType.set("release")
    gameVersions.addAll(listOf(mcVersion))
    loaders.add("fabric")
    loaders.add("quilt")

    uploadFile.set(tasks.remapJar.get())
}