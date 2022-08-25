package com.cg.checkin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Checkin_id")
public class CheckInId {
	
	    @Id
		String id;
		int checkInId;

		public CheckInId() {
		}

		public CheckInId(String id, int checkInId) {
			this.id = id;
			this.checkInId = checkInId;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public int getCheckInId() {
			return checkInId;
		}

		public void setSeq(int checkInId) {
			this.checkInId = checkInId;
		}
	}

