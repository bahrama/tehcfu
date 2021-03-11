package sevice;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.BlogDaoLocal;
import entity.BlogEntity;

/**
 * Session Bean implementation class BlogService
 */
@Stateless
public class BlogService implements BlogServiceLocal {

    /**
     * Default constructor. 
     */
    public BlogService() {
        // TODO Auto-generated constructor stub
    }
    @Inject
    private BlogDaoLocal blogDaoLocal;

    
    @Override
    public void insertBlog(BlogEntity blogEntity){
    	blogDaoLocal.insertBlog(blogEntity);
    }
    
    
    
    
    @Override
    @SuppressWarnings("unchecked")
	public List<BlogEntity> findAllBlog(){
    	return blogDaoLocal.findAllBlog();
    }
    
    
    @Override
    public BlogEntity findBlogById(long id) throws Exception{
            return blogDaoLocal.findBlogById(id);
    }
    
    
    @Override
    public void updateBlog(BlogEntity blogEntity) throws Exception{
        blogDaoLocal.updateBlog(blogEntity);
    }
    
    @Override
    public void deleteBlog(BlogEntity blogEntity){
           blogDaoLocal.deleteBlog(blogEntity);
    }
    
    
    @Override
    public List<BlogEntity> findBlogByName(String blogText) throws Exception{
    	return blogDaoLocal.findBlogByName(blogText);
    }
    
	@Override
	public List<BlogEntity> findAllNewsMode(String mode) {
		return blogDaoLocal.findAllNewsMode(mode);
	}
}
