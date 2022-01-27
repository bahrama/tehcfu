package ui;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;

import catch_db.CatchCreativeLocal;
import entity.BlogEntity;
import entity.CreativeEntity;
import sevice.CreativeServiceLocal;

@Named
@ViewScoped
public class CreativeDetalPage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CreativeDetalPage() {
		// TODO Auto-generated constructor stub
	}
//	@Inject
//	private CatchCreativeLocal catchCreativeLocal;
	@Inject
	private CreativeServiceLocal creativeServiceLocal;
	
	private CreativeEntity creativeEntity=new CreativeEntity();
	
	public CreativeEntity findCreativeById(int id) {
//		for (CreativeEntity creativeEntity : catchCreativeLocal.getCreativeEntities()) {
//			if(creativeEntity.getId()==id)
//				this.creativeEntity=creativeEntity;
//		}
//		return this.creativeEntity;
		try {
			this.creativeEntity=creativeServiceLocal.findCreativeEntityById(id);
			return creativeEntity;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	

	
	public String findCreativePic1() {
		try {
		return this.creativeEntity.getPic1().toString();
		}catch (Exception e) {
			return null;
		}
	}
	
	public String findCreativePic2() {
				try {
				return this.creativeEntity.getPic2().toString();
				}catch (Exception e) {
					return null;
				}
	}
	
	public String findCreativePic3() {
		try {
		return this.creativeEntity.getPic3().toString();
		}catch (Exception e) {
			return null;
		}
	}
	
	public String findCreativePic4() {
			try {
			return this.creativeEntity.getPic4().toString();
			}catch (Exception e) {
				return null;
			}
	}
	
	public String findCreativePic5() {
		try {
		return this.creativeEntity.getPic5().toString();
		}catch (Exception e) {
			return null;
		}
	}
	
	public String findCreativePic6() {
		try {
		return this.creativeEntity.getPic6().toString();
		}catch (Exception e) {
			return null;
		}
	}
	

	
}
