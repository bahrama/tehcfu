package ui;

import java.io.Serializable;
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
	@Inject
	private BlogServiceLocal blogServiceLocal;
	
	private String searchText;
	
	
	
	public String getSearchText() {
		return searchText;
	}



	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}



	public void findAllSearch(){
		try {
			for (MoblEntity moblEntity : sellerServiceLocal.findSellerByNamePerLike(searchText)) {
				System.err.println(moblEntity.getSellerStorePer());
			}
			for (BlogEntity blogEntity : blogServiceLocal.findBlogByName(searchText)) {
				System.err.println(blogEntity.getBlogName());
			}
		  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
