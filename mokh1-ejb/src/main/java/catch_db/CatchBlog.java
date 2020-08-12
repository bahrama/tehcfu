package catch_db;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.ejb.AccessTimeout;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import entity.BlogEntity;
import sevice.BlogServiceLocal;

/**
 * Session Bean implementation class CatchNews
 */
@Singleton
@Startup
public class CatchBlog implements CatchBlogLocal {

    /**
     * Default constructor. 
     */
    public CatchBlog() {
        // TODO Auto-generated constructor stub
    }
    
    private List<BlogEntity> blogEntities=new ArrayList<>();
    
    @Inject
    private BlogServiceLocal blogServiceLocal;
    
    
    
    @Override
    public List<BlogEntity> getBlogEntities() {
		return blogEntities;
	}



    @PostConstruct
    public void init() {
    	this.blogEntities.addAll(blogServiceLocal.findAllBlog());
    }
    
    
	@Schedule(hour = "*", minute = "*/1", persistent = false)
	@AccessTimeout(value = 4, unit = TimeUnit.SECONDS)
	public void ejra() throws Exception {
	    this.blogEntities.clear();
	    this.blogEntities.addAll(blogServiceLocal.findAllBlog());
	}
	

}
