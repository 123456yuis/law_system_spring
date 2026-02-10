package com.ylsf.grk.law_system;


import dev.langchain4j.data.document.Document;


import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;


import dev.langchain4j.data.document.parser.apache.pdfbox.ApachePdfBoxDocumentParser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class RAGTest {
//    @Test
//    void contextLoads() {
//        Document document = FileSystemDocumentLoader.loadDocument("src/main/resources/legal/Constitution.pdf", new ApachePdfBoxDocumentParser());
//        System.out.println(document.metadata());
//        System.out.println(document.text());
//    }
}
