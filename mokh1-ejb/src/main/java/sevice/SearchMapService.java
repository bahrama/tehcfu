package sevice;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import catch_db.CatchSellerLocal;
import dao.SellerTblDaoLocal;
import entity.MoblEntity;

/**
 * Session Bean implementation class SearchMapService
 */
@Stateless
public class SearchMapService implements SearchMapServiceLocal {

    /**
     * Default constructor. 
     */
    public SearchMapService() {
        // TODO Auto-generated constructor stub
    }
//    @Inject
//    private CatchSellerLocal catchSellerLocal;
    @Inject
    private SellerTblDaoLocal sellerTblDaoLocal;
    
    
    @Override
	public List<MoblEntity> operation(double lat, double lng) {
		List<MoblEntity> moblEntities = new ArrayList<>();
		//double x = Math.sqrt(Math.hypot(lng, lat));
		for (MoblEntity moblEntity : sellerTblDaoLocal.findAllSeller()) {
			//double y =Math.hypot(merchantAddresEntity.getMerchandWidth(), merchantAddresEntity.getMerchantHeight());
			double m=(moblEntity.getLat()-lat);
			double n=(moblEntity.getLng()-lng);
			double f=(Math.hypot(m, n));
			long o=Math.round(f*10000);
			//getMerchandWidth//lat
			//getMerchantHeight//lng
			
			if(o<110) {
				moblEntities.add(moblEntity);
			}
		}
		
		return moblEntities;
	}
    
    @Override
	public List<MoblEntity> operation2(double lat, double lng, String raste) {
		List<MoblEntity> moblEntities = new ArrayList<>();
		//double x = Math.sqrt(Math.hypot(lng, lat));
		for (MoblEntity moblEntity : sellerTblDaoLocal.findAllSeller()) {
			//double y =Math.hypot(merchantAddresEntity.getMerchandWidth(), merchantAddresEntity.getMerchantHeight());
			double m=(moblEntity.getLat()-lat);
			double n=(moblEntity.getLng()-lng);
			double f=(Math.hypot(m, n));
			long o=Math.round(f*10000);
			//getMerchandWidth//lat
			//getMerchantHeight//lng
			
			if(o<110) {
				moblEntities.add(moblEntity);
			}
		}
		System.err.println(raste);
		

		return moblEntities;
	}

}
