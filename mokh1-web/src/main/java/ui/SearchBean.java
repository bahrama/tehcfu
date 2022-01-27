package ui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.BlogEntity;
import entity.MoblEntity;
import sevice.BlogServiceLocal;
import sevice.SellerServiceLocal;

@Named
@SessionScoped
public class SearchBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SearchBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private SellerServiceLocal sellerServiceLocal;
//	@Inject
//	private BlogServiceLocal blogServiceLocal;
	
	private String searchTxt;

	private List<MoblEntity> moblEntities=new ArrayList<MoblEntity>();
	private List<MoblEntity> moblEntitiesE=new ArrayList<MoblEntity>();
	
	private String filter;




	public String getFilter() {
		return filter;
	}



	public void setFilter(String filter) {
		this.filter = filter;
	}



	public String getSearchTxt() {
		return searchTxt;
	}



	public void setSearchTxt(String searchTxt) {
		this.searchTxt = searchTxt;
	}



	public List<MoblEntity> getMoblEntities() {
		return moblEntities;
	}



	public void setMoblEntities(List<MoblEntity> moblEntities) {
		this.moblEntities = moblEntities;
	}



	public List<MoblEntity> getMoblEntitiesE() {
		return moblEntitiesE;
	}



	public void setMoblEntitiesE(List<MoblEntity> moblEntitiesE) {
		this.moblEntitiesE = moblEntitiesE;
	}



	public void findAllSearch(){
		System.err.println(searchTxt);
		System.err.println("IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
		this.moblEntities.clear();
		try {
			
			this.moblEntities.addAll(sellerServiceLocal.findSellerByNamePerLike(searchTxt));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void findAllSearchFilter(){
		System.err.println(filter);
		System.err.println("IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
		this.moblEntities.clear();
		this.moblEntitiesE.clear();
		try {
			
			this.moblEntities.addAll(sellerServiceLocal.findSellerByFilter(searchTxt, filter));
			this.moblEntitiesE.addAll(sellerServiceLocal.findSellerByFilterE(searchTxt, filter));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
