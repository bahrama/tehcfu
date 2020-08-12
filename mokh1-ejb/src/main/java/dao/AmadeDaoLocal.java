package dao;



import java.util.List;

import javax.ejb.Local;

import entity.Amade;



@Local
public interface AmadeDaoLocal {

	void insertToAmade(Amade amade);

	Amade findAmadeById(long amadeId);

	List<Amade> findAllAmade();

	void deleteAmade(Amade amade);

}
