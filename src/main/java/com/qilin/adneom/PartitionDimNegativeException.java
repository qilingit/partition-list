package com.qilin.adneom;

public class PartitionDimNegativeException extends Exception
{
    public PartitionDimNegativeException() {
        super("Dimension can not be negative");
    }
}
