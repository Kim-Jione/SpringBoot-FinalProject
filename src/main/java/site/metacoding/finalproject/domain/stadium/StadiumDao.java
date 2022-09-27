package site.metacoding.finalproject.domain.stadium;

import java.util.List;

public interface StadiumDao { 
	public List<Stadium> findAll();
	public Stadium findById(Integer id);
	public void insert(Stadium stadiumId);
	public void update(Integer id, Stadium stadiumId);
	public void deleteById(Integer id);
}
