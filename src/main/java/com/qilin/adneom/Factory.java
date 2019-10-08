package com.qilin.adneom;

public class Factory 
{
	public static PartitionService createPartition()
	{
		return new PartitionImpl();
	}
}
