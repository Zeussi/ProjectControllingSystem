package edu.hm.cs.team8.masterdata.impl;

import java.util.List;
import java.util.Map;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Query;

public class Cache {

	private static List<Map<String, Object>> cache = null;

	public synchronized static List<Map<String, Object>> getCache(Handle handle) {

		if (cache == null) {
			final Query<Map<String, Object>> query = handle.createQuery("select * from BI");

			cache = query.list();
		}

		return cache;

	}
}
