package ui;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.MoblEntity;
import sevice.SellerServiceLocal;

@Named
@ViewScoped
public class RentViewBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RentViewBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private SellerServiceLocal sellerServiceLocal;
	
	
	public List<MoblEntity> findAllSeller(){
		return sellerServiceLocal.findAllSeller();
	}

}
