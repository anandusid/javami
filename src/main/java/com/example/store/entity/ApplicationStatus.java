package com.example.store.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ApplicationStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDateTime time;

	private String status;

	// Getters and setters
	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(final LocalDateTime time) {
		this.time = time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(final String status) {
		this.status = status;
	}
}
