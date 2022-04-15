package cache;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CustomLRUCache<K, V> {
	int capacity = 2;

	private Map<K, V> map = new HashMap<K, V>();
	private Deque<K> list = new LinkedList<K>();

	/**
	 * If item is already there make it recently accessed item
	 * 
	 * @param key
	 * @param value
	 */
	public void put(K key, V value) {
		if (map.containsKey(key)) {
			list.remove();
		} else {
			if (map.size() == capacity) {
				System.out.println("Capacity exceeded ,removing oldest entry ,key=" + key);
				// Remove the oldest entry
				K oldestKey = list.peekLast();
				list.removeLast();
				map.remove(oldestKey);
			}
		}
		map.put(key, value);
		list.add(key);
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public V get(K key) {
		// As the key is accessed hence making it recently accessed item by
		if (map.containsKey(key)) {
			System.out.println();
			list.remove(key);
			list.addFirst(key);
			return map.get(key);
		} else {
			return null;
		}

	}

	public static void main(String[] args) {

		CustomLRUCache<Integer, String> cache = new CustomLRUCache<Integer, String>();
		cache.put(1, "One");
		cache.put(2, "Two");
		cache.put(3, "Three");
		cache.put(4, "Four");
	}

}
