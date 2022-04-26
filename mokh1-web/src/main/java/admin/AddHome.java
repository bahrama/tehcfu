package admin;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.io.IOUtils;

import entity.HomeEntity;
import sevice.HomeServiceLocal;

@Named
@RequestScoped
public class AddHome {

	public AddHome() {
		// TODO Auto-generated constructor stub
	} 
	@Inject
	private HomeServiceLocal homeServiceLocal;

	@Size(max=2 , message="max size is 2")
	@NotNull
	private String name;
	private Part pic;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Part getPic() {
		return pic;
	}
	public void setPic(Part pic) {
		this.pic = pic;
	}
	
	public void insertHomeCat() {
		try {
		FacesContext context = FacesContext.getCurrentInstance();
		HomeEntity homeEntity=new HomeEntity();
		homeEntity.setName(name);
		homeEntity.setPicId(this.picture());
		homeServiceLocal.insertHomeEntity(homeEntity);
		context.addMessage(null, new FacesMessage("با موفقیت وارد گردید."));
		}catch (Exception e) {
			e.printStackTrace();
		}
		}
	
	public String picture() throws Exception {
		try {
			UUID uuid=UUID.randomUUID();
			byte[] image1Byte = IOUtils.toByteArray(pic.getInputStream());
			File out3 = new File("/home/wildfly/AX/" + uuid + ".jpg");
			InputStream in = new ByteArrayInputStream(image1Byte);
			BufferedImage img3 = ImageIO.read(in);
			ImageIO.write(img3, "jpg", out3);
			return uuid.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new Exception("error image entering");
		}
	}
	
}
