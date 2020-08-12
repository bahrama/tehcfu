package catch_db;

import java.util.List;

import javax.ejb.Local;

import entity.BlogEntity;

@Local
public interface CatchBlogLocal {

	List<BlogEntity> getBlogEntities();

}
