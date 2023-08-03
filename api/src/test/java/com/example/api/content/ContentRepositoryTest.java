package com.example.api.content;

import com.example.api.content.domain.Content;
import com.example.api.content.domain.ContentKeyword;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ContentRepositoryTest {
  @Autowired
  ContentRepository repository;


  @Test
  void createContentAndKeywordTest() {
    //given
    Content c = new Content();
    c.setContNm("test");

    c.addKeyword("a");
    c.addKeyword("b");
    c.addKeyword("c");
    c.addKeyword("d");
    repository.save(c);

    //when
    List<Content> all = repository.findAll();

    //then
    assertEquals(all.size(), 1);
    Content c1 = all.get(0);
    assertEquals(c1.getContentKeyword().size(), 4);
  }
}
