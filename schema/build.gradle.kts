plugins {
  id("org.jetbrains.kotlin.jvm").version("2.0.0")
  id("com.apollographql.apollo3").version("3.8.4")
  id("maven-publish")
}

dependencies {
  implementation("com.apollographql.apollo3:apollo-runtime")
}

group = "com.example"
version = "0.0.1"

publishing {
  publications {
    create("default", MavenPublication::class.java) {
      from(components["java"])
    }
  }
  repositories {
    maven {
      name = "myRepository"
      url = uri("../my-repository")
    }
  }
}

apollo {
  service("service") {
    packageName.set("com.example.schema")
    generateApolloMetadata.set(true)
    alwaysGenerateTypesMatching.set(listOf("Query", "Shared"))
  }
}

abstract class ComponentFactoryHolder {
  @get:Inject
  abstract val softwareComponentFactory: SoftwareComponentFactory
}

val holder = project.objects.newInstance(ComponentFactoryHolder::class.java)

val adhocComponentWithVariants = holder.softwareComponentFactory.adhoc("apollo-schema")

adhocComponentWithVariants.addVariantsFromConfiguration(configurations.getByName("apolloServiceSchemaProducer")) {}

publishing.publications.create("apollo-schema", MavenPublication::class.java) {
  from(adhocComponentWithVariants)
  artifactId = "${project.name}-apollo-schema"
}
