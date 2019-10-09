package com.qilin.adneom;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.*;

public class AdneomFunctionTest 
{
	PartitionService partitionImpl;
	List<Integer> list, listNull;
	@Before
	public void initialize()
	{
		partitionImpl = Factory.createPartition();
		list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
		listNull = null;
	}

	// dim null
	@Test
	public void testPartition_dimNull()
	{
		try
		{
			partitionImpl.partition(list, null);
		}
		catch (PartitionException e)
		{
			assert(e.getMessage().contains("Dimension can not be null"));
		}
	}

	// dim negative
	@Test
	public void testPartition_dimNegative()
	{
		try
		{
			partitionImpl.partition(list, -1);
		}
		catch (PartitionException e)
		{
			assert(e.getMessage().contains("Dimension can not be negative"));
		}
	}

	// List null
	@Test
	public void testPartition_ListNull() throws PartitionException
	{
		List<List<Integer>> listPartitionNull = partitionImpl.partition(null, 2);
		assertEquals(listPartitionNull, new ArrayList<List<Integer>>());
		System.out.println("Input: " + listNull + ", dim: 2, \nOutput: " + listPartitionNull + "\n");
	}

	// List empty
	@Test
	public void testPartition_ListEmpty() throws PartitionException
	{
		List<List<Integer>> listPartitionEmpty = partitionImpl.partition(new ArrayList<Integer>(), 2);
		assertEquals(listPartitionEmpty, new ArrayList<List<Integer>>());
		System.out.println("Input: " + listPartitionEmpty + ", dim: 2, \nOutput: " + listPartitionEmpty + "\n");
	}

	// dim 0
	@Test
	public void testPartition_Dim0() throws PartitionException
	{
		List<List<Integer>> listPartition0 = partitionImpl.partition(list, 0);
		assertEquals(listPartition0, new ArrayList<List<Integer>>());
		System.out.println("Input: " + list + ", dim: 0, \nOutput: " + listPartition0 + "\n");
	}

	// dim 1
	@Test
	public void testPartition_Dim1() throws PartitionException
	{
		List<List<Integer>> listPartition1 = partitionImpl.partition(list, 1);
		List<List<Integer>> listPartitionExpected1 = new ArrayList<List<Integer>>(6);
		for(int i = 0; i < 6; i++)
		{
			listPartitionExpected1.add(new ArrayList<Integer>());
		}
		for(int j = 0; j < 6; j++)
		{
			listPartitionExpected1.get(j).add(j+1);
		}
		System.out.println("Input: " + list + ", dim: 1, \nOutput: " + listPartitionExpected1 + "\n");
		assertEquals(listPartition1,listPartitionExpected1);
	}

	// test number of element non changed
	@Test
	public void testPartition_ElementNoChange() throws PartitionException
	{
		List<List<Integer>> listPartition1 = partitionImpl.partition(list, 1);
		List<List<Integer>> listPartitionExpected1 = new ArrayList<List<Integer>>(6);
		for(int i = 0; i < 6; i++)
		{
			listPartitionExpected1.add(new ArrayList<Integer>());
		}
		for(int j = 0; j < 6; j++)
		{
			listPartitionExpected1.get(j).add(j+1);
		}
		System.out.println("Input: " + list + ", number of element : " + list.size() + ", dim: 1, \nOutput: "
				+ listPartitionExpected1 + ", number of element : " + PartitionImpl.countElementListChain(listPartitionExpected1) + "\n");
		assertEquals(list.size(), PartitionImpl.countElementListChain(listPartitionExpected1));
	}

	// Dim 2, exact devised
	@Test
	public void testPartition_DimExactDivisionNoOne() throws PartitionException
	{
		List<List<Integer>> listPartition2 = partitionImpl.partition(list, 2);
		List<List<Integer>> listPartitionExpected2 = new ArrayList<List<Integer>>(3);
		for(int i = 0; i < 3; i++)
		{
			listPartitionExpected2.add(new ArrayList<Integer>());
		}

		listPartitionExpected2.get(0).add(1);
		listPartitionExpected2.get(0).add(2);
		listPartitionExpected2.get(1).add(3);
		listPartitionExpected2.get(1).add(4);
		listPartitionExpected2.get(2).add(5);
		listPartitionExpected2.get(2).add(6);

		assertEquals(listPartition2,listPartitionExpected2);
		System.out.println("Input: " + list + ", dim: 2, \nOutput: " + listPartitionExpected2 + "\n");
	}

	// dim is not exact devised
	@Test
	public void testPartition_NoExactDivision() throws PartitionException
	{
		// dim 4
		List<List<Integer>> listPartition4 = partitionImpl.partition(list, 4);
		List<List<Integer>> listPartitionExpected4 = new ArrayList<List<Integer>>(2);
		for(int i = 0; i < 2; i++)
		{
			listPartitionExpected4.add(new ArrayList<Integer>());
		}

		listPartitionExpected4.get(0).add(1);
		listPartitionExpected4.get(0).add(2);
		listPartitionExpected4.get(0).add(3);
		listPartitionExpected4.get(0).add(4);
		listPartitionExpected4.get(1).add(5);
		listPartitionExpected4.get(1).add(6);

		assertEquals(listPartition4,listPartitionExpected4);
		System.out.println("Input: " + list + ", dim: 4, \nOutput: " + listPartitionExpected4 + "\n");
	}

	// dim is the number of element
	@Test
	public void testPartition_DimEqualsToElement() throws PartitionException
	{
		List<List<Integer>> listPartition6 = partitionImpl.partition(list, 6);
		List<List<Integer>> listPartitionExpected6 = new ArrayList<List<Integer>>(1);

		listPartitionExpected6.add(list);

		assertEquals(listPartition6,listPartitionExpected6);
		System.out.println("Input: " + list + ", dim: 6, \nOutput: " + listPartitionExpected6 + "\n");
	}

	// dim bigger than number of element
	@Test
	public void testPartition_DimBiggerThanElement() throws PartitionException
    {
		// dim 7
		List<List<Integer>> listPartition7 = partitionImpl.partition(list, 7);
		List<List<Integer>> listPartitionExpected7 = new ArrayList<List<Integer>>(1);

		listPartitionExpected7.add(list);

		assertEquals(listPartition7,listPartitionExpected7);
		System.out.println("Input: " + list + ", dim: 7, \nOutput: " + listPartitionExpected7 + "\n");
	}
}