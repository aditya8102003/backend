package com.cg.checkin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.checkin.model.CheckInRecord;

public interface CheckInRepo extends MongoRepository<CheckInRecord, Long> {

}
