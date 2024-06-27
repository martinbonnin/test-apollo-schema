plugins {
  id("org.jetbrains.kotlin.jvm").version("2.0.0")
  id("com.apollographql.apollo3").version("3.8.4")
  id("maven-publish")
}

dependencies {
  implementation("com.apollographql.apollo3:apollo-runtime")
  implementation("com.example:schema:0.0.1")
  apolloMetadata("com.example:schema-apollo:0.0.1")
}

group = "com.example"
version = "0.0.1"

publishing {
  repositories {
    maven {
      name = "myRepository"
      url = uri("../my-repository")
    }
  }
}

apollo {
  service("service") {
    packageName.set("com.example.feature")
  }
}