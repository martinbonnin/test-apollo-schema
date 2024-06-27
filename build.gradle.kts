plugins {
  id("org.jetbrains.kotlin.multiplatform").version("2.0.0")
}

kotlin {
  jvm()
  
  sourceSets {
    getByName("jvmTest") {
      dependencies {
        implementation(kotlin("test"))
      }
    }
  }
}