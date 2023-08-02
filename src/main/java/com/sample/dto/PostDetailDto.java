package com.sample.dto;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;

import com.sample.vo.AttachedFile;
import com.sample.vo.Tag;

@Alias("PostDetailDto")
public class PostDetailDto {

	// 게시글 정보
	private int no;
	private String title;
	private String userId;
	private String userName;
	private String deleted;
	private int readCount;
	private int commentCount;
	private Date createdDate;
	private Date updatedDate;
	private String content;
	// 댓글 정보
	private List<PostCommentListDto> comments;
	// 첨부파일 정보
	private List<AttachedFile> attachedFiles;
	// 태그 정보
	private List<Tag> tags;
	
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
	
	public String getDeleted() {
		return deleted;
	}
	
	public void setDeleted(String deleted) {
		this.deleted = deleted;
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
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<PostCommentListDto> getComments() {
		return comments;
	}
	public void setComments(List<PostCommentListDto> comments) {
		this.comments = comments;
	}
	public List<AttachedFile> getAttachedFiles() {
		return attachedFiles;
	}
	public void setAttachedFiles(List<AttachedFile> attachedFiles) {
		this.attachedFiles = attachedFiles;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
	
	
}
