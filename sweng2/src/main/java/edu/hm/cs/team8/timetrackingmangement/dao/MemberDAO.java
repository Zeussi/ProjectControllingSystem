package edu.hm.cs.team8.timetrackingmangement.dao;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.timetrackingmangement.datamodel.Member;
import edu.hm.cs.team8.timetrackingmangement.impl.Cache;

public class MemberDAO {

	final Set<Member> members = new HashSet<>();

	public MemberDAO(Handle handle) {

		for (final Map<String, Object> line : Cache.getCache(handle)) {

			if (!line.containsKey("mitarbeiter"))
				continue;

			members.add(new Member(Long.parseLong(line.get("mid").toString()), line.get("mitarbeiter").toString(),
					Integer.parseInt(line.get("entwicklungsstufe").toString())));
		}
	}

	public Member findMemberByID(final long id) {

		for (final Member member : members)
			if (member.getmId() == id)
				return member;

		return null;
	}

	public Member findMemberByName(final String name) {

		for (final Member member : members)
			if (member.getName().equals(name))
				return member;

		return null;
	}

	public Set<Member> getMembers() {
		return Collections.unmodifiableSet(members);
	}
}
