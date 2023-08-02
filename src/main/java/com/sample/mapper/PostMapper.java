package com.sample.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sample.dto.PostDetailDto;
import com.sample.dto.PostListDto;
import com.sample.vo.AttachedFile;
import com.sample.vo.Post;
import com.sample.vo.Tag;

@Mapper
public interface PostMapper {
	
	// List<PostListDto> getPosts();
	
	// void deletePosts(@Param("id") String userId, @Param("nums") List<Integer> numbers); 
	// Mybatis에서는 @Param을 사용하면 Mapper에 값을 두 개 줄 수 있다. 맵을 사용해도 되긴 함.
	void insertPost(@Param("id") String userId, @Param("post") Post post);  // @Param을 사용할 경우, 양쪽 모두 @Param을 써야 한다!

	int getTotalRows();

	List<PostListDto> getPosts(Map<String, Object> param);
	
	Post getPostByNo(int postNo);
	void updatePost(Post post);
	
	PostDetailDto getPostDetailByNo(int postNo);
	
	void insertAttachedFile(AttachedFile attachedFile);
	void insertTag(Tag tag);
	
	List<AttachedFile> getAttachedFilesByPostNo(int postNo);
	List<Tag> getTagsByPostNo(int postNo);

}

