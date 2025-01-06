package com.juliusyolo.yoho.configuration;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.RetrievalAugmentationAdvisor;
import org.springframework.ai.rag.generation.augmentation.ContextualQueryAugmenter;
import org.springframework.ai.rag.preretrieval.query.expansion.MultiQueryExpander;
import org.springframework.ai.rag.preretrieval.query.transformation.TranslationQueryTransformer;
import org.springframework.ai.rag.retrieval.search.VectorStoreDocumentRetriever;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class YohoConfiguration {


    @Bean
    public TranslationQueryTransformer translationQueryTransformer(ChatClient.Builder chatClientBuilder) {
        return TranslationQueryTransformer.builder().chatClientBuilder(chatClientBuilder).targetLanguage("english").build();
    }

    @Bean
    public MultiQueryExpander multiQueryExpander(ChatClient.Builder chatClientBuilder) {
        return MultiQueryExpander.builder()
                .chatClientBuilder(chatClientBuilder)
                .numberOfQueries(3)
                .build();
    }

    @Bean
    public RetrievalAugmentationAdvisor retrievalAugmentationAdvisor(TranslationQueryTransformer translationQueryTransformer, MultiQueryExpander multiQueryExpander, VectorStore vectorStore) {
        return RetrievalAugmentationAdvisor.builder()
                .queryTransformers(translationQueryTransformer)
                .queryExpander(multiQueryExpander)
                .documentRetriever(VectorStoreDocumentRetriever.builder()
                        .similarityThreshold(0.50)
                        .vectorStore(vectorStore)
                        .build())
                .queryAugmenter(ContextualQueryAugmenter.builder()
                        .allowEmptyContext(true)
                        .build())
                .build();
    }
}
