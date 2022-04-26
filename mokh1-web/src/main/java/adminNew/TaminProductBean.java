package adminNew;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Size;

import org.primefaces.model.file.UploadedFile;

import dao.TaminProductDaoLocal;
import entity.BlogEntity;
import entity.TaminProductEntity;
import help.FileConvertor;
import help.TimeCovnertor;

@Named
@ViewScoped
public class TaminProductBean implements Serializable {

	/**
	 *   
	 */
	private static final long serialVersionUID = 1L;

	public TaminProductBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private TaminProductDaoLocal taminProductDaoLocal;
	private TaminProductEntity taminProductEntity;
	@Size(max=500 , message="max size is 500")
	private String name1;
	@Size(max=500 , message="max size is 500")
	private String name2;
	@Size(max=500 , message="max size is 500")
	private String name3;
	@Size(max=500 , message="max size is 500")
	private String name4;
	@Size(max=100 , message="max size is 100")
	private String specification;
	@Size(max=100 , message="max size is 100")
	private String description;
	private long price;
	private String datePer;
	private UploadedFile pic1;
	private UploadedFile pic2;
	private UploadedFile pic3;
	private UploadedFile pic4;
	private UploadedFile pic5;
	private boolean check1;
	private boolean check2;
	private List<String> faaliats=new ArrayList<String>();
	////////////////////////////////EDIT////////////////////////
	@Size(max=500 , message="max size is 500")
	private String rasteEdit;
	@Size(max=500 , message="max size is 500")
	private String name1Edit;
	@Size(max=500 , message="max size is 500")
	private String name2Edit;
	@Size(max=500 , message="max size is 500")
	private String name3Edit;
	@Size(max=500 , message="max size is 500")
	private String name4Edit;
	@Size(max=100 , message="max size is 100")
	private String specificationEdit;
	@Size(max=100 , message="max size is 100")
	private String descriptionEdit;
	private long priceEdit;
	private String datePerEdit;
	private UploadedFile pic1Edit;
	private UploadedFile pic2Edit;
	private UploadedFile pic3Edit;
	private UploadedFile pic4Edit;
	private UploadedFile pic5Edit;
	private boolean check1Edit;
	private boolean check2Edit;
	private List<String> faaliatsEdit=new ArrayList<String>();
	//////////////////////////////////////////////////////
	
	private UIComponent pic1EditComponent;
	private UIComponent pic2EditComponent;
	private UIComponent pic3EditComponent;
	private UIComponent pic4EditComponent;
	private UIComponent pic5EditComponent;
	private UIComponent pic1Component;
	private UIComponent pic2Component;
	private UIComponent pic3Component;
	private UIComponent pic4Component;
	private UIComponent pic5Component;


	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public String getName3() {
		return name3;
	}
	public void setName3(String name3) {
		this.name3 = name3;
	}
	public String getName4() {
		return name4;
	}
	public void setName4(String name4) {
		this.name4 = name4;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getDatePer() {
		return datePer;
	}
	public void setDatePer(String datePer) {
		this.datePer = datePer;
	}
	public UploadedFile getPic1() {
		return pic1;
	}
	public void setPic1(UploadedFile pic1) {
		this.pic1 = pic1;
	}
	public UploadedFile getPic2() {
		return pic2;
	}
	public void setPic2(UploadedFile pic2) {
		this.pic2 = pic2;
	}
	public UploadedFile getPic3() {
		return pic3;
	}
	public void setPic3(UploadedFile pic3) {
		this.pic3 = pic3;
	}
	public UploadedFile getPic4() {
		return pic4;
	}
	public void setPic4(UploadedFile pic4) {
		this.pic4 = pic4;
	}
	public UploadedFile getPic5() {
		return pic5;
	}
	public void setPic5(UploadedFile pic5) {
		this.pic5 = pic5;
	}
	public boolean isCheck1() {
		return check1;
	}
	public void setCheck1(boolean check1) {
		this.check1 = check1;
	}
	public boolean isCheck2() {
		return check2;
	}
	public void setCheck2(boolean check2) {
		this.check2 = check2;
	}
	public String getRasteEdit() {
		return rasteEdit;
	}
	public void setRasteEdit(String rasteEdit) {
		this.rasteEdit = rasteEdit;
	}
	public String getName1Edit() {
		return name1Edit;
	}
	public void setName1Edit(String name1Edit) {
		this.name1Edit = name1Edit;
	}
	public String getName2Edit() {
		return name2Edit;
	}
	public void setName2Edit(String name2Edit) {
		this.name2Edit = name2Edit;
	}
	public String getName3Edit() {
		return name3Edit;
	}
	public void setName3Edit(String name3Edit) {
		this.name3Edit = name3Edit;
	}
	public String getName4Edit() {
		return name4Edit;
	}
	public void setName4Edit(String name4Edit) {
		this.name4Edit = name4Edit;
	}
	public String getSpecificationEdit() {
		return specificationEdit;
	}
	public void setSpecificationEdit(String specificationEdit) {
		this.specificationEdit = specificationEdit;
	}
	public String getDescriptionEdit() {
		return descriptionEdit;
	}
	public void setDescriptionEdit(String descriptionEdit) {
		this.descriptionEdit = descriptionEdit;
	}
	public long getPriceEdit() {
		return priceEdit;
	}
	public void setPriceEdit(long priceEdit) {
		this.priceEdit = priceEdit;
	}
	public String getDatePerEdit() {
		return datePerEdit;
	}
	public void setDatePerEdit(String datePerEdit) {
		this.datePerEdit = datePerEdit;
	}
	public UploadedFile getPic1Edit() {
		return pic1Edit;
	}
	public void setPic1Edit(UploadedFile pic1Edit) {
		this.pic1Edit = pic1Edit;
	}
	public UploadedFile getPic2Edit() {
		return pic2Edit;
	}
	public void setPic2Edit(UploadedFile pic2Edit) {
		this.pic2Edit = pic2Edit;
	}
	public UploadedFile getPic3Edit() {
		return pic3Edit;
	}
	public void setPic3Edit(UploadedFile pic3Edit) {
		this.pic3Edit = pic3Edit;
	}
	public UploadedFile getPic4Edit() {
		return pic4Edit;
	}
	public void setPic4Edit(UploadedFile pic4Edit) {
		this.pic4Edit = pic4Edit;
	}
	public UploadedFile getPic5Edit() {
		return pic5Edit;
	}
	public void setPic5Edit(UploadedFile pic5Edit) {
		this.pic5Edit = pic5Edit;
	}
	public boolean isCheck1Edit() {
		return check1Edit;
	}
	public void setCheck1Edit(boolean check1Edit) {
		this.check1Edit = check1Edit;
	}
	public boolean isCheck2Edit() {
		return check2Edit;
	}
	public void setCheck2Edit(boolean check2Edit) {
		this.check2Edit = check2Edit;
	}
	public UIComponent getPic1EditComponent() {
		return pic1EditComponent;
	}
	public void setPic1EditComponent(UIComponent pic1EditComponent) {
		this.pic1EditComponent = pic1EditComponent;
	}
	public UIComponent getPic2EditComponent() {
		return pic2EditComponent;
	}
	public void setPic2EditComponent(UIComponent pic2EditComponent) {
		this.pic2EditComponent = pic2EditComponent;
	}
	public UIComponent getPic3EditComponent() {
		return pic3EditComponent;
	}
	public void setPic3EditComponent(UIComponent pic3EditComponent) {
		this.pic3EditComponent = pic3EditComponent;
	}
	public UIComponent getPic4EditComponent() {
		return pic4EditComponent;
	}
	public void setPic4EditComponent(UIComponent pic4EditComponent) {
		this.pic4EditComponent = pic4EditComponent;
	}
	public UIComponent getPic5EditComponent() {
		return pic5EditComponent;
	}
	public void setPic5EditComponent(UIComponent pic5EditComponent) {
		this.pic5EditComponent = pic5EditComponent;
	}
	public UIComponent getPic1Component() {
		return pic1Component;
	}
	public void setPic1Component(UIComponent pic1Component) {
		this.pic1Component = pic1Component;
	}
	public UIComponent getPic2Component() {
		return pic2Component;
	}
	public void setPic2Component(UIComponent pic2Component) {
		this.pic2Component = pic2Component;
	}
	public UIComponent getPic3Component() {
		return pic3Component;
	}
	public void setPic3Component(UIComponent pic3Component) {
		this.pic3Component = pic3Component;
	}
	public UIComponent getPic4Component() {
		return pic4Component;
	}
	public void setPic4Component(UIComponent pic4Component) {
		this.pic4Component = pic4Component;
	}
	public UIComponent getPic5Component() {
		return pic5Component;
	}
	public void setPic5Component(UIComponent pic5Component) {
		this.pic5Component = pic5Component;
	}
	public TaminProductEntity getTaminProductEntity() {
		return taminProductEntity;
	}
	public void setTaminProductEntity(TaminProductEntity taminProductEntity) {
		this.taminProductEntity = taminProductEntity;
	}
	public List<String> getFaaliats() {
		return faaliats;
	}
	public void setFaaliats(List<String> faaliats) {
		this.faaliats = faaliats;
	}
	public List<String> getFaaliatsEdit() {
		return faaliatsEdit;
	}
	public void setFaaliatsEdit(List<String> faaliatsEdit) {
		this.faaliatsEdit = faaliatsEdit;
	}
	public String convertDateToPer(Date date) {		
		if (!date.equals(null) || !date.equals(""))
			return TimeCovnertor.findPersianDate(date);
		else
			return "بدون تاریخ";
	}
	
	public void deleteTamin() {
		try {
			taminProductDaoLocal.deleteTaminProduct(this.taminProductEntity);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("*****************************با موفقیت حذف گردید************************"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<TaminProductEntity> findAllTamin(){
		return taminProductDaoLocal.findAllTaminProduct();
	}
	
	private String faaliatHaEdit() {
		try {
		String item="";
		for (String string : this.faaliatsEdit) {
			item=item +string + "-";
		}
		return item;
		}catch (Exception e) {
			System.err.println();
			return "";
		}
		}
	
	private String faaliatHa() {
		String item="";
		if(this.faaliats==null) {
		for (String string : this.faaliats) {
			item=item +string + "-";
		}
		return item;
		}else {
		return "";
		}
	}
	
	public String convertTextFromFile(String text) {
		try {
			return FileConvertor.convertTextFileToText(text);
		} catch (Exception e) {
			return null;
		}
	}
	
	
	public void updateTaminProduct() {
		try {

			if (!datePerEdit.equals(""))
				taminProductEntity.setDate(TimeCovnertor.mohlateEjareChangeDate(datePerEdit));
			if (!descriptionEdit.equals(""))
				taminProductEntity.setDescription(FileConvertor.convertTextFile(descriptionEdit));
			if (!name1Edit.equals(""))
				taminProductEntity.setName1(name1Edit);
			if (!name2Edit.equals(""))
				taminProductEntity.setName2(name2Edit);
			if (!name3Edit.equals(""))
				taminProductEntity.setName3(name3Edit);
			if (!name4Edit.equals(""))
				taminProductEntity.setName4(name4Edit);
			if (priceEdit!=0)
				taminProductEntity.setPrice(priceEdit);
			if (!specificationEdit.equals(""))
				taminProductEntity.setSpecification(FileConvertor.convertTextFile(specificationEdit));
			if(!this.faaliatHaEdit().equals(""))
				taminProductEntity.setRaste(this.faaliatHaEdit());
			if (pic1Edit != null) {
				if (pic1Edit.getSize() > 50000) {
					throw new Exception("pic1Size");
				} else if (!pic1Edit.getContentType().equals("image/jpeg")) {
					throw new Exception("pic1Type");
				} else {
					this.taminProductEntity.setPic1(FileConvertor.convertPicture(pic1Edit));
				}
			}
			if (pic2Edit != null) {
				if (pic2Edit.getSize() > 50000) {
					throw new Exception("pic2Size");
				} else if (!pic2Edit.getContentType().equals("image/jpeg")) {
					throw new Exception("pic2Type");
				} else {
					this.taminProductEntity.setPic2(FileConvertor.convertPicture(pic2Edit));
				}
			}
			if (pic3Edit != null) {
				if (pic3Edit.getSize() > 50000) {
					throw new Exception("pic3Size");
				} else if (!pic3Edit.getContentType().equals("image/jpeg")) {
					throw new Exception("pic3Type");
				} else {
					this.taminProductEntity.setPic3(FileConvertor.convertPicture(pic3Edit));
				}
			}
			if (pic4Edit != null) {
				if (pic4Edit.getSize() > 50000) {
					throw new Exception("pic4Size");
				} else if (!pic4Edit.getContentType().equals("image/jpeg")) {
					throw new Exception("pic4Type");
				} else {
					this.taminProductEntity.setPic4(FileConvertor.convertPicture(pic4Edit));
				}
			}
			if (pic5Edit != null) {
				if (pic5Edit.getSize() > 50000) {
					throw new Exception("pic5Size");
				} else if (!pic5Edit.getContentType().equals("image/jpeg")) {
					throw new Exception("pic5Type");
				} else {
					this.taminProductEntity.setPic5(FileConvertor.convertPicture(pic5Edit));
				}
			}
			

			taminProductDaoLocal.updateTaminProduct(this.taminProductEntity);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("با موفقیت آپدیت گردید."));
			this.datePerEdit = "";
			this.descriptionEdit = "";
			this.name1Edit = "";
			this.name2Edit = "";
			this.name3Edit = "";
			this.name4Edit = "";
			this.priceEdit = 0;
			this.rasteEdit="";
			this.specificationEdit="";
			
		} catch (Exception e) {
			if (e.getMessage().equals("pic1Size"))
				FacesContext.getCurrentInstance().addMessage(pic1EditComponent.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
			if (e.getMessage().equals("pic1Type"))
				FacesContext.getCurrentInstance().addMessage(pic1EditComponent.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
			if (e.getMessage().equals("pic2Size"))
				FacesContext.getCurrentInstance().addMessage(pic2EditComponent.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
			if (e.getMessage().equals("pic2Type"))
				FacesContext.getCurrentInstance().addMessage(pic2EditComponent.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
			if (e.getMessage().equals("pic3Size"))
				FacesContext.getCurrentInstance().addMessage(pic3EditComponent.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
			if (e.getMessage().equals("pic3Type"))
				FacesContext.getCurrentInstance().addMessage(pic3EditComponent.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
			if (e.getMessage().equals("pic4Size"))
				FacesContext.getCurrentInstance().addMessage(pic4EditComponent.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
			if (e.getMessage().equals("pic4Type"))
				FacesContext.getCurrentInstance().addMessage(pic4EditComponent.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
			if (e.getMessage().equals("pic5Size"))
				FacesContext.getCurrentInstance().addMessage(pic5EditComponent.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
			if (e.getMessage().equals("pic5Type"))
				FacesContext.getCurrentInstance().addMessage(pic5EditComponent.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
			if (e.getMessage() == null)
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));
		}
	}
	
	
	public void insertToTaminProduct() {
		TaminProductEntity taminProductEntity = new TaminProductEntity();
		try {
			taminProductEntity.setDate(TimeCovnertor.mohlateEjareChangeDate(datePer));
			taminProductEntity.setSpecification(FileConvertor.convertTextFile(specification));
			taminProductEntity.setDescription(FileConvertor.convertTextFile(description));
			taminProductEntity.setName1(name1);
			taminProductEntity.setName2(name2);
			taminProductEntity.setName3(name3);
			taminProductEntity.setName4(name4);
			if (pic1 != null) {
				if (pic1.getSize() > 50000) {
					throw new Exception("pic1Size");
				} else if (!pic1.getContentType().equals("image/jpeg")) {
					throw new Exception("pic1Type");
				} else {
					taminProductEntity.setPic1(FileConvertor.convertPicture(pic1));
				}
			}
			if (pic2 != null) {
				if (pic2.getSize() > 50000) {
					throw new Exception("pic2Size");
				} else if (!pic2.getContentType().equals("image/jpeg")) {
					throw new Exception("pic2Type");
				} else {
					taminProductEntity.setPic2(FileConvertor.convertPicture(pic2));
				}
			}
			if (pic3 != null) {
				if (pic3.getSize() > 50000) {
					throw new Exception("pic3Size");
				} else if (!pic3.getContentType().equals("image/jpeg")) {
					throw new Exception("pic3Type");
				} else {
					taminProductEntity.setPic3(FileConvertor.convertPicture(pic3));
				}
			}
			if (pic4 != null) {
				if (pic4.getSize() > 50000) {
					throw new Exception("pic4Size");
				} else if (!pic4.getContentType().equals("image/jpeg")) {
					throw new Exception("pic4Type");
				} else {
					taminProductEntity.setPic4(FileConvertor.convertPicture(pic4));
				}
			}
			if (pic5 != null) {
				if (pic5.getSize() > 50000) {
					throw new Exception("pic5Size");
				} else if (!pic5.getContentType().equals("image/jpeg")) {
					throw new Exception("pic5Type");
				} else {
					taminProductEntity.setPic5(FileConvertor.convertPicture(pic5));
				}
			}
			taminProductEntity.setRaste(this.faaliatHa());
			taminProductEntity.setDate(new Date());
			taminProductDaoLocal.insertTaminProduct(taminProductEntity);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("با موفقیت وارد گردید."));
			this.datePer="";
			this.description="";
			this.name1="";
			this.name2="";
			this.name3="";
			this.name4="";
			this.specification="";
		} catch (Exception e) {
			if(e.getMessage().equals("pic1Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic1Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
			if(e.getMessage().equals("pic2Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic2Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
			if(e.getMessage().equals("pic3Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic3Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
			if(e.getMessage().equals("pic4Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic4Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
			if(e.getMessage().equals("pic5Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic5Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
			if(e.getMessage()==null)
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));
		}
	}
	
	
	
}
