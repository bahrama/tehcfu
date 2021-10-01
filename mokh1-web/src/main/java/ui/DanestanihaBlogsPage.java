package ui;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;

import catch_db.CatchBlogLocal;
import entity.BlogEntity;
import sevice.BlogServiceLocal;

@Named
@ViewScoped
public class DanestanihaBlogsPage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DanestanihaBlogsPage() {
		// TODO Auto-generated constructor stub
	}

//	@Inject
//	private CatchBlogLocal catchBlogLocal;
	@Inject
	private BlogServiceLocal blogServiceLocal;

	private List<BlogEntity> blogHogogi = new ArrayList<>();
	private List<BlogEntity> blogMaliati = new ArrayList<>();
	private List<BlogEntity> blogTaminEjtema = new ArrayList<>();
	private List<BlogEntity> blogDarbareDecor = new ArrayList<>();
	private List<BlogEntity> blogAmozesh = new ArrayList<>();
	private List<BlogEntity> blogYafte = new ArrayList<>();

	public List<BlogEntity> getBlogHogogi() {
		return blogHogogi;
	}

	public void setBlogHogogi(List<BlogEntity> blogHogogi) {
		this.blogHogogi = blogHogogi;
	}

	public List<BlogEntity> getBlogMaliati() {
		return blogMaliati;
	}

	public void setBlogMaliati(List<BlogEntity> blogMaliati) {
		this.blogMaliati = blogMaliati;
	}

	public List<BlogEntity> getBlogTaminEjtema() {
		return blogTaminEjtema;
	}

	public void setBlogTaminEjtema(List<BlogEntity> blogTaminEjtema) {
		this.blogTaminEjtema = blogTaminEjtema;
	}

	public List<BlogEntity> getBlogDarbareDecor() {
		return blogDarbareDecor;
	}

	public void setBlogDarbareDecor(List<BlogEntity> blogDarbareDecor) {
		this.blogDarbareDecor = blogDarbareDecor;
	}

	public List<BlogEntity> getBlogAmozesh() {
		return blogAmozesh;
	}

	public void setBlogAmozesh(List<BlogEntity> blogAmozesh) {
		this.blogAmozesh = blogAmozesh;
	}
	
	

	public List<BlogEntity> getBlogYafte() {
		return blogYafte;
	}

	public void setBlogYafte(List<BlogEntity> blogYafte) {
		this.blogYafte = blogYafte;
	}

	@PostConstruct
	public void init() {
//		for (BlogEntity blogEntity : catchBlogLocal.getBlogEntities()) {
//			if (blogEntity.getBlogType().equals("قوانین حقوقی"))
//				this.blogHogogi.add(blogEntity);
//		}
//		for (BlogEntity blogEntity : catchBlogLocal.getBlogEntities()) {
//			if (blogEntity.getBlogType().equals("قوانین مالیاتی"))
//				this.blogMaliati.add(blogEntity);
//		}
//		for (BlogEntity blogEntity : catchBlogLocal.getBlogEntities()) {
//			if (blogEntity.getBlogType().equals("آموزش"))
//				this.blogAmozesh.add(blogEntity);
//		}
//		for (BlogEntity blogEntity : catchBlogLocal.getBlogEntities()) {
//			if (blogEntity.getBlogType().equals("قوانین تامین اجتماعی"))
//				this.blogTaminEjtema.add(blogEntity);
//		}
//		for (BlogEntity blogEntity : catchBlogLocal.getBlogEntities()) {
//			if (blogEntity.getBlogType().equals("درباره دکوراسیون"))
//				this.blogDarbareDecor.add(blogEntity);
//		}
//		Collections.reverse(blogAmozesh);
//		Collections.reverse(blogDarbareDecor);
//		Collections.reverse(blogHogogi);
//		Collections.reverse(blogMaliati);
//		Collections.reverse(blogTaminEjtema);
		this.blogHogogi.addAll(blogServiceLocal.findAllNewsType("F"));
		this.blogAmozesh.addAll(blogServiceLocal.findAllNewsType("J"));
		this.blogDarbareDecor.addAll(blogServiceLocal.findAllNewsType("I"));
		this.blogMaliati.addAll(blogServiceLocal.findAllNewsType("G"));
		this.blogTaminEjtema.addAll(blogServiceLocal.findAllNewsType("H"));
		this.blogYafte.addAll(blogServiceLocal.findAllNewsType("Q"));
	}

	public byte[] findBlogPicById(int id) {
		BlogEntity blogEntity = new BlogEntity();
		try {
			blogEntity=blogServiceLocal.findBlogById(id);
			return this.findPic1(blogEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
//		for (BlogEntity blogEntity2 : catchBlogLocal.getBlogEntities()) {
//			if (blogEntity2.getId() == id)
//				blogEntity = blogEntity2;
//		}
		

	}

	private byte[] findPic1(BlogEntity blogEntity) {
		try {
			File imageFile1 = new File("/home/wildfly/AX/" + blogEntity.getPic1().toString() + ".jpg");
			BufferedImage image1 = ImageIO.read(imageFile1);
			ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
			ImageIO.write(image1, "jpg", baos1);
			return baos1.toByteArray();
		} catch (Exception e) {
			return null;
		}
	}

	public List<BlogEntity> checkType(String type) {
		switch (type) {
		case "قوانین حقوقی":
			return this.blogHogogi;
		case "قوانین مالیاتی":
			return this.blogMaliati;
		case "قوانین تامین اجتماعی":
			return this.blogTaminEjtema;
		case "درباره دکوراسیون":
			return this.blogDarbareDecor;
		case "آموزش":
			return this.blogAmozesh;
		case "یافته های جهانی":
			return this.blogYafte;
		default:
			return null;
		}
	}

}
