package security;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.authentication.mechanism.http.RememberMe;

@CustomFormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(
                loginPage = "/pages/login/signin-phone.xhtml",
                errorPage="/pages/login/error.xhtml",
                useForwardToLogin = false
            )
)
@FacesConfig
@Named
@ApplicationScoped
public class AplicationConfig {

	public AplicationConfig() {
		// TODO Auto-generated constructor stub
	}

}
