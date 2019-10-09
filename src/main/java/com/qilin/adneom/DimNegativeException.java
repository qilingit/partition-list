package com.qilin.adneom;

public class DimNegativeException extends PartitionException
{
    public DimNegativeException() {
        super("Dimension can not be negative");
    }
}
