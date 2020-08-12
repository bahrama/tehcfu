package ui;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import catch_db.CatchBlogLocal;
import catch_db.CatchHomeLocal;
import catch_db.CatchSellerLocal;
import entity.BazdidEntity;
import entity.BlogEntity;
import entity.HomeEntity;
import entity.MoblEntity;
import sevice.BazdidServiceLocal;
import sevice.SellerServiceLocal;

@Named("homeBean")
@SessionScoped
public class HomeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HomeBean() {
		// TODO Auto-generated constructor stub
	}

	@Inject
	private BazdidServiceLocal bazdidService;
	@Inject
	private CatchHomeLocal catchHomeLocal;
	private List<HomeEntity> homeEntities = new ArrayList<>();
	@Inject
	private CatchBlogLocal catchBlogLocal;
	@Inject
	private CatchSellerLocal catchSellerLocal;
	@Inject
	private FacesContext facesContext;
	@Inject
	private HttpSession session;
	private MoblEntity moblEntity = new MoblEntity();
	@Inject
	private SellerServiceLocal sellerServiceLocal;
	

	private List<BlogEntity> blogEntities = new ArrayList<>();

	private String user = "";
	private String mobile = "";
	private BazdidEntity bazdidEntity = new BazdidEntity();

	@PostConstruct
	public void init() {	
		try {
			bazdidService.findBazdidEntityById(1);
		} catch (Exception e1) {
			BazdidEntity bazdidEntity=new BazdidEntity();
			bazdidEntity.setBazdidNumber(1);
			bazdidService.insertToBazdid(bazdidEntity);
		}
		
		try {
		
		FacesContext contex = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) contex.getExternalContext().getRequest();
    	
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
		    ipAddress = request.getRemoteAddr();
		}
		System.err.println("ipAddress:" + ipAddress);
		bazdidEntity=bazdidService.findBazdidEntityById(1);
 
		
		if(ipAddress.startsWith("2.144.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("2.176.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("5.22.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("5.22.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("5.23.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("5.34.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("5.52.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("5.53.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("5.56.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("5.57.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("5.61.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("5.62.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("5.63.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("5.72.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("5.78.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("5.104.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("5.106.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("5.112.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("5.134.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("5.134.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("5.144.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("5.145.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("5.159.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("5.160.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("5.182.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("5.190.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("5.198.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("5.200.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("5.201.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("5.202.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("5.208.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("5.226.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("5.232.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("5.250.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("31.2.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("31.7.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("31.14.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("31.24.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("31.25.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("31.29.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("31.40.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("31.47.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("31.56.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("31.130.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("31.170.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("31.171.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("31.184.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("31.193.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("31.214.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("31.214.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("31.217.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("37.9.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("37.10.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("37.19.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("37.27.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}


			if(ipAddress.startsWith("37.32.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("37.44.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("37.49.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("37.63.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("37.75.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("37.98.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("37.114.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("37.128.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("37.129.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("37.130.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("37.137.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("37.143.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("37.148.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("37.152.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("37.153.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}



			if(ipAddress.startsWith("37.156.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("37.191.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("37.202.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("37.221.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}



			if(ipAddress.startsWith("37.228.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("37.235.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("37.254.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("46.18.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("46.21.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("46.28.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("46.32.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("46.34.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}



			if(ipAddress.startsWith("46.36.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("46.38.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("46.41.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("46.51.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("46.62.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("46.100.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}


			if(ipAddress.startsWith("46.102.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("46.143.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("46.148.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("46.164.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("46.167.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("46.182.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("46.209.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("46.224.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("46.235.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("46.245.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("46.248.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("46.249.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("46.251.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("46.255.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("62.60.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("62.102.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("62.193.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("62.220.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("66.79.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("77.36.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("77.42.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("77.77.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}



			if(ipAddress.startsWith("77.81.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("77.104.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("77.237.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("77.238.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("77.245.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("78.31.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("78.38.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("78.109.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("78.110.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("78.111.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("78.154.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("78.157.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("78.158.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("79.127.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("79.132.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("79.174.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("79.175.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("80.66.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("80.71.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("80.75.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("80.191.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("80.210.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("80.242.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("80.249.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("80.250.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("80.253.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("81.12.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("81.16.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("81.28.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("81.29.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("81.31.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("81.90.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("81.91.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("81.163.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("82.97.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("82.99.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("82.115.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("83.120.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("83.147.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("83.150.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("84.47.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("84.241.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("85.9.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("85.15.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("85.133.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("85.185.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("85.198.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("85.204.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("85.208.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("85.239.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("86.55.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("86.57.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("86.104.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("86.105.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("86.106.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}


			if(ipAddress.startsWith("86.107.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("86.109.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("87.107.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("87.247.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("87.248.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("87.251.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("88.135.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("89.32.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("89.33.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("89.34.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("89.35.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("89.36.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("89.37.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("89.38.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("89.39.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("89.40.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("89.41.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("89.42.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("89.43.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("89.44.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("89.45.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("89.46.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("89.47.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("89.144.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("89.165.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("89.184.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("89.196.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("89.198.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("89.219.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("89.221.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("89.235.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("91.92.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("91.98.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("91.106.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("91.108.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("91.109.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("91.133.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("91.147.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("91.184.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("91.185.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("91.186.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("91.190.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("91.206.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("91.207.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("91.208.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("91.209.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("91.212.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("91.216.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("91.217.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("91.220.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("91.222.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("91.224.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("91.225.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("91.226.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("91.227.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("91.228.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("91.229.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("91.230.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("91.232.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("91.233.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("91.236.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("91.237.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("91.238.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}


			if(ipAddress.startsWith("91.239.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("91.240.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("91.241.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("91.242.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("91.243.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("91.244.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("91.245.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("91.247.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("91.250.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("91.251.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("92.42.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("92.43.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("92.50.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("92.61.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("92.114.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("92.242.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("92.246.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("92.249.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("93.88.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("93.110.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("93.113.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("93.114.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("93.115.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("93.117.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("93.118.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("93.119.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("93.126.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("93.190.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}


			if(ipAddress.startsWith("94.24.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("94.74.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("94.101.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("94.139.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}



			if(ipAddress.startsWith("94.176.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("94.177.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("94.182.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("94.184.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("94.199.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("94.232.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("94.241.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("95.38.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("95.64.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("95.80.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("95.81.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("95.82.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("95.130.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("95.142.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("95.156.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("95.162.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("95.215.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("103.215.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("103.216.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("103.231.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("109.72.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("109.74.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("109.94.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("109.95.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("109.108.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("109.109.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("109.110.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("109.111.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("109.122.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("109.125.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("109.162.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("109.201.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("109.203.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("109.206.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("109.225.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("109.230.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("109.232.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("109.238.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("109.239.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("113.203.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("128.65.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("128.140.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("130.185.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("130.255.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("134.255.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("146.66.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("151.232.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("151.238.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("151.240.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("157.119.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("158.58.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("159.20.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("164.138.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("164.215.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("172.80.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("176.12.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("176.46.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("176.56.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("176.62.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("176.65.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("176.67.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("176.101.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("176.102.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("176.110.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("176.112.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("176.122.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("176.123.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("176.124.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("176.221.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("176.223.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("178.21.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("178.22.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("178.131.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("178.157.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("178.169.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("178.173.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("178.215.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("178.216.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("178.219.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("178.236.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("178.238.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("178.239.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("178.248.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("178.251.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("178.252.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("178.253.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.1")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.2.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.3.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.4.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.5.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.8.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.10.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.11.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.12.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.13.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.14.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.16.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.18.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.20.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.21.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.22.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.23.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.24.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.25.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.26.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.29.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.30.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.31.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.32.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.34.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.37.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.39.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.40.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.41.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.42.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.44.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.45.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.46.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.47.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.49.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.50.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.51.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.53.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.55.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.56.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.57.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.58.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.59.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.60.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.62.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.63.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.64.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.66.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.67.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.69.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.70.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
	
			if(ipAddress.startsWith("185.71.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.72.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.73.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.74.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.75.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.76.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.78.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.79.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.80.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.81.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.82.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.83.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.84.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.85.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.86.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.88.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.89.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.92.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.93.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.94.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.95.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.96.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.97.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.98.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.99.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.100.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.101.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.103.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.104.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.105.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.106.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}


			if(ipAddress.startsWith("185.107.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.108.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.109.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.110.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.111.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.112.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.113.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.114.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.115.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}


			if(ipAddress.startsWith("185.116.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.117.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.118.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.119.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.120.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.121.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.122.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.123.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}


			if(ipAddress.startsWith("185.124.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.125.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.126.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.127.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.128.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}


			if(ipAddress.startsWith("185.129.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.130.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.131.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.132.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.133.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.134.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.135.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.136.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.137.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.139.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.140.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.141.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.142.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}


			if(ipAddress.startsWith("185.143.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.144.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.145.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.147.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.148.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.150.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.151.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.153.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.154.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.155.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.156.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.157.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.158.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.159.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.160.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}


			if(ipAddress.startsWith("185.161.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.162.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.163.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.164.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.165.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.166.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.167.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.168.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.169.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.170.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.171.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.172.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.173.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}


			if(ipAddress.startsWith("185.174.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.175.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.176.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.177.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.178.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.179.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.180.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.181.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.182.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.183.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.184.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.185.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
	
			if(ipAddress.startsWith("185.186.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.187.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.188.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.189.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.190.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.191.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.192.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.193.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.194.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.195.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.196.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.197.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.198.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.199.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.201.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.202.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.203.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.204.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.205.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.206.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.207.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.208.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.209.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.210.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.211.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.212.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.213.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.214.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.215.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.216.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.217.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.219.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.220.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.221.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.222.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.224.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.225.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.226.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.227.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.228.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.229.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.231.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.231.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.232.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.233.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.234.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}


			if(ipAddress.startsWith("185.235.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.236.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.237.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.238.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.239.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.240.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.243.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.244.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.246.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.249.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("185.251.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("185.255.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("188.0.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("188.34.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("188.75.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("188.118.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("188.121.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("188.122.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("188.136.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("188.158.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("188.191.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("188.208.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("188.209.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("188.210.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("188.211.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("188.212.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}


			if(ipAddress.startsWith("188.213.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("188.214.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}



			if(ipAddress.startsWith("188.215.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("188.229.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}


			if(ipAddress.startsWith("188.240.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("188.245.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("188.253.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("192.15.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("193.8.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("193.19.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("193.32.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("193.34.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("193.35.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("193.104.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("193.105.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("193.148.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("193.151.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("193.176.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("193.178.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("193.189.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("193.201.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("193.222.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("193.242.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("194.5.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("194.26.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}


			if(ipAddress.startsWith("194.33.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("194.34.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("194.39.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("194.41.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}

			if(ipAddress.startsWith("194.60.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("194.143.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("194.146.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("194.147.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("194.150.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("194.156.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("194.225.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("195.20.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("195.88.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("195.110.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("195.146.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("195.170.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("195.181.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("195.191.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("195.211.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("195.238.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("195.245.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("196.3.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("212.1.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("212.16.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("212.33.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("212.80.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("212.86.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("212.120.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("213.108.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("213.109.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("213.176.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			if(ipAddress.startsWith("213.195.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
		///////////////////////////////////
			
			if(ipAddress.startsWith("213.207.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			
			if(ipAddress.startsWith("213.217.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			
			if(ipAddress.startsWith("213.232.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			
			
			if(ipAddress.startsWith("213.233.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			
			
			if(ipAddress.startsWith("217.11.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			
			if(ipAddress.startsWith("217.24.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			
			if(ipAddress.startsWith("217.25.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			
			if(ipAddress.startsWith("217.60.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			
			if(ipAddress.startsWith("217.66.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			
			if(ipAddress.startsWith("217.77.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			////////////////////////////////////////
			if(ipAddress.startsWith("217.146.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			
			if(ipAddress.startsWith("217.170.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			
			if(ipAddress.startsWith("217.171.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			
			
			if(ipAddress.startsWith("217.172.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			
			if(ipAddress.startsWith("217.174.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			
			if(ipAddress.startsWith("217.218.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			
			if(ipAddress.startsWith("192.168.")){
			bazdidEntity.setBazdidNumber(bazdidEntity.getBazdidNumber()+1);
			bazdidService.updateBazdidEntity(bazdidEntity);
			}
			
			
		
		Cookie[] userCookies = request.getCookies();
		String tehcfuCookie = "";
		if (userCookies != null && userCookies.length > 0) {
			for (int i = 0; i < userCookies.length; i++) {
				if (userCookies[i].getName().equals("tehcfu")) {
					// System.err.println(userCookies[i]);
					tehcfuCookie = userCookies[i].getValue();
					break;
				}
			}
		}
		System.err.println(tehcfuCookie);
		this.moblEntity=sellerServiceLocal.findSellerByToken(tehcfuCookie);
		session.setAttribute("mobile" ,moblEntity.getMobile());
		catchSellerLocal.getOnlineUsers().add(moblEntity);
		System.err.println(catchSellerLocal.getOnlineUsers().size());
		System.err.println("UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
		System.err.println(catchSellerLocal.getOnlineUsers().size());
		System.err.println("UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
		System.err.println(catchSellerLocal.getOnlineUsers().size());
		System.err.println("UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
		System.err.println(catchSellerLocal.getOnlineUsers().size());
		System.err.println("UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
		System.err.println(catchSellerLocal.getOnlineUsers().size());
		System.err.println("UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
		
		}catch (Exception e) {
		System.err.println("token not find");
		}
	}

	public byte[] findHomeCatByName(String name) {
		HomeEntity homeEntity2 = new HomeEntity();
		for (HomeEntity homeEntity : catchHomeLocal.getHomeEntities()) {
			if (homeEntity.getName().equals(name))
				homeEntity2 = homeEntity;
		}
		return this.findPic1(homeEntity2);

	}

	public byte[] findPic1(HomeEntity homeEntity) {
		try {
			File imageFile1 = new File("/home/wildfly/AX/" + homeEntity.getPicId().toString() + ".jpg");
			BufferedImage image1 = ImageIO.read(imageFile1);
			ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
			ImageIO.write(image1, "jpg", baos1);
			return baos1.toByteArray();
		} catch (Exception e) {
			return null;
		}
	}

	public List<HomeEntity> findAllSlide() {
		for (HomeEntity homeEntity : catchHomeLocal.getHomeEntities()) {
			if (homeEntity.getName().equals("اسلاید")) {
				this.homeEntities.add(homeEntity);
			}
		}
		return this.homeEntities;
	}

	public byte[] findHomeCatById(int id) {
		HomeEntity homeEntity2 = new HomeEntity();
		for (HomeEntity homeEntity : catchHomeLocal.getHomeEntities()) {
			if (homeEntity.getId() == id)
				homeEntity2 = homeEntity;
		}
		return this.findPic1(homeEntity2);

	}

	public List<BlogEntity> findAllPassage() {
        blogEntities.clear();
		for (BlogEntity blogEntity : catchBlogLocal.getBlogEntities()) {
			if (blogEntity.getBlogType().equals("مجتمع تجاری")) {
				blogEntities.add(blogEntity);
			}
		}
		return blogEntities;
	}

	public byte[] findPassagePic(BlogEntity blogEntity) {
		try {
			File imageFile1 = new File("/home/wildfly/AX/" + blogEntity.getPic1().toString() + ".jpg");
			BufferedImage image1 = ImageIO.read(imageFile1);
			ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
			ImageIO.write(image1, "jpg", baos1);
			return baos1.toByteArray();
		} catch (Exception e) {
			return null;
		}
	}

	public byte[] findPassageById(int id) {
		BlogEntity blogEntity2 = new BlogEntity();
		for (BlogEntity blogEntity : blogEntities) {
			if (blogEntity.getId() == id)
				blogEntity2 = blogEntity;
		}
		return this.findPassagePic(blogEntity2);
	}

	public String findUserByToken() {
		try {
			// this.user=session.getAttribute("user").toString();
			this.mobile = session.getAttribute("mobile").toString();
			// System.err.println(user);
			System.err.println(mobile);
			return mobile;
		} catch (Exception e) {
			return "مهمان";
		}
	}
	@PreDestroy
	public void destroying() {
		catchSellerLocal.getOnlineUsers().remove(moblEntity);
	}

	public String logout() {
		HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		Cookie cookie2 = new Cookie("tehcfu", "");
		cookie2.setPath("/");
		response.addCookie(cookie2);
		catchSellerLocal.getOnlineUsers().remove(moblEntity);
		return "/pages/main/home.xhtml?faces-redirect=true";
	}

	public long findBazdid() {
		return bazdidEntity.getBazdidNumber();
	}

}
