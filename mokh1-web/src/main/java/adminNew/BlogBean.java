package adminNew;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sound.midi.SysexMessage;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.primefaces.model.file.UploadedFile;

import entity.BlogEntity;
import entity.MoblEntity;
import help.FileConvertor;
import help.TimeCovnertor;
import sevice.BlogServiceLocal;

@Named
@ViewScoped
public class BlogBean implements Serializable {

	public BlogBean() {
		// TODO Auto-generated constructor stub
	}

	private FileConvertor fileConvertor;
	@Inject
	private BlogServiceLocal blogServiceLocal;

	@Size(max = 2, message = "max is 2")
	private String blogType;
	@Size(max = 200, message = "max is 200")
	private String blogName;
	private String blog;
	private String blogHead;
	private UploadedFile blogPic1;
	private boolean importantNews;
	private String datePers;
	private String newsMode;
	private BlogEntity blogEntity;
	private UIComponent blogPic1Component;
	/////////////////////// EDIT///////////////////////

	private String blogTypeEdit;
	private String blogNameEdit;
	private String blogEdit;
	private String blogHeadEdit;
	private UploadedFile blogPic1Edit;
	private String datePersEdit;
	private String newsModeEdit;
	private UIComponent blogPic1EditComponent;

	public FileConvertor getFileConvertor() {
		return fileConvertor;
	}

	public void setFileConvertor(FileConvertor fileConvertor) {
		this.fileConvertor = fileConvertor;
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

	public UploadedFile getBlogPic1() {
		return blogPic1;
	}

	public void setBlogPic1(UploadedFile blogPic1) {
		this.blogPic1 = blogPic1;
	}

	public boolean isImportantNews() {
		return importantNews;
	}

	public void setImportantNews(boolean importantNews) {
		this.importantNews = importantNews;
	}

	public String getDatePers() {
		return datePers;
	}

	public void setDatePers(String datePers) {
		this.datePers = datePers;
	}

	public String getNewsMode() {
		return newsMode;
	}

	public void setNewsMode(String newsMode) {
		this.newsMode = newsMode;
	}

	public BlogEntity getBlogEntity() {
		return blogEntity;
	}

	public void setBlogEntity(BlogEntity blogEntity) {
		this.blogEntity = blogEntity;
	}

	public String getBlogTypeEdit() {
		return blogTypeEdit;
	}

	public void setBlogTypeEdit(String blogTypeEdit) {
		this.blogTypeEdit = blogTypeEdit;
	}

	public String getBlogNameEdit() {
		return blogNameEdit;
	}

	public void setBlogNameEdit(String blogNameEdit) {
		this.blogNameEdit = blogNameEdit;
	}

	public String getBlogEdit() {
		return blogEdit;
	}

	public void setBlogEdit(String blogEdit) {
		this.blogEdit = blogEdit;
	}

	public String getBlogHeadEdit() {
		return blogHeadEdit;
	}

	public void setBlogHeadEdit(String blogHeadEdit) {
		this.blogHeadEdit = blogHeadEdit;
	}

	public UploadedFile getBlogPic1Edit() {
		return blogPic1Edit;
	}

	public void setBlogPic1Edit(UploadedFile blogPic1Edit) {
		this.blogPic1Edit = blogPic1Edit;
	}

	public String getDatePersEdit() {
		return datePersEdit;
	}

	public void setDatePersEdit(String datePersEdit) {
		this.datePersEdit = datePersEdit;
	}

	public String getNewsModeEdit() {
		return newsModeEdit;
	}

	public void setNewsModeEdit(String newsModeEdit) {
		this.newsModeEdit = newsModeEdit;
	}

	public UIComponent getBlogPic1Component() {
		return blogPic1Component;
	}

	public void setBlogPic1Component(UIComponent blogPic1Component) {
		this.blogPic1Component = blogPic1Component;
	}

	public UIComponent getBlogPic1EditComponent() {
		return blogPic1EditComponent;
	}

	public void setBlogPic1EditComponent(UIComponent blogPic1EditComponent) {
		this.blogPic1EditComponent = blogPic1EditComponent;
	}

	public String convertDateToPer(Date date) {		
		if (!date.equals(null) || !date.equals(""))
			return TimeCovnertor.findPersianDate(date);
		else
			return "بدون تاریخ";
	}

	public Date conertPersianToDate(String persianDate) {
		return TimeCovnertor.mohlateEjareChangeDate(persianDate);
	}

	public String convertTextFromFile(String text) {
		try {
			return FileConvertor.convertTextFileToText(text);
		} catch (Exception e) {
			return null;
		}
	}

	public void deleteBlog() {
		try {
			blogServiceLocal.deleteBlog(this.blogEntity);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("*****************************با موفقیت حذف گردید************************"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<BlogEntity> findAllBlog(){
		return blogServiceLocal.findAllBlog();
	}
	
	public void updateBlog() {
		try {
			if (!blogNameEdit.equals(""))
				this.blogEntity.setBlogName(this.blogNameEdit);
			try {
				if ((!blogTypeEdit.equals("")) | (!blogTypeEdit.equals(null)))
					this.blogEntity.setBlogType(this.blogTypeEdit);
			} catch (Exception e) {
				System.err.println("type null");
			}
			try {
				this.blogEntity.setBlogDate(TimeCovnertor.mohlateEjareChangeDate(datePersEdit));
			} catch (Exception e) {
				System.err.println("date null");
			}
			if (!blogEdit.equals(""))
				blogEntity.setBlogMain(FileConvertor.convertTextFile(blogEdit));

			if (!blogHeadEdit.equals(""))
				blogEntity.setBlogHead(FileConvertor.convertTextFile(blogHeadEdit));

			if (blogPic1Edit != null) {
				if (blogPic1Edit.getSize() > 50000) {
					throw new Exception("pic1Size");
				} else if (!blogPic1Edit.getContentType().equals("image/jpeg")) {
					throw new Exception("pic1Type");
				} else {
					this.blogEntity.setPic1(FileConvertor.convertPicture(blogPic1Edit));
				}
			}
			try {
				if ((!newsModeEdit.equals("")) | (!newsModeEdit.equals(null))) {
					this.blogEntity.setNewsMode(newsModeEdit);
				}
			} catch (NullPointerException e) {
				System.err.println("newsmode null point");
			}
			blogServiceLocal.updateBlog(this.blogEntity);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("با موفقیت آپدیت گردید."));
			this.blogEdit = "";
			this.blogHeadEdit = "";
			this.blogNameEdit = "";
		} catch (Exception e) {
			if (e.getMessage().equals("pic1Size"))
				FacesContext.getCurrentInstance().addMessage(blogPic1EditComponent.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
			if (e.getMessage().equals("pic1Type"))
				FacesContext.getCurrentInstance().addMessage(blogPic1EditComponent.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
			if (e.getMessage() == null)
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));
		}
	}

	public void insertToBlog() {
		BlogEntity blogEntity = new BlogEntity();
		try {
			blogEntity.setBlogDate(TimeCovnertor.mohlateEjareChangeDate(datePers));
			blogEntity.setBlogHead(FileConvertor.convertTextFile(blogHead));
			blogEntity.setBlogMain(FileConvertor.convertTextFile(blog));
			blogEntity.setBlogName(blogName);
			blogEntity.setBlogType(blogType);
			blogEntity.setImportant(false);
			blogEntity.setNewsMode(newsMode);
			if (blogPic1 != null) {
				if (blogPic1.getSize() > 50000) {
					throw new Exception("pic1Size");
				} else if (!blogPic1.getContentType().equals("image/jpeg")) {
					throw new Exception("pic1Type");
				} else {
					blogEntity.setPic1(FileConvertor.convertPicture(blogPic1));
				}
			}
			blogEntity.setNewsMode(newsMode);
			blogServiceLocal.insertBlog(blogEntity);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("با موفقیت وارد گردید."));
			this.blog="";
			this.blogHead="";
			this.blogName="";
		} catch (Exception e) {
			if(e.getMessage().equals("pic1Size"))
	    		FacesContext.getCurrentInstance().addMessage(blogPic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic1Type"))
	    		FacesContext.getCurrentInstance().addMessage(blogPic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
			if(e.getMessage()==null)
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));
		}
	}

}
