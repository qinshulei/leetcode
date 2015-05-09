/*
* LRU Cache Total Accepted: 37829 Total Submissions: 253932 My Submissions Question Solution 
*
* Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
*
* get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
* set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the *least recently used item before inserting a new item.
*
*  //
*/

import java.util.LinkedHashMap;
import java.util.*;
import java.lang.Integer;
public class LRUCache{

  private  LinkedHashMap<Integer,Integer> map;
  private int mCapacity;

  public LRUCache(int capacity) {
        this.mCapacity = capacity;
        map = new LinkedHashMap<Integer,Integer>(capacity, 0.75f, true)
        {
            @Override 
            public boolean removeEldestEntry(Map.Entry eldest){  
              return size() > mCapacity; 
            }  
        };
  }
    
    
  public int get(int key) {
    if(map.get(key)==null)
    {
        return -1;
    }
    return map.get((key));
        
  }
    
    
  public void set(int key, int value) {
     map.put(new Integer(key),new Integer(value));
  }
  
  
  public static void main(String[] args){
      LRUCache cache = new LRUCache(5);
      cache.set(1,2);
      cache.set(7,4); 
      cache.set(5,9); 
      cache.set(3,4); 
      cache.set(6,6); 
      cache.get(7);
      
  
  }


}