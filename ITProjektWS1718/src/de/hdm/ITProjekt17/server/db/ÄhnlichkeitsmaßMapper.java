package de.hdm.ITProjekt17.server.db;

import java.util.Vector;

import de.hdm.ITProjekt17.shared.bo.Ähnlichkeitsmaß;

import java.sql.*;

public class ÄhnlichkeitsmaßMapper {
	
	/**
	 * Erstellen eines "Singletons" der Klasse ÄhnlichkeitsmaßMapper
	 */
	private static ÄhnlichkeitsmaßMapper ähnlichkeitsmaßMapper = null;
	/*
	 * Geschützter Konstruktor
	 */
	protected ÄhnlichkeitsmaßMapper(){
	}
	
	public static ÄhnlichkeitsmaßMapper ähnlichkeitsmaßMapper(){
		if (ähnlichkeitsmaßMapper == null){
			ähnlichkeitsmaßMapper = new ÄhnlichkeitsmaßMapper();
		}
		
		return ähnlichkeitsmaßMapper;
	}
	
	public Vector<Ähnlichkeitsmaß> getAll(){
		Connection con = DBConnection.connection();
		Vector<Ähnlichkeitsmaß> result = new Vector<Ähnlichkeitsmaß>();
		return result;
		
		
		
	}
	
}
