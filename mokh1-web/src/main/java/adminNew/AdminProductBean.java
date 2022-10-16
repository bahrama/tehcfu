package adminNew;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.validation.constraints.Size;

import org.primefaces.model.file.UploadedFile;

import dao.AyeneVConsoleDaoLocal;
import dao.DarbChobiDaoLocal;
import dao.DarbZedSergatDaoLocal;
import dao.GhabAxDaoLocal;
import dao.KabinetDaoLocal;
import dao.KomodBoofeKetabkhaneJakafshiDaoLocal;
import dao.MdfDaoLocal;
import dao.MizAsaliDaoLocal;
import dao.MizEdariDaoLocal;
import dao.MizJeloMobliDaoLocal;
import dao.MizNaharKhoriDaoLocal;
import dao.MizTvDaoLocal;
import dao.MoblmanDaoLocal;
import dao.MojasameDaoLocal;
import dao.MonabatDaoLocal;
import dao.PanjareDaoLocal;
import dao.PartitionDaoLocal;
import dao.ProductDaoLocal;
import dao.SandaliEdariDaoLocal;
import dao.ServiceKhab1DaoLocal;
import dao.ServiceKhab2DaoLocal;
import dao.ServiceKhabKodakDaoLocal;
import entity.AyeneVConsole;
import entity.BlogEntity;
import entity.DarbChobi;
import entity.DarbZedSergat;
import entity.GhabAx;
import entity.Kabinet;
import entity.KomodBoofeKetabkhaneJakafshi;
import entity.Mdf;
import entity.MizAsali;
import entity.MizEdari;
import entity.MizJeloMobli;
import entity.MizNaharKhori;
import entity.MizTv;
import entity.Moblman;
import entity.Mojasame;
import entity.Monabat;
import entity.Panjare;
import entity.Partition;
import entity.ProductEntity;
import entity.SandaliEdari;
import entity.ServiceKhab1;
import entity.ServiceKhab2;
import entity.ServiceKhabKodak;
import help.FileConvertor;
import help.TimeCovnertor;
import panel.TempBean;
import sevice.ProductserviceLocal;

@Named
@ViewScoped
public class AdminProductBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminProductBean() {
		// TODO Auto-generated constructor stub
	}

	@Inject
	private ProductserviceLocal productserviceLocal; 
	@Inject
	private ProductDaoLocal productDaoLocal;
	
	@Inject
	private AyeneVConsoleDaoLocal ayeneVConsoleDaoLocal;
	@Inject
	private DarbChobiDaoLocal darbChobiDaoLocal;
	@Inject
	private DarbZedSergatDaoLocal darbZedSergatDaoLocal;
	@Inject
	private GhabAxDaoLocal ghabAxDaoLocal;
	@Inject
	private KabinetDaoLocal kabinetDaoLocal;
	@Inject
	private KomodBoofeKetabkhaneJakafshiDaoLocal komodBoofeKetabkhaneJakafshiDaoLocal;
	@Inject
	private MdfDaoLocal mdfDaoLocal;
	@Inject
	private MizAsaliDaoLocal mizAsaliDaoLocal;
	@Inject
	private MizEdariDaoLocal mizEdariDaoLocal;
	@Inject
	private MizJeloMobliDaoLocal mizJeloMobliDaoLocal;
	@Inject
	private MizNaharKhoriDaoLocal mizNaharKhoriDaoLocal;
	@Inject
	private MizTvDaoLocal mizTvDaoLocal;
	@Inject
	private MoblmanDaoLocal moblmanDaoLocal;
	@Inject
	private MojasameDaoLocal mojasameDaoLocal;
	@Inject
	private MonabatDaoLocal monabatDaoLocal;
	@Inject
	private PanjareDaoLocal panjareDaoLocal;
	@Inject
	private PartitionDaoLocal partitionDaoLocal;
	@Inject
	private SandaliEdariDaoLocal sandaliEdariDaoLocal;
	@Inject
	private ServiceKhab1DaoLocal serviceKhab1DaoLocal;
	@Inject
	private ServiceKhab2DaoLocal serviceKhab2DaoLocal;
	@Inject
	private ServiceKhabKodakDaoLocal serviceKhabKodakDaoLocal;
	
	
	@Inject
	private AdminProfile adminProfile;
	private String panelShow="ayeneVconsole";
	
	private UploadedFile pic1;
	private UploadedFile pic2;
	private UploadedFile pic3;
	private UploadedFile pic4;
	private UploadedFile pic5;
	private UIComponent pic1Component;
	private UIComponent pic2Component;
	private UIComponent pic3Component;
	private UIComponent pic4Component;
	private UIComponent pic5Component;
	
	private List<String> faaliats=new ArrayList<String>();
	
	@Size(min = 1 ,max=100,message="حداکثر 100 کاراکتر")
	private String nameCode;
	@Size(max=100,message="حداکثر 100 کاراکتر")
	private String brand;
	@Size(max=100,message="حداکثر 100 کاراکتر")
	private String contry;
	@Size(max=100,message="حداکثر 100 کاراکتر")
	private String raste;
	@Size(max=100,message="حداکثر 100 کاراکتر")
	private String abad;
	@Size(max=3000,message="حداکثر 3000 کاراکتر")
	private String description;
	//mojod
	private String status;
	private Integer TahvilDay=1;
	private String easyNezafat;
	private Long price=(long) 1000;
	private Long price2=(long) 1000;
	private String oldNew;
	@Size(max=200,message="حداکثر 200 کاراکتر")
	private String zemanat;
	@Size(max=50,message="حداکثر 50 کاراکتر")
	private String guarantiStatus;
	private Integer guaranyTimeMounth=1;
	@Size(max=200,message="حداکثر 200 کاراکتر")
	private String rangBandi;
	@Size(max=2000,message="حداکثر 2000 کاراکتر")
	private String aparat;
	@Size(max=7000,message="حداکثر 7000 کاراکتر")
	private String instagram;
	///////////////////////////////////////////ayenevconsole/////////////////
	
		@Size(max=100,message="حداکثر 100 کاراکتر")
		private String jenseEskeletConsole;
		@Size(max=100,message="حداکثر 100 کاراکتر") 
		private String jensePayeConsole;
	    private Long priceConsole=(long) 1000;
	    private String keshoConsole;
		private Integer tedadKesho=1;
		private String komodConsole;
	    private Integer tedadKomod=1;
		private String ayeneConsole;
		private Integer tedadAyene=1;
	    @Size(max=100,message="حداکثر 100 کاراکتر") 
	    private String shekleHendesi;
	    @Size(max=100,message="حداکثر 100 کاراکتر") 
	    private String zekhamatAyene;
	    private String ayeneGhab;
	    @Size(max=100,message="حداکثر 100 کاراکتر") 
	    private String jenseGhab;
	    @Size(max=100,message="حداکثر 100 کاراکتر") 
	    private String abadGhabAyene;
	    @Size(max=100,message="حداکثر 100 کاراکتر") 
	    private String rangGhabAyene;
	    private Long priceGhabAyene=(long) 1000;
	
	//////////////////////DarbChobi////////////////////////
	     @Size(max=100,message="حداکثر 100 کاراکتر") 
		 private String rokeshDarbChobi;
	     @Size(max=100,message="حداکثر 100 کاراکتر") 
		 private String noeRangDarbChobi;
	     @Size(max=100,message="حداکثر 100 کاراکتر") 
		 private String zekhamatDarbChobi; 
	     @Size(max=100,message="حداکثر 100 کاراکتر")  
	     private String jenseKalafDarbChobi;
		 @Size(max=100,message="حداکثر 100 کاراکتر")  
	     private String makanDarbChobi;
		 //boolean
		 private String cncDarbChobi;
	     //boolean
		 private String zedeAbDarbChobi;
		 //boolean
		 private String shostoshoDarbChobi;
	////////////////////DarbZedSergat
		 @Size(max=100,message="حداکثر 100 کاراکتر")  
		 private String nameMdfDarbZedSergat;
		  
		  @Size(max=100,message="حداکثر 100 کاراکتر")  
		  private String zekhamatMdfDarbZedSergat;
		  
		  @Size(max=100,message="حداکثر 100 کاراکتر")  
		  private String keshvarMdfDarbZedSergat;
		  
		  @Size(max=100,message="حداکثر 100 کاراکتر")  
		  private String varagFeleziDarbZedSergat;
		  
		  //bool   
		  private String gotiBandiFeleziDarbZedSergat;
		  
		  @Size(max=100,message="حداکثر 100 کاراکتر")  
		  private String zekhamatVaragFeleziDarbZedSergat;
		  //bool
		  private String cncDarbZedSergat;
		  
		  //bool
          private String metrilJelogiriDarbZedSergat;
		  
		  //bool 
          private String sedagiriDarbZedSergat;
		  
		  //bool 
          private String goflPostchiDarbZedSergat;
		  
		  
		  //bool
          private String nasbPostchiDarbZedSergat;
		  
		  //bool
          private String zedeAbDarbZedSergat;
		  
		  //bool
          private String zedeDeylamDarbZedSergat;
		  
          @Size(max=100,message="حداکثر 100 کاراکتر")  
          private String rokeshDarbZedSergat;
		  
          @Size(max=100,message="حداکثر 100 کاراکتر") 
          private String rangDarbZedSergat;
          
          ///////////////////////////////GhabAx
          
          @Size(max=100,message="حداکثر 100 کاراکتر")  
          private String jenseGabeAx;
    	  
          @Size(max=100,message="حداکثر 100 کاراکتر")  
          private String abadGabeAx;
    	  
          @Size(max=100,message="حداکثر 100 کاراکتر")  
          private String abadMofidGabeAx;
          
          //////////////////////////Kabinet
          
          @Size(max=100,message="حداکثر 100 کاراکتر") 
          private String jenseKabinet;
   	  
          @Size(max=100,message="حداکثر 100 کاراکتر") 
          private String jenseSafeKabinet;
   	  
          @Size(max=100,message="حداکثر 100 کاراکتر") 
          private String noeMdfKabinet;
   	  
          @Size(max=100,message="حداکثر 100 کاراکتر") 
          private String zekhamateMdfKabinet;
   	  
          @Size(max=100,message="حداکثر 100 کاراکتر") 
          private String abadMdfKabinet;
   	  
   	  //bool
          private String dastgireDarbKabinet;
   	  //bool
          private String reylKabinet;
   	  //bool
          private String jakKabinet;
   	  //bool 
          private String payeKabinet;
   	  //bool
          private String magnetKabinet;
   	  //bool
          private String charkhKabinet;
   	      private Long priceMetrKabinet = (long) 1000;
          private Long priceMetrTakhfifKabinet = (long) 1000;
          
         ///////////////////////////KomodBoofeKetabkhaneJakafshi
          
          @Size(max=100,message="حداکثر 100 کاراکتر") 
          private String shekleHendesikomod;
          @Size(max=100,message="حداکثر 100 کاراکتر") 
          private String shekleHendesiBoofe;
          @Size(max=100,message="حداکثر 100 کاراکتر") 
   	      private String shekleHendesiKetabkhane;
          @Size(max=100,message="حداکثر 100 کاراکتر") 
          private String shekleHendesiJakafshi;
          @Size(max=100,message="حداکثر 100 کاراکتر") 
          private String jensekomod;
          @Size(max=100,message="حداکثر 100 کاراکتر") 
          private String jenseBoofe;
          @Size(max=100,message="حداکثر 100 کاراکتر") 
          private String jenseKetabkhane;
          @Size(max=100,message="حداکثر 100 کاراکتر") 
          private String jenseJakafshi;
          @Size(max=100,message="حداکثر 100 کاراکتر") 
          private String abadkomod;
          @Size(max=100,message="حداکثر 100 کاراکتر") 
          private String abadBoofe;
          @Size(max=100,message="حداکثر 100 کاراکتر") 
          private String abadKetabkhane;
          @Size(max=100,message="حداکثر 100 کاراکتر") 
          private String abadJakafshi;
   	      private Long pricekomod = (long) 1000;
    	  private Long priceBoofe = (long) 1000;
   	      private Long priceKetabkhane = (long) 1000;
   	      private Long priceJakafshi = (long) 1000;
   	      private Integer tedadkomod = 0;
   	      private Integer tedadBoofe = 0;
   	      private Integer tedadKetabkhane = 0;
   	      private Integer tedadJakafshi = 0;
   	      
   	      //////////////////////////Mdf
   		
   	     @Size(max=100,message="حداکثر 100 کاراکتر") 
   	     private String zekhametMdf;
   		  
   	     @Size(max=100,message="حداکثر 100 کاراکتر") 
   	     private String abadMdf;
   		  
   		 private Long priceMetrMdf = (long) 1000;
   		  
   		 private Long priceTakhfifMetrMdf = (long) 1000;
   		 
   		 ////////////////////////////MizAsali
   		 
   		 @Size(max=100,message="حداکثر 100 کاراکتر") 
   	     private String sheklehendesiMizJeJeloAsali;
   	  
   	     private Integer tedadMizJeJeloAsali = 0;
   	  
   	   @Size(max=100,message="حداکثر 100 کاراکتر") 
   	   private String jenseEskeletMizJeJeloAsali;
   	  
   	   @Size(max=100,message="حداکثر 100 کاراکتر") 
   	   private String jensePayeMizJeJeloAsali;
   	  
   	  //bool
   	   private String shisheMizJeJeloAsali;
   	  
   	   @Size(max=100,message="حداکثر 100 کاراکتر") 
   	   private String noeShisheMizJeJeloAsali;
   	  
   	   private Long priceShisheMizJeJeloAsali = (long) 1000;
   	  
       @Size(max=1000,message="حداکثر 1000 کاراکتر") 
   	   private String descriptionMizJeJeloAsali;
       
       //////////////////////////////////MizEdari
       
        @Size(max=100,message="حداکثر 100 کاراکتر") 
	    private String sheklehendesiMizٍEdari;
	    private Integer tedadChantekeMizٍEdari=0;
	    @Size(max=100,message="حداکثر 100 کاراکتر") 
	    private String jenseEskeletMizٍEdari;
	    @Size(max=100,message="حداکثر 100 کاراکتر") 
	    private String jensePayeMizٍEdari;
	    //bool
	    private String shisheMizٍEdari;
	    @Size(max=100,message="حداکثر 100 کاراکتر") 
	    private String noeShisheMizٍEdari;
	    private Long priceShisheMizٍEdari = (long) 1000;
	    //bool
	    private String shisheAbzarMizٍEdari;
        //bool
	    private String keshoMizٍEdari;
	    private Integer tedadkeshoMizٍEdari = 0;
	    //bool
	    private String komodMizٍEdari;
	    private Integer tedadkomodMizٍEdari=0;
	    //bool
	    private String fazayeLavazemJanebiMizٍEdari;
	    @Size(max=1000,message="حداکثر 1000 کاراکتر") 
	    private String descriptionfazayeLavazemJanebiMizٍEdari;
	    
	    //////////////////////////MizJeloMobli
   		  
	    @Size(max=100,message="حداکثر 100 کاراکتر") 
		  private String sheklehendesiMizJeloMobli;
		  
		   private Integer tedadMizJeloMobli = 0;
		  
		   @Size(max=100,message="حداکثر 100 کاراکتر") 
		  private String jenseEskeletMizJeloMobli;
		  
		   @Size(max=100,message="حداکثر 100 کاراکتر") 
		   private String jensePayeMizJeloMobli;
		  
		   @Size(max=100,message="حداکثر 100 کاراکتر") 
		   private String abadMizJeloMobli;
		  
		   @Size(max=100,message="حداکثر 100 کاراکتر") 
		   private String rangMizJeloMobli;
		  
		   private Long priceMizJeloMobli=(long) 1000;
		   //bool
		   private String  shisheMizJeloMobli;
		  
		   @Size(max=100,message="حداکثر 100 کاراکتر") 
		   private String noeShisheMizJeloMobli;
		  
		   private Long priceShisheMizJeloMobli=(long) 1000;
		  //bool
		   private String shisheAbzarMizJeloMobli;
		   
		   ///////////////////////////MizNaharKhori
		   
		   private Integer tedadMizNaharKhori = 0;
			  
		   @Size(max=100,message="حداکثر 100 کاراکتر") 
		   private String sakhtarMizNaharKhori;
			  
		   @Size(max=1000,message="حداکثر 1000 کاراکتر") 
			  private String descriptionMizNaharKhori;
			  
		   @Size(max=100,message="حداکثر 100 کاراکتر") 
			  private String sheklehendesiMizNaharKhori;
			  
		   @Size(max=100,message="حداکثر 100 کاراکتر") 
			  private String jenseSafeMizNaharKhori;
			  
		   @Size(max=100,message="حداکثر 100 کاراکتر") 
			  private String jenseEskeletMizNaharKhori;
			  
		   @Size(max=100,message="حداکثر 100 کاراکتر") 
			  private String jensePayeMizNaharKhori;
			  
			  //bool
			  private String shisheMizNaharKhori;
			  
			  @Size(max=100,message="حداکثر 100 کاراکتر") 
			  private String rangeShisheMizNaharKhori;
			  
			  @Size(max=100,message="حداکثر 100 کاراکتر") 
			  private String zekhamatShisheMizNaharKhori;
			  
			  private Long priceShisheMizNaharKhori = (long) 1000;
			  //bool
			   private String shisheAbzarMizNaharKhori;
			  
			  private Integer tedadSandaliMizNaharKhori=0;
			  
			  @Size(max=100,message="حداکثر 100 کاراکتر") 
			  private String jenseFomSandaliMizNaharKhori;
			  
			  @Size(max=100,message="حداکثر 100 کاراکتر") 
			  private String jenseEsfangSandaliMizNaharKhori;
			  
			  @Size(max=100,message="حداکثر 100 کاراکتر") 
			  private String jenseEskeletSandaliMizNaharKhori;
			  
			  @Size(max=100,message="حداکثر 100 کاراکتر") 
			  private String jensePayeSandaliMizNaharKhori;
			  
			  //bool
			  private String payeSandaliRangMizNaharKhori;
			  
			  @Size(max=100,message="حداکثر 100 کاراکتر") 
			  private String rangPayeSandaliMizNaharKhori;
			  
			  @Size(max=100,message="حداکثر 100 کاراکتر") 
			  private String jenseParcheSandaliMizNaharKhori;
			  
			  @Size(max=100,message="حداکثر 100 کاراکتر") 
			  private String nameParcheSandaliMizNaharKhori;
			  
			  //bool
			  private String rangSelParcheSandaliMizNaharKhori;
			  
			  @Size(max=100,message="حداکثر 100 کاراکتر") 
			  private String rangParcheSandaliMizNaharKhori;
			  
			  /////////////////////////////////MizTv
			  @Size(max=100,message="حداکثر 100 کاراکتر") 
			  private String jenseEskeletMizTv;
			  
			  @Size(max=100,message="حداکثر 100 کاراکتر") 
			  private String abadMizTv;
			  
			  private Integer mizMarbotTvInch = 0;
			  
			  @Size(max=100,message="حداکثر 100 کاراکتر") 
			  private String rangMizTv;
			  
			  //bool
			  private String gabeliatRangMizTv;
			  
			  @Size(max=100,message="حداکثر 100 کاراکتر") 
			  private String rangAvalMizTv;
			  
			  @Size(max=100,message="حداکثر 100 کاراکتر") 
			  private String rangDovomMizTv;
			  
			 //bool
			  private String kesho;

			  private Integer tedadkesho = 0;
			  
			  @Size(max=100,message="حداکثر 100 کاراکتر") 
			  private String jensePayeMizTv;
			  
			  @Size(max=100,message="حداکثر 100 کاراکتر") 
			  private String rangPayeMizTv;
			  
			  //bool
			  private String fazayeLavazemJanebi;
			  
			  @Size(max=1000,message="حداکثر 1000 کاراکتر") 
			  private String descriptionLavazemJanebi;
			  
			  /////////////////////////Moblman
			  
			  @Size(max=100,message="حداکثر 100 کاراکتر") 
			  private String noeMobl;
				  
			 private Integer tedadMobl = 0;
				  
			 @Size(max=100,message="حداکثر 100 کاراکتر")
			 private String sakhtarMobl;
				  
			 @Size(max=100,message="حداکثر 100 کاراکتر")
			 private String jenseFome;
				  
			 @Size(max=100,message="حداکثر 100 کاراکتر")
			 private String jenseEsfanj;
				  
			 @Size(max=100,message="حداکثر 100 کاراکتر")
			 private String jenseEskelet;
				  
			 @Size(max=100,message="حداکثر 100 کاراکتر")
			 private String jensePaye;
				  //bool
			 private String enetekhabRangPaye;
				  
			 @Size(max=100,message="حداکثر 100 کاراکتر")
			 private String rangPaye;
				  
			 @Size(max=100,message="حداکثر 100 کاراکتر")
			 private String jenseParche;
				  
			 @Size(max=100,message="حداکثر 100 کاراکتر")
			 private String nameParche;
				  
			//bool
			 private String enetekhabRangParche;
				  
			 @Size(max=100,message="حداکثر 100 کاراکتر")
			 private String rangParche;
				  //bool
			 private String mekanizmTakhtsho;
				  
			 @Size(max=1000,message="حداکثر 1000 کاراکتر")
				  private String descriptionMekanizmTakhtsho;
				//bool
			   private String kosan;
				  
				  private Integer tedadKosan=0;
				  
				  @Size(max=100,message="حداکثر 100 کاراکتر")
				  private String abadKosanBozorg;
				  
				  @Size(max=100,message="حداکثر 100 کاراکتر")
				  private String abadKosanKochak;
				  
				  @Size(max=100,message="حداکثر 100 کاراکتر")
				  private String modelKosan;
				  
				  @Size(max=100,message="حداکثر 100 کاراکتر")
				  private String jenseParcheKosan;
				  
				  @Size(max=100,message="حداکثر 100 کاراکتر")
				  private String rangeParcheKosan;
				  //bool
				  private String miz;
				  
			      private Integer tedadMiz = 0;
				  
			      @Size(max=100,message="حداکثر 100 کاراکتر")
			      private String abadMiz;
			      
			      //////////////////////////////Mojasame
			  
			      @Size(max=100,message="حداکثر 100 کاراکتر")
			      private String jenseMojasame;
				  
			      @Size(max=100,message="حداکثر 100 کاراکتر")
			      private String abadMojasame;
				  //bool
				  private String shostoshoMojasame;
				  
				  ///////////////////////////// Monabat
				  
				  @Size(max=100,message="حداکثر 100 کاراکتر")
				  private String nameMdfMonabat;
				  
				  @Size(max=100,message="حداکثر 100 کاراکتر")
				  private String zekhamatMdfMonabat;
				  
				  @Size(max=100,message="حداکثر 100 کاراکتر")
				  private String keshvarMdfMonabat;
				  
				  @Size(max=100,message="حداکثر 100 کاراکتر")
				  private String noeMonabat;
				  
				  @Size(max=100,message="حداکثر 100 کاراکتر")
				  private String abadMonabat;
				  
				  @Size(max=100,message="حداکثر 100 کاراکتر")
				  private String jenseMonabat;
				  
				  ///////////////////Panjare
				  
				  @Size(max=100,message="حداکثر 100 کاراکتر")
				  private String metrialPanjare;
				  
				  @Size(max=100,message="حداکثر 100 کاراکتر")
				  private String noeRangPanjare;
				  
				  @Size(max=100,message="حداکثر 100 کاراکتر")
				  private String jenseKalafPanjare;
				  
				  @Size(max=100,message="حداکثر 100 کاراکتر")
				  private String makanPanjare;
				  
				  //bool
                  private String cncPanjare;
				  
				  //bool
                  private String zedeAbPanjare;
				  
				  //bool
                  private String shostoshoPanjare;
                  
                  ///////////////////////Partition
                  
                  @Size(max=100,message="حداکثر 100 کاراکتر")
                  private String jenseSotonPartishen;
           	  
                  @Size(max=100,message="حداکثر 100 کاراکتر")
                  private String jensePanelPartishen;
           	  
                  @Size(max=100,message="حداکثر 100 کاراکتر")
                  private String jenseLabePartishen;
           	  
                  @Size(max=100,message="حداکثر 100 کاراکتر")
                  private String rangPartishen;
           	      //bool
           	      private String tarkibiPartishen;
           	  
           	      @Size(max=100,message="حداکثر 100 کاراکتر") 
           	      private String noeTarkibPartishen;
           	  
           	      //bool
           	      private boolean ejrayePardePartishen;
           	  
           	      @Size(max=100,message="حداکثر 100 کاراکتر") 
           	      private String rangPardePartishen;
           	  
           	      private Long priceMetrPartishen = (long) 1000;
           	  
           	      private Long priceTakhfifMetrPartishen = (long) 1000;
           	      
           	      ////////////////////////////SandaliEdari
           	      
           	   @Size(max=100,message="حداکثر 100 کاراکتر") 
           	   private String noeJenseSandaliEdari;
           		  
           	@Size(max=100,message="حداکثر 100 کاراکتر") 
           	private String abadSandaliEdari;
           		  
           	@Size(max=100,message="حداکثر 100 کاراکتر") 
           	private String rangSandaliEdari;
           		  
           	@Size(max=100,message="حداکثر 100 کاراکتر") 
           	private String jensePayeSandaliEdari;
           		  
           		 //bool
           	private String dasteSandaliEdari;
           		  
           	@Size(max=100,message="حداکثر 100 کاراکتر") 
           	private String noeSandaliEdari;
           		  
           		//bool
           	private String tebiSandaliEdari;
           	
           	//////////////////////////ServiceKhab1
           	
           	@Size(max=100,message="حداکثر 100 کاراکتر") 
           	private String modelServiceKhab;
      	 
      	    private Integer arzeTakhteKhab=0;
      	  @Size(max=100,message="حداکثر 100 کاراکتر") 
      	  private String jenseTakhtKhab;
      	  
      	@Size(max=100,message="حداکثر 100 کاراکتر") 
      	private String rangTakhtKhab;
      	  
      	   private Long priceTakhtKhab = (long) 1000;
      	  
      	 //bool
      	   private String kalafTakhtJakDar;
      	  //bool
      	   private String keshovbox;
      	//bool
      	private String patakhti;
      	
      	private Integer tedadPaTakhti=0;
      	@Size(max=100,message="حداکثر 100 کاراکتر") 
      	private String jensePaTakhti;
      	  
      	@Size(max=100,message="حداکثر 100 کاراکتر") 
      	private String abadPaTakhti;
      	  
      	@Size(max=100,message="حداکثر 100 کاراکتر") 
      	private String rangPaTakhti;
      	  
      	 private Long pricePaTakhti = (long) 1000;
      	//bool 
      	private String komodServiceKhab;
      	@Size(max=100,message="حداکثر 100 کاراکتر") 
      	private String jenseKomodServiceKhab;
      	@Size(max=100,message="حداکثر 100 کاراکتر") 
      	private String abadKomodServiceKhab;
      	@Size(max=100,message="حداکثر 100 کاراکتر") 
      	private String rangKomodServiceKhab;
      	 private Long priceKomodServiceKhab = (long) 1000;
      	  
      	 //bool
      	 private String mizArayesh;
      	 //bool
      	 private String sandaliServiceKhab;
      	  
      	@Size(max=100,message="حداکثر 100 کاراکتر") 
      	private String jenseMizArayesh;
      	@Size(max=100,message="حداکثر 100 کاراکتر") 
      	private String abadMizArayesh;
      	  
      	@Size(max=100,message="حداکثر 100 کاراکتر") 
      	private String rangMizArayesh;
      	  
      	 private Long priceMizArayesh = (long) 1000;
      	  
      	 //bool
      	 private String mizTahrir;
      	@Size(max=100,message="حداکثر 100 کاراکتر") 
      	private String jenseMizTahrir;
      	  
      	@Size(max=100,message="حداکثر 100 کاراکتر") 
      	private String abadMizTahrir;
      	  
      	@Size(max=100,message="حداکثر 100 کاراکتر") 
      	private String rangMizTahrir;
      	  
      	  private Long priceMizTahrir = (long) 1000;
      	  
      	//bool
      	  private String gabVayeneGadi;
      	  
      	@Size(max=100,message="حداکثر 100 کاراکتر") 
      	private String jenseGabVayeneGadi;
      	@Size(max=100,message="حداکثر 100 کاراکتر") 
      	private String abadGabVayeneGadi;
      	@Size(max=100,message="حداکثر 100 کاراکتر") 
      	private String rangGabVayeneGadi;
      	 private Long priceGabVayeneGadi = (long) 1000;
      	  
      	 //bool
      	 private String toshak;
      	@Size(max=100,message="حداکثر 100 کاراکتر") 
      	private String brandToshak;
      	  
      	@Size(max=100,message="حداکثر 100 کاراکتر") 
      	private String modelToshak;
      	  private Integer modatGharantiToshak =0;
      	  
      	@Size(max=100,message="حداکثر 100 کاراکتر") 
      	private String abadToshak;
      	  
      	 private Long priceToshak = (long) 1000;
      	  
      	@Size(max=1000,message="حداکثر 1000 کاراکتر") 
      	  private String tozihatToshak;
      	
      	////////////////////ServiceKhab2
      	
      	@Size(max=100,message="حداکثر 100 کاراکتر") 
      	private String modelServiceKhab2;

      	private Integer arzeTakhteKhab2 = 0;
   	  
      	@Size(max=100,message="حداکثر 100 کاراکتر") 
      	private String jenseTakhteKhab2;
   	  
      	@Size(max=100,message="حداکثر 100 کاراکتر") 
      	private String rangeTakhteKhab2;
   	  
   	   private Long priceTakhteKhab2 =(long) 1000;
   	  
   	   //bool
   	   private String kalafTakhtJackDar;
   	  
   	  //bool
   	   private String keshoVbox;
   	  
   	  //bool
   	   private String paTahti2;
   	  
   	   private Integer tedadPaTakhti2=0;
   	  
   	@Size(max=100,message="حداکثر 100 کاراکتر") 
   	private String jensePaTakhti2;
   	  
   	@Size(max=100,message="حداکثر 100 کاراکتر") 
   	private String abadPaTakhti2;
   	  
   	@Size(max=100,message="حداکثر 100 کاراکتر") 
   	private String rangPaTakhti2;
   	  
   	  private Long pricePaTakhti2 = (long) 1000;
   	  
   	  //bool
   	  private String komodServiceKhab2;
   	  
   	@Size(max=100,message="حداکثر 100 کاراکتر") 
   	  private String jensekomodServiceKhab2;
   	  
   	@Size(max=100,message="حداکثر 100 کاراکتر") 
   	private String abadkomodServiceKhab2;
   	  
   	@Size(max=100,message="حداکثر 100 کاراکتر") 
   	private String rangkomodServiceKhab2;
   	  
   	   private Long priceKomodServiceKhab2=(long) 1000;
   	  
   	  //bool
   	   private String mizArayesh2;
   	  
   	@Size(max=100,message="حداکثر 100 کاراکتر") 
   	private  String sandaliMizArayesh2;
   	  
   	@Size(max=100,message="حداکثر 100 کاراکتر") 
   	private String jenseMizArayesh2;
   	  
   	@Size(max=100,message="حداکثر 100 کاراکتر") 
   	private String abadMizArayesh2;
   	  
   	@Size(max=100,message="حداکثر 100 کاراکتر") 
   	private String rangMizArayesh2;
   	  
   	 private Long priceMizArayesh2 =(long) 1000;
   	  
//bool
   	 private String mizTahrir2;
   	  
   	@Size(max=100,message="حداکثر 100 کاراکتر") 
   	private String jensemizTahrir2;
   	  
   	@Size(max=100,message="حداکثر 100 کاراکتر") 
   	private String abadmizTahrir2;
   	  
   	@Size(max=100,message="حداکثر 100 کاراکتر") 
   	private String rangmizTahrir2;
   	  
   	   private Long priceMizTahrir2 =(long) 1000;
   	  
   	 //bool
   	   private String gabVAyeneGadi2;
   	  
   	@Size(max=100,message="حداکثر 100 کاراکتر") 
   	private String jenseGabVAyeneGadi2;
   	  
   	@Size(max=100,message="حداکثر 100 کاراکتر") 
   	private String abadGabVAyeneGadi2;
   	  
   	@Size(max=100,message="حداکثر 100 کاراکتر") 
   	private String rangGabVAyeneGadi2;
   	  
   	  private Long priceGabVAyeneGadi2 = (long) 1000;
   	  
   	 //bool
   	  private String toshak2;
   	  
   	@Size(max=100,message="حداکثر 100 کاراکتر") 
   	private String brandToshak2;
   	  
   	@Size(max=100,message="حداکثر 100 کاراکتر") 
   	private String modelToshak2;
   	  
   	  private Integer modatGarantiGabVAyeneGadi2=0;
   	  
   	@Size(max=100,message="حداکثر 100 کاراکتر") 
   	private String abadToshak2;
   	  
   	  private Long priceToshak2 = (long) 1000;
   	  
   	@Size(max=100,message="حداکثر 100 کاراکتر") 
   	private String descriptionToshak2;
   	
   	//////////////////////////ServiceKhabKodak
   	
   	@Size(max=100,message="حداکثر 100 کاراکتر") 
   	private String modelServiceKhabNozad;
	  
   	@Size(max=100,message="حداکثر 100 کاراکتر") 
   	private String jenseServiceKhabNozad;
	  
   	@Size(max=100,message="حداکثر 100 کاراکتر") 
   	private String rangServiceKhabNozad;
	  
	 private Long priceServiceKhabNozad =(long) 1000;
	  
	 //bool
	 private String keshoVBox;
	  
	//bool
	 private String kenarMadari;
	  
	 @Size(max=100,message="حداکثر 100 کاراکتر") 
	 private String jenseKomodkenarMadari;
	  
	 @Size(max=100,message="حداکثر 100 کاراکتر") 
	 private String abadKomodkenarMadari;
	  
	 @Size(max=100,message="حداکثر 100 کاراکتر") 
	 private String rangKomodkenarMadari;
	  
	 private Long priceKomodkenarMadari =(long) 1000;
	  //bool
	  private String mizSandaliKodak;
	  
	  private Integer tedadMizSandaliKodak = 0;
	  
	  @Size(max=100,message="حداکثر 100 کاراکتر") 
	  private String jenseMizSandaliKodak;
	  
	  @Size(max=100,message="حداکثر 100 کاراکتر") 
	  private String abadMizKodak;
	  
	  @Size(max=100,message="حداکثر 100 کاراکتر") 
	  private String abadSandaliKodak;
	  
	  private Long priceMizSandaliKodak = (long) 1000;
	  
	  //bool
	  private String komodMizSandaliKodak;
	  
	  @Size(max=100,message="حداکثر 100 کاراکتر") 
	  private String jenseKomodMizSandaliKodak;
	  
	  @Size(max=100,message="حداکثر 100 کاراکتر") 
	  private String abadKomodMizSandaliKodak;
	  
	  @Size(max=100,message="حداکثر 100 کاراکتر") 
	  private String rangKomodMizSandaliKodak;
	  
	  private Long priceKomodMizSandaliKodak = (long) 1000;
	  //bool
	  private String mizArayeshMizSandaliKodak;
	  
	 //bool
	  private String sandaliMizArayeshMizSandaliKodak;
	  
	  @Size(max=100,message="حداکثر 100 کاراکتر") 
	  private String jenseMizArayeshMizSandaliKodak;
	  
	  @Size(max=100,message="حداکثر 100 کاراکتر") 
	  private String abadMizArayeshMizSandaliKodak;
	  
	  @Size(max=100,message="حداکثر 100 کاراکتر") 
	  private String rangMizArayeshMizSandaliKodak;
	  
	  private Long priceMizArayeshMizSandaliKodak = (long) 1000;
	  //bool
	  private String vitrinKetabkhane;
	  
	  @Size(max=100,message="حداکثر 100 کاراکتر") 
	  private String jenseVitrinKetabkhane;
	  
	  @Size(max=100,message="حداکثر 100 کاراکتر") 
	  private String abadVitrinKetabkhane;
	  
	  @Size(max=100,message="حداکثر 100 کاراکتر") 
	  private String rangVitrinKetabkhane;
	  
	  private Long priceVitrinKetabkhane = (long) 1000;
	  //bool 
	  private String shelfDivari;
	  
	  @Size(max=100,message="حداکثر 100 کاراکتر") 
	  private String jenseShelfDivari;
	  
	  @Size(max=100,message="حداکثر 100 کاراکتر") 
	  private String abadShelfDivari;
	  
	  @Size(max=100,message="حداکثر 100 کاراکتر") 
	  private String rangShelfDivari;
	  
	   private Long priceShelfDivari = (long) 1000;
	  
	  //bool
	   private String toshak3;
	  
	   @Size(max=100,message="حداکثر 100 کاراکتر") 
	   private String brandToshak3;
	  
	   @Size(max=100,message="حداکثر 100 کاراکتر") 
	   private String modelToshak3;
	  
	   private Integer modatGarantiToshak3 = 0;
	  
	   @Size(max=100,message="حداکثر 100 کاراکتر") 
	   private String abadToshak3;
	  
	   private Long priceToshak3 = (long) 1000;
	  
	   @Size(max=100,message="حداکثر 100 کاراکتر") 
	   private String descriptionToshak3;
	  
	   ////////////////////////////////////////////////
	   ///////////////////***************************
	   //////////////////////////////////////////////////
	   private ProductEntity productEntity;
	   private Object productDetail;
	   
	   ////////////////////////////////////////////
	   ////////////////////////////////////////////
	   ////////////////////////////////////////////
	   private boolean enableProduct;
	   
	public boolean isEnableProduct() {
		return enableProduct;
	}

	public void setEnableProduct(boolean enableProduct) {
		this.enableProduct = enableProduct;
	}

	public Object getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(Object productDetail) {
		this.productDetail = productDetail;
	}

	public ProductEntity getProductEntity() {
		return productEntity;
	}

	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}

	public String getPanelShow() {
		return panelShow;
	}

	public List<String> getFaaliats() {
		return faaliats;
	}

	public void setFaaliats(List<String> faaliats) {
		this.faaliats = faaliats;
	}

	public void setPanelShow(String panelShow) {
		this.panelShow = panelShow;
	}
	
    public void onPanelChange() {
       System.err.println(this.panelShow); 
    }
    
	public ProductserviceLocal getProductserviceLocal() {
		return productserviceLocal;
	}

	public void setProductserviceLocal(ProductserviceLocal productserviceLocal) {
		this.productserviceLocal = productserviceLocal;
	}



	public AdminProfile getAdminProfile() {
		return adminProfile;
	}

	public void setAdminProfile(AdminProfile adminProfile) {
		this.adminProfile = adminProfile;
	}

	public String getNameCode() {
		return nameCode;
	}

	public void setNameCode(String nameCode) {
		this.nameCode = nameCode;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getContry() {
		return contry;
	}

	public void setContry(String contry) {
		this.contry = contry;
	}

	public String getRaste() {
		return raste;
	}

	public void setRaste(String raste) {
		this.raste = raste;
	}

	public String getAbad() {
		return abad;
	}

	public void setAbad(String abad) {
		this.abad = abad;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	



	
	public UploadedFile getPic1() {
		return pic1;
	}

	public void setPic1(UploadedFile pic1) {
		this.pic1 = pic1;
	}

	public UploadedFile getPic2() {
		return pic2;
	}

	public void setPic2(UploadedFile pic2) {
		this.pic2 = pic2;
	}

	public UploadedFile getPic3() {
		return pic3;
	}

	public void setPic3(UploadedFile pic3) {
		this.pic3 = pic3;
	}

	public UploadedFile getPic4() {
		return pic4;
	}

	public void setPic4(UploadedFile pic4) {
		this.pic4 = pic4;
	}

	public UploadedFile getPic5() {
		return pic5;
	}

	public void setPic5(UploadedFile pic5) {
		this.pic5 = pic5;
	}

	public Integer getTahvilDay() {
		return TahvilDay;
	}

	public void setTahvilDay(Integer tahvilDay) {
		TahvilDay = tahvilDay;
	}

	

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getPrice2() {
		return price2;
	}

	public void setPrice2(Long price2) {
		this.price2 = price2;
	}

	public String getZemanat() {
		return zemanat;
	}

	public void setZemanat(String zemanat) {
		this.zemanat = zemanat;
	}

	public String getGuarantiStatus() {
		return guarantiStatus;
	}

	public void setGuarantiStatus(String guarantiStatus) {
		this.guarantiStatus = guarantiStatus;
	}



	public Integer getGuaranyTimeMounth() {
		return guaranyTimeMounth;
	}

	public void setGuaranyTimeMounth(Integer guaranyTimeMounth) {
		this.guaranyTimeMounth = guaranyTimeMounth;
	}

	public String getRangBandi() {
		return rangBandi;
	}

	public void setRangBandi(String rangBandi) {
		this.rangBandi = rangBandi;
	}


	public String getJenseEskeletConsole() {
		return jenseEskeletConsole;
	}

	public void setJenseEskeletConsole(String jenseEskeletConsole) {
		this.jenseEskeletConsole = jenseEskeletConsole;
	}

	public String getJensePayeConsole() {
		return jensePayeConsole;
	}

	public void setJensePayeConsole(String jensePayeConsole) {
		this.jensePayeConsole = jensePayeConsole;
	}



	public Long getPriceConsole() {
		return priceConsole;
	}

	public void setPriceConsole(Long priceConsole) {
		this.priceConsole = priceConsole;
	}

	

	public Integer getTedadKesho() {
		return tedadKesho;
	}

	public void setTedadKesho(Integer tedadKesho) {
		this.tedadKesho = tedadKesho;
	}

	public Integer getTedadKomod() {
		return tedadKomod;
	}

	public void setTedadKomod(Integer tedadKomod) {
		this.tedadKomod = tedadKomod;
	}



	public Integer getTedadAyene() {
		return tedadAyene;
	}

	public void setTedadAyene(Integer tedadAyene) {
		this.tedadAyene = tedadAyene;
	}

	public String getShekleHendesi() {
		return shekleHendesi;
	}

	public void setShekleHendesi(String shekleHendesi) {
		this.shekleHendesi = shekleHendesi;
	}

	public String getZekhamatAyene() {
		return zekhamatAyene;
	}

	public void setZekhamatAyene(String zekhamatAyene) {
		this.zekhamatAyene = zekhamatAyene;
	}

	public String getAyeneGhab() {
		return ayeneGhab;
	}

	public void setAyeneGhab(String ayeneGhab) {
		this.ayeneGhab = ayeneGhab;
	}

	public String getJenseGhab() {
		return jenseGhab;
	}

	public void setJenseGhab(String jenseGhab) {
		this.jenseGhab = jenseGhab;
	}

	public String getAbadGhabAyene() {
		return abadGhabAyene;
	}

	public void setAbadGhabAyene(String abadGhabAyene) {
		this.abadGhabAyene = abadGhabAyene;
	}

	public String getRangGhabAyene() {
		return rangGhabAyene;
	}

	public void setRangGhabAyene(String rangGhabAyene) {
		this.rangGhabAyene = rangGhabAyene;
	}

	
	
////////////////////////////////////////////////////////////
	
	public Long getPriceGhabAyene() {
		return priceGhabAyene;
	}

	public void setPriceGhabAyene(Long priceGhabAyene) {
		this.priceGhabAyene = priceGhabAyene;
	}

	public AyeneVConsoleDaoLocal getAyeneVConsoleDaoLocal() {
		return ayeneVConsoleDaoLocal;
	}

	public void setAyeneVConsoleDaoLocal(AyeneVConsoleDaoLocal ayeneVConsoleDaoLocal) {
		this.ayeneVConsoleDaoLocal = ayeneVConsoleDaoLocal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	public String getEasyNezafat() {
		return easyNezafat;
	}

	public void setEasyNezafat(String easyNezafat) {
		this.easyNezafat = easyNezafat;
	}

	public String getOldNew() {
		return oldNew;
	}

	public void setOldNew(String oldNew) {
		this.oldNew = oldNew;
	}

	public String getKeshoConsole() {
		return keshoConsole;
	}

	public void setKeshoConsole(String keshoConsole) {
		this.keshoConsole = keshoConsole;
	}

	public String getKomodConsole() {
		return komodConsole;
	}

	public void setKomodConsole(String komodConsole) {
		this.komodConsole = komodConsole;
	}

	public String getAyeneConsole() {
		return ayeneConsole;
	}

	public void setAyeneConsole(String ayeneConsole) {
		this.ayeneConsole = ayeneConsole;
	}
	
	

	public String getRokeshDarbChobi() {
		return rokeshDarbChobi;
	}

	public void setRokeshDarbChobi(String rokeshDarbChobi) {
		this.rokeshDarbChobi = rokeshDarbChobi;
	}

	public String getNoeRangDarbChobi() {
		return noeRangDarbChobi;
	}

	public void setNoeRangDarbChobi(String noeRangDarbChobi) {
		this.noeRangDarbChobi = noeRangDarbChobi;
	}

	public String getZekhamatDarbChobi() {
		return zekhamatDarbChobi;
	}

	public void setZekhamatDarbChobi(String zekhamatDarbChobi) {
		this.zekhamatDarbChobi = zekhamatDarbChobi;
	}

	public String getJenseKalafDarbChobi() {
		return jenseKalafDarbChobi;
	}

	public void setJenseKalafDarbChobi(String jenseKalafDarbChobi) {
		this.jenseKalafDarbChobi = jenseKalafDarbChobi;
	}

	public String getMakanDarbChobi() {
		return makanDarbChobi;
	}

	public void setMakanDarbChobi(String makanDarbChobi) {
		this.makanDarbChobi = makanDarbChobi;
	}

	public String getCncDarbChobi() {
		return cncDarbChobi;
	}

	public void setCncDarbChobi(String cncDarbChobi) {
		this.cncDarbChobi = cncDarbChobi;
	}

	public String getZedeAbDarbChobi() {
		return zedeAbDarbChobi;
	}

	public void setZedeAbDarbChobi(String zedeAbDarbChobi) {
		this.zedeAbDarbChobi = zedeAbDarbChobi;
	}

	public String getShostoshoDarbChobi() {
		return shostoshoDarbChobi;
	}

	public void setShostoshoDarbChobi(String shostoshoDarbChobi) {
		this.shostoshoDarbChobi = shostoshoDarbChobi;
	}
	
	

	public DarbChobiDaoLocal getDarbChobiDaoLocal() {
		return darbChobiDaoLocal;
	}

	public void setDarbChobiDaoLocal(DarbChobiDaoLocal darbChobiDaoLocal) {
		this.darbChobiDaoLocal = darbChobiDaoLocal;
	}

	public DarbZedSergatDaoLocal getDarbZedSergatDaoLocal() {
		return darbZedSergatDaoLocal;
	}

	public void setDarbZedSergatDaoLocal(DarbZedSergatDaoLocal darbZedSergatDaoLocal) {
		this.darbZedSergatDaoLocal = darbZedSergatDaoLocal;
	}

	public GhabAxDaoLocal getGhabAxDaoLocal() {
		return ghabAxDaoLocal;
	}

	public void setGhabAxDaoLocal(GhabAxDaoLocal ghabAxDaoLocal) {
		this.ghabAxDaoLocal = ghabAxDaoLocal;
	}

	public KabinetDaoLocal getKabinetDaoLocal() {
		return kabinetDaoLocal;
	}

	public void setKabinetDaoLocal(KabinetDaoLocal kabinetDaoLocal) {
		this.kabinetDaoLocal = kabinetDaoLocal;
	}

	public KomodBoofeKetabkhaneJakafshiDaoLocal getKomodBoofeKetabkhaneJakafshiDaoLocal() {
		return komodBoofeKetabkhaneJakafshiDaoLocal;
	}

	public void setKomodBoofeKetabkhaneJakafshiDaoLocal(
			KomodBoofeKetabkhaneJakafshiDaoLocal komodBoofeKetabkhaneJakafshiDaoLocal) {
		this.komodBoofeKetabkhaneJakafshiDaoLocal = komodBoofeKetabkhaneJakafshiDaoLocal;
	}

	public MdfDaoLocal getMdfDaoLocal() {
		return mdfDaoLocal;
	}

	public void setMdfDaoLocal(MdfDaoLocal mdfDaoLocal) {
		this.mdfDaoLocal = mdfDaoLocal;
	}

	public MizAsaliDaoLocal getMizAsaliDaoLocal() {
		return mizAsaliDaoLocal;
	}

	public void setMizAsaliDaoLocal(MizAsaliDaoLocal mizAsaliDaoLocal) {
		this.mizAsaliDaoLocal = mizAsaliDaoLocal;
	}

	public MizEdariDaoLocal getMizEdariDaoLocal() {
		return mizEdariDaoLocal;
	}

	public void setMizEdariDaoLocal(MizEdariDaoLocal mizEdariDaoLocal) {
		this.mizEdariDaoLocal = mizEdariDaoLocal;
	}

	public MizJeloMobliDaoLocal getMizJeloMobliDaoLocal() {
		return mizJeloMobliDaoLocal;
	}

	public void setMizJeloMobliDaoLocal(MizJeloMobliDaoLocal mizJeloMobliDaoLocal) {
		this.mizJeloMobliDaoLocal = mizJeloMobliDaoLocal;
	}

	public MizNaharKhoriDaoLocal getMizNaharKhoriDaoLocal() {
		return mizNaharKhoriDaoLocal;
	}

	public void setMizNaharKhoriDaoLocal(MizNaharKhoriDaoLocal mizNaharKhoriDaoLocal) {
		this.mizNaharKhoriDaoLocal = mizNaharKhoriDaoLocal;
	}

	public MizTvDaoLocal getMizTvDaoLocal() {
		return mizTvDaoLocal;
	}

	public void setMizTvDaoLocal(MizTvDaoLocal mizTvDaoLocal) {
		this.mizTvDaoLocal = mizTvDaoLocal;
	}

	public MoblmanDaoLocal getMoblmanDaoLocal() {
		return moblmanDaoLocal;
	}

	public void setMoblmanDaoLocal(MoblmanDaoLocal moblmanDaoLocal) {
		this.moblmanDaoLocal = moblmanDaoLocal;
	}

	public MojasameDaoLocal getMojasameDaoLocal() {
		return mojasameDaoLocal;
	}

	public void setMojasameDaoLocal(MojasameDaoLocal mojasameDaoLocal) {
		this.mojasameDaoLocal = mojasameDaoLocal;
	}

	public MonabatDaoLocal getMonabatDaoLocal() {
		return monabatDaoLocal;
	}

	public void setMonabatDaoLocal(MonabatDaoLocal monabatDaoLocal) {
		this.monabatDaoLocal = monabatDaoLocal;
	}

	public PanjareDaoLocal getPanjareDaoLocal() {
		return panjareDaoLocal;
	}

	public void setPanjareDaoLocal(PanjareDaoLocal panjareDaoLocal) {
		this.panjareDaoLocal = panjareDaoLocal;
	}

	public PartitionDaoLocal getPartitionDaoLocal() {
		return partitionDaoLocal;
	}

	public void setPartitionDaoLocal(PartitionDaoLocal partitionDaoLocal) {
		this.partitionDaoLocal = partitionDaoLocal;
	}

	public SandaliEdariDaoLocal getSandaliEdariDaoLocal() {
		return sandaliEdariDaoLocal;
	}

	public void setSandaliEdariDaoLocal(SandaliEdariDaoLocal sandaliEdariDaoLocal) {
		this.sandaliEdariDaoLocal = sandaliEdariDaoLocal;
	}

	public ServiceKhab1DaoLocal getServiceKhab1DaoLocal() {
		return serviceKhab1DaoLocal;
	}

	public void setServiceKhab1DaoLocal(ServiceKhab1DaoLocal serviceKhab1DaoLocal) {
		this.serviceKhab1DaoLocal = serviceKhab1DaoLocal;
	}

	public ServiceKhab2DaoLocal getServiceKhab2DaoLocal() {
		return serviceKhab2DaoLocal;
	}

	public void setServiceKhab2DaoLocal(ServiceKhab2DaoLocal serviceKhab2DaoLocal) {
		this.serviceKhab2DaoLocal = serviceKhab2DaoLocal;
	}

	public ServiceKhabKodakDaoLocal getServiceKhabKodakDaoLocal() {
		return serviceKhabKodakDaoLocal;
	}

	public void setServiceKhabKodakDaoLocal(ServiceKhabKodakDaoLocal serviceKhabKodakDaoLocal) {
		this.serviceKhabKodakDaoLocal = serviceKhabKodakDaoLocal;
	}

	public String getNameMdfDarbZedSergat() {
		return nameMdfDarbZedSergat;
	}

	public void setNameMdfDarbZedSergat(String nameMdfDarbZedSergat) {
		this.nameMdfDarbZedSergat = nameMdfDarbZedSergat;
	}

	public String getZekhamatMdfDarbZedSergat() {
		return zekhamatMdfDarbZedSergat;
	}

	public void setZekhamatMdfDarbZedSergat(String zekhamatMdfDarbZedSergat) {
		this.zekhamatMdfDarbZedSergat = zekhamatMdfDarbZedSergat;
	}

	public String getKeshvarMdfDarbZedSergat() {
		return keshvarMdfDarbZedSergat;
	}

	public void setKeshvarMdfDarbZedSergat(String keshvarMdfDarbZedSergat) {
		this.keshvarMdfDarbZedSergat = keshvarMdfDarbZedSergat;
	}

	public String getVaragFeleziDarbZedSergat() {
		return varagFeleziDarbZedSergat;
	}

	public void setVaragFeleziDarbZedSergat(String varagFeleziDarbZedSergat) {
		this.varagFeleziDarbZedSergat = varagFeleziDarbZedSergat;
	}

	public String getGotiBandiFeleziDarbZedSergat() {
		return gotiBandiFeleziDarbZedSergat;
	}

	public void setGotiBandiFeleziDarbZedSergat(String gotiBandiFeleziDarbZedSergat) {
		this.gotiBandiFeleziDarbZedSergat = gotiBandiFeleziDarbZedSergat;
	}

	public String getZekhamatVaragFeleziDarbZedSergat() {
		return zekhamatVaragFeleziDarbZedSergat;
	}

	public void setZekhamatVaragFeleziDarbZedSergat(String zekhamatVaragFeleziDarbZedSergat) {
		this.zekhamatVaragFeleziDarbZedSergat = zekhamatVaragFeleziDarbZedSergat;
	}

	public String getCncDarbZedSergat() {
		return cncDarbZedSergat;
	}

	public void setCncDarbZedSergat(String cncDarbZedSergat) {
		this.cncDarbZedSergat = cncDarbZedSergat;
	}

	public String getMetrilJelogiriDarbZedSergat() {
		return metrilJelogiriDarbZedSergat;
	}

	public void setMetrilJelogiriDarbZedSergat(String metrilJelogiriDarbZedSergat) {
		this.metrilJelogiriDarbZedSergat = metrilJelogiriDarbZedSergat;
	}

	public String getSedagiriDarbZedSergat() {
		return sedagiriDarbZedSergat;
	}

	public void setSedagiriDarbZedSergat(String sedagiriDarbZedSergat) {
		this.sedagiriDarbZedSergat = sedagiriDarbZedSergat;
	}

	public String getGoflPostchiDarbZedSergat() {
		return goflPostchiDarbZedSergat;
	}

	public void setGoflPostchiDarbZedSergat(String goflPostchiDarbZedSergat) {
		this.goflPostchiDarbZedSergat = goflPostchiDarbZedSergat;
	}

	public String getNasbPostchiDarbZedSergat() {
		return nasbPostchiDarbZedSergat;
	}

	public void setNasbPostchiDarbZedSergat(String nasbPostchiDarbZedSergat) {
		this.nasbPostchiDarbZedSergat = nasbPostchiDarbZedSergat;
	}

	public String getZedeAbDarbZedSergat() {
		return zedeAbDarbZedSergat;
	}

	public void setZedeAbDarbZedSergat(String zedeAbDarbZedSergat) {
		this.zedeAbDarbZedSergat = zedeAbDarbZedSergat;
	}

	public String getZedeDeylamDarbZedSergat() {
		return zedeDeylamDarbZedSergat;
	}

	public void setZedeDeylamDarbZedSergat(String zedeDeylamDarbZedSergat) {
		this.zedeDeylamDarbZedSergat = zedeDeylamDarbZedSergat;
	}

	public String getRokeshDarbZedSergat() {
		return rokeshDarbZedSergat;
	}

	public void setRokeshDarbZedSergat(String rokeshDarbZedSergat) {
		this.rokeshDarbZedSergat = rokeshDarbZedSergat;
	}

	public String getRangDarbZedSergat() {
		return rangDarbZedSergat;
	}

	public void setRangDarbZedSergat(String rangDarbZedSergat) {
		this.rangDarbZedSergat = rangDarbZedSergat;
	}
	
	

	public String getJenseGabeAx() {
		return jenseGabeAx;
	}

	public void setJenseGabeAx(String jenseGabeAx) {
		this.jenseGabeAx = jenseGabeAx;
	}

	public String getAbadGabeAx() {
		return abadGabeAx;
	}

	public void setAbadGabeAx(String abadGabeAx) {
		this.abadGabeAx = abadGabeAx;
	}

	public String getAbadMofidGabeAx() {
		return abadMofidGabeAx;
	}

	public void setAbadMofidGabeAx(String abadMofidGabeAx) {
		this.abadMofidGabeAx = abadMofidGabeAx;
	}

	public String getJenseKabinet() {
		return jenseKabinet;
	}

	public void setJenseKabinet(String jenseKabinet) {
		this.jenseKabinet = jenseKabinet;
	}

	public String getJenseSafeKabinet() {
		return jenseSafeKabinet;
	}

	public void setJenseSafeKabinet(String jenseSafeKabinet) {
		this.jenseSafeKabinet = jenseSafeKabinet;
	}

	public String getNoeMdfKabinet() {
		return noeMdfKabinet;
	}

	public void setNoeMdfKabinet(String noeMdfKabinet) {
		this.noeMdfKabinet = noeMdfKabinet;
	}

	public String getZekhamateMdfKabinet() {
		return zekhamateMdfKabinet;
	}

	public void setZekhamateMdfKabinet(String zekhamateMdfKabinet) {
		this.zekhamateMdfKabinet = zekhamateMdfKabinet;
	}

	public String getAbadMdfKabinet() {
		return abadMdfKabinet;
	}

	public void setAbadMdfKabinet(String abadMdfKabinet) {
		this.abadMdfKabinet = abadMdfKabinet;
	}

	public String getDastgireDarbKabinet() {
		return dastgireDarbKabinet;
	}

	public void setDastgireDarbKabinet(String dastgireDarbKabinet) {
		this.dastgireDarbKabinet = dastgireDarbKabinet;
	}

	public String getReylKabinet() {
		return reylKabinet;
	}

	public void setReylKabinet(String reylKabinet) {
		this.reylKabinet = reylKabinet;
	}

	public String getJakKabinet() {
		return jakKabinet;
	}

	public void setJakKabinet(String jakKabinet) {
		this.jakKabinet = jakKabinet;
	}

	public String getPayeKabinet() {
		return payeKabinet;
	}

	public void setPayeKabinet(String payeKabinet) {
		this.payeKabinet = payeKabinet;
	}

	public String getMagnetKabinet() {
		return magnetKabinet;
	}

	public void setMagnetKabinet(String magnetKabinet) {
		this.magnetKabinet = magnetKabinet;
	}

	public String getCharkhKabinet() {
		return charkhKabinet;
	}

	public void setCharkhKabinet(String charkhKabinet) {
		this.charkhKabinet = charkhKabinet;
	}

	public Long getPriceMetrKabinet() {
		return priceMetrKabinet;
	}

	public void setPriceMetrKabinet(Long priceMetrKabinet) {
		this.priceMetrKabinet = priceMetrKabinet;
	}

	public Long getPriceMetrTakhfifKabinet() {
		return priceMetrTakhfifKabinet;
	}

	public void setPriceMetrTakhfifKabinet(Long priceMetrTakhfifKabinet) {
		this.priceMetrTakhfifKabinet = priceMetrTakhfifKabinet;
	}

	public String getShekleHendesikomod() {
		return shekleHendesikomod;
	}

	public void setShekleHendesikomod(String shekleHendesikomod) {
		this.shekleHendesikomod = shekleHendesikomod;
	}

	public String getShekleHendesiBoofe() {
		return shekleHendesiBoofe;
	}

	public void setShekleHendesiBoofe(String shekleHendesiBoofe) {
		this.shekleHendesiBoofe = shekleHendesiBoofe;
	}

	public String getShekleHendesiKetabkhane() {
		return shekleHendesiKetabkhane;
	}

	public void setShekleHendesiKetabkhane(String shekleHendesiKetabkhane) {
		this.shekleHendesiKetabkhane = shekleHendesiKetabkhane;
	}

	public String getShekleHendesiJakafshi() {
		return shekleHendesiJakafshi;
	}

	public void setShekleHendesiJakafshi(String shekleHendesiJakafshi) {
		this.shekleHendesiJakafshi = shekleHendesiJakafshi;
	}

	public String getJensekomod() {
		return jensekomod;
	}

	public void setJensekomod(String jensekomod) {
		this.jensekomod = jensekomod;
	}

	public String getJenseBoofe() {
		return jenseBoofe;
	}

	public void setJenseBoofe(String jenseBoofe) {
		this.jenseBoofe = jenseBoofe;
	}

	public String getJenseKetabkhane() {
		return jenseKetabkhane;
	}

	public void setJenseKetabkhane(String jenseKetabkhane) {
		this.jenseKetabkhane = jenseKetabkhane;
	}

	public String getJenseJakafshi() {
		return jenseJakafshi;
	}

	public void setJenseJakafshi(String jenseJakafshi) {
		this.jenseJakafshi = jenseJakafshi;
	}

	public String getAbadkomod() {
		return abadkomod;
	}

	public void setAbadkomod(String abadkomod) {
		this.abadkomod = abadkomod;
	}

	public String getAbadBoofe() {
		return abadBoofe;
	}

	public void setAbadBoofe(String abadBoofe) {
		this.abadBoofe = abadBoofe;
	}

	public String getAbadKetabkhane() {
		return abadKetabkhane;
	}

	public void setAbadKetabkhane(String abadKetabkhane) {
		this.abadKetabkhane = abadKetabkhane;
	}

	public String getAbadJakafshi() {
		return abadJakafshi;
	}

	public void setAbadJakafshi(String abadJakafshi) {
		this.abadJakafshi = abadJakafshi;
	}

	public Long getPricekomod() {
		return pricekomod;
	}

	public void setPricekomod(Long pricekomod) {
		this.pricekomod = pricekomod;
	}

	public Long getPriceBoofe() {
		return priceBoofe;
	}

	public void setPriceBoofe(Long priceBoofe) {
		this.priceBoofe = priceBoofe;
	}

	public Long getPriceKetabkhane() {
		return priceKetabkhane;
	}

	public void setPriceKetabkhane(Long priceKetabkhane) {
		this.priceKetabkhane = priceKetabkhane;
	}

	public Long getPriceJakafshi() {
		return priceJakafshi;
	}

	public void setPriceJakafshi(Long priceJakafshi) {
		this.priceJakafshi = priceJakafshi;
	}

	public Integer getTedadkomod() {
		return tedadkomod;
	}

	public void setTedadkomod(Integer tedadkomod) {
		this.tedadkomod = tedadkomod;
	}

	public Integer getTedadBoofe() {
		return tedadBoofe;
	}

	public void setTedadBoofe(Integer tedadBoofe) {
		this.tedadBoofe = tedadBoofe;
	}

	public Integer getTedadKetabkhane() {
		return tedadKetabkhane;
	}

	public void setTedadKetabkhane(Integer tedadKetabkhane) {
		this.tedadKetabkhane = tedadKetabkhane;
	}

	public Integer getTedadJakafshi() {
		return tedadJakafshi;
	}

	public void setTedadJakafshi(Integer tedadJakafshi) {
		this.tedadJakafshi = tedadJakafshi;
	}

	public String getZekhametMdf() {
		return zekhametMdf;
	}

	public void setZekhametMdf(String zekhametMdf) {
		this.zekhametMdf = zekhametMdf;
	}

	public String getAbadMdf() {
		return abadMdf;
	}

	public void setAbadMdf(String abadMdf) {
		this.abadMdf = abadMdf;
	}

	public Long getPriceMetrMdf() {
		return priceMetrMdf;
	}

	public void setPriceMetrMdf(Long priceMetrMdf) {
		this.priceMetrMdf = priceMetrMdf;
	}

	public Long getPriceTakhfifMetrMdf() {
		return priceTakhfifMetrMdf;
	}

	public void setPriceTakhfifMetrMdf(Long priceTakhfifMetrMdf) {
		this.priceTakhfifMetrMdf = priceTakhfifMetrMdf;
	}

	public String getSheklehendesiMizJeJeloAsali() {
		return sheklehendesiMizJeJeloAsali;
	}

	public void setSheklehendesiMizJeJeloAsali(String sheklehendesiMizJeJeloAsali) {
		this.sheklehendesiMizJeJeloAsali = sheklehendesiMizJeJeloAsali;
	}

	public Integer getTedadMizJeJeloAsali() {
		return tedadMizJeJeloAsali;
	}

	public void setTedadMizJeJeloAsali(Integer tedadMizJeJeloAsali) {
		this.tedadMizJeJeloAsali = tedadMizJeJeloAsali;
	}

	public String getJenseEskeletMizJeJeloAsali() {
		return jenseEskeletMizJeJeloAsali;
	}

	public void setJenseEskeletMizJeJeloAsali(String jenseEskeletMizJeJeloAsali) {
		this.jenseEskeletMizJeJeloAsali = jenseEskeletMizJeJeloAsali;
	}

	public String getJensePayeMizJeJeloAsali() {
		return jensePayeMizJeJeloAsali;
	}

	public void setJensePayeMizJeJeloAsali(String jensePayeMizJeJeloAsali) {
		this.jensePayeMizJeJeloAsali = jensePayeMizJeJeloAsali;
	}

	public String getShisheMizJeJeloAsali() {
		return shisheMizJeJeloAsali;
	}

	public void setShisheMizJeJeloAsali(String shisheMizJeJeloAsali) {
		this.shisheMizJeJeloAsali = shisheMizJeJeloAsali;
	}

	public String getNoeShisheMizJeJeloAsali() {
		return noeShisheMizJeJeloAsali;
	}

	public void setNoeShisheMizJeJeloAsali(String noeShisheMizJeJeloAsali) {
		this.noeShisheMizJeJeloAsali = noeShisheMizJeJeloAsali;
	}

	public Long getPriceShisheMizJeJeloAsali() {
		return priceShisheMizJeJeloAsali;
	}

	public void setPriceShisheMizJeJeloAsali(Long priceShisheMizJeJeloAsali) {
		this.priceShisheMizJeJeloAsali = priceShisheMizJeJeloAsali;
	}

	public String getDescriptionMizJeJeloAsali() {
		return descriptionMizJeJeloAsali;
	}

	public void setDescriptionMizJeJeloAsali(String descriptionMizJeJeloAsali) {
		this.descriptionMizJeJeloAsali = descriptionMizJeJeloAsali;
	}

	public String getSheklehendesiMizٍEdari() {
		return sheklehendesiMizٍEdari;
	}

	public void setSheklehendesiMizٍEdari(String sheklehendesiMizٍEdari) {
		this.sheklehendesiMizٍEdari = sheklehendesiMizٍEdari;
	}

	public Integer getTedadChantekeMizٍEdari() {
		return tedadChantekeMizٍEdari;
	}

	public void setTedadChantekeMizٍEdari(Integer tedadChantekeMizٍEdari) {
		this.tedadChantekeMizٍEdari = tedadChantekeMizٍEdari;
	}

	public String getJenseEskeletMizٍEdari() {
		return jenseEskeletMizٍEdari;
	}

	public void setJenseEskeletMizٍEdari(String jenseEskeletMizٍEdari) {
		this.jenseEskeletMizٍEdari = jenseEskeletMizٍEdari;
	}

	public String getJensePayeMizٍEdari() {
		return jensePayeMizٍEdari;
	}

	public void setJensePayeMizٍEdari(String jensePayeMizٍEdari) {
		this.jensePayeMizٍEdari = jensePayeMizٍEdari;
	}

	public String getShisheMizٍEdari() {
		return shisheMizٍEdari;
	}

	public void setShisheMizٍEdari(String shisheMizٍEdari) {
		this.shisheMizٍEdari = shisheMizٍEdari;
	}

	public String getNoeShisheMizٍEdari() {
		return noeShisheMizٍEdari;
	}

	public void setNoeShisheMizٍEdari(String noeShisheMizٍEdari) {
		this.noeShisheMizٍEdari = noeShisheMizٍEdari;
	}

	public Long getPriceShisheMizٍEdari() {
		return priceShisheMizٍEdari;
	}

	public void setPriceShisheMizٍEdari(Long priceShisheMizٍEdari) {
		this.priceShisheMizٍEdari = priceShisheMizٍEdari;
	}

	public String getShisheAbzarMizٍEdari() {
		return shisheAbzarMizٍEdari;
	}

	public void setShisheAbzarMizٍEdari(String shisheAbzarMizٍEdari) {
		this.shisheAbzarMizٍEdari = shisheAbzarMizٍEdari;
	}

	public String getKeshoMizٍEdari() {
		return keshoMizٍEdari;
	}

	public void setKeshoMizٍEdari(String keshoMizٍEdari) {
		this.keshoMizٍEdari = keshoMizٍEdari;
	}

	public Integer getTedadkeshoMizٍEdari() {
		return tedadkeshoMizٍEdari;
	}

	public void setTedadkeshoMizٍEdari(Integer tedadkeshoMizٍEdari) {
		this.tedadkeshoMizٍEdari = tedadkeshoMizٍEdari;
	}

	public String getKomodMizٍEdari() {
		return komodMizٍEdari;
	}

	public void setKomodMizٍEdari(String komodMizٍEdari) {
		this.komodMizٍEdari = komodMizٍEdari;
	}

	public Integer getTedadkomodMizٍEdari() {
		return tedadkomodMizٍEdari;
	}

	public void setTedadkomodMizٍEdari(Integer tedadkomodMizٍEdari) {
		this.tedadkomodMizٍEdari = tedadkomodMizٍEdari;
	}

	public String getFazayeLavazemJanebiMizٍEdari() {
		return fazayeLavazemJanebiMizٍEdari;
	}

	public void setFazayeLavazemJanebiMizٍEdari(String fazayeLavazemJanebiMizٍEdari) {
		this.fazayeLavazemJanebiMizٍEdari = fazayeLavazemJanebiMizٍEdari;
	}

	public String getDescriptionfazayeLavazemJanebiMizٍEdari() {
		return descriptionfazayeLavazemJanebiMizٍEdari;
	}

	public void setDescriptionfazayeLavazemJanebiMizٍEdari(String descriptionfazayeLavazemJanebiMizٍEdari) {
		this.descriptionfazayeLavazemJanebiMizٍEdari = descriptionfazayeLavazemJanebiMizٍEdari;
	}

	public String getSheklehendesiMizJeloMobli() {
		return sheklehendesiMizJeloMobli;
	}

	public void setSheklehendesiMizJeloMobli(String sheklehendesiMizJeloMobli) {
		this.sheklehendesiMizJeloMobli = sheklehendesiMizJeloMobli;
	}

	public Integer getTedadMizJeloMobli() {
		return tedadMizJeloMobli;
	}

	public void setTedadMizJeloMobli(Integer tedadMizJeloMobli) {
		this.tedadMizJeloMobli = tedadMizJeloMobli;
	}

	public String getJenseEskeletMizJeloMobli() {
		return jenseEskeletMizJeloMobli;
	}

	public void setJenseEskeletMizJeloMobli(String jenseEskeletMizJeloMobli) {
		this.jenseEskeletMizJeloMobli = jenseEskeletMizJeloMobli;
	}

	public String getJensePayeMizJeloMobli() {
		return jensePayeMizJeloMobli;
	}

	public void setJensePayeMizJeloMobli(String jensePayeMizJeloMobli) {
		this.jensePayeMizJeloMobli = jensePayeMizJeloMobli;
	}

	public String getAbadMizJeloMobli() {
		return abadMizJeloMobli;
	}

	public void setAbadMizJeloMobli(String abadMizJeloMobli) {
		this.abadMizJeloMobli = abadMizJeloMobli;
	}

	public String getRangMizJeloMobli() {
		return rangMizJeloMobli;
	}

	public void setRangMizJeloMobli(String rangMizJeloMobli) {
		this.rangMizJeloMobli = rangMizJeloMobli;
	}

	public Long getPriceMizJeloMobli() {
		return priceMizJeloMobli;
	}

	public void setPriceMizJeloMobli(Long priceMizJeloMobli) {
		this.priceMizJeloMobli = priceMizJeloMobli;
	}

	public String getShisheMizJeloMobli() {
		return shisheMizJeloMobli;
	}

	public void setShisheMizJeloMobli(String shisheMizJeloMobli) {
		this.shisheMizJeloMobli = shisheMizJeloMobli;
	}

	public String getNoeShisheMizJeloMobli() {
		return noeShisheMizJeloMobli;
	}

	public void setNoeShisheMizJeloMobli(String noeShisheMizJeloMobli) {
		this.noeShisheMizJeloMobli = noeShisheMizJeloMobli;
	}

	public Long getPriceShisheMizJeloMobli() {
		return priceShisheMizJeloMobli;
	}

	public void setPriceShisheMizJeloMobli(Long priceShisheMizJeloMobli) {
		this.priceShisheMizJeloMobli = priceShisheMizJeloMobli;
	}

	public String getShisheAbzarMizJeloMobli() {
		return shisheAbzarMizJeloMobli;
	}

	public void setShisheAbzarMizJeloMobli(String shisheAbzarMizJeloMobli) {
		this.shisheAbzarMizJeloMobli = shisheAbzarMizJeloMobli;
	}

	public Integer getTedadMizNaharKhori() {
		return tedadMizNaharKhori;
	}

	public void setTedadMizNaharKhori(Integer tedadMizNaharKhori) {
		this.tedadMizNaharKhori = tedadMizNaharKhori;
	}

	public String getSakhtarMizNaharKhori() {
		return sakhtarMizNaharKhori;
	}

	public void setSakhtarMizNaharKhori(String sakhtarMizNaharKhori) {
		this.sakhtarMizNaharKhori = sakhtarMizNaharKhori;
	}

	public String getDescriptionMizNaharKhori() {
		return descriptionMizNaharKhori;
	}

	public void setDescriptionMizNaharKhori(String descriptionMizNaharKhori) {
		this.descriptionMizNaharKhori = descriptionMizNaharKhori;
	}

	public String getSheklehendesiMizNaharKhori() {
		return sheklehendesiMizNaharKhori;
	}

	public void setSheklehendesiMizNaharKhori(String sheklehendesiMizNaharKhori) {
		this.sheklehendesiMizNaharKhori = sheklehendesiMizNaharKhori;
	}

	public String getJenseSafeMizNaharKhori() {
		return jenseSafeMizNaharKhori;
	}

	public void setJenseSafeMizNaharKhori(String jenseSafeMizNaharKhori) {
		this.jenseSafeMizNaharKhori = jenseSafeMizNaharKhori;
	}

	public String getJenseEskeletMizNaharKhori() {
		return jenseEskeletMizNaharKhori;
	}

	public void setJenseEskeletMizNaharKhori(String jenseEskeletMizNaharKhori) {
		this.jenseEskeletMizNaharKhori = jenseEskeletMizNaharKhori;
	}

	public String getJensePayeMizNaharKhori() {
		return jensePayeMizNaharKhori;
	}

	public void setJensePayeMizNaharKhori(String jensePayeMizNaharKhori) {
		this.jensePayeMizNaharKhori = jensePayeMizNaharKhori;
	}

	public String getShisheMizNaharKhori() {
		return shisheMizNaharKhori;
	}

	public void setShisheMizNaharKhori(String shisheMizNaharKhori) {
		this.shisheMizNaharKhori = shisheMizNaharKhori;
	}

	public String getRangeShisheMizNaharKhori() {
		return rangeShisheMizNaharKhori;
	}

	public void setRangeShisheMizNaharKhori(String rangeShisheMizNaharKhori) {
		this.rangeShisheMizNaharKhori = rangeShisheMizNaharKhori;
	}

	public String getZekhamatShisheMizNaharKhori() {
		return zekhamatShisheMizNaharKhori;
	}

	public void setZekhamatShisheMizNaharKhori(String zekhamatShisheMizNaharKhori) {
		this.zekhamatShisheMizNaharKhori = zekhamatShisheMizNaharKhori;
	}

	public Long getPriceShisheMizNaharKhori() {
		return priceShisheMizNaharKhori;
	}

	public void setPriceShisheMizNaharKhori(Long priceShisheMizNaharKhori) {
		this.priceShisheMizNaharKhori = priceShisheMizNaharKhori;
	}

	public String getShisheAbzarMizNaharKhori() {
		return shisheAbzarMizNaharKhori;
	}

	public void setShisheAbzarMizNaharKhori(String shisheAbzarMizNaharKhori) {
		this.shisheAbzarMizNaharKhori = shisheAbzarMizNaharKhori;
	}

	public Integer getTedadSandaliMizNaharKhori() {
		return tedadSandaliMizNaharKhori;
	}

	public void setTedadSandaliMizNaharKhori(Integer tedadSandaliMizNaharKhori) {
		this.tedadSandaliMizNaharKhori = tedadSandaliMizNaharKhori;
	}

	public String getJenseFomSandaliMizNaharKhori() {
		return jenseFomSandaliMizNaharKhori;
	}

	public void setJenseFomSandaliMizNaharKhori(String jenseFomSandaliMizNaharKhori) {
		this.jenseFomSandaliMizNaharKhori = jenseFomSandaliMizNaharKhori;
	}

	public String getJenseEsfangSandaliMizNaharKhori() {
		return jenseEsfangSandaliMizNaharKhori;
	}

	public void setJenseEsfangSandaliMizNaharKhori(String jenseEsfangSandaliMizNaharKhori) {
		this.jenseEsfangSandaliMizNaharKhori = jenseEsfangSandaliMizNaharKhori;
	}

	public String getJenseEskeletSandaliMizNaharKhori() {
		return jenseEskeletSandaliMizNaharKhori;
	}

	public void setJenseEskeletSandaliMizNaharKhori(String jenseEskeletSandaliMizNaharKhori) {
		this.jenseEskeletSandaliMizNaharKhori = jenseEskeletSandaliMizNaharKhori;
	}

	public String getJensePayeSandaliMizNaharKhori() {
		return jensePayeSandaliMizNaharKhori;
	}

	public void setJensePayeSandaliMizNaharKhori(String jensePayeSandaliMizNaharKhori) {
		this.jensePayeSandaliMizNaharKhori = jensePayeSandaliMizNaharKhori;
	}



	public String getPayeSandaliRangMizNaharKhori() {
		return payeSandaliRangMizNaharKhori;
	}

	public void setPayeSandaliRangMizNaharKhori(String payeSandaliRangMizNaharKhori) {
		this.payeSandaliRangMizNaharKhori = payeSandaliRangMizNaharKhori;
	}

	public String getRangPayeSandaliMizNaharKhori() {
		return rangPayeSandaliMizNaharKhori;
	}

	public void setRangPayeSandaliMizNaharKhori(String rangPayeSandaliMizNaharKhori) {
		this.rangPayeSandaliMizNaharKhori = rangPayeSandaliMizNaharKhori;
	}

	public String getJenseParcheSandaliMizNaharKhori() {
		return jenseParcheSandaliMizNaharKhori;
	}

	public void setJenseParcheSandaliMizNaharKhori(String jenseParcheSandaliMizNaharKhori) {
		this.jenseParcheSandaliMizNaharKhori = jenseParcheSandaliMizNaharKhori;
	}

	public String getNameParcheSandaliMizNaharKhori() {
		return nameParcheSandaliMizNaharKhori;
	}

	public void setNameParcheSandaliMizNaharKhori(String nameParcheSandaliMizNaharKhori) {
		this.nameParcheSandaliMizNaharKhori = nameParcheSandaliMizNaharKhori;
	}

	public String getRangSelParcheSandaliMizNaharKhori() {
		return rangSelParcheSandaliMizNaharKhori;
	}

	public void setRangSelParcheSandaliMizNaharKhori(String rangSelParcheSandaliMizNaharKhori) {
		this.rangSelParcheSandaliMizNaharKhori = rangSelParcheSandaliMizNaharKhori;
	}

	public String getRangParcheSandaliMizNaharKhori() {
		return rangParcheSandaliMizNaharKhori;
	}

	public void setRangParcheSandaliMizNaharKhori(String rangParcheSandaliMizNaharKhori) {
		this.rangParcheSandaliMizNaharKhori = rangParcheSandaliMizNaharKhori;
	}

	public String getJenseEskeletMizTv() {
		return jenseEskeletMizTv;
	}

	public void setJenseEskeletMizTv(String jenseEskeletMizTv) {
		this.jenseEskeletMizTv = jenseEskeletMizTv;
	}

	public String getAbadMizTv() {
		return abadMizTv;
	}

	public void setAbadMizTv(String abadMizTv) {
		this.abadMizTv = abadMizTv;
	}

	public Integer getMizMarbotTvInch() {
		return mizMarbotTvInch;
	}

	public void setMizMarbotTvInch(Integer mizMarbotTvInch) {
		this.mizMarbotTvInch = mizMarbotTvInch;
	}

	public String getRangMizTv() {
		return rangMizTv;
	}

	public void setRangMizTv(String rangMizTv) {
		this.rangMizTv = rangMizTv;
	}

	public String getGabeliatRangMizTv() {
		return gabeliatRangMizTv;
	}

	public void setGabeliatRangMizTv(String gabeliatRangMizTv) {
		this.gabeliatRangMizTv = gabeliatRangMizTv;
	}

	public String getRangAvalMizTv() {
		return rangAvalMizTv;
	}

	public void setRangAvalMizTv(String rangAvalMizTv) {
		this.rangAvalMizTv = rangAvalMizTv;
	}

	public String getRangDovomMizTv() {
		return rangDovomMizTv;
	}

	public void setRangDovomMizTv(String rangDovomMizTv) {
		this.rangDovomMizTv = rangDovomMizTv;
	}

	public String getKesho() {
		return kesho;
	}

	public void setKesho(String kesho) {
		this.kesho = kesho;
	}

	public Integer getTedadkesho() {
		return tedadkesho;
	}

	public void setTedadkesho(Integer tedadkesho) {
		this.tedadkesho = tedadkesho;
	}

	public String getJensePayeMizTv() {
		return jensePayeMizTv;
	}

	public void setJensePayeMizTv(String jensePayeMizTv) {
		this.jensePayeMizTv = jensePayeMizTv;
	}

	public String getRangPayeMizTv() {
		return rangPayeMizTv;
	}

	public void setRangPayeMizTv(String rangPayeMizTv) {
		this.rangPayeMizTv = rangPayeMizTv;
	}

	public String getFazayeLavazemJanebi() {
		return fazayeLavazemJanebi;
	}

	public void setFazayeLavazemJanebi(String fazayeLavazemJanebi) {
		this.fazayeLavazemJanebi = fazayeLavazemJanebi;
	}

	public String getDescriptionLavazemJanebi() {
		return descriptionLavazemJanebi;
	}

	public void setDescriptionLavazemJanebi(String descriptionLavazemJanebi) {
		this.descriptionLavazemJanebi = descriptionLavazemJanebi;
	}

	public String getNoeMobl() {
		return noeMobl;
	}

	public void setNoeMobl(String noeMobl) {
		this.noeMobl = noeMobl;
	}

	public Integer getTedadMobl() {
		return tedadMobl;
	}

	public void setTedadMobl(Integer tedadMobl) {
		this.tedadMobl = tedadMobl;
	}

	public String getSakhtarMobl() {
		return sakhtarMobl;
	}

	public void setSakhtarMobl(String sakhtarMobl) {
		this.sakhtarMobl = sakhtarMobl;
	}

	public String getJenseFome() {
		return jenseFome;
	}

	public void setJenseFome(String jenseFome) {
		this.jenseFome = jenseFome;
	}

	public String getJenseEsfanj() {
		return jenseEsfanj;
	}

	public void setJenseEsfanj(String jenseEsfanj) {
		this.jenseEsfanj = jenseEsfanj;
	}

	public String getJenseEskelet() {
		return jenseEskelet;
	}

	public void setJenseEskelet(String jenseEskelet) {
		this.jenseEskelet = jenseEskelet;
	}

	public String getJensePaye() {
		return jensePaye;
	}

	public void setJensePaye(String jensePaye) {
		this.jensePaye = jensePaye;
	}



	public String getEnetekhabRangPaye() {
		return enetekhabRangPaye;
	}

	public void setEnetekhabRangPaye(String enetekhabRangPaye) {
		this.enetekhabRangPaye = enetekhabRangPaye;
	}

	public String getRangPaye() {
		return rangPaye;
	}

	public void setRangPaye(String rangPaye) {
		this.rangPaye = rangPaye;
	}

	public String getJenseParche() {
		return jenseParche;
	}

	public void setJenseParche(String jenseParche) {
		this.jenseParche = jenseParche;
	}

	public String getNameParche() {
		return nameParche;
	}

	public void setNameParche(String nameParche) {
		this.nameParche = nameParche;
	}



	public String getEnetekhabRangParche() {
		return enetekhabRangParche;
	}

	public void setEnetekhabRangParche(String enetekhabRangParche) {
		this.enetekhabRangParche = enetekhabRangParche;
	}

	public String getRangParche() {
		return rangParche;
	}

	public void setRangParche(String rangParche) {
		this.rangParche = rangParche;
	}

	public String getMekanizmTakhtsho() {
		return mekanizmTakhtsho;
	}

	public void setMekanizmTakhtsho(String mekanizmTakhtsho) {
		this.mekanizmTakhtsho = mekanizmTakhtsho;
	}

	public String getDescriptionMekanizmTakhtsho() {
		return descriptionMekanizmTakhtsho;
	}

	public void setDescriptionMekanizmTakhtsho(String descriptionMekanizmTakhtsho) {
		this.descriptionMekanizmTakhtsho = descriptionMekanizmTakhtsho;
	}

	public String getKosan() {
		return kosan;
	}

	public void setKosan(String kosan) {
		this.kosan = kosan;
	}

	public Integer getTedadKosan() {
		return tedadKosan;
	}

	public void setTedadKosan(Integer tedadKosan) {
		this.tedadKosan = tedadKosan;
	}

	public String getAbadKosanBozorg() {
		return abadKosanBozorg;
	}

	public void setAbadKosanBozorg(String abadKosanBozorg) {
		this.abadKosanBozorg = abadKosanBozorg;
	}

	public String getAbadKosanKochak() {
		return abadKosanKochak;
	}

	public void setAbadKosanKochak(String abadKosanKochak) {
		this.abadKosanKochak = abadKosanKochak;
	}

	public String getModelKosan() {
		return modelKosan;
	}

	public void setModelKosan(String modelKosan) {
		this.modelKosan = modelKosan;
	}

	public String getJenseParcheKosan() {
		return jenseParcheKosan;
	}

	public void setJenseParcheKosan(String jenseParcheKosan) {
		this.jenseParcheKosan = jenseParcheKosan;
	}

	public String getRangeParcheKosan() {
		return rangeParcheKosan;
	}

	public void setRangeParcheKosan(String rangeParcheKosan) {
		this.rangeParcheKosan = rangeParcheKosan;
	}

	public String getMiz() {
		return miz;
	}

	public void setMiz(String miz) {
		this.miz = miz;
	}

	public Integer getTedadMiz() {
		return tedadMiz;
	}

	public void setTedadMiz(Integer tedadMiz) {
		this.tedadMiz = tedadMiz;
	}

	public String getAbadMiz() {
		return abadMiz;
	}

	public void setAbadMiz(String abadMiz) {
		this.abadMiz = abadMiz;
	}

	public String getJenseMojasame() {
		return jenseMojasame;
	}

	public void setJenseMojasame(String jenseMojasame) {
		this.jenseMojasame = jenseMojasame;
	}

	public String getAbadMojasame() {
		return abadMojasame;
	}

	public void setAbadMojasame(String abadMojasame) {
		this.abadMojasame = abadMojasame;
	}

	public String getShostoshoMojasame() {
		return shostoshoMojasame;
	}

	public void setShostoshoMojasame(String shostoshoMojasame) {
		this.shostoshoMojasame = shostoshoMojasame;
	}

	public String getNameMdfMonabat() {
		return nameMdfMonabat;
	}

	public void setNameMdfMonabat(String nameMdfMonabat) {
		this.nameMdfMonabat = nameMdfMonabat;
	}

	public String getZekhamatMdfMonabat() {
		return zekhamatMdfMonabat;
	}

	public void setZekhamatMdfMonabat(String zekhamatMdfMonabat) {
		this.zekhamatMdfMonabat = zekhamatMdfMonabat;
	}

	public String getKeshvarMdfMonabat() {
		return keshvarMdfMonabat;
	}

	public void setKeshvarMdfMonabat(String keshvarMdfMonabat) {
		this.keshvarMdfMonabat = keshvarMdfMonabat;
	}

	public String getNoeMonabat() {
		return noeMonabat;
	}

	public void setNoeMonabat(String noeMonabat) {
		this.noeMonabat = noeMonabat;
	}

	public String getAbadMonabat() {
		return abadMonabat;
	}

	public void setAbadMonabat(String abadMonabat) {
		this.abadMonabat = abadMonabat;
	}

	public String getJenseMonabat() {
		return jenseMonabat;
	}

	public void setJenseMonabat(String jenseMonabat) {
		this.jenseMonabat = jenseMonabat;
	}

	public String getMetrialPanjare() {
		return metrialPanjare;
	}

	public void setMetrialPanjare(String metrialPanjare) {
		this.metrialPanjare = metrialPanjare;
	}

	public String getNoeRangPanjare() {
		return noeRangPanjare;
	}

	public void setNoeRangPanjare(String noeRangPanjare) {
		this.noeRangPanjare = noeRangPanjare;
	}

	public String getJenseKalafPanjare() {
		return jenseKalafPanjare;
	}

	public void setJenseKalafPanjare(String jenseKalafPanjare) {
		this.jenseKalafPanjare = jenseKalafPanjare;
	}

	public String getMakanPanjare() {
		return makanPanjare;
	}

	public void setMakanPanjare(String makanPanjare) {
		this.makanPanjare = makanPanjare;
	}

	public String getCncPanjare() {
		return cncPanjare;
	}

	public void setCncPanjare(String cncPanjare) {
		this.cncPanjare = cncPanjare;
	}

	public String getZedeAbPanjare() {
		return zedeAbPanjare;
	}

	public void setZedeAbPanjare(String zedeAbPanjare) {
		this.zedeAbPanjare = zedeAbPanjare;
	}

	public String getShostoshoPanjare() {
		return shostoshoPanjare;
	}

	public void setShostoshoPanjare(String shostoshoPanjare) {
		this.shostoshoPanjare = shostoshoPanjare;
	}

	public String getJenseSotonPartishen() {
		return jenseSotonPartishen;
	}

	public void setJenseSotonPartishen(String jenseSotonPartishen) {
		this.jenseSotonPartishen = jenseSotonPartishen;
	}

	public String getJensePanelPartishen() {
		return jensePanelPartishen;
	}

	public void setJensePanelPartishen(String jensePanelPartishen) {
		this.jensePanelPartishen = jensePanelPartishen;
	}

	public String getJenseLabePartishen() {
		return jenseLabePartishen;
	}

	public void setJenseLabePartishen(String jenseLabePartishen) {
		this.jenseLabePartishen = jenseLabePartishen;
	}

	public String getRangPartishen() {
		return rangPartishen;
	}

	public void setRangPartishen(String rangPartishen) {
		this.rangPartishen = rangPartishen;
	}

	public String getTarkibiPartishen() {
		return tarkibiPartishen;
	}

	public void setTarkibiPartishen(String tarkibiPartishen) {
		this.tarkibiPartishen = tarkibiPartishen;
	}

	public String getNoeTarkibPartishen() {
		return noeTarkibPartishen;
	}

	public void setNoeTarkibPartishen(String noeTarkibPartishen) {
		this.noeTarkibPartishen = noeTarkibPartishen;
	}

	public boolean isEjrayePardePartishen() {
		return ejrayePardePartishen;
	}

	public void setEjrayePardePartishen(boolean ejrayePardePartishen) {
		this.ejrayePardePartishen = ejrayePardePartishen;
	}

	public String getRangPardePartishen() {
		return rangPardePartishen;
	}

	public void setRangPardePartishen(String rangPardePartishen) {
		this.rangPardePartishen = rangPardePartishen;
	}

	public Long getPriceMetrPartishen() {
		return priceMetrPartishen;
	}

	public void setPriceMetrPartishen(Long priceMetrPartishen) {
		this.priceMetrPartishen = priceMetrPartishen;
	}

	public Long getPriceTakhfifMetrPartishen() {
		return priceTakhfifMetrPartishen;
	}

	public void setPriceTakhfifMetrPartishen(Long priceTakhfifMetrPartishen) {
		this.priceTakhfifMetrPartishen = priceTakhfifMetrPartishen;
	}

	public String getNoeJenseSandaliEdari() {
		return noeJenseSandaliEdari;
	}

	public void setNoeJenseSandaliEdari(String noeJenseSandaliEdari) {
		this.noeJenseSandaliEdari = noeJenseSandaliEdari;
	}

	public String getAbadSandaliEdari() {
		return abadSandaliEdari;
	}

	public void setAbadSandaliEdari(String abadSandaliEdari) {
		this.abadSandaliEdari = abadSandaliEdari;
	}

	public String getRangSandaliEdari() {
		return rangSandaliEdari;
	}

	public void setRangSandaliEdari(String rangSandaliEdari) {
		this.rangSandaliEdari = rangSandaliEdari;
	}

	public String getJensePayeSandaliEdari() {
		return jensePayeSandaliEdari;
	}

	public void setJensePayeSandaliEdari(String jensePayeSandaliEdari) {
		this.jensePayeSandaliEdari = jensePayeSandaliEdari;
	}

	public String getDasteSandaliEdari() {
		return dasteSandaliEdari;
	}

	public void setDasteSandaliEdari(String dasteSandaliEdari) {
		this.dasteSandaliEdari = dasteSandaliEdari;
	}

	public String getNoeSandaliEdari() {
		return noeSandaliEdari;
	}

	public void setNoeSandaliEdari(String noeSandaliEdari) {
		this.noeSandaliEdari = noeSandaliEdari;
	}

	public String getTebiSandaliEdari() {
		return tebiSandaliEdari;
	}

	public void setTebiSandaliEdari(String tebiSandaliEdari) {
		this.tebiSandaliEdari = tebiSandaliEdari;
	}

	public String getModelServiceKhab() {
		return modelServiceKhab;
	}

	public void setModelServiceKhab(String modelServiceKhab) {
		this.modelServiceKhab = modelServiceKhab;
	}

	public Integer getArzeTakhteKhab() {
		return arzeTakhteKhab;
	}

	public void setArzeTakhteKhab(Integer arzeTakhteKhab) {
		this.arzeTakhteKhab = arzeTakhteKhab;
	}

	public String getJenseTakhtKhab() {
		return jenseTakhtKhab;
	}

	public void setJenseTakhtKhab(String jenseTakhtKhab) {
		this.jenseTakhtKhab = jenseTakhtKhab;
	}

	public String getRangTakhtKhab() {
		return rangTakhtKhab;
	}

	public void setRangTakhtKhab(String rangTakhtKhab) {
		this.rangTakhtKhab = rangTakhtKhab;
	}

	public Long getPriceTakhtKhab() {
		return priceTakhtKhab;
	}

	public void setPriceTakhtKhab(Long priceTakhtKhab) {
		this.priceTakhtKhab = priceTakhtKhab;
	}

	public String getKalafTakhtJakDar() {
		return kalafTakhtJakDar;
	}

	public void setKalafTakhtJakDar(String kalafTakhtJakDar) {
		this.kalafTakhtJakDar = kalafTakhtJakDar;
	}

	public String getKeshovbox() {
		return keshovbox;
	}

	public void setKeshovbox(String keshovbox) {
		this.keshovbox = keshovbox;
	}

	public String getPatakhti() {
		return patakhti;
	}

	public void setPatakhti(String patakhti) {
		this.patakhti = patakhti;
	}

	public Integer getTedadPaTakhti() {
		return tedadPaTakhti;
	}

	public void setTedadPaTakhti(Integer tedadPaTakhti) {
		this.tedadPaTakhti = tedadPaTakhti;
	}

	public String getJensePaTakhti() {
		return jensePaTakhti;
	}

	public void setJensePaTakhti(String jensePaTakhti) {
		this.jensePaTakhti = jensePaTakhti;
	}

	public String getAbadPaTakhti() {
		return abadPaTakhti;
	}

	public void setAbadPaTakhti(String abadPaTakhti) {
		this.abadPaTakhti = abadPaTakhti;
	}

	public String getRangPaTakhti() {
		return rangPaTakhti;
	}

	public void setRangPaTakhti(String rangPaTakhti) {
		this.rangPaTakhti = rangPaTakhti;
	}

	public Long getPricePaTakhti() {
		return pricePaTakhti;
	}

	public void setPricePaTakhti(Long pricePaTakhti) {
		this.pricePaTakhti = pricePaTakhti;
	}

	public String getKomodServiceKhab() {
		return komodServiceKhab;
	}

	public void setKomodServiceKhab(String komodServiceKhab) {
		this.komodServiceKhab = komodServiceKhab;
	}

	public String getJenseKomodServiceKhab() {
		return jenseKomodServiceKhab;
	}

	public void setJenseKomodServiceKhab(String jenseKomodServiceKhab) {
		this.jenseKomodServiceKhab = jenseKomodServiceKhab;
	}

	public String getAbadKomodServiceKhab() {
		return abadKomodServiceKhab;
	}

	public void setAbadKomodServiceKhab(String abadKomodServiceKhab) {
		this.abadKomodServiceKhab = abadKomodServiceKhab;
	}

	public String getRangKomodServiceKhab() {
		return rangKomodServiceKhab;
	}

	public void setRangKomodServiceKhab(String rangKomodServiceKhab) {
		this.rangKomodServiceKhab = rangKomodServiceKhab;
	}

	public Long getPriceKomodServiceKhab() {
		return priceKomodServiceKhab;
	}

	public void setPriceKomodServiceKhab(Long priceKomodServiceKhab) {
		this.priceKomodServiceKhab = priceKomodServiceKhab;
	}

	public String getMizArayesh() {
		return mizArayesh;
	}

	public void setMizArayesh(String mizArayesh) {
		this.mizArayesh = mizArayesh;
	}

	public String getSandaliServiceKhab() {
		return sandaliServiceKhab;
	}

	public void setSandaliServiceKhab(String sandaliServiceKhab) {
		this.sandaliServiceKhab = sandaliServiceKhab;
	}

	public String getJenseMizArayesh() {
		return jenseMizArayesh;
	}

	public void setJenseMizArayesh(String jenseMizArayesh) {
		this.jenseMizArayesh = jenseMizArayesh;
	}

	public String getAbadMizArayesh() {
		return abadMizArayesh;
	}

	public void setAbadMizArayesh(String abadMizArayesh) {
		this.abadMizArayesh = abadMizArayesh;
	}

	public String getRangMizArayesh() {
		return rangMizArayesh;
	}

	public void setRangMizArayesh(String rangMizArayesh) {
		this.rangMizArayesh = rangMizArayesh;
	}

	public Long getPriceMizArayesh() {
		return priceMizArayesh;
	}

	public void setPriceMizArayesh(Long priceMizArayesh) {
		this.priceMizArayesh = priceMizArayesh;
	}

	public String getMizTahrir() {
		return mizTahrir;
	}

	public void setMizTahrir(String mizTahrir) {
		this.mizTahrir = mizTahrir;
	}

	public String getJenseMizTahrir() {
		return jenseMizTahrir;
	}

	public void setJenseMizTahrir(String jenseMizTahrir) {
		this.jenseMizTahrir = jenseMizTahrir;
	}

	public String getAbadMizTahrir() {
		return abadMizTahrir;
	}

	public void setAbadMizTahrir(String abadMizTahrir) {
		this.abadMizTahrir = abadMizTahrir;
	}

	public String getRangMizTahrir() {
		return rangMizTahrir;
	}

	public void setRangMizTahrir(String rangMizTahrir) {
		this.rangMizTahrir = rangMizTahrir;
	}

	public Long getPriceMizTahrir() {
		return priceMizTahrir;
	}

	public void setPriceMizTahrir(Long priceMizTahrir) {
		this.priceMizTahrir = priceMizTahrir;
	}

	public String getGabVayeneGadi() {
		return gabVayeneGadi;
	}

	public void setGabVayeneGadi(String gabVayeneGadi) {
		this.gabVayeneGadi = gabVayeneGadi;
	}

	public String getJenseGabVayeneGadi() {
		return jenseGabVayeneGadi;
	}

	public void setJenseGabVayeneGadi(String jenseGabVayeneGadi) {
		this.jenseGabVayeneGadi = jenseGabVayeneGadi;
	}

	public String getAbadGabVayeneGadi() {
		return abadGabVayeneGadi;
	}

	public void setAbadGabVayeneGadi(String abadGabVayeneGadi) {
		this.abadGabVayeneGadi = abadGabVayeneGadi;
	}

	public String getRangGabVayeneGadi() {
		return rangGabVayeneGadi;
	}

	public void setRangGabVayeneGadi(String rangGabVayeneGadi) {
		this.rangGabVayeneGadi = rangGabVayeneGadi;
	}

	public Long getPriceGabVayeneGadi() {
		return priceGabVayeneGadi;
	}

	public void setPriceGabVayeneGadi(Long priceGabVayeneGadi) {
		this.priceGabVayeneGadi = priceGabVayeneGadi;
	}

	public String getToshak() {
		return toshak;
	}

	public void setToshak(String toshak) {
		this.toshak = toshak;
	}

	public String getBrandToshak() {
		return brandToshak;
	}

	public void setBrandToshak(String brandToshak) {
		this.brandToshak = brandToshak;
	}

	public String getModelToshak() {
		return modelToshak;
	}

	public void setModelToshak(String modelToshak) {
		this.modelToshak = modelToshak;
	}

	public Integer getModatGharantiToshak() {
		return modatGharantiToshak;
	}

	public void setModatGharantiToshak(Integer modatGharantiToshak) {
		this.modatGharantiToshak = modatGharantiToshak;
	}

	public String getAbadToshak() {
		return abadToshak;
	}

	public void setAbadToshak(String abadToshak) {
		this.abadToshak = abadToshak;
	}

	public Long getPriceToshak() {
		return priceToshak;
	}

	public void setPriceToshak(Long priceToshak) {
		this.priceToshak = priceToshak;
	}

	public String getTozihatToshak() {
		return tozihatToshak;
	}

	public void setTozihatToshak(String tozihatToshak) {
		this.tozihatToshak = tozihatToshak;
	}

	public String getModelServiceKhab2() {
		return modelServiceKhab2;
	}

	public void setModelServiceKhab2(String modelServiceKhab2) {
		this.modelServiceKhab2 = modelServiceKhab2;
	}



	public Integer getArzeTakhteKhab2() {
		return arzeTakhteKhab2;
	}

	public void setArzeTakhteKhab2(Integer arzeTakhteKhab2) {
		this.arzeTakhteKhab2 = arzeTakhteKhab2;
	}

	public String getJenseTakhteKhab2() {
		return jenseTakhteKhab2;
	}

	public void setJenseTakhteKhab2(String jenseTakhteKhab2) {
		this.jenseTakhteKhab2 = jenseTakhteKhab2;
	}

	public String getRangeTakhteKhab2() {
		return rangeTakhteKhab2;
	}

	public void setRangeTakhteKhab2(String rangeTakhteKhab2) {
		this.rangeTakhteKhab2 = rangeTakhteKhab2;
	}

	public Long getPriceTakhteKhab2() {
		return priceTakhteKhab2;
	}

	public void setPriceTakhteKhab2(Long priceTakhteKhab2) {
		this.priceTakhteKhab2 = priceTakhteKhab2;
	}

	public String getKalafTakhtJackDar() {
		return kalafTakhtJackDar;
	}

	public void setKalafTakhtJackDar(String kalafTakhtJackDar) {
		this.kalafTakhtJackDar = kalafTakhtJackDar;
	}

	public String getKeshoVbox() {
		return keshoVbox;
	}

	public void setKeshoVbox(String keshoVbox) {
		this.keshoVbox = keshoVbox;
	}

	public String getPaTahti2() {
		return paTahti2;
	}

	public void setPaTahti2(String paTahti2) {
		this.paTahti2 = paTahti2;
	}

	public Integer getTedadPaTakhti2() {
		return tedadPaTakhti2;
	}

	public void setTedadPaTakhti2(Integer tedadPaTakhti2) {
		this.tedadPaTakhti2 = tedadPaTakhti2;
	}

	public String getJensePaTakhti2() {
		return jensePaTakhti2;
	}

	public void setJensePaTakhti2(String jensePaTakhti2) {
		this.jensePaTakhti2 = jensePaTakhti2;
	}

	public String getAbadPaTakhti2() {
		return abadPaTakhti2;
	}

	public void setAbadPaTakhti2(String abadPaTakhti2) {
		this.abadPaTakhti2 = abadPaTakhti2;
	}

	public String getRangPaTakhti2() {
		return rangPaTakhti2;
	}

	public void setRangPaTakhti2(String rangPaTakhti2) {
		this.rangPaTakhti2 = rangPaTakhti2;
	}

	public Long getPricePaTakhti2() {
		return pricePaTakhti2;
	}

	public void setPricePaTakhti2(Long pricePaTakhti2) {
		this.pricePaTakhti2 = pricePaTakhti2;
	}

	public String getKomodServiceKhab2() {
		return komodServiceKhab2;
	}

	public void setKomodServiceKhab2(String komodServiceKhab2) {
		this.komodServiceKhab2 = komodServiceKhab2;
	}

	public String getJensekomodServiceKhab2() {
		return jensekomodServiceKhab2;
	}

	public void setJensekomodServiceKhab2(String jensekomodServiceKhab2) {
		this.jensekomodServiceKhab2 = jensekomodServiceKhab2;
	}

	public String getAbadkomodServiceKhab2() {
		return abadkomodServiceKhab2;
	}

	public void setAbadkomodServiceKhab2(String abadkomodServiceKhab2) {
		this.abadkomodServiceKhab2 = abadkomodServiceKhab2;
	}

	public String getRangkomodServiceKhab2() {
		return rangkomodServiceKhab2;
	}

	public void setRangkomodServiceKhab2(String rangkomodServiceKhab2) {
		this.rangkomodServiceKhab2 = rangkomodServiceKhab2;
	}

	public Long getPriceKomodServiceKhab2() {
		return priceKomodServiceKhab2;
	}

	public void setPriceKomodServiceKhab2(Long priceKomodServiceKhab2) {
		this.priceKomodServiceKhab2 = priceKomodServiceKhab2;
	}

	public String getMizArayesh2() {
		return mizArayesh2;
	}

	public void setMizArayesh2(String mizArayesh2) {
		this.mizArayesh2 = mizArayesh2;
	}

	public String getSandaliMizArayesh2() {
		return sandaliMizArayesh2;
	}

	public void setSandaliMizArayesh2(String sandaliMizArayesh2) {
		this.sandaliMizArayesh2 = sandaliMizArayesh2;
	}

	public String getJenseMizArayesh2() {
		return jenseMizArayesh2;
	}

	public void setJenseMizArayesh2(String jenseMizArayesh2) {
		this.jenseMizArayesh2 = jenseMizArayesh2;
	}

	public String getAbadMizArayesh2() {
		return abadMizArayesh2;
	}

	public void setAbadMizArayesh2(String abadMizArayesh2) {
		this.abadMizArayesh2 = abadMizArayesh2;
	}

	public String getRangMizArayesh2() {
		return rangMizArayesh2;
	}

	public void setRangMizArayesh2(String rangMizArayesh2) {
		this.rangMizArayesh2 = rangMizArayesh2;
	}

	public Long getPriceMizArayesh2() {
		return priceMizArayesh2;
	}

	public void setPriceMizArayesh2(Long priceMizArayesh2) {
		this.priceMizArayesh2 = priceMizArayesh2;
	}

	public String getMizTahrir2() {
		return mizTahrir2;
	}

	public void setMizTahrir2(String mizTahrir2) {
		this.mizTahrir2 = mizTahrir2;
	}

	public String getJensemizTahrir2() {
		return jensemizTahrir2;
	}

	public void setJensemizTahrir2(String jensemizTahrir2) {
		this.jensemizTahrir2 = jensemizTahrir2;
	}

	public String getAbadmizTahrir2() {
		return abadmizTahrir2;
	}

	public void setAbadmizTahrir2(String abadmizTahrir2) {
		this.abadmizTahrir2 = abadmizTahrir2;
	}

	public String getRangmizTahrir2() {
		return rangmizTahrir2;
	}

	public void setRangmizTahrir2(String rangmizTahrir2) {
		this.rangmizTahrir2 = rangmizTahrir2;
	}

	public Long getPriceMizTahrir2() {
		return priceMizTahrir2;
	}

	public void setPriceMizTahrir2(Long priceMizTahrir2) {
		this.priceMizTahrir2 = priceMizTahrir2;
	}

	public String getGabVAyeneGadi2() {
		return gabVAyeneGadi2;
	}

	public void setGabVAyeneGadi2(String gabVAyeneGadi2) {
		this.gabVAyeneGadi2 = gabVAyeneGadi2;
	}

	public String getJenseGabVAyeneGadi2() {
		return jenseGabVAyeneGadi2;
	}

	public void setJenseGabVAyeneGadi2(String jenseGabVAyeneGadi2) {
		this.jenseGabVAyeneGadi2 = jenseGabVAyeneGadi2;
	}

	public String getAbadGabVAyeneGadi2() {
		return abadGabVAyeneGadi2;
	}

	public void setAbadGabVAyeneGadi2(String abadGabVAyeneGadi2) {
		this.abadGabVAyeneGadi2 = abadGabVAyeneGadi2;
	}

	public String getRangGabVAyeneGadi2() {
		return rangGabVAyeneGadi2;
	}

	public void setRangGabVAyeneGadi2(String rangGabVAyeneGadi2) {
		this.rangGabVAyeneGadi2 = rangGabVAyeneGadi2;
	}

	public Long getPriceGabVAyeneGadi2() {
		return priceGabVAyeneGadi2;
	}

	public void setPriceGabVAyeneGadi2(Long priceGabVAyeneGadi2) {
		this.priceGabVAyeneGadi2 = priceGabVAyeneGadi2;
	}

	public String getToshak2() {
		return toshak2;
	}

	public void setToshak2(String toshak2) {
		this.toshak2 = toshak2;
	}

	public String getBrandToshak2() {
		return brandToshak2;
	}

	public void setBrandToshak2(String brandToshak2) {
		this.brandToshak2 = brandToshak2;
	}

	public String getModelToshak2() {
		return modelToshak2;
	}

	public void setModelToshak2(String modelToshak2) {
		this.modelToshak2 = modelToshak2;
	}

	public Integer getModatGarantiGabVAyeneGadi2() {
		return modatGarantiGabVAyeneGadi2;
	}

	public void setModatGarantiGabVAyeneGadi2(Integer modatGarantiGabVAyeneGadi2) {
		this.modatGarantiGabVAyeneGadi2 = modatGarantiGabVAyeneGadi2;
	}

	public String getAbadToshak2() {
		return abadToshak2;
	}

	public void setAbadToshak2(String abadToshak2) {
		this.abadToshak2 = abadToshak2;
	}

	public Long getPriceToshak2() {
		return priceToshak2;
	}

	public void setPriceToshak2(Long priceToshak2) {
		this.priceToshak2 = priceToshak2;
	}

	public String getDescriptionToshak2() {
		return descriptionToshak2;
	}

	public void setDescriptionToshak2(String descriptionToshak2) {
		this.descriptionToshak2 = descriptionToshak2;
	}

	public String getModelServiceKhabNozad() {
		return modelServiceKhabNozad;
	}

	public void setModelServiceKhabNozad(String modelServiceKhabNozad) {
		this.modelServiceKhabNozad = modelServiceKhabNozad;
	}

	public String getJenseServiceKhabNozad() {
		return jenseServiceKhabNozad;
	}

	public void setJenseServiceKhabNozad(String jenseServiceKhabNozad) {
		this.jenseServiceKhabNozad = jenseServiceKhabNozad;
	}

	public String getRangServiceKhabNozad() {
		return rangServiceKhabNozad;
	}

	public void setRangServiceKhabNozad(String rangServiceKhabNozad) {
		this.rangServiceKhabNozad = rangServiceKhabNozad;
	}

	public Long getPriceServiceKhabNozad() {
		return priceServiceKhabNozad;
	}

	public void setPriceServiceKhabNozad(Long priceServiceKhabNozad) {
		this.priceServiceKhabNozad = priceServiceKhabNozad;
	}

	public String getKeshoVBox() {
		return keshoVBox;
	}

	public void setKeshoVBox(String keshoVBox) {
		this.keshoVBox = keshoVBox;
	}

	public String getKenarMadari() {
		return kenarMadari;
	}

	public void setKenarMadari(String kenarMadari) {
		this.kenarMadari = kenarMadari;
	}

	public String getJenseKomodkenarMadari() {
		return jenseKomodkenarMadari;
	}

	public void setJenseKomodkenarMadari(String jenseKomodkenarMadari) {
		this.jenseKomodkenarMadari = jenseKomodkenarMadari;
	}

	public String getAbadKomodkenarMadari() {
		return abadKomodkenarMadari;
	}

	public void setAbadKomodkenarMadari(String abadKomodkenarMadari) {
		this.abadKomodkenarMadari = abadKomodkenarMadari;
	}

	public String getRangKomodkenarMadari() {
		return rangKomodkenarMadari;
	}

	public void setRangKomodkenarMadari(String rangKomodkenarMadari) {
		this.rangKomodkenarMadari = rangKomodkenarMadari;
	}

	public Long getPriceKomodkenarMadari() {
		return priceKomodkenarMadari;
	}

	public void setPriceKomodkenarMadari(Long priceKomodkenarMadari) {
		this.priceKomodkenarMadari = priceKomodkenarMadari;
	}

	public String getMizSandaliKodak() {
		return mizSandaliKodak;
	}

	public void setMizSandaliKodak(String mizSandaliKodak) {
		this.mizSandaliKodak = mizSandaliKodak;
	}

	public Integer getTedadMizSandaliKodak() {
		return tedadMizSandaliKodak;
	}

	public void setTedadMizSandaliKodak(Integer tedadMizSandaliKodak) {
		this.tedadMizSandaliKodak = tedadMizSandaliKodak;
	}

	public String getJenseMizSandaliKodak() {
		return jenseMizSandaliKodak;
	}

	public void setJenseMizSandaliKodak(String jenseMizSandaliKodak) {
		this.jenseMizSandaliKodak = jenseMizSandaliKodak;
	}

	public String getAbadMizKodak() {
		return abadMizKodak;
	}

	public void setAbadMizKodak(String abadMizKodak) {
		this.abadMizKodak = abadMizKodak;
	}

	public String getAbadSandaliKodak() {
		return abadSandaliKodak;
	}

	public void setAbadSandaliKodak(String abadSandaliKodak) {
		this.abadSandaliKodak = abadSandaliKodak;
	}

	public Long getPriceMizSandaliKodak() {
		return priceMizSandaliKodak;
	}

	public void setPriceMizSandaliKodak(Long priceMizSandaliKodak) {
		this.priceMizSandaliKodak = priceMizSandaliKodak;
	}

	public String getKomodMizSandaliKodak() {
		return komodMizSandaliKodak;
	}

	public void setKomodMizSandaliKodak(String komodMizSandaliKodak) {
		this.komodMizSandaliKodak = komodMizSandaliKodak;
	}

	public String getJenseKomodMizSandaliKodak() {
		return jenseKomodMizSandaliKodak;
	}

	public void setJenseKomodMizSandaliKodak(String jenseKomodMizSandaliKodak) {
		this.jenseKomodMizSandaliKodak = jenseKomodMizSandaliKodak;
	}

	public String getAbadKomodMizSandaliKodak() {
		return abadKomodMizSandaliKodak;
	}

	public void setAbadKomodMizSandaliKodak(String abadKomodMizSandaliKodak) {
		this.abadKomodMizSandaliKodak = abadKomodMizSandaliKodak;
	}

	public String getRangKomodMizSandaliKodak() {
		return rangKomodMizSandaliKodak;
	}

	public void setRangKomodMizSandaliKodak(String rangKomodMizSandaliKodak) {
		this.rangKomodMizSandaliKodak = rangKomodMizSandaliKodak;
	}

	public Long getPriceKomodMizSandaliKodak() {
		return priceKomodMizSandaliKodak;
	}

	public void setPriceKomodMizSandaliKodak(Long priceKomodMizSandaliKodak) {
		this.priceKomodMizSandaliKodak = priceKomodMizSandaliKodak;
	}

	public String getMizArayeshMizSandaliKodak() {
		return mizArayeshMizSandaliKodak;
	}

	public void setMizArayeshMizSandaliKodak(String mizArayeshMizSandaliKodak) {
		this.mizArayeshMizSandaliKodak = mizArayeshMizSandaliKodak;
	}

	public String getSandaliMizArayeshMizSandaliKodak() {
		return sandaliMizArayeshMizSandaliKodak;
	}

	public void setSandaliMizArayeshMizSandaliKodak(String sandaliMizArayeshMizSandaliKodak) {
		this.sandaliMizArayeshMizSandaliKodak = sandaliMizArayeshMizSandaliKodak;
	}

	public String getJenseMizArayeshMizSandaliKodak() {
		return jenseMizArayeshMizSandaliKodak;
	}

	public void setJenseMizArayeshMizSandaliKodak(String jenseMizArayeshMizSandaliKodak) {
		this.jenseMizArayeshMizSandaliKodak = jenseMizArayeshMizSandaliKodak;
	}

	public String getAbadMizArayeshMizSandaliKodak() {
		return abadMizArayeshMizSandaliKodak;
	}

	public void setAbadMizArayeshMizSandaliKodak(String abadMizArayeshMizSandaliKodak) {
		this.abadMizArayeshMizSandaliKodak = abadMizArayeshMizSandaliKodak;
	}

	public String getRangMizArayeshMizSandaliKodak() {
		return rangMizArayeshMizSandaliKodak;
	}

	public void setRangMizArayeshMizSandaliKodak(String rangMizArayeshMizSandaliKodak) {
		this.rangMizArayeshMizSandaliKodak = rangMizArayeshMizSandaliKodak;
	}

	public Long getPriceMizArayeshMizSandaliKodak() {
		return priceMizArayeshMizSandaliKodak;
	}

	public void setPriceMizArayeshMizSandaliKodak(Long priceMizArayeshMizSandaliKodak) {
		this.priceMizArayeshMizSandaliKodak = priceMizArayeshMizSandaliKodak;
	}

	public String getVitrinKetabkhane() {
		return vitrinKetabkhane;
	}

	public void setVitrinKetabkhane(String vitrinKetabkhane) {
		this.vitrinKetabkhane = vitrinKetabkhane;
	}

	public String getJenseVitrinKetabkhane() {
		return jenseVitrinKetabkhane;
	}

	public void setJenseVitrinKetabkhane(String jenseVitrinKetabkhane) {
		this.jenseVitrinKetabkhane = jenseVitrinKetabkhane;
	}

	public String getAbadVitrinKetabkhane() {
		return abadVitrinKetabkhane;
	}

	public void setAbadVitrinKetabkhane(String abadVitrinKetabkhane) {
		this.abadVitrinKetabkhane = abadVitrinKetabkhane;
	}

	public String getRangVitrinKetabkhane() {
		return rangVitrinKetabkhane;
	}

	public void setRangVitrinKetabkhane(String rangVitrinKetabkhane) {
		this.rangVitrinKetabkhane = rangVitrinKetabkhane;
	}

	public Long getPriceVitrinKetabkhane() {
		return priceVitrinKetabkhane;
	}

	public void setPriceVitrinKetabkhane(Long priceVitrinKetabkhane) {
		this.priceVitrinKetabkhane = priceVitrinKetabkhane;
	}

	public String getShelfDivari() {
		return shelfDivari;
	}

	public void setShelfDivari(String shelfDivari) {
		this.shelfDivari = shelfDivari;
	}

	public String getJenseShelfDivari() {
		return jenseShelfDivari;
	}

	public void setJenseShelfDivari(String jenseShelfDivari) {
		this.jenseShelfDivari = jenseShelfDivari;
	}

	public String getAbadShelfDivari() {
		return abadShelfDivari;
	}

	public void setAbadShelfDivari(String abadShelfDivari) {
		this.abadShelfDivari = abadShelfDivari;
	}

	public String getRangShelfDivari() {
		return rangShelfDivari;
	}

	public void setRangShelfDivari(String rangShelfDivari) {
		this.rangShelfDivari = rangShelfDivari;
	}

	public Long getPriceShelfDivari() {
		return priceShelfDivari;
	}

	public void setPriceShelfDivari(Long priceShelfDivari) {
		this.priceShelfDivari = priceShelfDivari;
	}

	public String getToshak3() {
		return toshak3;
	}

	public void setToshak3(String toshak3) {
		this.toshak3 = toshak3;
	}

	public String getBrandToshak3() {
		return brandToshak3;
	}

	public void setBrandToshak3(String brandToshak3) {
		this.brandToshak3 = brandToshak3;
	}

	public String getModelToshak3() {
		return modelToshak3;
	}

	public void setModelToshak3(String modelToshak3) {
		this.modelToshak3 = modelToshak3;
	}

	public Integer getModatGarantiToshak3() {
		return modatGarantiToshak3;
	}

	public void setModatGarantiToshak3(Integer modatGarantiToshak3) {
		this.modatGarantiToshak3 = modatGarantiToshak3;
	}

	public String getAbadToshak3() {
		return abadToshak3;
	}

	public void setAbadToshak3(String abadToshak3) {
		this.abadToshak3 = abadToshak3;
	}



	public Long getPriceToshak3() {
		return priceToshak3;
	}

	public void setPriceToshak3(Long priceToshak3) {
		this.priceToshak3 = priceToshak3;
	}

	public String getDescriptionToshak3() {
		return descriptionToshak3;
	}

	public void setDescriptionToshak3(String descriptionToshak3) {
		this.descriptionToshak3 = descriptionToshak3;
	}
	
	
	
    public UIComponent getPic1Component() {
		return pic1Component;
	}

	public void setPic1Component(UIComponent pic1Component) {
		this.pic1Component = pic1Component;
	}

	public UIComponent getPic2Component() {
		return pic2Component;
	}

	public void setPic2Component(UIComponent pic2Component) {
		this.pic2Component = pic2Component;
	}

	public UIComponent getPic3Component() {
		return pic3Component;
	}

	public void setPic3Component(UIComponent pic3Component) {
		this.pic3Component = pic3Component;
	}

	public UIComponent getPic4Component() {
		return pic4Component;
	}

	public void setPic4Component(UIComponent pic4Component) {
		this.pic4Component = pic4Component;
	}

	public UIComponent getPic5Component() {
		return pic5Component;
	}

	public void setPic5Component(UIComponent pic5Component) {
		this.pic5Component = pic5Component;
	}

	public String getAparat() {
		return aparat;
	}

	public void setAparat(String aparat) {
		this.aparat = aparat;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String convertPicture(UploadedFile uploadedFile) {
    	try {
			return FileConvertor.convertPicture(uploadedFile);
		} catch (Exception e) {
			return null;
		}
    }

	public boolean convertBool(String val) {
		switch (val) {
		case "y":
			return true;
		case "n":
			return false;
		}
		return false;
	}
	
	private String faaliatHa() {
		System.err.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
		System.err.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
		System.err.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
		for (String string : faaliats) {
			System.err.println(string);	
		}
		System.err.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
		System.err.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
		String item="";
		if(this.faaliats!=null) {
		for (String string : this.faaliats) {
			item=item +string + "-";
		}
		return item;
		}else {
		return "";
		}
	}
	
	public void emptyInp() {
		this.nameCode="";
		this.brand="";
		this.contry="";
		this.raste="";
		this.abad="";
		this.description="";
		this.status="";
		this.TahvilDay=1;
		this.price=(long) 1000;
		this.price2=(long) 1000;
		this.zemanat="";
		this.guarantiStatus="";
		this.guaranyTimeMounth=1;
		this.rangBandi="";
		this.jenseEskeletConsole="";
		this.jensePayeConsole="";
		this.priceConsole=(long) 1000;
		this.keshoConsole="";
		this.tedadKesho=1;
		this.komodConsole="";
		this.tedadKomod=1;
			this.ayeneConsole="";
			this.tedadAyene=1;
		    this.shekleHendesi="";
		    this.zekhamatAyene="";
		    this.ayeneGhab="";
		    this.jenseGhab="";
		    this.abadGhabAyene="";
		    this.rangGhabAyene="";
		    this.priceGhabAyene=(long) 1000;
			 this.rokeshDarbChobi="";
			 this.noeRangDarbChobi="";
			 this.zekhamatDarbChobi=""; 
		     this.jenseKalafDarbChobi="";
		     this.makanDarbChobi="";
			 this.cncDarbChobi="";
			 this.zedeAbDarbChobi="";
			 this.shostoshoDarbChobi="";
			 this.nameMdfDarbZedSergat="";
			  
			  this.zekhamatMdfDarbZedSergat="";
			  
			  this.keshvarMdfDarbZedSergat="";
			  
			  this.varagFeleziDarbZedSergat="";
			  
			  this.gotiBandiFeleziDarbZedSergat="";
			  
			  this.zekhamatVaragFeleziDarbZedSergat="";
			  this.cncDarbZedSergat="";
			  
	          this.metrilJelogiriDarbZedSergat="";
			  
	          this.sedagiriDarbZedSergat="";
			  
	          this.goflPostchiDarbZedSergat="";
			  
			  
	          this.nasbPostchiDarbZedSergat="";
			  
	          this.zedeAbDarbZedSergat="";
			  
	          this.zedeDeylamDarbZedSergat="";
			  
	          this.rokeshDarbZedSergat="";
			  
	          this.rangDarbZedSergat="";
	          
	          
	          this.jenseGabeAx="";
	    	  
	          this.abadGabeAx="";
	    	  
	          this.abadMofidGabeAx="";
	          
	          
	          this.jenseKabinet="";
	   	  
	          this.jenseSafeKabinet="";
	   	  
	          this.noeMdfKabinet="";
	   	  
	          this.zekhamateMdfKabinet="";
	   	  
	          this.abadMdfKabinet="";
	   	  
	          this.dastgireDarbKabinet="";
	          this.reylKabinet="";
	          this.jakKabinet="";
	          this.payeKabinet="";
	          this.magnetKabinet="";
	          this.charkhKabinet="";
	          this.priceMetrKabinet = (long) 1000;
	          this.priceMetrTakhfifKabinet = (long) 1000;
	          
	          
	          this.shekleHendesikomod="";
	          this.shekleHendesiBoofe="";
	   	      this.shekleHendesiKetabkhane="";
	          this.shekleHendesiJakafshi="";
	          this.jensekomod="";
	          this.jenseBoofe="";
	          this.jenseKetabkhane="";
	          this.jenseJakafshi="";
	          this.abadkomod="";
	          this.abadBoofe="";
	          this.abadKetabkhane="";
	          this.abadJakafshi="";
	          this.pricekomod = (long) 1000;
	          this.priceBoofe = (long) 1000;
	          this.priceKetabkhane = (long) 1000;
	          this.priceJakafshi = (long) 1000;
	          this.tedadkomod = 0;
	          this.tedadBoofe = 0;
	          this.tedadKetabkhane = 0;
	          this.tedadJakafshi = 0;
	   	      this.zekhametMdf="";
	   		 this.abadMdf="";
	   		  
	   		this.priceMetrMdf = (long) 1000;
	   		  
	   		this.priceTakhfifMetrMdf = (long) 1000;
	   		 	   		 
	   	     this.sheklehendesiMizJeJeloAsali="";
	   	  
	   	  this.tedadMizJeJeloAsali = 0;
	   	  
	   	   this.jenseEskeletMizJeJeloAsali="";
	   	  
	   	   this.jensePayeMizJeJeloAsali="";
	   	  
	   	   this.shisheMizJeJeloAsali="";
	   	  
	   	   this.noeShisheMizJeJeloAsali="";
	   	  
	   	   this.priceShisheMizJeJeloAsali = (long) 1000;
	   	  
	   	   this.descriptionMizJeJeloAsali="";
	       
	       
		    this.sheklehendesiMizٍEdari="";
		    this.tedadChantekeMizٍEdari=0;
		    this.jenseEskeletMizٍEdari="";
		    this.jensePayeMizٍEdari="";
		    this.shisheMizٍEdari="";
		    this.noeShisheMizٍEdari="";
		    this.priceShisheMizٍEdari = (long) 1000;
		    this.shisheAbzarMizٍEdari="";
		    this.keshoMizٍEdari="";
		    this.tedadkeshoMizٍEdari = 0;
		    this.komodMizٍEdari="";
		    this.tedadkomodMizٍEdari=0;
		    this.fazayeLavazemJanebiMizٍEdari="";
		    this.descriptionfazayeLavazemJanebiMizٍEdari="";
		    this.sheklehendesiMizJeloMobli="";
			  
			   this.tedadMizJeloMobli = 0;
			  
			  this.jenseEskeletMizJeloMobli="";
			  
			   this.jensePayeMizJeloMobli="";
			  
			   this.abadMizJeloMobli="";
			  
			   this.rangMizJeloMobli="";
			  
			   this.priceMizJeloMobli=(long) 1000;
			   this. shisheMizJeloMobli="";
			  
			   this.noeShisheMizJeloMobli="";
			  
			   this.priceShisheMizJeloMobli=(long) 1000;
			   this.shisheAbzarMizJeloMobli="";
			   
			   
			   this.tedadMizNaharKhori = 0;
				  
			   this.sakhtarMizNaharKhori="";
				  
				  this.descriptionMizNaharKhori="";
				  
				  this.sheklehendesiMizNaharKhori="";
				  
				  this.jenseSafeMizNaharKhori="";
				  
				  this.jenseEskeletMizNaharKhori="";
				  
				  this.jensePayeMizNaharKhori="";
				  
				  this.shisheMizNaharKhori="";
				  
				  this.rangeShisheMizNaharKhori="";
				  
				  this.zekhamatShisheMizNaharKhori="";
				  
				  this.priceShisheMizNaharKhori = (long) 1000;
				   this.shisheAbzarMizNaharKhori="";
				  
				  this.tedadSandaliMizNaharKhori=0;
				  
				  this.jenseFomSandaliMizNaharKhori="";
				  
				  this.jenseEsfangSandaliMizNaharKhori="";
				  
				  this.jenseEskeletSandaliMizNaharKhori="";
				  
				  this.jensePayeSandaliMizNaharKhori="";
				  
				  this.payeSandaliRangMizNaharKhori="";
				  
				  this.rangPayeSandaliMizNaharKhori="";
				  
				  this.jenseParcheSandaliMizNaharKhori="";
				  
				  this.nameParcheSandaliMizNaharKhori="";
				  
				  this.rangSelParcheSandaliMizNaharKhori="";
				  
				  this.rangParcheSandaliMizNaharKhori="";
				  
				  this.jenseEskeletMizTv="";
				  
				  this.abadMizTv="";
				  
				  this.mizMarbotTvInch = 0;
				  
				  this.rangMizTv="";
				  
				  this.gabeliatRangMizTv="";
				  
				  this.rangAvalMizTv="";
				  
				  this.rangDovomMizTv="";
				  
				  this.kesho="";

				  this.tedadkesho = 0;
				  
				  this.jensePayeMizTv="";
				  
				  this.rangPayeMizTv="";
				  
				  this.fazayeLavazemJanebi="";
				  
				  this.descriptionLavazemJanebi="";
				  
				  
				  this.noeMobl="";
					  
				 this.tedadMobl = 0;
					  
				 this.sakhtarMobl="";
					  
				 this.jenseFome="";
					  
				 this.jenseEsfanj="";
					  
				 this.jenseEskelet="";
					  
				 this.jensePaye="";
				 this.enetekhabRangPaye="";
					  
				 this.rangPaye="";
					  
				 this.jenseParche="";
					  
				 this.nameParche="";
					  
				 this.enetekhabRangParche="";
					  
				 this.rangParche="";
				 this.mekanizmTakhtsho="";
					  
					  this.descriptionMekanizmTakhtsho="";
				   this.kosan="";
					  
					 this.tedadKosan=0;
					  
					  this.abadKosanBozorg="";
					  
					  this.abadKosanKochak="";
					  
					  this.modelKosan="";
					  
					  this.jenseParcheKosan="";
					  
					  this.rangeParcheKosan="";
					  this.miz="";
					  
				      this.tedadMiz = 0;
					  
				      this.abadMiz="";
				      
				  
				      this.jenseMojasame="";
					  
				      this.abadMojasame="";
					  this.shostoshoMojasame="";
					  
					  
					  this.nameMdfMonabat="";
					  
					  this.zekhamatMdfMonabat="";
					  
					  this.keshvarMdfMonabat="";
					  
					  this.noeMonabat="";
					  
					  this.abadMonabat="";
					  
					  this.jenseMonabat="";
					  
					  
					  this.metrialPanjare="";
					  
					  this.noeRangPanjare="";
					  
					  this.jenseKalafPanjare="";
					  
					  this.makanPanjare="";
					  
	                  this.cncPanjare="";
					  
	                  this.zedeAbPanjare="";
					  
	                  this.shostoshoPanjare="";
	                  
	                  
	                  this.jenseSotonPartishen="";
	           	  
	                  this.jensePanelPartishen="";
	           	  
	                  this.jenseLabePartishen="";
	           	  
	                  this.rangPartishen="";
	           	      this.tarkibiPartishen="";
	           	  
	           	      this.noeTarkibPartishen="";
	           	  
	           	      this.ejrayePardePartishen=false;
	           	  
	           	      this.rangPardePartishen="";
	           	  
	           	      this.priceMetrPartishen = (long) 1000;
	           	  
	           	      this.priceTakhfifMetrPartishen = (long) 1000;
	           	      
	           	      
	           	   this.noeJenseSandaliEdari="";
	           		  
	           	this.abadSandaliEdari="";
	           		  
	           	this.rangSandaliEdari="";
	           		  
	           	this.jensePayeSandaliEdari="";
	           		  
	           	this.dasteSandaliEdari="";
	           		  
	           	this.noeSandaliEdari="";
	           		  
	           	this.tebiSandaliEdari="";
	           	
	           	
	           	this.modelServiceKhab="";
	      	 
	      	    this.arzeTakhteKhab=0;
	      	  this.jenseTakhtKhab="";
	      	  
	      	this.rangTakhtKhab="";
	      	  
	      	   this.priceTakhtKhab = (long) 1000;
	      	  
	      	   this.kalafTakhtJakDar="";
	      	   this.keshovbox="";
	      	this.patakhti="";
	      	
	      	this.tedadPaTakhti=0;
	      	this.jensePaTakhti="";
	      	  
	      	this.abadPaTakhti="";
	      	  
	      	this.rangPaTakhti="";
	      	  
	      	 this.pricePaTakhti = (long) 1000;
	      	this.komodServiceKhab="";
	      	this.jenseKomodServiceKhab="";
	      	this.abadKomodServiceKhab="";
	      	this.rangKomodServiceKhab="";
	      	 this.priceKomodServiceKhab = (long) 1000;
	      	  
	      	 this.mizArayesh="";
	      	 this.sandaliServiceKhab="";
	      	  
	      	this.jenseMizArayesh="";
	      	this.abadMizArayesh="";
	      	  
	      	this.rangMizArayesh="";
	      	  
	      	 this.priceMizArayesh = (long) 1000;
	      	  
	      	 this.mizTahrir="";
	      	this.jenseMizTahrir="";
	      	  
	      	this.abadMizTahrir="";
	      	  
	      	this.rangMizTahrir="";
	      	  
	      	 this.priceMizTahrir = (long) 1000;
	      	  
	      	  this.gabVayeneGadi="";
	      	  
	      	this.jenseGabVayeneGadi="";
	      	this.abadGabVayeneGadi="";
	      	this.rangGabVayeneGadi="";
	      	this.priceGabVayeneGadi = (long) 1000;
	      	  
	      	 this.toshak="";
	      	this.brandToshak="";
	      	  
	      	this.modelToshak="";
	      	  this.modatGharantiToshak =0;
	      	  
	      	this.abadToshak="";
	      	  
	      	this.priceToshak = (long) 1000;
	      	  
	      	  this.tozihatToshak="";
	      	
	      	
	      	this.modelServiceKhab2="";

	      	this.arzeTakhteKhab2 = 0;
	   	  
	      	this.jenseTakhteKhab2="";
	   	  
	      	this.rangeTakhteKhab2="";
	   	  
	   	   this.priceTakhteKhab2 =(long) 1000;
	   	  
	   	   this.kalafTakhtJackDar="";
	   	  
	   	   this.keshoVbox="";
	   	  
	   	   this.paTahti2="";
	   	  
	   	   this.tedadPaTakhti2=0;
	   	  
	   	this.jensePaTakhti2="";
	   	  
	   	this.abadPaTakhti2="";
	   	  
	   	this.rangPaTakhti2="";
	   	  
	   	  this.pricePaTakhti2 = (long) 1000;
	   	  
	   	  this.komodServiceKhab2="";
	   	  
	   	  this.jensekomodServiceKhab2="";
	   	  
	   	this.abadkomodServiceKhab2="";
	   	  
	   	this.rangkomodServiceKhab2="";
	   	  
	   	   this.priceKomodServiceKhab2=(long) 1000;
	   	  
	   	   this.mizArayesh2="";
	   	  
	  this.sandaliMizArayesh2="";
	   	  
	   	this.jenseMizArayesh2="";
	   	  
	   	this.abadMizArayesh2="";
	   	  
	   	this.rangMizArayesh2="";
	   	  
	   	this.priceMizArayesh2 =(long) 1000;
	   	  
	   	 this.mizTahrir2="";
	   	  
	   	this.jensemizTahrir2="";
	   	  
	   	this.abadmizTahrir2="";
	   	  
	   	this.rangmizTahrir2="";
	   	  
	   	   this.priceMizTahrir2 =(long) 1000;
	   	  
	   	   this.gabVAyeneGadi2="";
	   	  
	   	this.jenseGabVAyeneGadi2="";
	   	  
	   	this.abadGabVAyeneGadi2="";
	   	  
	   	this.rangGabVAyeneGadi2="";
	   	  
	   	  this.priceGabVAyeneGadi2 = (long) 1000;
	   	  
	   	  this.toshak2="";
	   	  
	   	this.brandToshak2="";
	   	  
	   	this.modelToshak2="";
	   	  
	   	 this.modatGarantiGabVAyeneGadi2=0;
	   	  
	   	this.abadToshak2="";
	   	  
	   	  this.priceToshak2 = (long) 1000;
	   	  
	   	this.descriptionToshak2="";
	   	
	   	
	   	this.modelServiceKhabNozad="";
		  
	   	this.jenseServiceKhabNozad="";
		  
	   	this.rangServiceKhabNozad="";
		  
		 this.priceServiceKhabNozad =(long) 1000;
		  
		 this.keshoVBox="";
		  
		 this.kenarMadari="";
		  
		 this.jenseKomodkenarMadari="";
		  
		 this.abadKomodkenarMadari="";
		  
		 this.rangKomodkenarMadari="";
		  
		 this.priceKomodkenarMadari =(long) 1000;
		  this.mizSandaliKodak="";
		  
		 this.tedadMizSandaliKodak = 0;
		  
		  this.jenseMizSandaliKodak="";
		  
		  this.abadMizKodak="";
		  
		  this.abadSandaliKodak="";
		  
		  this.priceMizSandaliKodak = (long) 1000;
		  
		  this.komodMizSandaliKodak="";
		  
		  this.jenseKomodMizSandaliKodak="";
		  
		  this.abadKomodMizSandaliKodak="";
		  
		  this.rangKomodMizSandaliKodak="";
		  
		  this.priceKomodMizSandaliKodak = (long) 1000;
		  this.mizArayeshMizSandaliKodak="";
		  
		  this.sandaliMizArayeshMizSandaliKodak="";
		  
		  this.jenseMizArayeshMizSandaliKodak="";
		  
		  this.abadMizArayeshMizSandaliKodak="";
		  
		  this.rangMizArayeshMizSandaliKodak="";
		  
		  this.priceMizArayeshMizSandaliKodak = (long) 1000;
		  this.vitrinKetabkhane="";
		  
		  this.jenseVitrinKetabkhane="";
		  
		  this.abadVitrinKetabkhane="";
		  
		  this.rangVitrinKetabkhane="";
		  
		  this.priceVitrinKetabkhane = (long) 1000;
		  this.shelfDivari="";
		  
		  this.jenseShelfDivari="";
		  
		  this.abadShelfDivari="";
		  
		  this.rangShelfDivari="";
		  
		  this.priceShelfDivari = (long) 1000;
		  
		   this.toshak3="";
		  
		   this.brandToshak3="";
		  
		   this.modelToshak3="";
		  
		   this.modatGarantiToshak3 = 0;
		  
		   this.abadToshak3="";
		  
		   this.priceToshak3 = (long) 1000;
		  
		   this.descriptionToshak3="";
		   this.aparat="";
		   this.instagram="";
	}
	
	
	public void insertToAyeneVConsol() {
		AyeneVConsole ayeneVConsole= new AyeneVConsole();
		ProductEntity productEntity = new ProductEntity();
		try {
			productEntity.setProduct(adminProfile.getMoblEntity());
			productEntity.setAparat(aparat);
			productEntity.setInstagram(instagram);
			productEntity.setNameCode(nameCode);
			productEntity.setBrand(brand);
			productEntity.setContry(contry);
			productEntity.setAbad(abad);
			productEntity.setTahvilDay(TahvilDay);
			productEntity.setEasyNezafat(convertBool(easyNezafat));
			productEntity.setDescription(description);
			productEntity.setStatus(convertBool(status));
			productEntity.setPrice(price);
			productEntity.setPrice2(price2);
			productEntity.setOldNew(convertBool(oldNew));
			productEntity.setZemanat(zemanat);
			productEntity.setGuarantiStatus(guarantiStatus);
			productEntity.setGuaranyTimeMounth(guaranyTimeMounth);
			productEntity.setRangBandi(rangBandi);
			productEntity.setpDate(new Date());
		ayeneVConsole.setJenseEskeletConsole(jenseEskeletConsole);
		ayeneVConsole.setJensePayeConsole(jensePayeConsole);
		ayeneVConsole.setPriceConsole(priceConsole);
		ayeneVConsole.setKeshoConsole(convertBool(keshoConsole));
		ayeneVConsole.setAyeneConsole(convertBool(ayeneConsole));
		ayeneVConsole.setTedadAyene(tedadAyene);
		ayeneVConsole.setShekleHendesi(shekleHendesi);
		ayeneVConsole.setZekhamatAyene(zekhamatAyene);
		ayeneVConsole.setAyeneGhab(convertBool(ayeneGhab));
		ayeneVConsole.setJenseGhab(jenseGhab);
		ayeneVConsole.setAbadGhabAyene(abadGhabAyene);
		ayeneVConsole.setRangGhabAyene(rangGhabAyene);
    	ayeneVConsole.setPriceGhabAyene(priceGhabAyene);
    	ayeneVConsole.setKomodConsole(convertBool(komodConsole));
		if (pic1 != null) {
             if (!pic1.getContentType().equals("image/jpeg")) {
				throw new Exception("pic1Type");
			} else {
				productEntity.setPic1(convertPicture(pic1));
			}
		}
		if (pic2 != null) {
             if (!pic2.getContentType().equals("image/jpeg")) {
				throw new Exception("pic2Type");
			} else {
				productEntity.setPic2(convertPicture(pic2));
			}
		}
		if (pic3 != null) {
			if (!pic3.getContentType().equals("image/jpeg")) {
				throw new Exception("pic3Type");
			} else {
				productEntity.setPic3(convertPicture(pic3));
			}
		}
		if (pic4 != null) {
			if (!pic4.getContentType().equals("image/jpeg")) {
				throw new Exception("pic4Type");
			} else {
				productEntity.setPic4(convertPicture(pic4));
			}
		}
		if (pic5 != null) {
			if (!pic5.getContentType().equals("image/jpeg")) {
				throw new Exception("pic5Type");
			} else {
				productEntity.setPic5(convertPicture(pic5));
			}
		}
		productEntity.setRaste(faaliatHa());
    	ayeneVConsole.setTedadKesho(tedadKesho);
		ayeneVConsole.setTedadKomod(tedadKomod);
		productEntity.setAyeneVConsole(ayeneVConsole);
		    productDaoLocal.insertToProduct(productEntity);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("*****************************با موفقیت وارد گردید************************"));
			emptyInp();
		} catch (Exception e) {
			if(e.getMessage().equals("pic1Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic1Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic2Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic2Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic3Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic3Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic4Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic4Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic5Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic5Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage()==null)
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));

		}
	}
	
	
	public void insertToDarbChobi() {
		DarbChobi darbChobi = new DarbChobi();
		ProductEntity productEntity = new ProductEntity();
		try {
			productEntity.setProduct(adminProfile.getMoblEntity());
			productEntity.setAparat(aparat);
			productEntity.setInstagram(instagram);
			productEntity.setNameCode(nameCode);
			productEntity.setBrand(brand);
			productEntity.setContry(contry);
			productEntity.setAbad(abad);
			productEntity.setTahvilDay(TahvilDay);
			productEntity.setEasyNezafat(convertBool(easyNezafat));
			productEntity.setDescription(description);
			productEntity.setStatus(convertBool(status));
			productEntity.setPrice(price);
			productEntity.setPrice2(price2);
			productEntity.setOldNew(convertBool(oldNew));
			productEntity.setZemanat(zemanat);
			productEntity.setGuarantiStatus(guarantiStatus);
		if (pic1 != null) {
if (!pic1.getContentType().equals("image/jpeg")) {
				throw new Exception("pic1Type");
			} else {
				productEntity.setPic1(convertPicture(pic1));
			}
		}
		if (pic2 != null) {
if (!pic2.getContentType().equals("image/jpeg")) {
				throw new Exception("pic2Type");
			} else {
				productEntity.setPic2(convertPicture(pic2));
			}
		}
		if (pic3 != null) {
 if (!pic3.getContentType().equals("image/jpeg")) {
				throw new Exception("pic3Type");
			} else {
				productEntity.setPic3(convertPicture(pic3));
			}
		}
		if (pic4 != null) {
 if (!pic4.getContentType().equals("image/jpeg")) {
				throw new Exception("pic4Type");
			} else {
				productEntity.setPic4(convertPicture(pic4));
			}
		}
		if (pic5 != null) {
 if (!pic5.getContentType().equals("image/jpeg")) {
				throw new Exception("pic5Type");
			} else {
				productEntity.setPic5(convertPicture(pic5));
			}
		}
		productEntity.setRaste(faaliatHa());
		productEntity.setpDate(new Date());
		productEntity.setGuaranyTimeMounth(guaranyTimeMounth);
		productEntity.setRangBandi(rangBandi);
		//////////////////////////////////////////////
		darbChobi.setRokeshDarbChobi(rokeshDarbChobi);
		darbChobi.setShostoshoDarbChobi(this.convertBool(shostoshoDarbChobi));
		darbChobi.setZedeAbDarbChobi(this.convertBool(zedeAbDarbChobi));
		darbChobi.setCncDarbChobi(this.convertBool(cncDarbChobi));
		darbChobi.setJenseKalafDarbChobi(jenseKalafDarbChobi);
		darbChobi.setMakanDarbChobi(makanDarbChobi);
		darbChobi.setNoeRangDarbChobi(noeRangDarbChobi);
		darbChobi.setZekhamatDarbChobi(zekhamatDarbChobi);
		productEntity.setRaste(faaliatHa());
		productEntity.setDarbChobi(darbChobi);
			productDaoLocal.insertToProduct(productEntity);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("*****************************با موفقیت وارد گردید************************"));
			emptyInp();
		} catch (Exception e) {
			if(e.getMessage().equals("pic1Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic1Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic2Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic2Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic3Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic3Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic4Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic4Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic5Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic5Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage()==null)
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));

		}
	}
	
	public void insertToDarbZedSergat() {
		ProductEntity productEntity= new ProductEntity();
		DarbZedSergat darbZedSergat = new DarbZedSergat();
		try {
		productEntity.setProduct(adminProfile.getMoblEntity());
		productEntity.setAparat(aparat);
		productEntity.setInstagram(instagram);
		productEntity.setNameCode(nameCode);
		productEntity.setBrand(brand);
		productEntity.setContry(contry);
		productEntity.setAbad(abad);
		productEntity.setTahvilDay(TahvilDay);
		productEntity.setEasyNezafat(convertBool(easyNezafat));
		productEntity.setDescription(description);
		productEntity.setStatus(convertBool(status));
		productEntity.setPrice(price);
		productEntity.setPrice2(price2);
		productEntity.setOldNew(convertBool(oldNew));
		productEntity.setZemanat(zemanat);
		productEntity.setGuarantiStatus(guarantiStatus);
		if (pic1 != null) {
 if (!pic1.getContentType().equals("image/jpeg")) {
				throw new Exception("pic1Type");
			} else {
				productEntity.setPic1(convertPicture(pic1));
			}
		}
		if (pic2 != null) {
 if (!pic2.getContentType().equals("image/jpeg")) {
				throw new Exception("pic2Type");
			} else {
				productEntity.setPic2(convertPicture(pic2));
			}
		}
		if (pic3 != null) {
 if (!pic3.getContentType().equals("image/jpeg")) {
				throw new Exception("pic3Type");
			} else {
				productEntity.setPic3(convertPicture(pic3));
			}
		}
		if (pic4 != null) {
 if (!pic4.getContentType().equals("image/jpeg")) {
				throw new Exception("pic4Type");
			} else {
				productEntity.setPic4(convertPicture(pic4));
			}
		}
		if (pic5 != null) {
if (!pic5.getContentType().equals("image/jpeg")) {
				throw new Exception("pic5Type");
			} else {
				productEntity.setPic5(convertPicture(pic5));
			}
		}
		productEntity.setRaste(faaliatHa());
		productEntity.setpDate(new Date());
		productEntity.setGuaranyTimeMounth(guaranyTimeMounth);
		productEntity.setRangBandi(rangBandi);
		//////////////////////////////////////////////
		darbZedSergat.setCncDarbZedSergat(convertBool(cncDarbZedSergat));
		darbZedSergat.setGoflPostchiDarbZedSergat(convertBool(goflPostchiDarbZedSergat));
		darbZedSergat.setGotiBandiFeleziDarbZedSergat(convertBool(gotiBandiFeleziDarbZedSergat));
		darbZedSergat.setKeshvarMdfDarbZedSergat(keshvarMdfDarbZedSergat);
		darbZedSergat.setMetrilJelogiriDarbZedSergat(convertBool(metrilJelogiriDarbZedSergat));
		darbZedSergat.setNameMdfDarbZedSergat(nameMdfDarbZedSergat);
		darbZedSergat.setNasbPostchiDarbZedSergat(convertBool(nasbPostchiDarbZedSergat));
		darbZedSergat.setRangDarbZedSergat(rangDarbZedSergat);
		darbZedSergat.setRokeshDarbZedSergat(rokeshDarbZedSergat);
		darbZedSergat.setSedagiriDarbZedSergat(convertBool(sedagiriDarbZedSergat));
		darbZedSergat.setVaragFeleziDarbZedSergat(varagFeleziDarbZedSergat);
		darbZedSergat.setZedeAbDarbZedSergat(convertBool(zekhamatVaragFeleziDarbZedSergat));
		darbZedSergat.setZedeDeylamDarbZedSergat(convertBool(zedeAbDarbZedSergat));
		darbZedSergat.setZekhamatMdfDarbZedSergat(zekhamatMdfDarbZedSergat);
		darbZedSergat.setZekhamatVaragFeleziDarbZedSergat(zekhamatVaragFeleziDarbZedSergat);
		productEntity.setRaste(faaliatHa());
		productEntity.setDarbZedSergat(darbZedSergat);
		    productDaoLocal.insertToProduct(productEntity);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("*****************************با موفقیت وارد گردید************************"));
			emptyInp();
		} catch (Exception e) {
			if(e.getMessage().equals("pic1Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic1Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic2Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic2Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic3Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic3Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic4Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic4Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic5Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic5Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage()==null)
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));
		}
	}
	
	public void insertToGhabAx() {
		ProductEntity productEntity= new ProductEntity();
		GhabAx ghabAx =new GhabAx();
		try {
		productEntity.setProduct(adminProfile.getMoblEntity());
		productEntity.setAparat(aparat);
		productEntity.setInstagram(instagram);
		productEntity.setNameCode(nameCode);
		productEntity.setBrand(brand);
		productEntity.setContry(contry);
		productEntity.setAbad(abad);
		productEntity.setTahvilDay(TahvilDay);
		productEntity.setEasyNezafat(convertBool(easyNezafat));
		productEntity.setDescription(description);
		productEntity.setStatus(convertBool(status));
		productEntity.setPrice(price);
		productEntity.setPrice2(price2);
		productEntity.setOldNew(convertBool(oldNew));
		productEntity.setZemanat(zemanat);
		productEntity.setGuarantiStatus(guarantiStatus);
		if (pic1 != null) {
 if (!pic1.getContentType().equals("image/jpeg")) {
				throw new Exception("pic1Type");
			} else {
				productEntity.setPic1(convertPicture(pic1));
			}
		}
		if (pic2 != null) {
 if (!pic2.getContentType().equals("image/jpeg")) {
				throw new Exception("pic2Type");
			} else {
				productEntity.setPic2(convertPicture(pic2));
			}
		}
		if (pic3 != null) {
 if (!pic3.getContentType().equals("image/jpeg")) {
				throw new Exception("pic3Type");
			} else {
				productEntity.setPic3(convertPicture(pic3));
			}
		}
		if (pic4 != null) {
 if (!pic4.getContentType().equals("image/jpeg")) {
				throw new Exception("pic4Type");
			} else {
				productEntity.setPic4(convertPicture(pic4));
			}
		}
		if (pic5 != null) {
 if (!pic5.getContentType().equals("image/jpeg")) {
				throw new Exception("pic5Type");
			} else {
				productEntity.setPic5(convertPicture(pic5));
			}
		}
		productEntity.setRaste(faaliatHa());
		productEntity.setpDate(new Date());
		productEntity.setGuaranyTimeMounth(guaranyTimeMounth);
		productEntity.setRangBandi(rangBandi);
		productEntity.setRaste(faaliatHa());
		//////////////////////////////////////////////
		ghabAx.setAbadGabeAx(abadGabeAx);
		ghabAx.setAbadMofidGabeAx(abadMofidGabeAx);
		ghabAx.setJenseGabeAx(jenseGabeAx);
		productEntity.setGhabAx(ghabAx);
		    productDaoLocal.insertToProduct(productEntity);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("*****************************با موفقیت وارد گردید************************"));
			emptyInp();
		} catch (Exception e) {
			if(e.getMessage().equals("pic1Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic1Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic2Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic2Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic3Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic3Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic4Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic4Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic5Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic5Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage()==null)
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));
		}
	}
	
	public void insertToKabinet() {
		ProductEntity productEntity= new ProductEntity();
		Kabinet kabinet =new Kabinet();
		try {
		productEntity.setProduct(adminProfile.getMoblEntity());
		productEntity.setNameCode(nameCode);
		productEntity.setAparat(aparat);
		productEntity.setInstagram(instagram);
		productEntity.setBrand(brand);
		productEntity.setContry(contry);
		productEntity.setAbad(abad);
		productEntity.setTahvilDay(TahvilDay);
		productEntity.setEasyNezafat(convertBool(easyNezafat));
		productEntity.setDescription(description);
		productEntity.setStatus(convertBool(status));
		productEntity.setPrice(price);
		productEntity.setPrice2(price2);
		productEntity.setOldNew(convertBool(oldNew));
		productEntity.setZemanat(zemanat);
		productEntity.setGuarantiStatus(guarantiStatus);
		if (pic1 != null) {
 if (!pic1.getContentType().equals("image/jpeg")) {
				throw new Exception("pic1Type");
			} else {
				productEntity.setPic1(convertPicture(pic1));
			}
		}
		if (pic2 != null) {
 if (!pic2.getContentType().equals("image/jpeg")) {
				throw new Exception("pic2Type");
			} else {
				productEntity.setPic2(convertPicture(pic2));
			}
		}
		if (pic3 != null) {
 if (!pic3.getContentType().equals("image/jpeg")) {
				throw new Exception("pic3Type");
			} else {
				productEntity.setPic3(convertPicture(pic3));
			}
		}
		if (pic4 != null) {
 if (!pic4.getContentType().equals("image/jpeg")) {
				throw new Exception("pic4Type");
			} else {
				productEntity.setPic4(convertPicture(pic4));
			}
		}
		if (pic5 != null) {
 if (!pic5.getContentType().equals("image/jpeg")) {
				throw new Exception("pic5Type");
			} else {
				productEntity.setPic5(convertPicture(pic5));
			}
		}
		productEntity.setRaste(faaliatHa());
		productEntity.setpDate(new Date());
		productEntity.setGuaranyTimeMounth(guaranyTimeMounth);
		productEntity.setRangBandi(rangBandi);
		productEntity.setRaste(faaliatHa());
		//////////////////////////////////////////////
		kabinet.setAbadMdfKabinet(abadMdfKabinet);
		kabinet.setCharkhKabinet(convertBool(charkhKabinet));
		kabinet.setDastgireDarbKabinet(convertBool(dastgireDarbKabinet));
		kabinet.setJakKabinet(convertBool(jakKabinet));
		kabinet.setJenseKabinet(jenseKabinet);
		kabinet.setJenseSafeKabinet(jenseSafeKabinet);
		kabinet.setMagnetKabinet(convertBool(magnetKabinet));
		kabinet.setNoeMdfKabinet(noeMdfKabinet);
		kabinet.setPriceMetrKabinet(priceMetrKabinet);
		kabinet.setPriceMetrTakhfifKabinet(priceMetrTakhfifKabinet);
		kabinet.setReylKabinet(convertBool(reylKabinet));
		kabinet.setZekhamateMdfKabinet(zekhamateMdfKabinet);
		productEntity.setKabinet(kabinet);
		    productDaoLocal.insertToProduct(productEntity);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("*****************************با موفقیت وارد گردید************************"));
			emptyInp();
		} catch (Exception e) {
			if(e.getMessage().equals("pic1Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic1Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic2Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic2Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic3Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic3Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic4Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic4Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic5Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic5Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage()==null)
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));
		}
	}
	
	public void insertKomodBoofeKetabkhaneJakafshi() {
		ProductEntity productEntity= new ProductEntity();
		KomodBoofeKetabkhaneJakafshi komodBoofeKetabkhaneJakafshi = new KomodBoofeKetabkhaneJakafshi();
		try {
		productEntity.setProduct(adminProfile.getMoblEntity());
		productEntity.setNameCode(nameCode);
		productEntity.setAparat(aparat);
		productEntity.setInstagram(instagram);
		productEntity.setBrand(brand);
		productEntity.setContry(contry);
		productEntity.setAbad(abad);
		productEntity.setTahvilDay(TahvilDay);
		productEntity.setEasyNezafat(convertBool(easyNezafat));
		productEntity.setDescription(description);
		productEntity.setStatus(convertBool(status));
		productEntity.setPrice(price);
		productEntity.setPrice2(price2);
		productEntity.setOldNew(convertBool(oldNew));
		productEntity.setZemanat(zemanat);
		productEntity.setGuarantiStatus(guarantiStatus);
		if (pic1 != null) {
 if (!pic1.getContentType().equals("image/jpeg")) {
				throw new Exception("pic1Type");
			} else {
				productEntity.setPic1(convertPicture(pic1));
			}
		}
		if (pic2 != null) {
 if (!pic2.getContentType().equals("image/jpeg")) {
				throw new Exception("pic2Type");
			} else {
				productEntity.setPic2(convertPicture(pic2));
			}
		}
		if (pic3 != null) {
 if (!pic3.getContentType().equals("image/jpeg")) {
				throw new Exception("pic3Type");
			} else {
				productEntity.setPic3(convertPicture(pic3));
			}
		}
		if (pic4 != null) {
 if (!pic4.getContentType().equals("image/jpeg")) {
				throw new Exception("pic4Type");
			} else {
				productEntity.setPic4(convertPicture(pic4));
			}
		}
		if (pic5 != null) {
 if (!pic5.getContentType().equals("image/jpeg")) {
				throw new Exception("pic5Type");
			} else {
				productEntity.setPic5(convertPicture(pic5));
			}
		}
		productEntity.setRaste(faaliatHa());
		productEntity.setpDate(new Date());
		productEntity.setGuaranyTimeMounth(guaranyTimeMounth);
		productEntity.setRangBandi(rangBandi);
		productEntity.setRaste(faaliatHa());
		//////////////////////////////////////////////
		komodBoofeKetabkhaneJakafshi.setAbadBoofe(abadBoofe);
		komodBoofeKetabkhaneJakafshi.setAbadJakafshi(abadJakafshi);
		komodBoofeKetabkhaneJakafshi.setAbadKetabkhane(abadKetabkhane);
		komodBoofeKetabkhaneJakafshi.setAbadkomod(abadkomod);
		komodBoofeKetabkhaneJakafshi.setJenseBoofe(jenseBoofe);
		komodBoofeKetabkhaneJakafshi.setJenseJakafshi(jenseJakafshi);
		komodBoofeKetabkhaneJakafshi.setJenseKetabkhane(jenseKetabkhane);
		komodBoofeKetabkhaneJakafshi.setJensekomod(jensekomod);
		komodBoofeKetabkhaneJakafshi.setPriceBoofe(priceBoofe);
		komodBoofeKetabkhaneJakafshi.setPriceJakafshi(priceJakafshi);
		komodBoofeKetabkhaneJakafshi.setPriceKetabkhane(priceKetabkhane);
		komodBoofeKetabkhaneJakafshi.setPricekomod(pricekomod);
		komodBoofeKetabkhaneJakafshi.setShekleHendesiBoofe(shekleHendesiBoofe);
		komodBoofeKetabkhaneJakafshi.setShekleHendesiJakafshi(shekleHendesiJakafshi);
		komodBoofeKetabkhaneJakafshi.setShekleHendesiKetabkhane(shekleHendesiKetabkhane);
		komodBoofeKetabkhaneJakafshi.setShekleHendesikomod(shekleHendesikomod);
		komodBoofeKetabkhaneJakafshi.setTedadBoofe(tedadBoofe);
		komodBoofeKetabkhaneJakafshi.setTedadJakafshi(tedadJakafshi);
		komodBoofeKetabkhaneJakafshi.setTedadKetabkhane(tedadKetabkhane);
		komodBoofeKetabkhaneJakafshi.setTedadkomod(tedadkomod);
		productEntity.setKomodBoofeKetabkhaneJakafshi(komodBoofeKetabkhaneJakafshi);
		    productDaoLocal.insertToProduct(productEntity);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("*****************************با موفقیت وارد گردید************************"));
			emptyInp();
		} catch (Exception e) {
			if(e.getMessage().equals("pic1Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic1Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic2Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic2Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic3Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic3Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic4Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic4Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic5Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic5Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage()==null)
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));
		}
	}
	
	
	public void insertMdf() {
		ProductEntity productEntity= new ProductEntity();
		Mdf mdf = new Mdf();
		try {
		productEntity.setProduct(adminProfile.getMoblEntity());
		productEntity.setNameCode(nameCode);
		productEntity.setAparat(aparat);
		productEntity.setInstagram(instagram);
		productEntity.setBrand(brand);
		productEntity.setContry(contry);
		productEntity.setAbad(abad);
		productEntity.setTahvilDay(TahvilDay);
		productEntity.setEasyNezafat(convertBool(easyNezafat));
		productEntity.setDescription(description);
		productEntity.setStatus(convertBool(status));
		productEntity.setPrice(price);
		productEntity.setPrice2(price2);
		productEntity.setOldNew(convertBool(oldNew));
		productEntity.setZemanat(zemanat);
		productEntity.setGuarantiStatus(guarantiStatus);
		if (pic1 != null) {
              if (!pic1.getContentType().equals("image/jpeg")) {
				throw new Exception("pic1Type");
			} else {
				productEntity.setPic1(convertPicture(pic1));
			}
		}
		if (pic2 != null) {
if (!pic2.getContentType().equals("image/jpeg")) {
				throw new Exception("pic2Type");
			} else {
				productEntity.setPic2(convertPicture(pic2));
			}
		}
		if (pic3 != null) {
 if (!pic3.getContentType().equals("image/jpeg")) {
				throw new Exception("pic3Type");
			} else {
				productEntity.setPic3(convertPicture(pic3));
			}
		}
		if (pic4 != null) {
if (!pic4.getContentType().equals("image/jpeg")) {
				throw new Exception("pic4Type");
			} else {
				productEntity.setPic4(convertPicture(pic4));
			}
		}
		if (pic5 != null) {
 if (!pic5.getContentType().equals("image/jpeg")) {
				throw new Exception("pic5Type");
			} else {
				productEntity.setPic5(convertPicture(pic5));
			}
		}
		productEntity.setRaste(faaliatHa());
		productEntity.setpDate(new Date());
		productEntity.setGuaranyTimeMounth(guaranyTimeMounth);
		productEntity.setRangBandi(rangBandi);
		productEntity.setRaste(faaliatHa());
		//////////////////////////////////////////////
		mdf.setAbadMdf(abadMdf);
		mdf.setPriceMetrMdf(priceMetrMdf);
		mdf.setPriceTakhfifMetrMdf(priceTakhfifMetrMdf);
		mdf.setZekhametMdf(zekhametMdf);
		productEntity.setMdf(mdf);
            productDaoLocal.insertToProduct(productEntity);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("*****************************با موفقیت وارد گردید************************"));
			emptyInp();
		} catch (Exception e) {
			if(e.getMessage().equals("pic1Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic1Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic2Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic2Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic3Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic3Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic4Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic4Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic5Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic5Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage()==null)
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));
		}
	}
	
	public void insertToMizAsali() {
		ProductEntity productEntity= new ProductEntity();
		MizAsali mizAsali = new MizAsali();
		try {
		productEntity.setProduct(adminProfile.getMoblEntity());
		productEntity.setNameCode(nameCode);
		productEntity.setAparat(aparat);
		productEntity.setInstagram(instagram);
		productEntity.setBrand(brand);
		productEntity.setContry(contry);
		productEntity.setAbad(abad);
		productEntity.setTahvilDay(TahvilDay);
		productEntity.setEasyNezafat(convertBool(easyNezafat));
		productEntity.setDescription(description);
		productEntity.setStatus(convertBool(status));
		productEntity.setPrice(price);
		productEntity.setPrice2(price2);
		productEntity.setOldNew(convertBool(oldNew));
		productEntity.setZemanat(zemanat);
		productEntity.setGuarantiStatus(guarantiStatus);
		if (pic1 != null) {
if (!pic1.getContentType().equals("image/jpeg")) {
				throw new Exception("pic1Type");
			} else {
				productEntity.setPic1(convertPicture(pic1));
			}
		}
		if (pic2 != null) {
 if (!pic2.getContentType().equals("image/jpeg")) {
				throw new Exception("pic2Type");
			} else {
				productEntity.setPic2(convertPicture(pic2));
			}
		}
		if (pic3 != null) {
 if (!pic3.getContentType().equals("image/jpeg")) {
				throw new Exception("pic3Type");
			} else {
				productEntity.setPic3(convertPicture(pic3));
			}
		}
		if (pic4 != null) {
 if (!pic4.getContentType().equals("image/jpeg")) {
				throw new Exception("pic4Type");
			} else {
				productEntity.setPic4(convertPicture(pic4));
			}
		}
		if (pic5 != null) {
 if (!pic5.getContentType().equals("image/jpeg")) {
				throw new Exception("pic5Type");
			} else {
				productEntity.setPic5(convertPicture(pic5));
			}
		}
		productEntity.setRaste(faaliatHa());
		productEntity.setpDate(new Date());
		productEntity.setGuaranyTimeMounth(guaranyTimeMounth);
		productEntity.setRangBandi(rangBandi);
		productEntity.setRaste(faaliatHa());
		//////////////////////////////////////////////
		mizAsali.setDescriptionMizJeJeloAsali(descriptionMizJeJeloAsali);
		mizAsali.setJenseEskeletMizJeJeloAsali(jenseEskeletMizJeJeloAsali);
		mizAsali.setJensePayeMizJeJeloAsali(jensePayeMizJeJeloAsali);
		mizAsali.setNoeShisheMizJeJeloAsali(noeShisheMizJeJeloAsali);
		mizAsali.setPriceShisheMizJeJeloAsali(priceShisheMizJeJeloAsali);
		mizAsali.setSheklehendesiMizJeJeloAsali(sheklehendesiMizJeJeloAsali);
		mizAsali.setTedadMizJeJeloAsali(tedadMizJeJeloAsali);
		productEntity.setMizAsali(mizAsali);
		productDaoLocal.insertToProduct(productEntity);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("*****************************با موفقیت وارد گردید************************"));
			emptyInp();
		} catch (Exception e) {
			if(e.getMessage().equals("pic1Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic1Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic2Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic2Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic3Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic3Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic4Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic4Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic5Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic5Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage()==null)
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));
		}
	}
	
	public void insertToMizEdari() {
		ProductEntity productEntity= new ProductEntity();
		MizEdari mizEdari = new MizEdari();
		try {
		productEntity.setProduct(adminProfile.getMoblEntity());
		productEntity.setNameCode(nameCode);
		productEntity.setAparat(aparat);
		productEntity.setInstagram(instagram);
		productEntity.setBrand(brand);
		productEntity.setContry(contry);
		productEntity.setAbad(abad);
		productEntity.setTahvilDay(TahvilDay);
		productEntity.setEasyNezafat(convertBool(easyNezafat));
		productEntity.setDescription(description);
		productEntity.setStatus(convertBool(status));
		productEntity.setPrice(price);
		productEntity.setPrice2(price2);
		productEntity.setOldNew(convertBool(oldNew));
		productEntity.setZemanat(zemanat);
		productEntity.setGuarantiStatus(guarantiStatus);
		if (pic1 != null) {
 if (!pic1.getContentType().equals("image/jpeg")) {
				throw new Exception("pic1Type");
			} else {
				productEntity.setPic1(convertPicture(pic1));
			}
		}
		if (pic2 != null) {
 if (!pic2.getContentType().equals("image/jpeg")) {
				throw new Exception("pic2Type");
			} else {
				productEntity.setPic2(convertPicture(pic2));
			}
		}
		if (pic3 != null) {
 if (!pic3.getContentType().equals("image/jpeg")) {
				throw new Exception("pic3Type");
			} else {
				productEntity.setPic3(convertPicture(pic3));
			}
		}
		if (pic4 != null) {
 if (!pic4.getContentType().equals("image/jpeg")) {
				throw new Exception("pic4Type");
			} else {
				productEntity.setPic4(convertPicture(pic4));
			}
		}
		if (pic5 != null) {
 if (!pic5.getContentType().equals("image/jpeg")) {
				throw new Exception("pic5Type");
			} else {
				productEntity.setPic5(convertPicture(pic5));
			}
		}
		productEntity.setRaste(faaliatHa());
		productEntity.setpDate(new Date());
		productEntity.setGuaranyTimeMounth(guaranyTimeMounth);
		productEntity.setRangBandi(rangBandi);
		productEntity.setRaste(faaliatHa());
		//////////////////////////////////////////////
		mizEdari.setDescriptionfazayeLavazemJanebiMizٍEdari(descriptionfazayeLavazemJanebiMizٍEdari);
		mizEdari.setFazayeLavazemJanebiMizٍEdari(convertBool(fazayeLavazemJanebiMizٍEdari));
		mizEdari.setJenseEskeletMizٍEdari(jenseEskeletMizٍEdari);
		mizEdari.setJensePayeMizٍEdari(jensePayeMizٍEdari);
		mizEdari.setKeshoMizٍEdari(convertBool(keshoMizٍEdari));
		mizEdari.setKomodMizٍEdari(convertBool(komodMizٍEdari));
		mizEdari.setNoeShisheMizٍEdari(noeShisheMizٍEdari);
		mizEdari.setPriceShisheMizٍEdari(priceShisheMizٍEdari);
		mizEdari.setSheklehendesiMizٍEdari(sheklehendesiMizٍEdari);
		mizEdari.setTedadChantekeMizٍEdari(tedadChantekeMizٍEdari);
		mizEdari.setTedadkeshoMizٍEdari(tedadkeshoMizٍEdari);
		mizEdari.setTedadkomodMizٍEdari(tedadkomodMizٍEdari);
		productEntity.setMizEdari(mizEdari);
		productDaoLocal.insertToProduct(productEntity);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("*****************************با موفقیت وارد گردید************************"));
			emptyInp();
		} catch (Exception e) {
			if(e.getMessage().equals("pic1Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic1Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic2Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic2Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic3Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic3Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic4Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic4Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic5Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic5Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage()==null)
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));
		}
	}
	
	public void insertToMizJeloMobli() {
		ProductEntity productEntity= new ProductEntity();
		MizJeloMobli mizJeloMobli = new MizJeloMobli();
		try {
		productEntity.setProduct(adminProfile.getMoblEntity());
		productEntity.setNameCode(nameCode);
		productEntity.setAparat(aparat);
		productEntity.setInstagram(instagram);
		productEntity.setBrand(brand);
		productEntity.setContry(contry);
		productEntity.setAbad(abad);
		productEntity.setTahvilDay(TahvilDay);
		productEntity.setEasyNezafat(convertBool(easyNezafat));
		productEntity.setDescription(description);
		productEntity.setStatus(convertBool(status));
		productEntity.setPrice(price);
		productEntity.setPrice2(price2);
		productEntity.setOldNew(convertBool(oldNew));
		productEntity.setZemanat(zemanat);
		productEntity.setGuarantiStatus(guarantiStatus);
		if (pic1 != null) {
	 if (!pic1.getContentType().equals("image/jpeg")) {
				throw new Exception("pic1Type");
			} else {
				productEntity.setPic1(convertPicture(pic1));
			}
		}
		if (pic2 != null) {
 if (!pic2.getContentType().equals("image/jpeg")) {
				throw new Exception("pic2Type");
			} else {
				productEntity.setPic2(convertPicture(pic2));
			}
		}
		if (pic3 != null) {
 if (!pic3.getContentType().equals("image/jpeg")) {
				throw new Exception("pic3Type");
			} else {
				productEntity.setPic3(convertPicture(pic3));
			}
		}
		if (pic4 != null) {
if (!pic4.getContentType().equals("image/jpeg")) {
				throw new Exception("pic4Type");
			} else {
				productEntity.setPic4(convertPicture(pic4));
			}
		}
		if (pic5 != null) {
 if (!pic5.getContentType().equals("image/jpeg")) {
				throw new Exception("pic5Type");
			} else {
				productEntity.setPic5(convertPicture(pic5));
			}
		}
		productEntity.setRaste(faaliatHa());
		productEntity.setpDate(new Date());
		productEntity.setGuaranyTimeMounth(guaranyTimeMounth);
		productEntity.setRangBandi(rangBandi);
		productEntity.setRaste(faaliatHa());
		//////////////////////////////////////////////
		mizJeloMobli.setAbadMizJeloMobli(abadMizJeloMobli);
		mizJeloMobli.setJenseEskeletMizJeloMobli(jenseEskeletMizJeloMobli);
		mizJeloMobli.setJensePayeMizJeloMobli(jensePayeMizJeloMobli);
		mizJeloMobli.setNoeShisheMizJeloMobli(noeShisheMizJeloMobli);
		mizJeloMobli.setPriceMizJeloMobli(priceMizJeloMobli);
		mizJeloMobli.setPriceShisheMizJeloMobli(priceShisheMizJeloMobli);
		mizJeloMobli.setRangMizJeloMobli(rangMizJeloMobli);
		mizJeloMobli.setSheklehendesiMizJeloMobli(sheklehendesiMizJeloMobli);
		mizJeloMobli.setShisheAbzarMizJeloMobli(convertBool(shisheAbzarMizJeloMobli));
		mizJeloMobli.setShisheMizJeloMobli(convertBool(shisheAbzarMizJeloMobli));
		mizJeloMobli.setTedadMizJeloMobli(tedadMizJeloMobli);
		productEntity.setMizJeloMobli(mizJeloMobli);
		productDaoLocal.insertToProduct(productEntity);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("*****************************با موفقیت وارد گردید************************"));
			emptyInp();
		} catch (Exception e) {
			if(e.getMessage().equals("pic1Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic1Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic2Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic2Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic3Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic3Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic4Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic4Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic5Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic5Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage()==null)
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));
		}
	}
	
	public void insertToMizNaharKhori() {
		ProductEntity productEntity= new ProductEntity();
		MizNaharKhori mizNaharKhori = new MizNaharKhori();
		try {
		productEntity.setProduct(adminProfile.getMoblEntity());
		productEntity.setNameCode(nameCode);
		productEntity.setAparat(aparat);
		productEntity.setInstagram(instagram);
		productEntity.setBrand(brand);
		productEntity.setContry(contry);
		productEntity.setAbad(abad);
		productEntity.setTahvilDay(TahvilDay);
		productEntity.setEasyNezafat(convertBool(easyNezafat));
		productEntity.setDescription(description);
		productEntity.setStatus(convertBool(status));
		productEntity.setPrice(price);
		productEntity.setPrice2(price2);
		productEntity.setOldNew(convertBool(oldNew));
		productEntity.setZemanat(zemanat);
		productEntity.setGuarantiStatus(guarantiStatus);
		if (pic1 != null) {
 if (!pic1.getContentType().equals("image/jpeg")) {
				throw new Exception("pic1Type");
			} else {
				productEntity.setPic1(convertPicture(pic1));
			}
		}
		if (pic2 != null) {
 if (!pic2.getContentType().equals("image/jpeg")) {
				throw new Exception("pic2Type");
			} else {
				productEntity.setPic2(convertPicture(pic2));
			}
		}
		if (pic3 != null) {
 if (!pic3.getContentType().equals("image/jpeg")) {
				throw new Exception("pic3Type");
			} else {
				productEntity.setPic3(convertPicture(pic3));
			}
		}
		if (pic4 != null) {
 if (!pic4.getContentType().equals("image/jpeg")) {
				throw new Exception("pic4Type");
			} else {
				productEntity.setPic4(convertPicture(pic4));
			}
		}
		if (pic5 != null) {
 if (!pic5.getContentType().equals("image/jpeg")) {
				throw new Exception("pic5Type");
			} else {
				productEntity.setPic5(convertPicture(pic5));
			}
		}
		productEntity.setRaste(faaliatHa());
		productEntity.setpDate(new Date());
		productEntity.setGuaranyTimeMounth(guaranyTimeMounth);
		productEntity.setRangBandi(rangBandi);
		productEntity.setRaste(faaliatHa());
		//////////////////////////////////////////////
		mizNaharKhori.setDescriptionMizNaharKhori(descriptionMizNaharKhori);
		mizNaharKhori.setJenseEsfangSandaliMizNaharKhori(jenseEsfangSandaliMizNaharKhori);
		mizNaharKhori.setJenseEskeletMizNaharKhori(jenseEskeletMizNaharKhori);
		mizNaharKhori.setJenseEskeletSandaliMizNaharKhori(jenseEskeletSandaliMizNaharKhori);
		mizNaharKhori.setJenseFomSandaliMizNaharKhori(jenseFomSandaliMizNaharKhori);
		mizNaharKhori.setJenseParcheSandaliMizNaharKhori(jenseParcheSandaliMizNaharKhori);
		mizNaharKhori.setJensePayeMizNaharKhori(jensePayeMizNaharKhori);
		mizNaharKhori.setJensePayeSandaliMizNaharKhori(jensePayeSandaliMizNaharKhori);
		mizNaharKhori.setJensePayeMizNaharKhori(jensePayeMizNaharKhori);
		mizNaharKhori.setJensePayeSandaliMizNaharKhori(jensePayeSandaliMizNaharKhori);
		mizNaharKhori.setJenseSafeMizNaharKhori(jenseSafeMizNaharKhori);
		mizNaharKhori.setNameParcheSandaliMizNaharKhori(nameParcheSandaliMizNaharKhori);
		mizNaharKhori.setPayeSandaliRangMizNaharKhori(convertBool(payeSandaliRangMizNaharKhori));
		mizNaharKhori.setPriceShisheMizNaharKhori(priceShisheMizNaharKhori);
		mizNaharKhori.setRangeShisheMizNaharKhori(rangeShisheMizNaharKhori);
		mizNaharKhori.setRangParcheSandaliMizNaharKhori(rangParcheSandaliMizNaharKhori);
		mizNaharKhori.setRangPayeSandaliMizNaharKhori(rangPayeSandaliMizNaharKhori);
		mizNaharKhori.setSakhtarMizNaharKhori(sakhtarMizNaharKhori);
		mizNaharKhori.setSheklehendesiMizNaharKhori(sheklehendesiMizNaharKhori);
		mizNaharKhori.setShisheAbzarMizNaharKhori(convertBool(shisheAbzarMizNaharKhori));
		mizNaharKhori.setTedadMizNaharKhori(tedadMizNaharKhori);
		mizNaharKhori.setZekhamatShisheMizNaharKhori(zekhamatShisheMizNaharKhori);
		productEntity.setMizNaharKhori(mizNaharKhori);
		productDaoLocal.insertToProduct(productEntity);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("*****************************با موفقیت وارد گردید************************"));
			emptyInp();
		} catch (Exception e) {
			if(e.getMessage().equals("pic1Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic1Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic2Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic2Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic3Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic3Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic4Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic4Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic5Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic5Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage()==null)
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));
		}
	}
	
	public void insertToMizTv() {
		ProductEntity productEntity= new ProductEntity();
		MizTv mizTv = new MizTv();
		try {
		productEntity.setProduct(adminProfile.getMoblEntity());
		productEntity.setNameCode(nameCode);
		productEntity.setAparat(aparat);
		productEntity.setInstagram(instagram);
		productEntity.setBrand(brand);
		productEntity.setContry(contry);
		productEntity.setAbad(abad);
		productEntity.setTahvilDay(TahvilDay);
		productEntity.setEasyNezafat(convertBool(easyNezafat));
		productEntity.setDescription(description);
		productEntity.setStatus(convertBool(status));
		productEntity.setPrice(price);
		productEntity.setPrice2(price2);
		productEntity.setOldNew(convertBool(oldNew));
		productEntity.setZemanat(zemanat);
		productEntity.setGuarantiStatus(guarantiStatus);
		if (pic1 != null) {
 if (!pic1.getContentType().equals("image/jpeg")) {
				throw new Exception("pic1Type");
			} else {
				productEntity.setPic1(convertPicture(pic1));
			}
		}
		if (pic2 != null) {
 if (!pic2.getContentType().equals("image/jpeg")) {
				throw new Exception("pic2Type");
			} else {
				productEntity.setPic2(convertPicture(pic2));
			}
		}
		if (pic3 != null) {
 if (!pic3.getContentType().equals("image/jpeg")) {
				throw new Exception("pic3Type");
			} else {
				productEntity.setPic3(convertPicture(pic3));
			}
		}
		if (pic4 != null) {
 if (!pic4.getContentType().equals("image/jpeg")) {
				throw new Exception("pic4Type");
			} else {
				productEntity.setPic4(convertPicture(pic4));
			}
		}
		if (pic5 != null) {
 if (!pic5.getContentType().equals("image/jpeg")) {
				throw new Exception("pic5Type");
			} else {
				productEntity.setPic5(convertPicture(pic5));
			}
		}
		productEntity.setRaste(faaliatHa());
		productEntity.setpDate(new Date());
		productEntity.setGuaranyTimeMounth(guaranyTimeMounth);
		productEntity.setRangBandi(rangBandi);
		productEntity.setRaste(faaliatHa());
		//////////////////////////////////////////////
		mizTv.setAbadMizTv(abadMizTv);
		mizTv.setDescriptionLavazemJanebi(descriptionLavazemJanebi);
		mizTv.setGabeliatRangMizTv(ejrayePardePartishen);
		mizTv.setFazayeLavazemJanebi(convertBool(fazayeLavazemJanebi));
		mizTv.setJenseEskeletMizTv(jenseEskeletMizTv);
		mizTv.setJensePayeMizTv(jensePayeMizTv);
		mizTv.setKesho(convertBool(kesho));
		mizTv.setMizMarbotTvInch(mizMarbotTvInch);
		mizTv.setRangAvalMizTv(rangAvalMizTv);
		mizTv.setRangDovomMizTv(rangDovomMizTv);
		mizTv.setRangMizTv(rangMizTv);
		mizTv.setRangPayeMizTv(rangPayeMizTv);
		mizTv.setTedadkesho(tedadkesho);
		productEntity.setMizTv(mizTv);
		productDaoLocal.insertToProduct(productEntity);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("*****************************با موفقیت وارد گردید************************"));
			emptyInp();
		} catch (Exception e) {
			if(e.getMessage().equals("pic1Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic1Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic2Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic2Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic3Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic3Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic4Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic4Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic5Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic5Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage()==null)
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));
		}
	}
	
	public void insertToMoblman() {
		ProductEntity productEntity= new ProductEntity();
		Moblman moblman = new Moblman();
		try {
		productEntity.setProduct(adminProfile.getMoblEntity());
		productEntity.setNameCode(nameCode);
		productEntity.setAparat(aparat);
		productEntity.setInstagram(instagram);
		productEntity.setBrand(brand);
		productEntity.setContry(contry);
		productEntity.setAbad(abad);
		productEntity.setTahvilDay(TahvilDay);
		productEntity.setEasyNezafat(convertBool(easyNezafat));
		productEntity.setDescription(description);
		productEntity.setStatus(convertBool(status));
		productEntity.setPrice(price);
		productEntity.setPrice2(price2);
		productEntity.setOldNew(convertBool(oldNew));
		productEntity.setZemanat(zemanat);
		productEntity.setGuarantiStatus(guarantiStatus);
		if (pic1 != null) {
 if (!pic1.getContentType().equals("image/jpeg")) {
				throw new Exception("pic1Type");
			} else {
				productEntity.setPic1(convertPicture(pic1));
			}
		}
		if (pic2 != null) {
 if (!pic2.getContentType().equals("image/jpeg")) {
				throw new Exception("pic2Type");
			} else {
				productEntity.setPic2(convertPicture(pic2));
			}
		}
		if (pic3 != null) {
 if (!pic3.getContentType().equals("image/jpeg")) {
				throw new Exception("pic3Type");
			} else {
				productEntity.setPic3(convertPicture(pic3));
			}
		}
		if (pic4 != null) {
 if (!pic4.getContentType().equals("image/jpeg")) {
				throw new Exception("pic4Type");
			} else {
				productEntity.setPic4(convertPicture(pic4));
			}
		}
		if (pic5 != null) {
 if (!pic5.getContentType().equals("image/jpeg")) {
				throw new Exception("pic5Type");
			} else {
				productEntity.setPic5(convertPicture(pic5));
			}
		}
		productEntity.setRaste(faaliatHa());
		productEntity.setpDate(new Date());
		productEntity.setGuaranyTimeMounth(guaranyTimeMounth);
		productEntity.setRangBandi(rangBandi);
		productEntity.setRaste(faaliatHa());
		//////////////////////////////////////////////
		moblman.setAbadKosanBozorg(abadKosanBozorg);
		moblman.setAbadKosanKochak(abadKosanKochak);
		moblman.setAbadMiz(abadMiz);
		moblman.setDescriptionMekanizmTakhtsho(descriptionMekanizmTakhtsho);
		moblman.setEnetekhabRangParche(convertBool(enetekhabRangParche));
		moblman.setEnetekhabRangPaye(convertBool(enetekhabRangPaye));
		moblman.setJenseEsfanj(jenseEsfanj);
		moblman.setJenseEskelet(jenseEskelet);
		moblman.setJenseFome(jenseFome);
		moblman.setJenseParche(jenseParche);
		moblman.setJenseParcheKosan(jenseParcheKosan);
		moblman.setJensePaye(jensePaye);
		moblman.setKosan(convertBool(kosan));
		moblman.setMekanizmTakhtsho(convertBool(mekanizmTakhtsho));
		moblman.setMiz(convertBool(miz));
		moblman.setModelKosan(modelKosan);
		moblman.setNameParche(nameParche);
		moblman.setNoeMobl(noeMobl);
		moblman.setRangeParcheKosan(rangeParcheKosan);
		moblman.setRangParche(rangParche);
		moblman.setSakhtarMobl(sakhtarMobl);
		moblman.setTedadKosan(tedadKosan);
		moblman.setTedadMiz(tedadMiz);
		moblman.setTedadMobl(tedadMobl);
		productEntity.setMoblman(moblman);
		productDaoLocal.insertToProduct(productEntity);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("*****************************با موفقیت وارد گردید************************"));
			emptyInp();
		} catch (Exception e) {
			if(e.getMessage().equals("pic1Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic1Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic2Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic2Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic3Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic3Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic4Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic4Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic5Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic5Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage()==null)
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));
		}
	}
	
	public void insertToMojasame() {
		ProductEntity productEntity= new ProductEntity();
		Mojasame mojasame = new Mojasame();
		try {
		productEntity.setProduct(adminProfile.getMoblEntity());
		productEntity.setNameCode(nameCode);
		productEntity.setAparat(aparat);
		productEntity.setInstagram(instagram);
		productEntity.setBrand(brand);
		productEntity.setContry(contry);
		productEntity.setAbad(abad);
		productEntity.setTahvilDay(TahvilDay);
		productEntity.setEasyNezafat(convertBool(easyNezafat));
		productEntity.setDescription(description);
		productEntity.setStatus(convertBool(status));
		productEntity.setPrice(price);
		productEntity.setPrice2(price2);
		productEntity.setOldNew(convertBool(oldNew));
		productEntity.setZemanat(zemanat);
		productEntity.setGuarantiStatus(guarantiStatus);
		if (pic1 != null) {
 if (!pic1.getContentType().equals("image/jpeg")) {
				throw new Exception("pic1Type");
			} else {
				productEntity.setPic1(convertPicture(pic1));
			}
		}
		if (pic2 != null) {
 if (!pic2.getContentType().equals("image/jpeg")) {
				throw new Exception("pic2Type");
			} else {
				productEntity.setPic2(convertPicture(pic2));
			}
		}
		if (pic3 != null) {
 if (!pic3.getContentType().equals("image/jpeg")) {
				throw new Exception("pic3Type");
			} else {
				productEntity.setPic3(convertPicture(pic3));
			}
		}
		if (pic4 != null) {
	 if (!pic4.getContentType().equals("image/jpeg")) {
				throw new Exception("pic4Type");
			} else {
				productEntity.setPic4(convertPicture(pic4));
			}
		}
		if (pic5 != null) {
 if (!pic5.getContentType().equals("image/jpeg")) {
				throw new Exception("pic5Type");
			} else {
				productEntity.setPic5(convertPicture(pic5));
			}
		}
		productEntity.setRaste(faaliatHa());
		productEntity.setpDate(new Date());
		productEntity.setGuaranyTimeMounth(guaranyTimeMounth);
		productEntity.setRangBandi(rangBandi);
		productEntity.setRaste(faaliatHa());
		//////////////////////////////////////////////
		mojasame.setAbadMojasame(abadMojasame);
		mojasame.setJenseMojasame(jenseMojasame);
		mojasame.setShostoshoMojasame(convertBool(shostoshoMojasame));
		productEntity.setMojasame(mojasame);
		productDaoLocal.insertToProduct(productEntity);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("*****************************با موفقیت وارد گردید************************"));
			emptyInp();
		} catch (Exception e) {
			if(e.getMessage().equals("pic1Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic1Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic2Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic2Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic3Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic3Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic4Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic4Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic5Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic5Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage()==null)
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));
		}
	}
	
	
	public void insertToMonabat() {
		ProductEntity productEntity= new ProductEntity();
		Monabat monabat = new Monabat();
		try {
		productEntity.setProduct(adminProfile.getMoblEntity());
		productEntity.setNameCode(nameCode);
		productEntity.setAparat(aparat);
		productEntity.setInstagram(instagram);
		productEntity.setBrand(brand);
		productEntity.setContry(contry);
		productEntity.setAbad(abad);
		productEntity.setTahvilDay(TahvilDay);
		productEntity.setEasyNezafat(convertBool(easyNezafat));
		productEntity.setDescription(description);
		productEntity.setStatus(convertBool(status));
		productEntity.setPrice(price);
		productEntity.setPrice2(price2);
		productEntity.setOldNew(convertBool(oldNew));
		productEntity.setZemanat(zemanat);
		productEntity.setGuarantiStatus(guarantiStatus);
		if (pic1 != null) {
 if (!pic1.getContentType().equals("image/jpeg")) {
				throw new Exception("pic1Type");
			} else {
				productEntity.setPic1(convertPicture(pic1));
			}
		}
		if (pic2 != null) {
 if (!pic2.getContentType().equals("image/jpeg")) {
				throw new Exception("pic2Type");
			} else {
				productEntity.setPic2(convertPicture(pic2));
			}
		}
		if (pic3 != null) {
 if (!pic3.getContentType().equals("image/jpeg")) {
				throw new Exception("pic3Type");
			} else {
				productEntity.setPic3(convertPicture(pic3));
			}
		}
		if (pic4 != null) {
 if (!pic4.getContentType().equals("image/jpeg")) {
				throw new Exception("pic4Type");
			} else {
				productEntity.setPic4(convertPicture(pic4));
			}
		}
		if (pic5 != null) {
 if (!pic5.getContentType().equals("image/jpeg")) {
				throw new Exception("pic5Type");
			} else {
				productEntity.setPic5(convertPicture(pic5));
			}
		}
		productEntity.setRaste(faaliatHa());
		productEntity.setpDate(new Date());
		productEntity.setGuaranyTimeMounth(guaranyTimeMounth);
		productEntity.setRangBandi(rangBandi);
		productEntity.setRaste(faaliatHa());
		//////////////////////////////////////////////
		monabat.setAbadMonabat(abadMonabat);
		monabat.setJenseMonabat(jenseMonabat);
		monabat.setKeshvarMdfMonabat(keshvarMdfMonabat);
		monabat.setNameMdfMonabat(nameMdfMonabat);
		monabat.setNoeMonabat(noeMonabat);
		monabat.setZekhamatMdfMonabat(zekhamatMdfMonabat);
		productEntity.setMonabat(monabat);
		    productDaoLocal.insertToProduct(productEntity);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("*****************************با موفقیت وارد گردید************************"));
			emptyInp();
		} catch (Exception e) {
			if(e.getMessage().equals("pic1Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic1Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic2Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic2Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic3Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic3Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic4Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic4Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic5Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic5Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage()==null)
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));
		}
	}
	
	public void insertToPanjare() {
		ProductEntity productEntity= new ProductEntity();
		Panjare panjare =new Panjare();
		try {
		productEntity.setProduct(adminProfile.getMoblEntity());
		productEntity.setNameCode(nameCode);
		productEntity.setAparat(aparat);
		productEntity.setInstagram(instagram);
		productEntity.setBrand(brand);
		productEntity.setContry(contry);
		productEntity.setAbad(abad);
		productEntity.setTahvilDay(TahvilDay);
		productEntity.setEasyNezafat(convertBool(easyNezafat));
		productEntity.setDescription(description);
		productEntity.setStatus(convertBool(status));
		productEntity.setPrice(price);
		productEntity.setPrice2(price2);
		productEntity.setOldNew(convertBool(oldNew));
		productEntity.setZemanat(zemanat);
		productEntity.setGuarantiStatus(guarantiStatus);
		if (pic1 != null) {
 if (!pic1.getContentType().equals("image/jpeg")) {
				throw new Exception("pic1Type");
			} else {
				productEntity.setPic1(convertPicture(pic1));
			}
		}
		if (pic2 != null) {
 if (!pic2.getContentType().equals("image/jpeg")) {
				throw new Exception("pic2Type");
			} else {
				productEntity.setPic2(convertPicture(pic2));
			}
		}
		if (pic3 != null) {
 if (!pic3.getContentType().equals("image/jpeg")) {
				throw new Exception("pic3Type");
			} else {
				productEntity.setPic3(convertPicture(pic3));
			}
		}
		if (pic4 != null) {
 if (!pic4.getContentType().equals("image/jpeg")) {
				throw new Exception("pic4Type");
			} else {
				productEntity.setPic4(convertPicture(pic4));
			}
		}
		if (pic5 != null) {
 if (!pic5.getContentType().equals("image/jpeg")) {
				throw new Exception("pic5Type");
			} else {
				productEntity.setPic5(convertPicture(pic5));
			}
		}
		productEntity.setRaste(faaliatHa());
		productEntity.setpDate(new Date());
		productEntity.setGuaranyTimeMounth(guaranyTimeMounth);
		productEntity.setRangBandi(rangBandi);
		productEntity.setRaste(faaliatHa());
		//////////////////////////////////////////////
		panjare.setCncPanjare(convertBool(cncPanjare));
		panjare.setJenseKalafPanjare(jenseKalafPanjare);
		panjare.setMakanPanjare(makanPanjare);
		panjare.setMetrialPanjare(metrialPanjare);
		panjare.setNoeRangPanjare(noeRangPanjare);
		panjare.setShostoshoPanjare(convertBool(shostoshoPanjare));
		panjare.setZedeAbPanjare(convertBool(zedeAbPanjare));
		productEntity.setPanjare(panjare);
		productDaoLocal.insertToProduct(productEntity);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("*****************************با موفقیت وارد گردید************************"));
			emptyInp();
		} catch (Exception e) {
			if(e.getMessage().equals("pic1Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic1Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic2Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic2Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic3Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic3Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic4Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic4Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic5Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic5Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage()==null)
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));
		}
	}
	
	public void insertToPartition() {
		ProductEntity productEntity= new ProductEntity();
		Partition partition = new Partition();
		try {
		productEntity.setProduct(adminProfile.getMoblEntity());
		productEntity.setNameCode(nameCode);
		productEntity.setAparat(aparat);
		productEntity.setInstagram(instagram);
		productEntity.setBrand(brand);
		productEntity.setContry(contry);
		productEntity.setAbad(abad);
		productEntity.setTahvilDay(TahvilDay);
		productEntity.setEasyNezafat(convertBool(easyNezafat));
		productEntity.setDescription(description);
		productEntity.setStatus(convertBool(status));
		productEntity.setPrice(price);
		productEntity.setPrice2(price2);
		productEntity.setOldNew(convertBool(oldNew));
		productEntity.setZemanat(zemanat);
		productEntity.setGuarantiStatus(guarantiStatus);
		if (pic1 != null) {
 if (!pic1.getContentType().equals("image/jpeg")) {
				throw new Exception("pic1Type");
			} else {
				productEntity.setPic1(convertPicture(pic1));
			}
		}
		if (pic2 != null) {
 if (!pic2.getContentType().equals("image/jpeg")) {
				throw new Exception("pic2Type");
			} else {
				productEntity.setPic2(convertPicture(pic2));
			}
		}
		if (pic3 != null) {
 if (!pic3.getContentType().equals("image/jpeg")) {
				throw new Exception("pic3Type");
			} else {
				productEntity.setPic3(convertPicture(pic3));
			}
		}
		if (pic4 != null) {
 if (!pic4.getContentType().equals("image/jpeg")) {
				throw new Exception("pic4Type");
			} else {
				productEntity.setPic4(convertPicture(pic4));
			}
		}
		if (pic5 != null) {
 if (!pic5.getContentType().equals("image/jpeg")) {
				throw new Exception("pic5Type");
			} else {
				productEntity.setPic5(convertPicture(pic5));
			}
		}
		productEntity.setRaste(faaliatHa());
		productEntity.setpDate(new Date());
		productEntity.setGuaranyTimeMounth(guaranyTimeMounth);
		productEntity.setRangBandi(rangBandi);
		productEntity.setRaste(faaliatHa());
		//////////////////////////////////////////////
		partition.setEjrayePardePartishen(ejrayePardePartishen);
		partition.setJenseLabePartishen(jenseLabePartishen);
		partition.setJensePanelPartishen(jensePanelPartishen);
		partition.setJenseSotonPartishen(jenseSotonPartishen);
		partition.setNoeTarkibPartishen(noeTarkibPartishen);
		partition.setPriceMetrPartishen(priceMetrPartishen);
		partition.setPriceTakhfifMetrPartishen(priceTakhfifMetrPartishen);
		partition.setRangPardePartishen(rangPardePartishen);
		partition.setRangPartishen(rangPartishen);
		partition.setTarkibiPartishen(convertBool(tarkibiPartishen));
		productEntity.setPartition(partition);
		productDaoLocal.insertToProduct(productEntity);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("*****************************با موفقیت وارد گردید************************"));
			emptyInp();
		} catch (Exception e) {
			if(e.getMessage().equals("pic1Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic1Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic2Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic2Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic3Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic3Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic4Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic4Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic5Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic5Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage()==null)
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));
		}
	}
	
	public void insertToSandaliEdari() {
		ProductEntity productEntity= new ProductEntity();
		SandaliEdari sandaliEdari = new SandaliEdari();
		try {
		productEntity.setProduct(adminProfile.getMoblEntity());
		productEntity.setNameCode(nameCode);
		productEntity.setAparat(aparat);
		productEntity.setInstagram(instagram);
		productEntity.setBrand(brand);
		productEntity.setContry(contry);
		productEntity.setAbad(abad);
		productEntity.setTahvilDay(TahvilDay);
		productEntity.setEasyNezafat(convertBool(easyNezafat));
		productEntity.setDescription(description);
		productEntity.setStatus(convertBool(status));
		productEntity.setPrice(price);
		productEntity.setPrice2(price2);
		productEntity.setOldNew(convertBool(oldNew));
		productEntity.setZemanat(zemanat);
		productEntity.setGuarantiStatus(guarantiStatus);
		if (pic1 != null) {
	 if (!pic1.getContentType().equals("image/jpeg")) {
				throw new Exception("pic1Type");
			} else {
				productEntity.setPic1(convertPicture(pic1));
			}
		}
		if (pic2 != null) {
 if (!pic2.getContentType().equals("image/jpeg")) {
				throw new Exception("pic2Type");
			} else {
				productEntity.setPic2(convertPicture(pic2));
			}
		}
		if (pic3 != null) {
if (!pic3.getContentType().equals("image/jpeg")) {
				throw new Exception("pic3Type");
			} else {
				productEntity.setPic3(convertPicture(pic3));
			}
		}
		if (pic4 != null) {
 if (!pic4.getContentType().equals("image/jpeg")) {
				throw new Exception("pic4Type");
			} else {
				productEntity.setPic4(convertPicture(pic4));
			}
		}
		if (pic5 != null) {
 if (!pic5.getContentType().equals("image/jpeg")) {
				throw new Exception("pic5Type");
			} else {
				productEntity.setPic5(convertPicture(pic5));
			}
		}
		productEntity.setRaste(faaliatHa());
		productEntity.setpDate(new Date());
		productEntity.setGuaranyTimeMounth(guaranyTimeMounth);
		productEntity.setRangBandi(rangBandi);
		productEntity.setRaste(faaliatHa());
		//////////////////////////////////////////////
		sandaliEdari.setAbadSandaliEdari(abadSandaliEdari);
		sandaliEdari.setDasteSandaliEdari(convertBool(dasteSandaliEdari));
		sandaliEdari.setJensePayeSandaliEdari(jensePayeSandaliEdari);
		sandaliEdari.setNoeJenseSandaliEdari(noeJenseSandaliEdari);
		sandaliEdari.setNoeSandaliEdari(noeSandaliEdari);
		sandaliEdari.setRangSandaliEdari(rangSandaliEdari);
		sandaliEdari.setTebiSandaliEdari(convertBool(tebiSandaliEdari));
		productEntity.setSandaliEdari(sandaliEdari);
		productDaoLocal.insertToProduct(productEntity);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("*****************************با موفقیت وارد گردید************************"));
			emptyInp();
		} catch (Exception e) {
			if(e.getMessage().equals("pic1Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic1Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic2Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic2Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic3Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic3Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic4Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic4Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic5Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic5Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage()==null)
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));
		}
	}
	
	public void insertToServiceKhab1() {
		ProductEntity productEntity= new ProductEntity();
		ServiceKhab1 serviceKhab1 = new ServiceKhab1();
		try {
		productEntity.setProduct(adminProfile.getMoblEntity());
		productEntity.setNameCode(nameCode);
		productEntity.setAparat(aparat);
		productEntity.setInstagram(instagram);
		productEntity.setBrand(brand);
		productEntity.setContry(contry);
		productEntity.setAbad(abad);
		productEntity.setTahvilDay(TahvilDay);
		productEntity.setEasyNezafat(convertBool(easyNezafat));
		productEntity.setDescription(description);
		productEntity.setStatus(convertBool(status));
		productEntity.setPrice(price);
		productEntity.setPrice2(price2);
		productEntity.setOldNew(convertBool(oldNew));
		productEntity.setZemanat(zemanat);
		productEntity.setGuarantiStatus(guarantiStatus);
		if (pic1 != null) {
 if (!pic1.getContentType().equals("image/jpeg")) {
				throw new Exception("pic1Type");
			} else {
				productEntity.setPic1(convertPicture(pic1));
			}
		}
		if (pic2 != null) {
 if (!pic2.getContentType().equals("image/jpeg")) {
				throw new Exception("pic2Type");
			} else {
				productEntity.setPic2(convertPicture(pic2));
			}
		}
		if (pic3 != null) {
 if (!pic3.getContentType().equals("image/jpeg")) {
				throw new Exception("pic3Type");
			} else {
				productEntity.setPic3(convertPicture(pic3));
			}
		}
		if (pic4 != null) {
 if (!pic4.getContentType().equals("image/jpeg")) {
				throw new Exception("pic4Type");
			} else {
				productEntity.setPic4(convertPicture(pic4));
			}
		}
		if (pic5 != null) {
 if (!pic5.getContentType().equals("image/jpeg")) {
				throw new Exception("pic5Type");
			} else {
				productEntity.setPic5(convertPicture(pic5));
			}
		}
		productEntity.setRaste(faaliatHa());
		productEntity.setpDate(new Date());
		productEntity.setGuaranyTimeMounth(guaranyTimeMounth);
		productEntity.setRangBandi(rangBandi);
		productEntity.setRaste(faaliatHa());
		//////////////////////////////////////////////
		serviceKhab1.setAbadGabVayeneGadi(abadGabVayeneGadi);
        System.err.println(1);
        serviceKhab1.setAbadKomodServiceKhab(abadKomodServiceKhab);
        System.err.println(1);
        serviceKhab1.setAbadKomodServiceKhab(abadKomodServiceKhab);
        System.err.println(1);
        serviceKhab1.setAbadMizArayesh(abadMizArayesh);
        System.err.println(1);
        serviceKhab1.setAbadMizTahrir(abadMizTahrir);
        System.err.println(1);
        serviceKhab1.setAbadPaTakhti(abadPaTakhti);
        System.err.println(1);
        serviceKhab1.setAbadToshak(abadToshak);
        System.err.println(1);
        serviceKhab1.setArzeTakhteKhab(arzeTakhteKhab);
        System.err.println(1);
        serviceKhab1.setBrandToshak(brandToshak);
        System.err.println(1);
        serviceKhab1.setGabVayeneGadi(convertBool(gabVayeneGadi));
        System.err.println(1);
        serviceKhab1.setJenseGabVayeneGadi(jenseGabVayeneGadi);
        System.err.println(1);
        serviceKhab1.setJenseKomodServiceKhab(jenseKomodServiceKhab);
        System.err.println(1);
        serviceKhab1.setJenseMizArayesh(jenseMizArayesh);
        System.err.println(1);
        serviceKhab1.setJenseMizTahrir(jenseMizTahrir);
        System.err.println(1);
        serviceKhab1.setJensePaTakhti(jensePaTakhti);
        System.err.println(1);
        serviceKhab1.setJenseTakhtKhab(jenseTakhtKhab);
        System.err.println(1);
        serviceKhab1.setKalafTakhtJakDar(convertBool(kalafTakhtJakDar));
        System.err.println(1);
        serviceKhab1.setKeshovbox(convertBool(keshovbox));
        System.err.println(1);
        serviceKhab1.setKomodServiceKhab(convertBool(komodServiceKhab));
        System.err.println(1);
        serviceKhab1.setMizArayesh(convertBool(mizArayesh));
        System.err.println(1);
        serviceKhab1.setMizTahrir(convertBool(mizTahrir));
        System.err.println(1);
        serviceKhab1.setModatGharantiToshak(modatGharantiToshak);
        System.err.println(1);
        serviceKhab1.setModelServiceKhab(modelServiceKhab);
        System.err.println(1);
        serviceKhab1.setModelToshak(modelToshak);
        System.err.println(1);
        serviceKhab1.setPatakhti(convertBool(patakhti));
        System.err.println(1);
        serviceKhab1.setPriceGabVayeneGadi(priceGabVayeneGadi);
        System.err.println(1);
        serviceKhab1.setPriceKomodServiceKhab(priceKomodServiceKhab);
        System.err.println(1);
        serviceKhab1.setPriceMizArayesh(priceMizArayesh);
        System.err.println(1);
        serviceKhab1.setPriceMizTahrir(priceMizTahrir);
        System.err.println(1);
        serviceKhab1.setPricePaTakhti(pricePaTakhti);
        System.err.println(1);
        serviceKhab1.setPriceTakhtKhab(priceTakhtKhab);
        System.err.println(1);
        serviceKhab1.setPriceToshak(priceToshak);
        System.err.println(1);
        serviceKhab1.setRangGabVayeneGadi(rangGabVayeneGadi);
        System.err.println(1);
        serviceKhab1.setRangKomodServiceKhab(rangKomodServiceKhab);
        System.err.println(1);
        serviceKhab1.setRangMizArayesh(rangMizArayesh);
        System.err.println(1);
        serviceKhab1.setRangMizTahrir(rangMizTahrir);
        System.err.println(1);
        serviceKhab1.setRangPaTakhti(rangPaTakhti);
        System.err.println(1);
        serviceKhab1.setRangTakhtKhab(rangTakhtKhab);
        System.err.println(1);
        serviceKhab1.setSandaliServiceKhab(convertBool(sandaliServiceKhab));
        System.err.println(1);
        serviceKhab1.setTedadPaTakhti(tedadPaTakhti);
        System.err.println(1);
        serviceKhab1.setToshak(convertBool(toshak));
        System.err.println(1);
        serviceKhab1.setTozihatToshak(tozihatToshak);
        System.err.println(1);
        productEntity.setServiceKhab1(serviceKhab1);
        	productDaoLocal.insertToProduct(productEntity);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("*****************************با موفقیت وارد گردید************************"));
			emptyInp();
		} catch (Exception e) {
			if(e.getMessage().equals("pic1Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic1Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic2Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic2Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic3Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic3Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic4Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic4Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic5Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic5Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage()==null)
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));
		}
	}
	
	
	public void insertToServiceKhab2() {
		ProductEntity productEntity= new ProductEntity();
		ServiceKhab2 serviceKhab2 = new ServiceKhab2();
		try {
		productEntity.setProduct(adminProfile.getMoblEntity());
		productEntity.setNameCode(nameCode);
		productEntity.setAparat(aparat);
		productEntity.setInstagram(instagram);
		productEntity.setBrand(brand);
		productEntity.setContry(contry);
		productEntity.setAbad(abad);
		productEntity.setTahvilDay(TahvilDay);
		productEntity.setEasyNezafat(convertBool(easyNezafat));
		productEntity.setDescription(description);
		productEntity.setStatus(convertBool(status));
		productEntity.setPrice(price);
		productEntity.setPrice2(price2);
		productEntity.setOldNew(convertBool(oldNew));
		productEntity.setZemanat(zemanat);
		productEntity.setGuarantiStatus(guarantiStatus);
		if (pic1 != null) {
 if (!pic1.getContentType().equals("image/jpeg")) {
				throw new Exception("pic1Type");
			} else {
				productEntity.setPic1(convertPicture(pic1));
			}
		}
		if (pic2 != null) {
 if (!pic2.getContentType().equals("image/jpeg")) {
				throw new Exception("pic2Type");
			} else {
				productEntity.setPic2(convertPicture(pic2));
			}
		}
		if (pic3 != null) {
 if (!pic3.getContentType().equals("image/jpeg")) {
				throw new Exception("pic3Type");
			} else {
				productEntity.setPic3(convertPicture(pic3));
			}
		}
		if (pic4 != null) {
 if (!pic4.getContentType().equals("image/jpeg")) {
				throw new Exception("pic4Type");
			} else {
				productEntity.setPic4(convertPicture(pic4));
			}
		}
		if (pic5 != null) {
 if (!pic5.getContentType().equals("image/jpeg")) {
				throw new Exception("pic5Type");
			} else {
				productEntity.setPic5(convertPicture(pic5));
			}
		}
		productEntity.setRaste(faaliatHa());
		productEntity.setpDate(new Date());
		productEntity.setGuaranyTimeMounth(guaranyTimeMounth);
		productEntity.setRangBandi(rangBandi);
		productEntity.setRaste(faaliatHa());
		//////////////////////////////////////////////
		serviceKhab2.setAbadGabVAyeneGadi2(abadGabVAyeneGadi2);
        System.err.println(1);
        serviceKhab2.setAbadkomodServiceKhab2(abadkomodServiceKhab2);
        System.err.println(1);
        serviceKhab2.setAbadkomodServiceKhab2(abadkomodServiceKhab2);
        System.err.println(1);
        serviceKhab2.setAbadMizArayesh2(abadMizArayesh2);
        System.err.println(1);
        serviceKhab2.setAbadmizTahrir2(abadmizTahrir2);
        System.err.println(1);
        serviceKhab2.setAbadPaTakhti2(abadPaTakhti2);
        System.err.println(1);
        serviceKhab2.setAbadToshak2(abadToshak2);
        System.err.println(1);
        serviceKhab2.setArzeTakhteKhab2(arzeTakhteKhab2);
        System.err.println(1);
        serviceKhab2.setBrandToshak2(brandToshak2);
        System.err.println(1);
        serviceKhab2.setGabVAyeneGadi2(convertBool(gabVAyeneGadi2));
        System.err.println(1);
        serviceKhab2.setJenseGabVAyeneGadi2(jenseGabVAyeneGadi2);
        System.err.println(1);
        serviceKhab2.setJensekomodServiceKhab2(jensekomodServiceKhab2);
        System.err.println(1);
        serviceKhab2.setJenseMizArayesh2(jenseMizArayesh2);
        System.err.println(1);
        serviceKhab2.setJensemizTahrir2(jensemizTahrir2);
        System.err.println(1);
        serviceKhab2.setJensePaTakhti2(jensePaTakhti2);
        System.err.println(1);
        serviceKhab2.setJenseTakhteKhab2(jenseTakhteKhab2);
        System.err.println(1);
        serviceKhab2.setKalafTakhtJackDar(convertBool(kalafTakhtJackDar));
        System.err.println(1);
        serviceKhab2.setKeshoVbox(convertBool(keshoVbox));
        System.err.println(1);
        serviceKhab2.setKomodServiceKhab2(convertBool(komodServiceKhab2));
        System.err.println(1);
        serviceKhab2.setMizArayesh2(convertBool(mizArayesh2));
        System.err.println(1);
        serviceKhab2.setMizTahrir2(convertBool(mizTahrir2));
        System.err.println(1);
        serviceKhab2.setModatGarantiGabVAyeneGadi2(modatGarantiGabVAyeneGadi2);
        System.err.println(1);
        serviceKhab2.setModelServiceKhab2(modelServiceKhab2);
        System.err.println(1);
        serviceKhab2.setModelToshak2(modelToshak2);
        System.err.println(1);
        serviceKhab2.setPaTahti2(convertBool(paTahti2));
        System.err.println(1);
        serviceKhab2.setPriceGabVAyeneGadi2(priceGabVAyeneGadi2);
        System.err.println(1);
        serviceKhab2.setPriceKomodServiceKhab2(priceKomodServiceKhab2);
        System.err.println(1);
        serviceKhab2.setPriceMizArayesh2(priceMizArayesh2);
        System.err.println(1);
        serviceKhab2.setPriceMizTahrir2(priceMizTahrir2);
        System.err.println(1);
        serviceKhab2.setPricePaTakhti2(pricePaTakhti2);
        System.err.println(1);
        serviceKhab2.setPriceTakhteKhab2(priceTakhteKhab2);
        System.err.println(1);
        serviceKhab2.setPriceToshak2(priceToshak2);
        System.err.println(1);
        serviceKhab2.setRangGabVAyeneGadi2(rangGabVAyeneGadi2);
        System.err.println(1);
        serviceKhab2.setRangkomodServiceKhab2(rangkomodServiceKhab2);
        System.err.println(1);
        serviceKhab2.setRangMizArayesh2(rangMizArayesh2);
        System.err.println(1);
        serviceKhab2.setRangmizTahrir2(rangmizTahrir2);
        System.err.println(1);
        serviceKhab2.setRangPaTakhti2(rangPaTakhti2);
        System.err.println(1);
        serviceKhab2.setRangeTakhteKhab2(rangeTakhteKhab2);
        System.err.println(1);
        serviceKhab2.setSandaliMizArayesh2(convertBool(sandaliMizArayesh2));
        System.err.println(1);
        serviceKhab2.setTedadPaTakhti2(tedadPaTakhti2);
        System.err.println(1);
        serviceKhab2.setToshak2(convertBool(toshak2));
        System.err.println(1);
        serviceKhab2.setDescriptionToshak2(descriptionToshak2);
        System.err.println(1);
        productEntity.setServiceKhab2(serviceKhab2);
        productDaoLocal.insertToProduct(productEntity);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("*****************************با موفقیت وارد گردید************************"));
			emptyInp();
		} catch (Exception e) {
			if(e.getMessage().equals("pic1Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic1Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic2Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic2Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic3Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic3Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic4Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic4Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic5Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic5Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage()==null)
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));
		}
	}
	
	
	
	public void insertToServiceKhabKodak() {
		ProductEntity productEntity= new ProductEntity();
		ServiceKhabKodak serviceKhabKodak = new ServiceKhabKodak();
		try {
		productEntity.setProduct(adminProfile.getMoblEntity());
		productEntity.setNameCode(nameCode);
		productEntity.setAparat(aparat);
		productEntity.setInstagram(instagram);
		productEntity.setBrand(brand);
		productEntity.setContry(contry);
		productEntity.setAbad(abad);
		productEntity.setTahvilDay(TahvilDay);
		productEntity.setEasyNezafat(convertBool(easyNezafat));
		productEntity.setDescription(description);
		productEntity.setStatus(convertBool(status));
		productEntity.setPrice(price);
		productEntity.setPrice2(price2);
		productEntity.setOldNew(convertBool(oldNew));
		productEntity.setZemanat(zemanat);
		productEntity.setGuarantiStatus(guarantiStatus);
		if (pic1 != null) {
 if (!pic1.getContentType().equals("image/jpeg")) {
				throw new Exception("pic1Type");
			} else {
				productEntity.setPic1(convertPicture(pic1));
			}
		}
		if (pic2 != null) {
 if (!pic2.getContentType().equals("image/jpeg")) {
				throw new Exception("pic2Type");
			} else {
				productEntity.setPic2(convertPicture(pic2));
			}
		}
		if (pic3 != null) {
 if (!pic3.getContentType().equals("image/jpeg")) {
				throw new Exception("pic3Type");
			} else {
				productEntity.setPic3(convertPicture(pic3));
			}
		}
		if (pic4 != null) {
 if (!pic4.getContentType().equals("image/jpeg")) {
				throw new Exception("pic4Type");
			} else {
				productEntity.setPic4(convertPicture(pic4));
			}
		}
		if (pic5 != null) {
 if (!pic5.getContentType().equals("image/jpeg")) {
				throw new Exception("pic5Type");
			} else {
				productEntity.setPic5(convertPicture(pic5));
			}
		}
		productEntity.setRaste(faaliatHa());
		productEntity.setpDate(new Date());
		productEntity.setGuaranyTimeMounth(guaranyTimeMounth);
		productEntity.setRangBandi(rangBandi);
		productEntity.setRaste(faaliatHa());
		System.err.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
		//////////////////////////////////////////////
		serviceKhabKodak.setAbadKomodkenarMadari(abadKomodkenarMadari);
		System.err.println(1);
		serviceKhabKodak.setAbadKomodMizSandaliKodak(abadKomodMizSandaliKodak);
		System.err.println(1);
		serviceKhabKodak.setAbadMizArayeshMizSandaliKodak(abadMizArayeshMizSandaliKodak);
		System.err.println(1);
		serviceKhabKodak.setAbadMizKodak(abadMizKodak);
		System.err.println(1);
		serviceKhabKodak.setAbadSandaliKodak(abadSandaliKodak);
		System.err.println(1);
		serviceKhabKodak.setAbadShelfDivari(abadShelfDivari);
		System.err.println(1);
		serviceKhabKodak.setAbadToshak3(abadToshak3);
		System.err.println(1);
		serviceKhabKodak.setAbadVitrinKetabkhane(abadVitrinKetabkhane);
		System.err.println(1);
		serviceKhabKodak.setBrandToshak3(brandToshak3);
		System.err.println(1);
		serviceKhabKodak.setDescriptionToshak3(descriptionToshak3);
		System.err.println(1);
		serviceKhabKodak.setJenseKomodkenarMadari(jenseKomodkenarMadari);
		System.err.println(1);
		serviceKhabKodak.setJenseKomodMizSandaliKodak(jenseKomodMizSandaliKodak);
		System.err.println(1);
		serviceKhabKodak.setJenseMizArayeshMizSandaliKodak(jenseMizArayeshMizSandaliKodak);
		System.err.println(1);
		serviceKhabKodak.setJenseMizSandaliKodak(jenseMizSandaliKodak);
		System.err.println(1);
		serviceKhabKodak.setJenseServiceKhabNozad(jenseServiceKhabNozad);
		System.err.println(1);
		serviceKhabKodak.setJenseShelfDivari(jenseShelfDivari);
		System.err.println(1);
		serviceKhabKodak.setJenseVitrinKetabkhane(jenseVitrinKetabkhane);
		System.err.println(1);
		serviceKhabKodak.setKenarMadari(convertBool(kenarMadari));
		System.err.println(1);
		serviceKhabKodak.setKeshoVBox(convertBool(keshoVBox));
		System.err.println(1);
		serviceKhabKodak.setKomodMizSandaliKodak(convertBool(komodMizSandaliKodak));
		System.err.println(1);
		serviceKhabKodak.setMizArayeshMizSandaliKodak(convertBool(mizArayeshMizSandaliKodak));
		System.err.println(1);
		serviceKhabKodak.setMizSandaliKodak(convertBool(mizSandaliKodak));
		System.err.println(1);
		serviceKhabKodak.setModatGarantiToshak3(modatGarantiToshak3);
		System.err.println(1);
		serviceKhabKodak.setModelServiceKhabNozad(modelServiceKhabNozad);
		System.err.println(1);
		serviceKhabKodak.setModelToshak3(modelToshak3);
		System.err.println(1);
		serviceKhabKodak.setPriceKomodkenarMadari(priceKomodkenarMadari);
		System.err.println(1);
		serviceKhabKodak.setPriceKomodMizSandaliKodak(priceKomodMizSandaliKodak);
		System.err.println(1);
		serviceKhabKodak.setPriceMizArayeshMizSandaliKodak(priceMizArayeshMizSandaliKodak);
		System.err.println(1);
		serviceKhabKodak.setPriceMizSandaliKodak(priceMizSandaliKodak);
		System.err.println(1);
		serviceKhabKodak.setPriceServiceKhabNozad(priceServiceKhabNozad);
		System.err.println(1);
		serviceKhabKodak.setPriceShelfDivari(priceShelfDivari);
		System.err.println(1);
		serviceKhabKodak.setPriceToshak3(priceToshak3);
		System.err.println(1);
		serviceKhabKodak.setPriceVitrinKetabkhane(priceVitrinKetabkhane);
		System.err.println(1);
		serviceKhabKodak.setRangKomodkenarMadari(rangKomodkenarMadari);
		System.err.println(1);
		serviceKhabKodak.setRangKomodMizSandaliKodak(rangKomodMizSandaliKodak);
		System.err.println(1);
		serviceKhabKodak.setRangMizArayeshMizSandaliKodak(rangMizArayeshMizSandaliKodak);
		System.err.println(1);
		serviceKhabKodak.setRangServiceKhabNozad(rangServiceKhabNozad);
		System.err.println(1);
		serviceKhabKodak.setRangShelfDivari(rangShelfDivari);
		System.err.println(1);
		serviceKhabKodak.setRangVitrinKetabkhane(rangVitrinKetabkhane);
		System.err.println(1);
		serviceKhabKodak.setSandaliMizArayeshMizSandaliKodak(convertBool(sandaliMizArayeshMizSandaliKodak));
		System.err.println(1);
		serviceKhabKodak.setShelfDivari(convertBool(shelfDivari));
		System.err.println(1);
		serviceKhabKodak.setTedadMizSandaliKodak(tedadMizSandaliKodak);
		System.err.println(1);
		serviceKhabKodak.setToshak3(convertBool(toshak3));
		System.err.println(1);
		serviceKhabKodak.setVitrinKetabkhane(convertBool(vitrinKetabkhane));
		System.err.println(1);
		productEntity.setServiceKhabKodak(serviceKhabKodak);
		productDaoLocal.insertToProduct(productEntity);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("*****************************با موفقیت وارد گردید************************"));
			emptyInp();
		} catch (Exception e) {
			if(e.getMessage().equals("pic1Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic1Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic1Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic2Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic2Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic2Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic3Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic3Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic3Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic4Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic4Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic4Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage().equals("pic5Size"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "size must minimum 50k", null));
	    	if(e.getMessage().equals("pic5Type"))
	    		FacesContext.getCurrentInstance().addMessage(pic5Component.getClientId(),
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "type must be jpg", null));
	    	if(e.getMessage()==null)
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا در ارتباط با دیتابیس", null));
		}
	}
	
	
	public List<ProductEntity> findAllProduct(){
		return productDaoLocal.findAllProductEntity();
	}
	
	public void updateProduct() {
		this.productEntity.setCheckO(enableProduct);
		productDaoLocal.updateProductEntity(this.productEntity);
	}
    public String convertToPersianDate(Date date) {
    	if(date!=null)
    	return TimeCovnertor.findPersianDate(date);
    	else
    	return "وارد نشده است";
    }
    
	/*
	 * public ProductEntity findProductEntityById(long productId) { return
	 * productDaoLocal.findProductEntityById(productId); }
	 */
    
//	public Object findProductEntityDetail(long productId) {
//		productDaoLocal.findProductEntityById(this.productEntity.getProductId());
//    	if(this.productEntity.getProductType().equals("AyeneVConsole"))
//    		this.productDetail = (AyeneVConsole)productDaoLocal.getProductDetail();
//    	if(this.productEntity.getProductType().equals("DarbChobi"))
//    		this.productDetail = (DarbChobi)productDaoLocal.getProductDetail();
//    	if(this.productEntity.getProductType().equals("DarbZedSergat"))
//    		this.productDetail =  (DarbZedSergat)productDaoLocal.getProductDetail();
//    	if(this.productEntity.getProductType().equals("GhabAx"))
//    		this.productDetail =  (GhabAx)productDaoLocal.getProductDetail();
//    	if(this.productEntity.getProductType().equals("Kabinet"))
//    		this.productDetail =  (Kabinet)productDaoLocal.getProductDetail();
//    	if(this.productEntity.getProductType().equals("KomodBoofeKetabkhaneJakafshi"))
//    		this.productDetail =  (KomodBoofeKetabkhaneJakafshi)productDaoLocal.getProductDetail();
//    	if(this.productEntity.getProductType().equals("Mdf"))
//    		this.productDetail =  (Mdf)productDaoLocal.getProductDetail();
//    	if(this.productEntity.getProductType().equals("MizAsali"))
//    		this.productDetail =  (MizAsali)productDaoLocal.getProductDetail();
//    	if(this.productEntity.getProductType().equals("MizEdari"))
//    		this.productDetail =  (MizEdari)productDaoLocal.getProductDetail();
//    	if(this.productEntity.getProductType().equals("MizJeloMobli"))
//    		this.productDetail =  (MizJeloMobli)productDaoLocal.getProductDetail();
//    	if(this.productEntity.getProductType().equals("MizNaharKhori"))
//    		this.productDetail =  (MizNaharKhori)productDaoLocal.getProductDetail();
//    	if(this.productEntity.getProductType().equals("MizTv"))
//    		this.productDetail =  (MizTv)productDaoLocal.getProductDetail();
//    	if(this.productEntity.getProductType().equals("Moblman"))
//    		this.productDetail =  (Moblman)productDaoLocal.getProductDetail();
//    	if(this.productEntity.getProductType().equals("Mojasame"))
//    		this.productDetail =  (Mojasame)productDaoLocal.getProductDetail();
//    	if(this.productEntity.getProductType().equals("Monabat"))
//    		this.productDetail =  (Monabat)productDaoLocal.getProductDetail();
//    	if(this.productEntity.getProductType().equals("Panjare"))
//    		this.productDetail =  (Panjare)productDaoLocal.getProductDetail();
//    	if(this.productEntity.getProductType().equals("Partition"))
//    		this.productDetail =  (Partition)productDaoLocal.getProductDetail();
//    	if(this.productEntity.getProductType().equals("SandaliEdari"))
//    		this.productDetail =  (SandaliEdari)productDaoLocal.getProductDetail();
//    	if(this.productEntity.getProductType().equals("ServiceKhab1"))
//    		this.productDetail =  (ServiceKhab1)productDaoLocal.getProductDetail();
//    	if(this.productEntity.getProductType().equals("ServiceKhab2"))
//    		this.productDetail =  (ServiceKhab2)productDaoLocal.getProductDetail();
//    	if(this.productEntity.getProductType().equals("ServiceKhabKodak"))
//    		this.productDetail =  (ServiceKhabKodak)productDaoLocal.getProductDetail();
//        return this.productDetail;
//}
	
	public void deleteProduct() {
		productDaoLocal.deleteProductEntity(productEntity);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("*****************************با موفقیت حذف گردید************************"));
	}
	
	public List<ProductEntity> findAllOnlyProductForUser(){
		return productDaoLocal.findAllProductEntityBySeller(adminProfile.getMoblEntity());
	}
}
