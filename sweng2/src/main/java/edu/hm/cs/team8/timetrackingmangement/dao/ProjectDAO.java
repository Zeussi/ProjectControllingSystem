package edu.hm.cs.team8.timetrackingmangement.dao;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.timetrackingmangement.datamodel.BusinessArea;
import edu.hm.cs.team8.timetrackingmangement.datamodel.Project;

public class ProjectDAO {

	private final Set<Project> projects = new HashSet<>();

	public ProjectDAO(final Handle handle) {

		for (final Map<String, Object> line : Cache.getCache(handle)) {

			if (!line.containsKey("projekt"))
				continue;

			projects.add(new Project(line.get("projekt").toString(), new BusinessArea(line.get("bereich").toString())));
		}
	}

	public Project findProjectByName(final String name) {

		for (Project area : projects)
			if (area.getName().equals(name))
				return area;

		return null;
	}

	public Set<Project> getProjects() {
		return Collections.unmodifiableSet(projects);
	}

}
