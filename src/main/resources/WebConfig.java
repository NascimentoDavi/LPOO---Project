import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Cross Origin Resources Sharing - It allows my spring boot application backend to interact with my angular front-end,
// particularly when it's running on a different domain or port (http://localhost:4200)

// WebMvcConfigurer is a Interface that allows one to customize Spring's default web configuration.

@Configuration // Annottion that Marks the class as a configuration class
public class WebConfig implements WebMvcConfigurer {

    // CORS (Cross Origin Resources Sharing) is a security feature implemented by browsers that prevents websites from making
    // requests to a different domain than the one that served the web page. In this case, I allowed port 4200, thats where Angular is running, to access the API.

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Allow all endpoints
                .allowedOrigins("http://localhost:4200") // Allow the Angular app to access the API
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow specific HTTP methods
                .allowedHeaders("*"); // Allow all headers (you can restrict to specific headers if needed)
    }
}
