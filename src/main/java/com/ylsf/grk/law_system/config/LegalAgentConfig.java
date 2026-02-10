package com.ylsf.grk.law_system.config;

import com.ylsf.grk.law_system.store.MongoChatMemoryStore;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.document.parser.apache.pdfbox.ApachePdfBoxDocumentParser;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LegalAgentConfig {
    @Resource
    private MongoChatMemoryStore mongoChatMemoryStore;

    @Bean
    public ChatMemoryProvider chatMemoryProviderLegal() {
        return memoryId -> MessageWindowChatMemory.builder()
                .id(memoryId)
                .maxMessages(20)
                .chatMemoryStore(mongoChatMemoryStore)
                .build();
    }

    @Bean
    ContentRetriever contentRetrieverLegal(){
        //创建一个Document对象，用于存储法律文件的内容
        Document document = FileSystemDocumentLoader.loadDocument("src/main/resources/legal/Constitution.pdf",new ApachePdfBoxDocumentParser());
        //创建一个EmbeddingStore对象，用于存储法律文件的嵌入向量
        InMemoryEmbeddingStore<TextSegment> embeddingStore = new InMemoryEmbeddingStore<>();
        //使用EmbeddingStoreIngestor对象将法律文件内容嵌入到EmbeddingStore对象中
        EmbeddingStoreIngestor.ingest(document,embeddingStore);
        //创建一个ContentRetriever对象，用于从EmbeddingStore对象中检索法律文件内容
        return EmbeddingStoreContentRetriever.from(embeddingStore);

    }
}
