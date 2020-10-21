package main.java.com.solvd.interfaces;

import java.util.List;

@FunctionalInterface
public interface ListToDouble<E> {
	public double fromListToDouble(List<E> list);
}
