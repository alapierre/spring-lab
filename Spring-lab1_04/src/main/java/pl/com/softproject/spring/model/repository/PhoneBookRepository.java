package pl.com.softproject.spring.model.repository;

import java.util.List;

import pl.com.softproject.spring.model.Entry;

public interface PhoneBookRepository {

	public abstract void save( Entry entry );

	public abstract void update( Entry entry );

	public abstract Entry findById( Long id );

	public abstract List<Entry> findAllEntries();
	
	public abstract void logToSysout();

}