package com.qilin.adneom;

public class DimNullException extends PartitionException
{
    public DimNullException()
    {
        super("Dimension can not be null");
    }
}
