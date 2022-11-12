package Mylist;


//this interface referred to the attached ADTDictionary.java
public interface ADTDictionary<K, E> {

// Reinitialize dictionary 
public void clear();

/** Insert a record
  @param  k The key for the record being inserted.
  @param  e The record being inserted. */
public void insert(K k, E e);

/** Remove and return a record.
  @param k The key of the record to be removed.
  @return A maching record. If multiple records match
  "k", remove an arbitrary one. Return null if no record
  with key "k" exists. */
public E remove(K k);

/** Remove and return an arbitrary record from dictionary.
  @return the record removed, or null if none exists. */
public E removeAny();

/** @return A record matching "k" (null if none exists).
  If multiple records match, return an arbitrary one. */
public E find(K k);

/** @return the number of records in the dictionary. */
public int size();
};
