package com.Ekart;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "database_sequences")
public class DatabaseSequence {

	@Id
	private String pid;

	private long seq;

	public String getId() {
		return pid;
	}

	public void setId(String pid) {
		this.pid = pid;
	}

	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}

}
