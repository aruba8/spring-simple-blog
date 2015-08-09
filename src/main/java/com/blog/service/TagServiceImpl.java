package com.blog.service;

import com.blog.model.Tag;
import com.blog.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public void saveTag(Tag tag) {
        tagRepository.save(tag);
    }

    @Override
    public void saveTags(Set<Tag> tags) {
        tagRepository.saveAll(tags);
    }
}
