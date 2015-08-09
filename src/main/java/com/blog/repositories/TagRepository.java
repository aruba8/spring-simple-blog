package com.blog.repositories;

import com.blog.model.Tag;

import java.util.Set;

public interface TagRepository {
    void saveAll(Set<Tag> tags);
    void save(Tag tag);
}
