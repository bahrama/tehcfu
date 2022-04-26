package adminNew;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.PreUpdate;

import dao.ProductDaoLocal;
import dao.SefareshDaoLocal;
import entity.MoblEntity;
import entity.ProductEntity;
import entity.SefareshEntity;
import help.TimeCovnertor;
import ui.HomeBean;

@Named
@SessionScoped
public class AdminSefaresh implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminSefaresh() {
		// TODO Auto-generated constructor stub
	}
	
	@Inject
	private ProductDaoLocal productDaLocal;
	@Inject
	private HomeBean homeBean;
	@Inject
	private SefareshDaoLocal sefareshDaoLocal;
	
	private List<SefareshEntity> sefareshEntities;
	
	public List<SefareshEntity> findAllSefareshByMerchant(){
		return sefareshDaoLocal.findAllSefareshByMerchant(homeBean.getMoblEntity());
	}
	
	public int findAllCountSefareshByMerchant(){
		return sefareshDaoLocal.findAllCountSefareshByMerchant(homeBean.getMoblEntity());
	}

	
//	public List<SefareshEntity> findAllProductByUserSefaresh(){
//	    sefareshEntities.clear();
//		sefareshEntities=new ArrayList<SefareshEntity>();
//		for (ProductEntity productEntity : productDaLocal.findAllProductEntityBySeller(homeBean.getMoblEntity())) {
//			sefareshEntities.add(findAllSefareshByProduct(productEntity));
//			
//		}
//	}
	
	public String convertDateToPer(Date date) {
    	if(!date.equals(null) || !date.equals(""))
    	return TimeCovnertor.findPersianDate(date);
    	else
    	return "بدون تاریخ";
    }
	
	public ProductEntity findProductById(long productId) {
		return productDaLocal.findProductOnlyById(productId);
	}
	
	public void registerUpdateSefaresh(long sefareshId) {
		SefareshEntity sefareshEntity = sefareshDaoLocal.findSefareshById(sefareshId);
		sefareshEntity.setAcceptSefaresh(true);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("*با موفقیت دریافت گردید*"));
		try {
			sefareshDaoLocal.updateSefaresh(sefareshEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
