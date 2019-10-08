package com.qilin.adneom;

public class PartitionDimNullException extends Exception
{
    public PartitionDimNullException() {
        super("Dimension can not be null");
    }
}
