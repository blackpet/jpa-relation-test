package com.example.api.content;

import com.example.api.content.domain.Content;
import org.springframework.data.repository.ListCrudRepository;

public interface ContentRepository extends ListCrudRepository<Content, Long> {
}
