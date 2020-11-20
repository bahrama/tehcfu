package validationpkj;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

@FacesValidator(value="validationpkj.ImageValidator")
public class ImageValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
			Part file=(Part) value;	
			 FacesMessage message=null;
			 
		        try {
		        	 
		            if (file==null || file.getSize()>=100000 || file.getContentType().isEmpty() )
		                message=new FacesMessage("حجم فایل باید کمتر از ۱۰۰ کیلو بایت باشد");
		            else if ((!file.getContentType().equals("image/jpeg"))) {
		            	System.err.println(file.getContentType().toString());
		            	message= new FacesMessage(FacesMessage.SEVERITY_ERROR, "فرمت مناسب با پسوند jpg وارد نمایید", "jpg");}
		            if (message!=null && !message.getDetail().isEmpty())
		                {
		                    message.setSeverity(FacesMessage.SEVERITY_ERROR);
		                    throw new ValidatorException(message );
		                }
		 
		        } catch (Exception ex) {
		               throw new ValidatorException(new FacesMessage(ex.getMessage()));
		        }
		
	}

}
