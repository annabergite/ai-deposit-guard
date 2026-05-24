package com.annab.ai.aidepositguard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ai.autoconfigure.ollama.OllamaAutoConfiguration;

// Temporarily exclude the Ollama auto-configuration which references
// Spring Boot's RestClientAutoConfiguration that isn't present with the
// current Spring AI / Spring Boot combination. This avoids the startup
// failure while you choose a proper dependency resolution (see README
// or project notes for long-term fixes).
@SpringBootApplication(exclude = {OllamaAutoConfiguration.class})
public class AiDepositGuardApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiDepositGuardApplication.class, args);
    }

}
