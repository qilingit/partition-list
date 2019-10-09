package com.qilin.adneom;

public class PartitionException extends Exception
{
    public PartitionException(String message)
    {
        super("Partition Exception : " + message);
    }
}
