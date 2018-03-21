package org.leetcode.Hashing;

/**
 * Basic Hash Node
 * 
 * @author nithishgvs
 *
 * @param <K>
 * @param <V>
 */
public class HashNode<K, V> {

	private K key;
	private V value;

	private HashNode<K, V> nextNode;

	public HashNode(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public HashNode<K, V> getNextNode() {
		return nextNode;
	}

	public void setNextNode(HashNode<K, V> nextNode) {
		this.nextNode = nextNode;
	}

}
