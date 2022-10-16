package ui;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;

import catch_db.CatchNamayeshgahLocal;
import entity.BlogEntity;
import entity.NamayeshgahEntity;
import sevice.NamayeshgahServiceLocal;

@Named
@ViewScoped
public class NamayeshgahDetailPage implements Serializable {

	/**
	 * 
	 */ 
	private static final long serialVersionUID = 1L;

	public NamayeshgahDetailPage() {
		// TODO Auto-generated constructor stub
	}

//	@Inject
//	private CatchNamayeshgahLocal catchNamayeshgahLocal;
	@Inject
	private NamayeshgahServiceLocal namayeshgahServiceLocal;

	private List<NamayeshgahEntity> namayeshgahEntitiesIran = new ArrayList<>();
	private List<NamayeshgahEntity> namayeshgahEntitiesJahan = new ArrayList<>();

	public List<NamayeshgahEntity> getNamayeshgahEntitiesIran() {
		return namayeshgahEntitiesIran;
	}

	public void setNamayeshgahEntitiesIran(List<NamayeshgahEntity> namayeshgahEntitiesIran) {
		this.namayeshgahEntitiesIran = namayeshgahEntitiesIran;
	}

	public List<NamayeshgahEntity> getNamayeshgahEntitiesJahan() {
		return namayeshgahEntitiesJahan;
	}

	public void setNamayeshgahEntitiesJahan(List<NamayeshgahEntity> namayeshgahEntitiesJahan) {
		this.namayeshgahEntitiesJahan = namayeshgahEntitiesJahan;
	}

	@PostConstruct
	public void init() {
		//for (NamayeshgahEntity namayeshgahEntity : catchNamayeshgahLocal.getNamayeshgahEntities()) {
		//	if (namayeshgahEntity.getType().equals("A"))
				try {
					this.namayeshgahEntitiesIran.addAll(namayeshgahServiceLocal.findNamayeshgahEntityByType("A"));
					this.namayeshgahEntitiesJahan.addAll(namayeshgahServiceLocal.findNamayeshgahEntityByType("B"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		//	else
				
	//	}
//		Collections.reverse(namayeshgahEntitiesIran);
//		Collections.reverse(namayeshgahEntitiesJahan);

	}

	public byte[] findNamayeshgahPicById(int id) {
//		NamayeshgahEntity namayeshgahEntity2 = new NamayeshgahEntity();
//		for (NamayeshgahEntity namayeshgahEntity : catchNamayeshgahLocal.getNamayeshgahEntities()) {
//			if (namayeshgahEntity.getId() == id)
//				namayeshgahEntity2 = namayeshgahEntity;
//		}
		try {
			return this.findPic1(namayeshgahServiceLocal.findNamayeshgahEntityById(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public byte[] findPic1(NamayeshgahEntity namayeshgahEntity) {
		try {
			File imageFile1 = new File("/home/wildfly/wildfly-18.0.1.Final/fimg/" + namayeshgahEntity.getPic().toString() + ".jpg");
			BufferedImage image1 = ImageIO.read(imageFile1);
			ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
			ImageIO.write(image1, "jpg", baos1);
			return baos1.toByteArray();
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<NamayeshgahEntity> checkNamayeshgah(String type){
		if(type.equals("A"))
			return this.namayeshgahEntitiesIran;
		else 
			return this.namayeshgahEntitiesJahan;
	}

}
