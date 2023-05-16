package edu.neu.pickmeup.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Orders {

    @Id
    private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
    
    
}
