package sevice;

import java.util.List;
import java.util.Set;

import javax.ejb.Local;

import entity.MoblEntity;

@Local
public interface OnlineUsersLocal {


	Set<MoblEntity> getMobls();



}
