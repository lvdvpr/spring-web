package com.sample.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("PostListDto")
public class PostListDto {

	private int no;
	private String title;
	private String userId;
	private String userName;
	private int readCount;
	private int commentCount;
	private Date createdDate;
	
	public PostListDto () {}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "PostListDto [no=" + no + ", title=" + title + ", userId=" + userId + ", userName=" + userName
				+ ", readCount=" + readCount + ", commentCount=" + commentCount + ", createdDate=" + createdDate
				+ ", getNo()=" + getNo() + ", getTitle()=" + getTitle() + ", getUserId()=" + getUserId()
				+ ", getUserName()=" + getUserName() + ", getReadCount()=" + getReadCount() + ", getCommentCount()="
				+ getCommentCount() + ", getCreatedDate()=" + getCreatedDate() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
