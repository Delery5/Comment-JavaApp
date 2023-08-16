package com.example.information.dto;

import java.util.Objects;

import lombok.Data;
@Data
public class CommentDTO {

	private long id;
	private String name;
	private String comment;
	
	public CommentDTO() {
		super();
	}
	
	public CommentDTO(long id, String name, String comment) {
		super();
		this.id = id;
		this.name = name;
		this.comment = comment;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "CommentDTO [id=" + id + ", name=" + name + ", comment=" + comment + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(comment, id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentDTO other = (CommentDTO) obj;
		return Objects.equals(comment, other.comment) && id == other.id && Objects.equals(name, other.name);
	}
	
	
}
