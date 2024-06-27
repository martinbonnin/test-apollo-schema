plugins {
  id("org.jetbrains.kotlin.jvm")
  id("com.apollographql.apollo3.external")
  id("maven-publish")
}

dependencies {
  implementation("com.apollographql.apollo3:apollo-runtime")
  implementation(project(":common-models"))
  apolloMetadata(project(":common-models"))
  apolloSchema("com.example:schema-apollo-schema:0.0.1")
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
    generateApolloMetadata.set(true)
  }
}