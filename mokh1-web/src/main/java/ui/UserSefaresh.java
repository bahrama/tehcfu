package ui;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import dao.ProductDaoLocal;
import dao.SefareshDaoLocal;
import entity.MoblEntity;
import entity.ProductEntity;
import entity.SefareshEntity;
import sevice.ProductserviceLocal;

@Named
@SessionScoped
public class UserSefaresh implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserSefaresh() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private ProductDaoLocal productDaLocal;
	@Inject
	private HomeBean homeBean;
	@Inject
	private SefareshDaoLocal sefareshDaoLocal;
	@Inject
	private FacesContext facesContext;
	
	public ProductEntity findProductById(long productId) {
		return productDaLocal.findProductOnlyById(productId);
	}
	
	
	public void submitSefaresh(long productId) {
		ProductEntity productEntity = findProductById(productId);
		if(homeBean.getMoblEntity()!=null) {
		SefareshEntity sefareshEntity=new SefareshEntity();
		sefareshEntity.setAcceptSefaresh(false);
		sefareshEntity.setSefareshProduct(productEntity);
		sefareshEntity.setSefareshMerchant(productEntity.getProduct());
		sefareshEntity.setSefareshUser(homeBean.getMoblEntity());
		sefareshEntity.setSubmitDate(new Date());
		try {
			sefareshDaoLocal.insertToSefaresh(sefareshEntity);
			 facesContext.getPartialViewContext().getEvalScripts().add("swal({title: 'موفق!',type: 'success', text: 'به سبد سفارش اظافه گردید', confirmButtonColor: '#469408',})");
		} catch (Exception e) {
			facesContext.getPartialViewContext().getEvalScripts().add("swal({title: 'ناموفق!',type: 'error', text: 'متاسفانه خطایی رخ  داده است', confirmButtonColor: '#469408',})");
			e.printStackTrace();
		}
	   
		}else {
		facesContext.getPartialViewContext().getEvalScripts().add("swal({title: 'ناموفق!',type: 'error', text: 'برای ثبت سفارش ابتدا وارد شوید', confirmButtonColor: '#469408',})");
		}
	}
	
	
	public List<SefareshEntity> findAllSefareshByUser(){
		return sefareshDaoLocal.findAllSefareshByUser(homeBean.getMoblEntity());
	}
	
	public void deleteSefaresh(long sefareshId) {
		SefareshEntity sefareshEntity = sefareshDaoLocal.findSefareshById(sefareshId);
		sefareshDaoLocal.deleteSefaresh(sefareshEntity);
	    facesContext.getPartialViewContext().getEvalScripts().add("swal({title: 'موفق!',type: 'success', text: 'سفارش با موفقیت حذف گردید', confirmButtonColor: '#469408',})");
	}
	
	public void updateSefaresh(long sefareshId) {
		SefareshEntity sefareshEntity = sefareshDaoLocal.findSefareshById(sefareshId);
		sefareshEntity.setDeleted(true);
		 facesContext.getPartialViewContext().getEvalScripts().add("swal({title: 'موفق!',type: 'success', text: 'سفارش با موفقیت حذف گردید', confirmButtonColor: '#469408',})");
		try {
			sefareshDaoLocal.updateSefaresh(sefareshEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void registerUpdateSefaresh(long sefareshId) {
		SefareshEntity sefareshEntity = sefareshDaoLocal.findSefareshById(sefareshId);
		sefareshEntity.setAcceptUserSefaresh(true);
		 facesContext.getPartialViewContext().getEvalScripts().add("swal({title: 'موفق!',type: 'success', text: 'سفارش با موفقیت ثبت گردید', confirmButtonColor: '#469408',})");
		try {
			sefareshDaoLocal.updateSefaresh(sefareshEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 public int findCountAllSefareshByUser() {
		 return sefareshDaoLocal.findCountAllSefareshByUser(homeBean.getMoblEntity());
	 }
}
