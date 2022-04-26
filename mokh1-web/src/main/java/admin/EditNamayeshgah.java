package admin;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.NamayeshgahEntity;
import sevice.NamayeshgahServiceLocal;

@Named
@ViewScoped
public class EditNamayeshgah implements Serializable {

	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;

	public EditNamayeshgah() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private NamayeshgahServiceLocal namayeshgahServiceLocal;
	
	
	public List<NamayeshgahEntity> findAllNamayeshgah(){
		return namayeshgahServiceLocal.findAllNamayeshgahEntity();
	}
	
	
	public void deleteNamayeshgah(int id) {
		try {
			namayeshgahServiceLocal.deleteNamayeshgahEntity(namayeshgahServiceLocal.findNamayeshgahEntityById(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
