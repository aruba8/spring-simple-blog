package com.blog.service;

import com.blog.model.Tag;

import java.util.Set;

public interface TagService {
    void saveTag(Tag tag);
    void saveTags(Set<Tag> tags);
}
