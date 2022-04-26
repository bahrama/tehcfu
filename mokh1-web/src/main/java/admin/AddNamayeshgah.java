package admin;

import javax.faces.view.ViewScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.servlet.http.Part;
import javax.validation.constraints.Size;

import org.apache.commons.io.IOUtils;

import entity.NamayeshgahEntity;
import sevice.NamayeshgahServiceLocal;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.UUID;

@Named
@ViewScoped
public class AddNamayeshgah implements Serializable {

	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;

	public AddNamayeshgah() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private NamayeshgahServiceLocal namayeshgahServiceLocal;
	
	@Size(max=100 , message="max size is 100")
	private String name;
	@Size(max=100 , message="max size is 100")
	private String city;
	@Size(max=100 , message="max size is 100")
	private String country;
	@Size(max=100 , message="max size is 100")
	private String tarikh;
	@Size(max=300 , message="max size is 300")
	private String makan;
	@Size(max=100 , message="max size is 100")
	private String nameBargozarK;
	@Size(max=100 , message="max size is 100")
	private String phoneModirNazer;
	@Size(max=100 , message="max size is 100")
	private String nameModirNazer;
	@Size(max=100 , message="max size is 100")
	private String fax;
	@Size(max=100 , message="max size is 100")
	private String phone;
	@Size(max=100 , message="max size is 100")
	private String email;
	@Size(max=100 , message="max size is 100")
	private String site;
	@Size(max=100 , message="max size is 2")
	private String type;
	private Part pic;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTarikh() {
		return tarikh;
	}
	public void setTarikh(String tarikh) {
		this.tarikh = tarikh;
	}
	public String getMakan() {
		return makan;
	}
	public void setMakan(String makan) {
		this.makan = makan;
	}
	public String getNameBargozarK() {
		return nameBargozarK;
	}
	public void setNameBargozarK(String nameBargozarK) {
		this.nameBargozarK = nameBargozarK;
	}
	public String getPhoneModirNazer() {
		return phoneModirNazer;
	}
	public void setPhoneModirNazer(String phoneModirNazer) {
		this.phoneModirNazer = phoneModirNazer;
	}
	public String getNameModirNazer() {
		return nameModirNazer;
	}
	public void setNameModirNazer(String nameModirNazer) {
		this.nameModirNazer = nameModirNazer;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Part getPic() {
		return pic;
	}
	public void setPic(Part pic) {
		this.pic = pic;
	}
	
	public void insertToNamayeshgah() {
		try {
		NamayeshgahEntity namayeshgahEntity=new NamayeshgahEntity();
		namayeshgahEntity.setCity(city);
		namayeshgahEntity.setCountry(country);
		namayeshgahEntity.setEmail(email);
		namayeshgahEntity.setFax(fax);
		namayeshgahEntity.setMakan(makan);
		namayeshgahEntity.setName(name);
		namayeshgahEntity.setNameBargozarK(nameBargozarK);
		namayeshgahEntity.setNameModirNazer(nameModirNazer);
		namayeshgahEntity.setPhone(phone);
		namayeshgahEntity.setPhoneModirNazer(phoneModirNazer);
		namayeshgahEntity.setSite(site);
		namayeshgahEntity.setTarikh(tarikh);
		namayeshgahEntity.setType(type);
		namayeshgahEntity.setPic(picture());
		namayeshgahServiceLocal.insertNamayeshgahEntity(namayeshgahEntity);
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
			throw new Exception("error image entering 1");
		}
		
	}

}
