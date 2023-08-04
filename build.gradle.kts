import com.github.jengelman.gradle.plugins.shadow.ShadowPlugin
import org.cadixdev.gradle.licenser.LicenseExtension
import org.cadixdev.gradle.licenser.Licenser

plugins {
    id("java")
    id("java-library")
    id("maven-publish")
    id("signing")

    alias(libs.plugins.shadow)
    alias(libs.plugins.licenser)

    eclipse
    idea
}

fun commitHash(): String = try {
    val runtime = Runtime.getRuntime()
    val process = runtime.exec("git rev-parse --short HEAD")
    val out = process.inputStream
    out.bufferedReader().readText().trim()
} catch (ignored: Exception) {
    "unknown"
}

val commit: String? = commitHash()

group = "de.kuchengames.bukkit.gui"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://plugins.gradle.org/m2/") }
    maven { url = uri("https://jitpack.io") }

    mavenLocal()
}

subprojects {
    group = rootProject.group
    version = rootProject.version

    repositories {
        mavenCentral()
        maven { url = uri("https://repo.papermc.io/repository/maven-public/") }
        maven { url = uri("https://jitpack.io") }

        mavenLocal()
    }

    apply {
        plugin<JavaPlugin>()
        plugin<JavaLibraryPlugin>()
        plugin<MavenPublishPlugin>()
        plugin<ShadowPlugin>()
        plugin<Licenser>()
        plugin<SigningPlugin>()
        plugin<EclipsePlugin>()
        plugin<IdeaPlugin>()
    }

    tasks.compileJava.configure {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(17)
    }

    configurations.all {
        attributes.attribute(TargetJvmVersion.TARGET_JVM_VERSION_ATTRIBUTE, 17)
    }

    configure<LicenseExtension> {
        header(rootProject.file("HEADER.txt"))
        include("**/*.java")
        newLine.set(true)
    }

    java {
        toolchain.languageVersion.set(JavaLanguageVersion.of(17))
    }

    val javaComponent = components["java"] as AdhocComponentWithVariants
    javaComponent.withVariantsFromConfiguration(configurations["shadowRuntimeElements"]) {
        skip()
    }

    signing {
        if (!version.toString().endsWith("-SNAPSHOT")) {
            val signingKey: String? by project
            val signingPassword: String? by project
            useInMemoryPgpKeys(signingKey, signingPassword)
            signing.isRequired
            sign(publishing.publications)
        }
    }

    tasks {

        withType<ProcessResources> {
            filesMatching("*") {
                expand(project.properties)
            }
        }

        compileJava {
            options.compilerArgs.addAll(arrayOf("-Xmaxerrs", "1000"))
            options.compilerArgs.add("-Xlint:all")
            for (disabledLint in arrayOf("processing", "path", "fallthrough", "serial")) options.compilerArgs.add("-Xlint:$disabledLint")
            options.isDeprecation = true
            options.encoding = Charsets.UTF_8.name()
        }

        jar {
            this.archiveClassifier.set(null as String?)
            this.archiveFileName.set("${project.name}-${project.version}-${commit}.${this.archiveExtension.getOrElse("jar")}")
            this.destinationDirectory.set(file("$projectDir/../out/unshaded"))
        }

        processResources {
            filteringCharset = Charsets.UTF_8.name()
        }

        named("build") {
            dependsOn(named("shadowJar"))
        }
    }

}