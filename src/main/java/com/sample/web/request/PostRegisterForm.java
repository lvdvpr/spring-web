package com.sample.web.request;

import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

@Alias("PostRegisterForm")
public class PostRegisterForm {

	private String title;
	private String content;
	private MultipartFile upfile;   // <input type="file" name="upfile">
	private List<String> tags;      // <input type="hidden" name="tags" value="스프링"> <input type="hidden" name="tags" value="자바">
	
	private String filename;        // <form> 태그에는 없는 필드임. 첨부파일 이름을 저장하기 위해서 생성한 변수임
	
	public PostRegisterForm() {}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public MultipartFile getUpfile() {
		return upfile;
	}

	public void setUpfile(MultipartFile upfile) {
		this.upfile = upfile;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Override
	public String toString() {
		return "PostRegisterForm [title=" + title + ", content=" + content + "]";
	}
}
