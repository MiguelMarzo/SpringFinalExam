package org.sistema.springmvc.dao;

import java.util.List;

import org.sistema.springmvc.models.Misbehaviour;

public interface MisbehaviourDAO {

	public Long insert(Misbehaviour misbehaviour);

	public Misbehaviour selectById(Long id);

	public List<Misbehaviour> selectAll();

	public void delete(Long id);
	
	public void update(Misbehaviour misbehaviour);
}
