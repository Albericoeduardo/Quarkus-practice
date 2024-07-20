package org.acme;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import jakarta.ws.rs.core.Application;

@OpenAPIDefinition(
    info = @Info(
        title = "Movie APIs",
        description = "Movie Application",
        version = "1.0.1",
        license = @License(
            name = "MIT",
            url = "http://localhost:8080"

        )
    ),
    tags = {
        @Tag(
            name = "Movies",
            description = "Movies"
        )
    }
)
public class MovieApplication extends Application {
    
}
