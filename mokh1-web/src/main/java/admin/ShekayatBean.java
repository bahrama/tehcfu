package admin;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.io.IOUtils;

import entity.Shekayat1;
import sevice.ShekayatServiceLocal;

@Named("shekayaAdmin")
@SessionScoped
public class ShekayatBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ShekayatBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private ShekayatServiceLocal shekayatServiceLocal;

	public List<Shekayat1> findAllShekayat(){
		return shekayatServiceLocal.findAllShekayat();
	}
	
	public Shekayat1 findShekayatById(long id) {
		try {
			return shekayatServiceLocal.findShekayatById(id);
		} catch (Exception e) {
			System.err.println("shekayat by id not find");
			return null;
		}
	}
	
	
	
	

	
}
