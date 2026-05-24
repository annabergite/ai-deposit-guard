package com.annab.ai.aidepositguard.config;

import org.springframework.ai.chroma.vectorstore.ChromaApi;
import org.springframework.ai.chroma.vectorstore.ChromaVectorStore;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChromaConfig {

    @Value("${spring.ai.chroma.client.base-url}")
    private String chromaBaseUrl;

    @Bean
    public ChromaApi chromaApi() {
        return new ChromaApi(chromaBaseUrl);
    }

    @Bean
    public ChromaVectorStore chromaVectorStore(ChromaApi chromaApi, EmbeddingModel embeddingModel) {
        return ChromaVectorStore.builder(chromaApi, embeddingModel)
                .initializeSchema(false)  // 禁用自动初始化，避免创建集合时的 metadata 问题
                .collectionName("deposit_guard_laws")
                .build();
    }
}
