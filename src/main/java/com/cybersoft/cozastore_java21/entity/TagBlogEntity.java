package com.cybersoft.cozastore_java21.entity;


import com.cybersoft.cozastore_java21.entity.ids.TagBlogIds;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "tag_blog")
public class TagBlogEntity {

    @EmbeddedId
    private TagBlogIds ids;

    @ManyToOne
    @JoinColumn(name = "tag_id", insertable = false,updatable = false)
    private TagEntity tag;

    @ManyToOne
    @JoinColumn(name = "blog_id", insertable = false,updatable = false)
    private BlogEntity blog;

    public TagBlogIds getIds() {
        return ids;
    }

    public void setIds(TagBlogIds ids) {
        this.ids = ids;
    }

    public TagEntity getTag() {
        return tag;
    }

    public void setTag(TagEntity tag) {
        this.tag = tag;
    }

    public BlogEntity getBlog() {
        return blog;
    }

    public void setBlog(BlogEntity blog) {
        this.blog = blog;
    }
}
