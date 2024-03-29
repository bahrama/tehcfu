package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.MoblEntity;
import enums.UserRole;

/**
 * Session Bean implementation class SellerTblDao
 */
@Stateless
public class SellerTblDao implements SellerTblDaoLocal {

	/**
	 * Default constructor.
	 */
	public SellerTblDao() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "aliUnit")
	private EntityManager entityManager;

	@Override
	public void insertSeller(MoblEntity moblEntity) throws Exception{
				entityManager.persist(moblEntity);		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<MoblEntity> findAllSeller() {
		return entityManager.createNamedQuery("MoblEntity.findAll").getResultList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<MoblEntity> findAllMapSeller() {
		return entityManager.createNamedQuery("MoblEntity.findAllMap").getResultList();
	}

	@Override
	public MoblEntity findSellerById(long id) throws Exception {
		try {
			return (MoblEntity) entityManager.createNamedQuery("MoblEntity.findById").setParameter("v_id", id)
					.getSingleResult();
		} catch (Exception exception) {
			throw new Exception();
		}
	}

	@Override
	public void updateSeller(MoblEntity moblEntity) throws Exception {
		try {
			entityManager.merge(moblEntity);
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Override
	public void deleteSeller(MoblEntity moblEntity) {
		MoblEntity moblEntity2 = new MoblEntity();
		moblEntity2 = entityManager.merge(moblEntity);
		entityManager.remove(moblEntity2);
	}

	@Override
	public MoblEntity findSellerByMobile(String mobile) throws Exception {
		try {
			return (MoblEntity) entityManager.createNamedQuery("MoblEntity.findByMobile")
					.setParameter("v_mobile", mobile).getSingleResult();
		} catch (Exception exception) {
			throw new Exception();
		}
	}

	@Override
	public MoblEntity findSellerByNameEng(String nameEng) throws Exception {
		try {
			return (MoblEntity) entityManager.createNamedQuery("MoblEntity.findByNameEng")
					.setParameter("v_sellerStoreEng", nameEng).getSingleResult();
		} catch (Exception exception) {
			throw new Exception();
		}
	}

	@Override
	public MoblEntity findSellerByToken(String token) throws Exception {
		try {
			return (MoblEntity) entityManager.createNamedQuery("MoblEntity.findByToken").setParameter("v_token", token)
					.getSingleResult();
		} catch (Exception exception) {
			throw new Exception();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MoblEntity> findSellersByPanel(String panel) throws Exception {
		try {
			return entityManager.createNamedQuery("MoblEntity.findByPanel").setParameter("v_panel", panel)
					.getResultList();
		} catch (Exception exception) {
			throw new Exception();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MoblEntity> findSellersByLikeName(String sellerName) throws Exception {
		try {
			return entityManager.createNamedQuery("MoblEntity.findSellerNameLike")
					.setParameter("v_sellerName", "%" + sellerName + "%").getResultList();
		} catch (Exception exception) {
			throw new Exception();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MoblEntity> findSellerByNamePerLike(String nameper) throws Exception {
		try {
			return entityManager.createNamedQuery("MoblEntity.findsellerStorePerLike")
					.setParameter("v_sellerStorePer", "%" + nameper + "%").setParameter("v_panel", "E").getResultList();
		} catch (Exception exception) {
			throw new Exception();
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MoblEntity> findSellerByFilter(String text,String filter) throws Exception {
		try {
			if(filter.equals("A")) {
			return entityManager.createNamedQuery("MoblEntity.findsellerStorePerLike")
					.setParameter("v_sellerStorePer", "%" + text + "%").setParameter("v_panel", "E").getResultList();
			}else if (filter.equals("B")) {
				return entityManager.createNamedQuery("MoblEntity.findsellerAddresLike")
						.setParameter("v_sellerAddres", "%" + text + "%").setParameter("v_panel", "E").getResultList();
			}else if (filter.equals("C")) {
				return entityManager.createNamedQuery("MoblEntity.findsellermodirforoshNameLike")
						.setParameter("v_modirforoshName", "%" + text + "%").setParameter("v_panel", "E").getResultList();
			}else {
				return null;
			}
			} catch (Exception exception) {
			throw new Exception();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MoblEntity> findSellerByFilterE(String text,String filter) throws Exception {
		try {
			if(filter.equals("A")) {
			return entityManager.createNamedQuery("MoblEntity.findsellerStorePerLikeE")
					.setParameter("v_sellerStorePer", "%" + text + "%").setParameter("v_panel", "E").getResultList();
			}else if (filter.equals("B")) {
				return entityManager.createNamedQuery("MoblEntity.findsellerAddresLikeE")
						.setParameter("v_sellerAddres", "%" + text + "%").setParameter("v_panel", "E").getResultList();
			}else if (filter.equals("C")) {
				return entityManager.createNamedQuery("MoblEntity.findsellermodirforoshNameLikeE")
						.setParameter("v_modirforoshName", "%" + text + "%").setParameter("v_panel", "E").getResultList();
			}else {
				return null;
			}
			} catch (Exception exception) {
			throw new Exception();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MoblEntity> findSellersByMojtame(String mojtame) throws Exception {
		try {
			return entityManager.createNamedQuery("MoblEntity.findByMojtame").setParameter("v_mojtame", mojtame)
					.getResultList();
		} catch (Exception exception) {
			throw new Exception();
		}
	}
	
}
