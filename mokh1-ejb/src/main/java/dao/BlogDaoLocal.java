package dao;

import java.util.List;

import javax.ejb.Local;

import entity.BlogEntity;

@Local
public interface BlogDaoLocal {

	void insertBlog(BlogEntity blogEntity);

	List<BlogEntity> findAllBlog();

	BlogEntity findBlogById(long id) throws Exception;

	void updateBlog(BlogEntity blogEntity) throws Exception;

	void deleteBlog(BlogEntity blogEntity);

	List<BlogEntity> findBlogByName(String blogText) throws Exception;

}
