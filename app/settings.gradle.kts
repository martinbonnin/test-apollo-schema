pluginManagement {
  listOf(repositories, dependencyResolutionManagement.repositories).forEach {
    it.apply {
      mavenCentral()
      google()
      maven("../my-repository")
    }
  }
}

include("featureA", "featureB", "common-models")