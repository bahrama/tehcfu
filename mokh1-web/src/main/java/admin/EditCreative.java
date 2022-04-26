package admin;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.CreativeEntity;
import sevice.CreativeServiceLocal;

@Named
@ViewScoped
public class EditCreative implements Serializable {

	/**
	 *   
	 */
	private static final long serialVersionUID = 1L;

	public EditCreative() {
		// TODO Auto-generated constructor stub
	}
	
	@Inject
	private CreativeServiceLocal creativeServiceLocal;

	public List<CreativeEntity> findAllCreative(){
		return creativeServiceLocal.findAllCreativeEntity();
	}
	
	public void deleteCreative(int id) {
		try {
			creativeServiceLocal.deleteCreativeEntity(creativeServiceLocal.findCreativeEntityById(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
