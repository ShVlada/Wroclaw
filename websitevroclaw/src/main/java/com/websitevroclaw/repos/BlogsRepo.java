package com.websitevroclaw.repos;

import com.websitevroclaw.entity.Blog;
import org.springframework.data.repository.CrudRepository;

public interface BlogsRepo extends CrudRepository<Blog, Long> {}
