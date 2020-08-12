package sevice;


import java.util.List;

import javax.ejb.Local;

import entity.Amade;


@Local
public interface AmadeServiceLocal {

	void insertToAmade(Amade amade);

	Amade findAmadeById(long amadeId);

	List<Amade> findAllAmade();

	void deleteAmade(Amade amade);

}
