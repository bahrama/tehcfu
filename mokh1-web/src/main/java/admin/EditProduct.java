package admin;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;

import entity.ProductEntity;
import sevice.ProductserviceLocal;

@ViewScoped
@Named
public class EditProduct implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EditProduct() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private ProductserviceLocal productserviceLocal;
	
	//private ProductEntity productEntity=new ProductEntity();
	private String status;
	
	
	
	
	


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
//
//	public ProductEntity getProductEntity() {
//		return productEntity;
//	}
//
//	public void setProductEntity(ProductEntity productEntity) {
//		this.productEntity = productEntity;
//	}

	public List<ProductEntity> findAllProduct(){
		return productserviceLocal.findAllProductEntity();
	}
	
	public void deleteProduct(long id) {
		try {
			productserviceLocal.deleteProductEntity(productserviceLocal.findProductEntityById(id));
			 FacesContext.getCurrentInstance().getExternalContext().redirect("/pages/admin/edit-product.xhtml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public byte[] findPic1() throws IOException {
//		try {
//		File imageFile1=new File("/home/wildfly/AX/" + this.productEntity.getPic1() + ".jpg");
//		BufferedImage image1=ImageIO.read(imageFile1);
//		ByteArrayOutputStream baos1=new ByteArrayOutputStream();
//		ImageIO.write(image1, "jpg", baos1);
//		return baos1.toByteArray();
//		}catch (Exception e) {
//			return null;
//		}
//	}
//	
//	public byte[] findPic2() throws IOException {
//		try {
//		File imageFile1=new File("/home/wildfly/AX/" + this.productEntity.getPic2() + ".jpg");
//		BufferedImage image1=ImageIO.read(imageFile1);
//		ByteArrayOutputStream baos1=new ByteArrayOutputStream();
//		ImageIO.write(image1, "jpg", baos1);
//		return baos1.toByteArray();
//		}catch (Exception e) {
//			return null;
//		}
//	}
//	
//	public byte[] findPic3() throws IOException {
//		try {
//		File imageFile1=new File("/home/wildfly/AX/" + this.productEntity.getPic3() + ".jpg");
//		BufferedImage image1=ImageIO.read(imageFile1);
//		ByteArrayOutputStream baos1=new ByteArrayOutputStream();
//		ImageIO.write(image1, "jpg", baos1);
//		return baos1.toByteArray();
//		}catch (Exception e) {
//			return null;
//		}
//	}
//	
//	public byte[] findPic4() throws IOException {
//		try {
//		File imageFile1=new File("/home/wildfly/AX/" + this.productEntity.getPic4() + ".jpg");
//		BufferedImage image1=ImageIO.read(imageFile1);
//		ByteArrayOutputStream baos1=new ByteArrayOutputStream();
//		ImageIO.write(image1, "jpg", baos1);
//		return baos1.toByteArray();
//		}catch (Exception e) {
//			return null;
//		}
//	}
//	
//	public byte[] findPic5() throws IOException {
//		try {
//		File imageFile1=new File("/home/wildfly/AX/" + this.productEntity.getPic5() + ".jpg");
//		BufferedImage image1=ImageIO.read(imageFile1);
//		ByteArrayOutputStream baos1=new ByteArrayOutputStream();
//		ImageIO.write(image1, "jpg", baos1);
//		return baos1.toByteArray();
//		}catch (Exception e) {
//			return null;
//		}
//	}
//	
//public void updateProduct() {
//	FacesContext context = FacesContext.getCurrentInstance();
//	try {
//		System.err.println("--------------" + status + "---------------");
//	this.productEntity.setStatus(Boolean.parseBoolean(status));
//	productserviceLocal.updateProductEntity(this.productEntity);
//	context.addMessage(null, new FacesMessage("با موفقیت آپدیت گردید."));
//	}catch (Exception e) {
//		e.printStackTrace();
//	}
//}

private String gregorian_to_jalali(int gy, int gm, int gd) {
	String text2 = "";
	int[] g_d_m = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334 };
	int jy;
	if (gy > 1600) {
		jy = 979;
		gy -= 1600;
	} else {
		jy = 0;
		gy -= 621;
	}
	int gy2 = (gm > 2) ? (gy + 1) : gy;
	int days = (365 * gy) + ((int) ((gy2 + 3) / 4)) - ((int) ((gy2 + 99) / 100)) + ((int) ((gy2 + 399) / 400)) - 80
			+ gd + g_d_m[gm - 1];
	jy += 33 * ((int) (days / 12053));
	days %= 12053;
	jy += 4 * ((int) (days / 1461));
	days %= 1461;
	if (days > 365) {
		jy += (int) ((days - 1) / 365);
		days = (days - 1) % 365;
	}
	int jm = (days < 186) ? 1 + (int) (days / 31) : 7 + (int) ((days - 186) / 30);
	int jd = 1 + ((days < 186) ? (days % 31) : ((days - 186) % 30));
	int[] out = { jy, jm, jd };
	// return out;
	// return null;
	// return jy + "-" + jm + "-" + jd;

	String month1 = "";
	if (jm == 1)
		month1 = "فروردین";
	else if (jm == 2)
		month1 = "اردیبهشت";
	else if (jm == 3)
		month1 = "خرداد";
	else if (jm == 4)
		month1 = "تیر";
	else if (jm == 5)
		month1 = "مرداد";
	else if (jm == 6)
		month1 = "شهریور";
	else if (jm == 7)
		month1 = "مهر";
	else if (jm == 8)
		month1 = "آبان";
	else if (jm == 9)
		month1 = "آذر";
	else if (jm == 10)
		month1 = "دی";
	else if (jm == 11)
		month1 = "بهمن";
	else if (jm == 12)
		month1 = "اسفند";
	text2 = jd + " / " + jm + " / " + jy;
	return text2;
}

public String findPersianDate(Date date) {
	try {
		String dateEng = date.toString();
		char[] mnth = new char[3];
		dateEng.getChars(4, 7, mnth, 0);
		String month = "";
		for (char c : mnth) {
			month += c;
		}
		System.err.println(month);
		int month1 = 0;
		if (month.equals("Jan"))
			month1 = 1;
		else if (month.equals("Feb"))
			month1 = 2;
		else if (month.equals("Mar"))
			month1 = 3;
		else if (month.equals("Apr"))
			month1 = 4;
		else if (month.equals("May"))
			month1 = 5;
		else if (month.equals("Jun"))
			month1 = 6;
		else if (month.equals("Jul"))
			month1 = 7;
		else if (month.equals("Aug"))
			month1 = 8;
		else if (month.equals("Sep"))
			month1 = 9;
		else if (month.equals("Oct"))
			month1 = 10;
		else if (month.equals("Nov"))
			month1 = 11;
		else if (month.equals("Dec"))
			month1 = 12;

		char[] dy = new char[2];
		dateEng.getChars(8, 10, dy, 0);
		String day = "";
		for (char c : dy) {
			day += c;
		}

		int day1 = Integer.parseInt(day);

		char[] yer = new char[4];
		dateEng.getChars(25, 29, yer, 0);
		String year = "";
		for (char c : yer) {
			year += c;
		}
		int year1 = Integer.parseInt(year);
		return gregorian_to_jalali(year1, month1, day1);
	} catch (Exception e) {
		return "";
	}

}

}
