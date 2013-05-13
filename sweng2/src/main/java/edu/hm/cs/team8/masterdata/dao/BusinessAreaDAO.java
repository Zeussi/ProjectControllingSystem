package edu.hm.cs.team8.masterdata.dao;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.masterdata.datamodel.BusinessArea;
import edu.hm.cs.team8.masterdata.impl.Cache;

public class BusinessAreaDAO {

	private final Set<BusinessArea> areas = new HashSet<>();

	public BusinessAreaDAO(final Handle handle) {

		for (final Map<String, Object> line : Cache.getCache(handle)) {

			if (!line.containsKey("bereich"))
				continue;

			areas.add(new BusinessArea(line.get("bereich").toString()));
		}
	}

	public BusinessArea findBusinessAreaByName(final String name) {

		for (BusinessArea area : areas)
			if (area.getName().equals(name))
				return area;

		return null;
	}

	public Set<BusinessArea> getBusinessAreas() {
		return Collections.unmodifiableSet(areas);
	}

}
