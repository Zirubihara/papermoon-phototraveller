package com.zirubihara.phototraveller.phototraveller.Assembler;

import com.zirubihara.phototraveller.phototraveller.controller.PostController;
import com.zirubihara.phototraveller.phototraveller.model.Post;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PostModelAssembler implements RepresentationModelAssembler<Post, EntityModel<Post>> {


    @Override
    public EntityModel<Post> toModel(Post post) {
        EntityModel<Post> postModel = EntityModel.of(post,
                linkTo(methodOn(PostController.class).one(post.getPostId())).withSelfRel(),
                linkTo(methodOn(PostController.class).all()).withRel("posts"));

        return postModel;

    }
}
