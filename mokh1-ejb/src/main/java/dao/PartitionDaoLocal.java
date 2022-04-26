package dao;

import javax.ejb.Local;

import entity.Partition;

@Local
public interface PartitionDaoLocal {

	void insertToPartition(Partition partition) throws Exception;

}
