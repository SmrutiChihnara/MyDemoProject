package com.app.service;

import com.app.model.Item;
import java.lang.Integer;
import java.util.List;

/**
 * @author:Smruti
 *  Generated F/w:SHWR-Framework 
 */
public interface IItemService {
  Integer saveItem(Item item);

  void updateItem(Item item);

  void deleteItem(Integer id);

  Item getOneItem(Integer id);

  List<Item> getAllItems();
}
