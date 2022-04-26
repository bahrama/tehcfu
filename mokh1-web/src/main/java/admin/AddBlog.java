package admin;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.UUID;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
@RequestScoped
public class AddBlog {
 
	public AddBlog() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private BlogServiceLocal blogServiceLocal;
	
	@Size(max=2 , message="max is 2")
	private String blogType;
	@Size(max=200 , message="max is 200")
	private String blogName;
	@NotNull
	private String blog;
	@NotNull
	private String blogHead;
	private Part blogPic1;
	private boolean importantNews;
	private Date date;
	private String newsMode;
	
	
	
	public String getNewsMode() {
		return newsMode;
	}
	public void setNewsMode(String newsMode) {
		this.newsMode = newsMode;
	}
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
	
	

	public void insertToBlog(){
		FacesContext context = FacesContext.getCurrentInstance();
		BlogEntity blogEntity = new BlogEntity();
		try {
        blogEntity.setBlogDate(date);
        blogEntity.setBlogHead(this.convertBlogHead());
        blogEntity.setBlogMain(this.convertBlogMain());
        blogEntity.setBlogName(blogName);
        blogEntity.setBlogType(blogType);
        blogEntity.setImportant(importantNews);
        blogEntity.setPic1(this.picture());
        blogEntity.setNewsMode(newsMode);
        blogServiceLocal.insertBlog(blogEntity);
        context.addMessage(null, new FacesMessage("با موفقیت وارد گردید."));
		}catch (Exception e) {
			e.printStackTrace();
		}
		}
	
	
	public String convertBlogMain() throws Exception {
		try {
		UUID uuid=UUID.randomUUID();
		byte[] blog = this.blog.getBytes(StandardCharsets.UTF_8);
		File out1 = new File("/home/wildfly/BLOG/" + uuid+ ".txt");
		InputStream in1 = new ByteArrayInputStream(blog);
		OutputStream outputStream = new FileOutputStream(out1);
		outputStream.write(blog);
		outputStream.flush();
		return uuid.toString();
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception("error blog main entering 1");
		}
	}
	
	public String convertBlogHead() throws Exception {
		try {
		UUID uuid=UUID.randomUUID();
		byte[] blogHead = this.blogHead.getBytes(StandardCharsets.UTF_8);
		File out1 = new File("/home/wildfly/BLOG/" + uuid+ ".txt");
		InputStream in1 = new ByteArrayInputStream(blogHead);
		OutputStream outputStream = new FileOutputStream(out1);
		outputStream.write(blogHead);
		outputStream.flush();
		return uuid.toString();
		}catch (Exception e) {
			throw new Exception("error blog head entering 1");
		}
	}
	
	public String picture() throws Exception {
		try {
			UUID uuid=UUID.randomUUID();
			byte[] image1Byte = IOUtils.toByteArray(blogPic1.getInputStream());
			File out3 = new File("/home/wildfly/AX/" + uuid + ".jpg");
			InputStream in = new ByteArrayInputStream(image1Byte);
			BufferedImage img3 = ImageIO.read(in);
			ImageIO.write(img3, "jpg", out3);
			return uuid.toString();
		} catch (IOException e) {

			throw new Exception("error image entering 1");
		}
		
	}
	
	
	

}
