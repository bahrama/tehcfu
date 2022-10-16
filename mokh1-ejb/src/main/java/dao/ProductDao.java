package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
import entity.MoblEntity;
import entity.Moblman;
import entity.Mojasame;
import entity.Monabat;
import entity.Panjare;
import entity.Partition;
import entity.ProductEntity;
import entity.RentEntity;
import entity.SandaliEdari;
import entity.ServiceKhab1;
import entity.ServiceKhab2;
import entity.ServiceKhabKodak;

/**
 * Session Bean implementation class ProductDao
 */
@Stateless
public class ProductDao implements ProductDaoLocal {

    /**
     * Default constructor. 
     */
    public ProductDao() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    
    private Object productDetail;
    
    
    @Override
    public Object getProductDetail() {
		return productDetail;
	}

	@Override
    public void insertToProduct(ProductEntity productEntity) throws Exception {
    	try {
    	entityManager.persist(productEntity);
    	}catch (Exception e) {
			throw new Exception("roleback for repetetly data");
		}
    	}
    
    @SuppressWarnings("unchecked")
    @Override
	public List<ProductEntity> findAllActiveProductEntity(){
    	return entityManager.createNamedQuery("findAllActiveProductEntity").setParameter("v_checkO", true).getResultList();
    }
    
    @SuppressWarnings("unchecked")
    @Override
	public List<ProductEntity> findAllProductEntity(){
    	return entityManager.createNamedQuery("findAllProductEntity").getResultList();
    }
    
    @Override
    public ProductEntity findProductOnlyById(long productId) {
    	return (ProductEntity) entityManager.createNamedQuery("findByProductEntityId").setParameter("v_productId", productId).setParameter("v_checkO", true).getSingleResult();
    }
    
    
    @Override
    public void deleteProductEntity(ProductEntity productEntity2){
    	ProductEntity productEntity=new ProductEntity();
    	productEntity=entityManager.merge(productEntity2);
    	entityManager.remove(productEntity);
    }

    @Override
    @SuppressWarnings("unchecked")
	public List<ProductEntity> findProductByUser(MoblEntity moblEntity){
    	return  entityManager.createNamedQuery("findAllProductEntityBySeller")
    			.setParameter("v_product", moblEntity).setParameter("v_checkO", true).getResultList();
    }
    
    
    
	/*
	 * @Override public ProductEntity findProductEntityById(long productId) {
	 * ProductEntity productEntity =(ProductEntity)
	 * entityManager.createNamedQuery("findByProductEntityId").setParameter(
	 * "v_productId", productId).getSingleResult();
	 * if(productEntity.getProductType().equals("AyeneVConsole")) this.productDetail
	 * = findAyeneVConsoleById(productId);
	 * if(productEntity.getProductType().equals("DarbChobi")) this.productDetail =
	 * findDarbChobiById(productId);
	 * if(productEntity.getProductType().equals("DarbZedSergat")) this.productDetail
	 * = findDarbZedSergatById(productId);
	 * if(productEntity.getProductType().equals("GhabAx")) this.productDetail =
	 * findGhabAxById(productId);
	 * if(productEntity.getProductType().equals("Kabinet")) this.productDetail =
	 * findKabinetById(productId);
	 * if(productEntity.getProductType().equals("KomodBoofeKetabkhaneJakafshi"))
	 * this.productDetail = findKomodBoofeKetabkhaneJakafshiById(productId);
	 * if(productEntity.getProductType().equals("Mdf")) this.productDetail =
	 * findMdfId(productId); if(productEntity.getProductType().equals("MizAsali"))
	 * this.productDetail = findMizAsaliById(productId);
	 * if(productEntity.getProductType().equals("MizEdari")) this.productDetail =
	 * findMizEdariById(productId);
	 * if(productEntity.getProductType().equals("MizJeloMobli")) this.productDetail
	 * = findMizJeloMobliById(productId);
	 * if(productEntity.getProductType().equals("MizNaharKhori")) this.productDetail
	 * = findMizNaharKhoriById(productId);
	 * if(productEntity.getProductType().equals("MizTv")) this.productDetail =
	 * findMizTvById(productId);
	 * if(productEntity.getProductType().equals("Moblman")) this.productDetail =
	 * findMoblmanById(productId);
	 * if(productEntity.getProductType().equals("Mojasame")) this.productDetail =
	 * findMojasameById(productId);
	 * if(productEntity.getProductType().equals("Monabat")) this.productDetail =
	 * findMonabatById(productId);
	 * if(productEntity.getProductType().equals("Panjare")) this.productDetail =
	 * findPanjareById(productId);
	 * if(productEntity.getProductType().equals("Partition")) this.productDetail =
	 * findPartitionById(productId);
	 * if(productEntity.getProductType().equals("SandaliEdari")) this.productDetail
	 * = findSandaliEdariById(productId);
	 * if(productEntity.getProductType().equals("ServiceKhab1")) this.productDetail
	 * = findServiceKhab1ById(productId);
	 * if(productEntity.getProductType().equals("ServiceKhab2")) this.productDetail
	 * = findServiceKhab2ById(productId);
	 * if(productEntity.getProductType().equals("ServiceKhabKodak"))
	 * this.productDetail = findServiceKhabKodakById(productId);
	 * 
	 * return productEntity; }
	 */
    @Override
    public void updateProductEntity(ProductEntity productEntity) {
    	entityManager.merge(productEntity);
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<ProductEntity> findAllProductEntityBySeller(MoblEntity moblEntity) {
    	return  entityManager.createNamedQuery("findAllProductEntityBySeller").setParameter("v_product", moblEntity).getResultList();
    }
    public AyeneVConsole findAyeneVConsoleById(long productId) {
    	return (AyeneVConsole) entityManager.createNamedQuery("findAyeneVConsoleById").setParameter("v_productId", productId).getSingleResult();
    }
    public DarbChobi findDarbChobiById(long productId) {
    	return (DarbChobi) entityManager.createNamedQuery("findDarbChobiById").setParameter("v_productId", productId).getSingleResult();
    }
    public DarbZedSergat findDarbZedSergatById(long productId) {
    	return (DarbZedSergat) entityManager.createNamedQuery("findDarbZedSergatById").setParameter("v_productId", productId).getSingleResult();
    }
    public GhabAx findGhabAxById(long productId) {
    	return (GhabAx) entityManager.createNamedQuery("findGhabAxById").setParameter("v_productId", productId).getSingleResult();
    }
    public Kabinet findKabinetById(long productId) {
    	return (Kabinet) entityManager.createNamedQuery("findKabinetById").setParameter("v_productId", productId).getSingleResult();
    }
    public KomodBoofeKetabkhaneJakafshi findKomodBoofeKetabkhaneJakafshiById(long productId) {
    	return (KomodBoofeKetabkhaneJakafshi) entityManager.createNamedQuery("findKomodBoofeKetabkhaneJakafshiById").setParameter("v_productId", productId).getSingleResult();
    }
    public Mdf findMdfId(long productId) {
    	return (Mdf) entityManager.createNamedQuery("findMdfById").setParameter("v_productId", productId).getSingleResult();
    }
    public MizAsali findMizAsaliById(long productId) {
    	return (MizAsali) entityManager.createNamedQuery("findMizAsaliById").setParameter("v_productId", productId).getSingleResult();
    }
    public MizEdari findMizEdariById(long productId) {
    	return (MizEdari) entityManager.createNamedQuery("findMizEdariById").setParameter("v_productId", productId).getSingleResult();
    }
    public MizJeloMobli findMizJeloMobliById(long productId) {
    	return (MizJeloMobli) entityManager.createNamedQuery("findMizJeloMobliById").setParameter("v_productId", productId).getSingleResult();
    }
    public MizNaharKhori findMizNaharKhoriById(long productId) {
    	return (MizNaharKhori) entityManager.createNamedQuery("findMizNaharKhoriById").setParameter("v_productId", productId).getSingleResult();
    }
    public MizTv findMizTvById(long productId) {
    	return (MizTv) entityManager.createNamedQuery("findMizTvById").setParameter("v_productId", productId).getSingleResult();
    }
    public Moblman findMoblmanById(long productId) {
    	return (Moblman) entityManager.createNamedQuery("findMoblmanById").setParameter("v_productId", productId).getSingleResult();
    }
    public Mojasame findMojasameById(long productId) {
    	return (Mojasame) entityManager.createNamedQuery("findMojasameById").setParameter("v_productId", productId).getSingleResult();
    }
    public Panjare findPanjareById(long productId) {
    	return (Panjare) entityManager.createNamedQuery("findPanjareById").setParameter("v_productId", productId).getSingleResult();
    }
    public Partition findPartitionById(long productId) {
    	return (Partition) entityManager.createNamedQuery("findPartitionById").setParameter("v_productId", productId).getSingleResult();
    }
    public SandaliEdari findSandaliEdariById(long productId) {
    	return (SandaliEdari) entityManager.createNamedQuery("findSandaliEdariById").setParameter("v_productId", productId).getSingleResult();
    }
    public ServiceKhab1 findServiceKhab1ById(long productId) {
    	return (ServiceKhab1) entityManager.createNamedQuery("findServiceKhab1ById").setParameter("v_productId", productId).getSingleResult();
    }
    public ServiceKhab2 findServiceKhab2ById(long productId) {
    	return (ServiceKhab2) entityManager.createNamedQuery("findServiceKhab2ById").setParameter("v_productId", productId).getSingleResult();
    }
    public ServiceKhabKodak findServiceKhabKodakById(long productId) {
    	return (ServiceKhabKodak) entityManager.createNamedQuery("findServiceKhabKodakById").setParameter("v_productId", productId).getSingleResult();
    }
    public Monabat findMonabatById(long productId) {
    	return (Monabat) entityManager.createNamedQuery("findServiceKhabKodakById").setParameter("v_productId", productId).getSingleResult();
    }

    
    
	/*
	 * @Override public Map<ProductEntity, Object>
	 * findAllProductBySeller2(MoblEntity moblEntity){ Map<ProductEntity, Object>
	 * map = new HashMap<ProductEntity, Object>(); for (ProductEntity proEntity :
	 * findAllProductEntityBySeller(moblEntity)) {
	 * if(proEntity.getProductType().equals("AyeneVConsole")) map.put(proEntity,
	 * findAyeneVConsoleById(proEntity.getProductId()));
	 * if(proEntity.getProductType().equals("DarbChobi")) map.put(proEntity,
	 * findDarbChobiById(proEntity.getProductId()));
	 * if(proEntity.getProductType().equals("DarbZedSergat")) map.put(proEntity,
	 * findDarbZedSergatById(proEntity.getProductId()));
	 * if(proEntity.getProductType().equals("GhabAx")) map.put(proEntity,
	 * findGhabAxById(proEntity.getProductId()));
	 * if(proEntity.getProductType().equals("Kabinet")) map.put(proEntity,
	 * findKabinetById(proEntity.getProductId()));
	 * if(proEntity.getProductType().equals("KomodBoofeKetabkhaneJakafshi"))
	 * map.put(proEntity,
	 * findKomodBoofeKetabkhaneJakafshiById(proEntity.getProductId()));
	 * if(proEntity.getProductType().equals("Mdf")) map.put(proEntity,
	 * findMdfId(proEntity.getProductId()));
	 * if(proEntity.getProductType().equals("MizAsali")) map.put(proEntity,
	 * findMizAsaliById(proEntity.getProductId()));
	 * if(proEntity.getProductType().equals("MizEdari")) map.put(proEntity,
	 * findMizEdariById(proEntity.getProductId()));
	 * if(proEntity.getProductType().equals("MizJeloMobli")) map.put(proEntity,
	 * findMizJeloMobliById(proEntity.getProductId()));
	 * if(proEntity.getProductType().equals("MizNaharKhori")) map.put(proEntity,
	 * findMizNaharKhoriById(proEntity.getProductId()));
	 * if(proEntity.getProductType().equals("MizTv")) map.put(proEntity,
	 * findMizTvById(proEntity.getProductId()));
	 * if(proEntity.getProductType().equals("Moblman")) map.put(proEntity,
	 * findMoblmanById(proEntity.getProductId()));
	 * if(proEntity.getProductType().equals("Mojasame")) map.put(proEntity,
	 * findMojasameById(proEntity.getProductId()));
	 * if(proEntity.getProductType().equals("Monabat")) map.put(proEntity,
	 * findMonabatById(proEntity.getProductId()));
	 * if(proEntity.getProductType().equals("Panjare")) map.put(proEntity,
	 * findPanjareById(proEntity.getProductId()));
	 * if(proEntity.getProductType().equals("Partition")) map.put(proEntity,
	 * findPartitionById(proEntity.getProductId()));
	 * if(proEntity.getProductType().equals("SandaliEdari")) map.put(proEntity,
	 * findSandaliEdariById(proEntity.getProductId()));
	 * if(proEntity.getProductType().equals("ServiceKhab1")) map.put(proEntity,
	 * findServiceKhab1ById(proEntity.getProductId()));
	 * if(proEntity.getProductType().equals("ServiceKhab2")) map.put(proEntity,
	 * findServiceKhab2ById(proEntity.getProductId()));
	 * if(proEntity.getProductType().equals("ServiceKhabKodak")) map.put(proEntity,
	 * findServiceKhabKodakById(proEntity.getProductId())); }
	 * 
	 * return map; }
	 */
    @Override
    public Object countAllProduct() {
    	return entityManager.createNamedQuery("countAllProduct").setParameter("v_checkO", true).getSingleResult();
    }
	
	
	  @Override public List<ProductEntity> findRandomProduct() {
	  List<ProductEntity> productEntities =new ArrayList<ProductEntity>(); 
	  int count = Integer.parseInt(countAllProduct().toString());
	  if(count>=6)
	  for(int j=0 ; j<6 ; j++) 
	  { Random random =new Random(); int indx =
	  random.nextInt(count);
	  productEntities.add(findAllActiveProductEntity().get(indx)); 
	  } 
	  else if(count<=6 && count >=1)
		  for(int j=0 ; j<count ; j++) 
		  { Random random =new Random(); int indx =
		  random.nextInt(count);
		  productEntities.add(findAllActiveProductEntity().get(indx)); 
		  }  
	  else
		  productEntities =null;
	  return productEntities; 
	  }
	 
	 

}
