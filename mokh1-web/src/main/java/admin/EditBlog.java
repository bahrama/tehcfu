package admin;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.io.IOUtils;

import entity.BlogEntity;
import sevice.BlogServiceLocal;

@Named
@SessionScoped
public class EditBlog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EditBlog() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private BlogServiceLocal blogServiceLocal;
	
	private BlogEntity blogEntity;
	
	private List<BlogEntity> blogEntities=new ArrayList<BlogEntity>();
	
	@Size(max=2 , message="max is 2")
	private String blogType;
	@Size(max=200 , message="max is 200")
	private String blogName;

	private String blog;

	private String blogHead;
	private Part blogPic1;
	private boolean importantNews;
	private Date date;
	
	
	
	
	
	
	public String getBlogType() {
		return blogType;
	}



	public void setBlogType(String blogType) {
		this.blogType = blogType;
	}



	public String getBlogName() {
		return blogName;
	}



	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}



	public String getBlog() {
		return blog;
	}



	public void setBlog(String blog) {
		this.blog = blog;
	}



	public String getBlogHead() {
		return blogHead;
	}



	public void setBlogHead(String blogHead) {
		this.blogHead = blogHead;
	}



	public Part getBlogPic1() {
		return blogPic1;
	}



	public void setBlogPic1(Part blogPic1) {
		this.blogPic1 = blogPic1;
	}



	public boolean isImportantNews() {
		return importantNews;
	}



	public void setImportantNews(boolean importantNews) {
		this.importantNews = importantNews;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public List<BlogEntity> findAllBlog(){
		return blogServiceLocal.findAllBlog();
	}
	
	
	
	public BlogEntity getBlogEntity() {

		return blogEntity;
	}



	public void setBlogEntity(BlogEntity blogEntity) {
		
		this.blogEntity = blogEntity;
		//test();
	}
	
	



	public List<BlogEntity> getBlogEntities() {
		return blogEntities;
	}



	public void setBlogEntities(List<BlogEntity> blogEntities) {
		this.blogEntities = blogEntities;
	}
	
//	






	public void deleteBlogById(int id) {
		try {
			blogServiceLocal.deleteBlog(blogServiceLocal.findBlogById(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	
	
	public String findBlogHead() {
		String text = null;
		
        try (FileReader reader = new FileReader("/home/wildfly/BLOG/" + blogEntity.getBlogHead() +".txt");
                BufferedReader br = new BufferedReader(reader)) {

               // read line by line
               String line=null;
               while ((line = br.readLine()) != null) {
                  text=line + "\n";
                  System.err.println(line);
               }

           } catch (IOException e) {
               System.err.format("IOException: %s%n", e);
           }
        return text;
	}
	
	public String findBlogMain() {
		String text = null;
		
        try (FileReader reader = new FileReader("/home/wildfly/BLOG/" + blogEntity.getBlogMain() +".txt");
                BufferedReader br = new BufferedReader(reader)) {

               // read line by line
        	String line = null;
               while ((line = br.readLine()) != null) {
                  text=line + "\n";
                  System.err.println(line);
               }

           } catch (IOException e) {
               System.err.format("IOException: %s%n", e);
           }
        return text;
	}
	
	public void test() {
		//this.blog=this.blogEntity.getBlogMain();
		//this.blogHead=this.blogEntity.getBlogHead();
		this.blogName=this.blogEntity.getBlogName();
		//this.blogHead=this.findBlogHead();
		//this.blog=this.findBlogMain();
	}

	
	public void updateBlogByID() {
		FacesContext context = FacesContext.getCurrentInstance();
//		System.err.println(this.blogEntity.getId());
//		System.err.println(this.blogEntity.getBlogHead());
//		System.err.println(this.blogEntity.getBlogMain());
//		System.err.println(this.blogEntity.getBlogName());
//		System.err.println(this.blogEntity.getBlogType());
//		System.err.println(this.blogEntity.getBlogDate());
//		System.err.println(this.blogEntity.getImportant());
		//test();
	try {
		try {
	    if(!blogName.equals(""))
		this.blogEntity.setBlogName(this.blogName);
		}catch (Exception e) {
			System.err.println("name null");
		}
		try {
		if((!blogType.equals(""))|(!blogType.equals(null)))
		this.blogEntity.setBlogType(this.blogType);
		}catch (Exception e) {
			System.err.println("type null");
		}
		if(this.importantNews==false)
		this.blogEntity.setImportant(false);
		if(this.importantNews==true)
		this.blogEntity.setImportant(true);
		try {
		this.blogEntity.setBlogDate(this.date);
		}catch (Exception e) {
			System.err.println("date null");
		}
		//if(!this.blogHead.equals(""))
		try {
			if(!blog.equals(""))
		this.convertBlogHead();
		}catch (Exception e) {
			System.err.println("head null");
		}
		//if(!this.blog.equals(""))
		try {
			if(!blogHead.equals(""))
		this.convertBlogMain();
		}catch (Exception e) {
			System.err.println("main null");
		}
		//if(!this.blogPic1.equals(null))
		try {
		if(!blogPic1.equals(null))
    	this.convertPicture();
		}catch (Exception e) {
			System.err.println("pic null");
		}
    	blogServiceLocal.updateBlog(this.blogEntity);
    	context.addMessage(null, new FacesMessage("با موفقیت آپدیت گردید."));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	

	
	public void convertBlogMain() throws Exception {
		try {
		byte[] blog = this.blog.getBytes(StandardCharsets.UTF_8);
		File out1 = new File("/home/wildfly/BLOG/" + this.blogEntity.getBlogMain()+ ".txt");
		InputStream in1 = new ByteArrayInputStream(blog);
		OutputStream outputStream = new FileOutputStream(out1);
		outputStream.write(blog);
		outputStream.flush();
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception("error blog main entering 1");
		}
	}
	
	public void convertBlogHead() throws Exception {
		try {
		byte[] blogHead = this.blogHead.getBytes(StandardCharsets.UTF_8);
		File out1 = new File("/home/wildfly/BLOG/" + this.blogEntity.getBlogHead()+ ".txt");
		InputStream in1 = new ByteArrayInputStream(blogHead);
		OutputStream outputStream = new FileOutputStream(out1);
		outputStream.write(blogHead);
		outputStream.flush();
		}catch (Exception e) {
			throw new Exception("error blog head entering 1");
		}
	}
	
	public byte[] findPic() throws IOException {
		try {
		File imageFile1=new File("/home/wildfly/AX/" + this.blogEntity.getPic1() + ".jpg");
		BufferedImage image1=ImageIO.read(imageFile1);
		ByteArrayOutputStream baos1=new ByteArrayOutputStream();
		ImageIO.write(image1, "jpg", baos1);
		return baos1.toByteArray();
		}catch (Exception e) {
			return null;
		}
	}
	
	
	public void convertPicture() throws Exception {
		try {
			byte[] image1Byte = IOUtils.toByteArray(blogPic1.getInputStream());
			File out3 = new File("/home/wildfly/AX/" + this.blogEntity.getPic1() + ".jpg");
			InputStream in = new ByteArrayInputStream(image1Byte);
			BufferedImage img3 = ImageIO.read(in);
			ImageIO.write(img3, "jpg", out3);
		} catch (IOException e) {

			throw new Exception("error image entering 1");
		}
		
	}
	

}
