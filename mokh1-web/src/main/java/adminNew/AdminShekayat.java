package adminNew;

import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.primefaces.model.file.UploadedFile;

import entity.Shekayat1;
import help.FileConvertor;
import panel.TempBean;
import sevice.ShekayatServiceLocal;

@ViewScoped
@Named
public class AdminShekayat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminShekayat() {
		// TODO Auto-generated constructor stub
	}
	
	@Inject
	private ShekayatServiceLocal shekayatServiceLocal;
	@Inject
	private AdminProfile profile;

	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	@NotNull(message = "فیلد نباید خالی باشد")
	@NotEmpty(message = "فیلد نباید خالی باشد")
	@Size(max = 100, min = 2, message = "حداقل ۲ و حداکثر ۱۰۰")
	private String vahedeSenfiName;
	@NotNull(message = "فیلد نباید خالی باشد")
	@NotEmpty(message = "فیلد نباید خالی باشد")
	@Size(max = 100, min = 2, message = "حداقل ۲ و حداکثر ۱۰۰")
	private String motesadiName;
	@NotNull(message = "فیلد نباید خالی باشد")
	@NotEmpty(message = "فیلد نباید خالی باشد")
	@Size(max = 100, min = 2, message = "حداقل ۲ و حداکثر ۱۰۰")
	private String vahedeSenfiPhone;
	@NotNull(message = "فیلد نباید خالی باشد")
	@NotEmpty(message = "فیلد نباید خالی باشد")
	@Size(max = 100, min = 2, message = "حداقل ۲ و حداکثر ۱۰۰")
	private String vahedeSenfiMobile;
	@Size(max = 100, message = " حداکثر ۱۰۰")
	private String vahedeShenaseSenfi;
	@Size(max = 100, message = "حداکثر ۱۰۰")
	private String vahedeSenfiPostCode;
	@Size(max = 500, min = 2, message = "حداقل ۲ و حداکثر ۵۰۰")
	private String vahedeShenaseAddres;
	@NotNull(message = "فیلد نباید خالی باشد")
	@NotEmpty(message = "فیلد نباید خالی باشد")
	@Size(max = 500, min = 2, message = "حداقل ۲ و حداکثر ۱۰۰")
	private String shekayatTitle;
	@Size(max = 5000, min = 2, message = "حداقل ۲ و حداکثر ۵۰۰۰")
	private String sharh;
	private String maraje;
	private List<String> marajes=new ArrayList<>();
	private UploadedFile shakiFactor;
	private UploadedFile shakiSsnPic;
	private UploadedFile shakiKalaPic;
	private UIComponent pic1EditComponent;
	private UIComponent pic2EditComponent;
	private UIComponent pic3EditComponent;

	public ShekayatServiceLocal getShekayatServiceLocal() {
		return shekayatServiceLocal;
	}
	public void setShekayatServiceLocal(ShekayatServiceLocal shekayatServiceLocal) {
		this.shekayatServiceLocal = shekayatServiceLocal;
	}
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	public String getVahedeSenfiName() {
		return vahedeSenfiName;
	}
	public void setVahedeSenfiName(String vahedeSenfiName) {
		this.vahedeSenfiName = vahedeSenfiName;
	}
	public String getMotesadiName() {
		return motesadiName;
	}
	public void setMotesadiName(String motesadiName) {
		this.motesadiName = motesadiName;
	}
	public String getVahedeSenfiPhone() {
		return vahedeSenfiPhone;
	}
	public void setVahedeSenfiPhone(String vahedeSenfiPhone) {
		this.vahedeSenfiPhone = vahedeSenfiPhone;
	}
	public String getVahedeSenfiMobile() {
		return vahedeSenfiMobile;
	}
	public void setVahedeSenfiMobile(String vahedeSenfiMobile) {
		this.vahedeSenfiMobile = vahedeSenfiMobile;
	}
	public String getVahedeShenaseSenfi() {
		return vahedeShenaseSenfi;
	}
	public void setVahedeShenaseSenfi(String vahedeShenaseSenfi) {
		this.vahedeShenaseSenfi = vahedeShenaseSenfi;
	}
	public String getVahedeSenfiPostCode() {
		return vahedeSenfiPostCode;
	}
	public void setVahedeSenfiPostCode(String vahedeSenfiPostCode) {
		this.vahedeSenfiPostCode = vahedeSenfiPostCode;
	}
	public String getVahedeShenaseAddres() {
		return vahedeShenaseAddres;
	}
	public void setVahedeShenaseAddres(String vahedeShenaseAddres) {
		this.vahedeShenaseAddres = vahedeShenaseAddres;
	}
	public String getShekayatTitle() {
		return shekayatTitle;
	}
	public void setShekayatTitle(String shekayatTitle) {
		this.shekayatTitle = shekayatTitle;
	}
	public String getSharh() {
		return sharh;
	}
	public void setSharh(String sharh) {
		this.sharh = sharh;
	}
	public UploadedFile getShakiFactor() {
		return shakiFactor;
	}
	public void setShakiFactor(UploadedFile shakiFactor) {
		this.shakiFactor = shakiFactor;
	}
	public UploadedFile getShakiSsnPic() {
		return shakiSsnPic;
	}
	public void setShakiSsnPic(UploadedFile shakiSsnPic) {
		this.shakiSsnPic = shakiSsnPic;
	}
	public UploadedFile getShakiKalaPic() {
		return shakiKalaPic;
	}
	public void setShakiKalaPic(UploadedFile shakiKalaPic) {
		this.shakiKalaPic = shakiKalaPic;
	}
	public UIComponent getPic1EditComponent() {
		return pic1EditComponent;
	}
	public void setPic1EditComponent(UIComponent pic1EditComponent) {
		this.pic1EditComponent = pic1EditComponent;
	}
	public UIComponent getPic2EditComponent() {
		return pic2EditComponent;
	}
	public void setPic2EditComponent(UIComponent pic2EditComponent) {
		this.pic2EditComponent = pic2EditComponent;
	}
	public UIComponent getPic3EditComponent() {
		return pic3EditComponent;
	}
	public void setPic3EditComponent(UIComponent pic3EditComponent) {
		this.pic3EditComponent = pic3EditComponent;
	}
	public String getMaraje() {
		return maraje;
	}
	public void setMaraje(String maraje) {
		this.maraje = maraje;
	}
	public List<String> getMarajes() {
		return marajes;
	}
	public void setMarajes(List<String> marajes) {
		this.marajes = marajes;
	}
	
	private String faaliatHa() {
		String item="";
		for (String string : this.marajes) {
			item=item +string + "-";
		}
		return item;
	}
	
    public String convertPicture(UploadedFile uploadedFile) {
    	try {
			return FileConvertor.convertPicture(uploadedFile);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }

	public void inserToShekayat() {
		try {
			Random random = new Random();
			int code = random.nextInt(999999999);
			Shekayat1 shekayat1 = new Shekayat1();
			shekayat1.setMotesadiName(motesadiName);
			shekayat1.setSharh(sharh);
			shekayat1.setDate(new Date());
			shekayat1.setShekayatTitle(shekayatTitle);
			shekayat1.setVahedeSenfiMobile(vahedeSenfiMobile);
			shekayat1.setVahedeSenfiName(vahedeSenfiName);
			shekayat1.setVahedeSenfiPhone(vahedeSenfiPhone);
			shekayat1.setVahedeSenfiPostCode(vahedeSenfiPostCode);
			shekayat1.setVahedeShenaseAddres(vahedeShenaseAddres);
			shekayat1.setVahedeShenaseSenfi(vahedeShenaseSenfi);
			shekayat1.setShomare(code);
			shekayat1.setMaraje(faaliatHa());
			if (this.shakiFactor != null) {
                if (!this.shakiFactor.getContentType().equals("image/jpeg")) {
					throw new Exception("pic1Type");
				} else {
					shekayat1.setPicPath(convertPicture(shakiFactor));
				}
			}
			if (this.shakiKalaPic != null) {
                if (!this.shakiKalaPic.getContentType().equals("image/jpeg")) {
					throw new Exception("pic2Type");
				} else {
					shekayat1.setShakiKalaPic(convertPicture(shakiKalaPic));
				}
			}
			if (this.shakiSsnPic != null) {
				System.err.println(shakiSsnPic.getContentType());
				System.err.println(shakiSsnPic.getFileName());
				System.err.println(shakiSsnPic.getSize());
                if (!this.shakiSsnPic.getContentType().equals("image/jpeg")) {
					throw new Exception("pic3Type");
				} else {
					shekayat1.setShakiSsnPic(convertPicture(shakiSsnPic));
				}
			}
			shekayat1.setShaki(profile.getMoblEntity());
			shekayatServiceLocal.inserToShekayat(shekayat1);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("با موفقیت ثبت گردید."));
			this.motesadiName = "";
			this.sharh = "";
			this.shekayatTitle = "";
			this.vahedeSenfiMobile = "";
			this.vahedeSenfiName = "";
			this.vahedeSenfiPhone = "";
			this.vahedeSenfiPostCode = "";
			this.vahedeShenaseAddres = "";
			this.vahedeShenaseSenfi = "";
			
		} catch (Exception e) {
	    	if(e.getMessage().equals("pic1Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic1EditComponent.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic21Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic2EditComponent.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic3Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic3EditComponent.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage()==null)
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));
		}

	}

	
	
	

}
