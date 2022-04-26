package ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import catch_db.CatchBlogLocal;
import entity.BlogEntity;
import entity.MoblEntity;
import sevice.BlogServiceLocal;
import sevice.SellerServiceLocal;

@Named
@ViewScoped
public class PassagePage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PassagePage() {
		// TODO Auto-generated constructor stub
	}
	
//	@Inject
//	private CatchBlogLocal catchBlogLocal;
	@Inject
	private BlogServiceLocal blogServiceLocal;
	@Inject
	private SellerServiceLocal sellerServiceLocal;
	
	private BlogEntity blogEntity=new BlogEntity();

	public BlogEntity getBlogEntity() {
		return blogEntity;
	}


	public void setBlogEntity(BlogEntity blogEntity) {
		this.blogEntity = blogEntity;
	}
	
	public String findBlogHeadById(int id) {
		try {
		//for (BlogEntity blogEntity2 : catchBlogLocal.getBlogEntities()) {
		//	if(blogEntity2.getId()==id)
			this.blogEntity=blogServiceLocal.findBlogById(id);
		//}
		return this.convertBlogHead(blogEntity);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		}
	
	public String convertBlogHead(BlogEntity blogEntity) throws Exception{
            try {
			File file = new File("/home/wildfly/wildfly-18.0.1.Final/fimg/" + blogEntity.getBlogHead() + ".txt");
			byte[] bytesArray = new byte[(int) file.length()];
			FileInputStream fis = new FileInputStream(file);
			fis.read(bytesArray);
			fis.close();
			String string=new String(bytesArray);
			return string;
            }catch (Exception e) {
				throw new Exception("file not find");
			}
	}
	
	public String findBlogMain() {
		try {

		return this.convertBlogMain();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		}
	
	
	public String convertBlogMain() throws Exception{
        try {
		File file = new File("/home/wildfly/wildfly-18.0.1.Final/fimg/" + blogEntity.getBlogMain() + ".txt");
		byte[] bytesArray = new byte[(int) file.length()];
		FileInputStream fis = new FileInputStream(file);
		fis.read(bytesArray);
		fis.close();
		String string=new String(bytesArray);
		return string;
        }catch (Exception e) {
			throw new Exception("file not find");
		}
}
	
	public List<MoblEntity> findSellerByMojtame(){
		try {
			return sellerServiceLocal.findSellersByMojtame(this.blogEntity.getBlogName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	

}
