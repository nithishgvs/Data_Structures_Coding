package org.leetcode.Hashing;

import java.util.ArrayList;

/**
 * Generic Hash Map with size 10(ArrayList size) will be created
 * 
 * @author nithishgvs
 *
 * @param <K>
 * @param <V>
 */
public class HashMap<K, V> {

	private int size = 0;
	private ArrayList<HashNode<K, V>> bucketArray;
	private int bucketSize = 0;

	// Constructor to initialize the bucketArray

	public HashMap() {
		// ArrayList will be created with default size 10
		// By default all values will be null
		bucketArray = new ArrayList<>();
		bucketSize = 10;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public int getBucketIndex(K key) {
		/*
		 * (anything%bucketSize) returns remainder which is always less than
		 * bucketSize
		 */
		int hashcode = key.hashCode();
		int keyHashCode = hashcode % bucketSize;
		return keyHashCode;
	}

	/**
	 * 
	 * @param key
	 */
	public void remove(K key) {
		int bucketIndex = getBucketIndex(key);
		HashNode<K, V> headNode = bucketArray.get(bucketIndex);
		HashNode<K, V> prevNode = null;

		while (headNode != null) {
			if (headNode.getKey().equals(key)) {
				break;
			}
			prevNode = headNode;
			headNode = headNode.getNextNode();
		}

		if (headNode == null) {
			return;
		}

		if (prevNode != null) {
			prevNode.setNextNode(headNode.getNextNode());
		} else {
			// Element is at headNode
			headNode = headNode.getNextNode();
			bucketArray.set(bucketIndex, headNode);
		}
		size--;
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public V get(K key) {
		int bucketIndex = getBucketIndex(key);
		HashNode<K, V> headNode = bucketArray.get(bucketIndex);
		while (headNode != null) {
			if (headNode.getKey().equals(key)) {
				return headNode.getValue();
			}
			headNode = headNode.getNextNode();
		}
		return null;
	}

	/**
	 * 
	 * @param key
	 * @param value
	 */
	public void put(K key, V value) {
		int bucketIndex = getBucketIndex(key);
		HashNode<K, V> headNode = bucketArray.get(bucketIndex);
		while (headNode != null) {
			if (headNode.getKey().equals(key)) {
				headNode.setValue(value);
				return;
			}
			headNode = headNode.getNextNode();
		}
		// Even if element is not present the headNode will be changed because
		// of above While loop
		headNode = bucketArray.get(bucketIndex);
		size++;
		// New node becomes head now and has to be inserted in the same bucke
		// index
		HashNode<K, V> newNode = new HashNode<>(key, value);
		newNode.setNextNode(headNode);
		bucketArray.set(bucketIndex, newNode);

		// Hashing
		if ((float) (size / bucketIndex) >= 0.7) {

			bucketSize = 2 * bucketSize;
			ArrayList<HashNode<K, V>> tempList = bucketArray;
			bucketArray = new ArrayList<>(bucketSize);

			for (HashNode<K, V> hashNode : tempList) {
				while (hashNode != null) {
					put(hashNode.getKey(), hashNode.getValue());
					hashNode = hashNode.getNextNode();
				}
			}

		}

	}

}
