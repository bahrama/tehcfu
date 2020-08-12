package catch_db;

import java.util.List;

import javax.ejb.Local;

import entity.Amade;

@Local
public interface CatchAmadeLocal {

	List<Amade> getAmadePano();

	List<Amade> getAmadeUnion();

	List<Amade> getAmadeMobasherat();

}
