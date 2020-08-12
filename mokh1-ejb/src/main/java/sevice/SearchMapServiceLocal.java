package sevice;


import java.util.List;

import javax.ejb.Local;

import entity.MoblEntity;


@Local
public interface SearchMapServiceLocal {

	List<MoblEntity> operation(double lat, double lng);

	List<MoblEntity> operation2(double lat, double lng, String raste);



}
