package com.example.thermometer_test_server.repo;

import com.example.thermometer_test_server.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Long> {
}
