package search;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.MoblEntity;
import sevice.SearchMapServiceLocal;


@Named
@RequestScoped
public class SearchMapBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4267365486724137411L;

	public SearchMapBean() {
		// TODO Auto-generated constructor stub
	}


	@Inject
	private SearchMapServiceLocal searchMapServiceLocal;
	

	public List<MoblEntity> operation(double lat, double lng) {
        return searchMapServiceLocal.operation(lat, lng);
	}
	
	public List<MoblEntity> operation2(double lat, double lng , String raste) {
		System.err.println(raste);
        return searchMapServiceLocal.operation2(lat, lng , raste);
	}

}
