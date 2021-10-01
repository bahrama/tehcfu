package sevice;


import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.AmadeDaoLocal;
import entity.Amade;
import enums.AmadeType;



/**
 * Session Bean implementation class AmadeService
 */
@Stateless
public class AmadeService implements AmadeServiceLocal {

    /**
     * Default constructor. 
     */
    public AmadeService() {
        // TODO Auto-generated constructor stub
    }
    @Inject
    private AmadeDaoLocal amadeDaoLocal;
    
    
    @Override
    public void insertToAmade(Amade amade){
    	amadeDaoLocal.insertToAmade(amade);
    }
    @Override
    public Amade findAmadeById(long amadeId) {
    	return amadeDaoLocal.findAmadeById(amadeId);
    }
    
    @Override
    @SuppressWarnings("unchecked")
	public List<Amade> findAllAmade(){
    	return amadeDaoLocal.findAllAmade();
    }
    
    @Override
    public void deleteAmade(Amade amade) {
         amadeDaoLocal.deleteAmade(amade);
    }

	@Override
    public List<Amade> findAmadeByType(AmadeType type) {
		return amadeDaoLocal.findAmadeByType(type);
	}
}
