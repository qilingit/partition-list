package com.qilin.adneom;

import java.util.ArrayList;
import java.util.List;

public class PartitionImpl implements PartitionService
{
	@Override
	public <T> List<List<T>> partition(List<T> list, Integer dim) throws PartitionException
	{
		if(dim == null)
		{
			throw new PartitionException("Dimension can not be null");
		}

		if(dim < 0)
		{
			throw new PartitionException("Dimension can not be negative");
		}

		if(dim == 0 || list == null || list.size() == 0)
		{
			return new ArrayList<List<T>>();
		}
		
		List<List<T>> result = new ArrayList<List<T>>();
		List<T> temp;
		
		if(list.size() < dim)
		{
			result.add(list);
			return result;
		}

		for(int i = 0; i < list.size(); i += dim)
		{
			temp = new ArrayList<T>();
			for(int j = i; j < dim + i && j < list.size(); j++) 
			{
				temp.add(list.get(j));
			}
			result.add(temp);
		}
		
		return result;
	}
	
	public static <T> int countElementListChain(List<List<T>> list)
	{
		int sum = 0;
		for(int i = 0; i < list.size(); i++)
		{
			sum += list.get(i).size();
		}
		return sum;
	}
}