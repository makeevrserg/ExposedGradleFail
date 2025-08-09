import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.gradle.kotlin.dsl.named
import ru.astrainteractive.gradleplugin.property.extension.ModelPropertyValueExt.requireProjectInfo

plugins {
    application
    kotlin("jvm")
    kotlin("plugin.serialization")
    alias(libs.plugins.gradle.shadow)
}

dependencies {
    // Kotlin
    implementation(libs.bundles.exposed)
    implementation(libs.driver.h2)
}

application {
    mainClass.set("com.makeevrserg.exposedgradlefail.MainKt")
}

val shadowJar = tasks.named<ShadowJar>("shadowJar")
shadowJar.configure {
    mergeServiceFiles()
    dependsOn(tasks.named<ProcessResources>("processResources"))
    isReproducibleFileOrder = true
    archiveClassifier = null as String?
    archiveVersion.set(requireProjectInfo.versionString)
    archiveBaseName.set("${requireProjectInfo.name}-bukkit")
    destinationDirectory = rootDir.resolve("jars").also(File::mkdirs)
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    configurations = listOf(project.configurations.runtimeClasspath.get())
    relocationPrefix = requireProjectInfo.group
    enableRelocation = true
}
