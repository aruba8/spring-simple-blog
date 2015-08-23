package com.blog.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tag")
public class Tag {

    @Id
    @Column(name = "name", unique = true)
    private String name;
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.REFRESH,
            mappedBy = "tags"
    )
    private Set<Article> articles;

    public Tag(String name){
        this.name = name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

    public Tag(){}


    public String getName() {
        return name;
    }

    public Set<Article> getArticles() {
        return articles;
    }


    public String toString(){
        return "Tag [name="+name+"]";
    }

    @Override
    public int hashCode() {
        return 37 * name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Tag)){
            return false;
        }

        Tag tag = (Tag) obj;
        return tag.getName().equals(this.getName());
    }
}
