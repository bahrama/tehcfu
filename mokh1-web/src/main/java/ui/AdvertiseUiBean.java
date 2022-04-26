package ui;

import java.io.Serializable;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.AdvertiseDaoLocal;
import entity.AdvertiseEntity;

@ViewScoped
@Named
public class AdvertiseUiBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdvertiseUiBean() {
		// TODO Auto-generated constructor stub
	}
	
	@Inject
	private AdvertiseDaoLocal advertiseDaoLocal;

	 public Map<AdvertiseEntity, Object> findAllAdvertiseByTypeMap(String advertiseType){
		 return advertiseDaoLocal.findAllAdvertiseByTypeMap(advertiseType);
	 }
	
}
