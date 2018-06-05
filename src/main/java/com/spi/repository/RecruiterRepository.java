package com.spi.repository;

import com.spi.model.Recruiter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecruiterRepository extends MongoRepository<Recruiter, String> {
}
