rootProject.name = "authorization-manager"

include("domain")
include("interaction")
include("spring-boot")
include("primary-adapter:rest:spring-web-mvc")
include("secondary-adapter:database:spring-data-jpa")
