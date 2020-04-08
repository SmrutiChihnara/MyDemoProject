package com.app.dao;

import java.util.List;

import com.app.model.Item;

/**
 * @author:Smruti 
 *  Generated F/w:SHWR-Framework 
 */
public interface IItemDao {
	Integer saveItem(Item item);

	void updateItem(Item item);

	void deleteItem(Integer id);

	Item getOneItem(Integer id);

	List<Item> getAllItems();
}
