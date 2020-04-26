rootProject.name = "server"

include("domain")
include("interaction")
include("spring-boot")
include("primary-adapter:rest:spring-web-mvc")
include("primary-adapter:graphql:graphql-java")
include("secondary-adapter:database:spring-data-jpa")
