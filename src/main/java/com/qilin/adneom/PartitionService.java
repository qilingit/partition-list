package com.qilin.adneom;

import java.util.List;

public interface PartitionService 
{
	<T> List<List<T>> partition(List<T> list, Integer dim) throws PartitionException;
}
