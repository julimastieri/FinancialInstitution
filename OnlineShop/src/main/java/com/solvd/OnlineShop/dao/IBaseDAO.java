package com.solvd.OnlineShop.dao;

public interface IBaseDAO<E> {
	E save(E e, long id);
	boolean removeById(long id);
}
