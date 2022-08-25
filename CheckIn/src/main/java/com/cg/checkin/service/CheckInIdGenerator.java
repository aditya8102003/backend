package com.cg.checkin.service;

import java.util.Objects;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.cg.checkin.model.CheckInId;

@Service
	public class CheckInIdGenerator {

		@Autowired
		private MongoOperations mongoOperations;

		public int getCheckInId(String CheckInIdName) {
			
			// get checkin id
			
			Query query = new Query(Criteria.where("id").is(CheckInIdName));
			
			// update the checkin id
			
			Update update = new Update().inc("checkInId", 1);
			
			// modify in document
			
			CheckInId counter = mongoOperations.findAndModify(query, update, options().returnNew(true).upsert(true),
					CheckInId.class);

			return !Objects.isNull(counter) ? counter.getCheckInId() : 1;
		}
	}