package com.bisenessmap.app.database.Repositories;

import com.bisenessmap.app.database.entity.BisenessType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BisenessTypeRepository extends MongoRepository<BisenessType, String> {
}
