package io.github.lucasbxavier.vehiclesmaintenance.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.junit.jupiter.api.Test;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class SwaggerConfigTest {
    private final SwaggerConfig config = new SwaggerConfig();

    @Test
    void shouldCreateOpenApiWithCorrectMetadata() {
        OpenAPI openAPI = config.customOpenAPI();
        Info info = openAPI.getInfo();

        assertThat(info).isNotNull();
        assertThat(info.getTitle()).isEqualTo("API de Manutenção de Veículos");
        assertThat(info.getVersion()).isEqualTo("v1");
        assertThat(info.getDescription()).isEqualTo("Documentação da API de Manutenção de Veículos");
    }

    @Test
    void shouldLogSwaggerUrlOnApplicationStartup() {
        Environment environment = mock(Environment.class);
        ApplicationReadyEvent event = mock(ApplicationReadyEvent.class);

        when(environment.getProperty("server.port", "8080")).thenReturn("8081");
        when(environment.getProperty("server.servlet.context-path", "")).thenReturn("/api");
        when(environment.getProperty("springdoc.swagger-ui.path", "/swagger-ui.html"))
                .thenReturn("/swagger-ui/index.html");

        ApplicationListener<ApplicationReadyEvent> listener =
                config.swaggerStartupLogger(environment);

        listener.onApplicationEvent(event);

        verify(environment).getProperty("server.port", "8080");
        verify(environment).getProperty("server.servlet.context-path", "");
        verify(environment).getProperty("springdoc.swagger-ui.path", "/swagger-ui.html");
    }

}