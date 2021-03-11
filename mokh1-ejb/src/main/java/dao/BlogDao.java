package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.BlogEntity;
import entity.MoblEntity;

/**
 * Session Bean implementation class BlogDao
 */
@Stateless
public class BlogDao implements BlogDaoLocal {

    /**
     * Default constructor. 
     */
    public BlogDao() {
        // TODO Auto-generated constructor stub
    }
    
    
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    
    @Override
    public void insertBlog(BlogEntity blogEntity){
    	entityManager.persist(blogEntity);
    }
    
    
    
    
    @Override
    @SuppressWarnings("unchecked")
	public List<BlogEntity> findAllBlog(){
    	return entityManager.createNamedQuery("BlogEntity.findAll").getResultList();
    }
    
    
    @Override
    public BlogEntity findBlogById(long id) throws Exception{
    	try {
    	return (BlogEntity) entityManager.createNamedQuery("BlogEntity.findById").setParameter("v_id", id).getSingleResult();
    }catch(Exception exception) {
    	throw new Exception();
    }
    }
    
    @Override
    public List<BlogEntity> findBlogByName(String blogText) throws Exception{
    	try {
    	return entityManager.createNamedQuery("BlogEntity.findByLike").setParameter("v_blogName","%" +  blogText + "%").getResultList();
    }catch(Exception exception) {
    	throw new Exception();
    }
    }
    
	@Override
	@SuppressWarnings("unchecked")
	public List<BlogEntity> findAllNewsMode(String mode) {
		return entityManager.createNamedQuery("BlogEntity.findByNewsMode").setParameter("v_newsMode", mode).getResultList();
	}
    
    
    @Override
    public void updateBlog(BlogEntity blogEntity) throws Exception{
    	try {
    	entityManager.merge(blogEntity);
    	}catch (Exception e) {
			throw new Exception();
		}
    }
    
    @Override
    public void deleteBlog(BlogEntity blogEntity){
    	BlogEntity blogEntity2=new BlogEntity();
    	blogEntity2=entityManager.merge(blogEntity);
    	entityManager.remove(blogEntity2);
    }
    

}
