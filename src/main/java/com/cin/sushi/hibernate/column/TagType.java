package com.cin.sushi.hibernate.column;

import java.io.Serializable;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import com.cin.sushi.enums.Tag;

public class TagType implements UserType{
	
	private int[] types = {Types.ARRAY};
	
	@Override
	public Object assemble(Serializable arg0, Object arg1) throws HibernateException {
		return arg0;
	}

	@Override
	public Object deepCopy(Object arg0) throws HibernateException {
		if (arg0 == null) return null;
		return arg0;
	}

	@Override
	public Serializable disassemble(Object arg0) throws HibernateException {
		return (Serializable) arg0;
	}

	@Override
	public boolean equals(Object arg0, Object arg1) throws HibernateException {
		return (arg0 == arg1) ||
				((arg0 != null) && (arg1 != null) && (arg0.equals(arg1)));
	}

	@Override
	public int hashCode(Object arg0) throws HibernateException {
		return arg0.hashCode();
	}

	@Override
	public boolean isMutable() {
		return true;
	}

	@Override
	public Object nullSafeGet(ResultSet arg0, String[] arg1, SharedSessionContractImplementor arg2, Object arg3)
			throws HibernateException, SQLException {
		if (arg0.wasNull()) {
			return null;
		}
		String[] array = (String[]) arg0.getArray(arg1[0]).getArray();
		List<Tag> tags = new ArrayList<>();
		for(String el : array) {
			tags.add(Tag.valueOf(el));
		}
		return tags;
	}

	@Override
	public void nullSafeSet(PreparedStatement arg0, Object arg1, int arg2, SharedSessionContractImplementor arg3)
			throws HibernateException, SQLException {
		if (arg1 == null) {
			arg0.setNull(arg2, types[0]);
		} else {
			ArrayList arrayList = (ArrayList) arg1;
			Array sqlArray = arg3.connection().createArrayOf("text", arrayList.toArray());
			arg0.setArray(arg2, sqlArray);
		}
	}

	@Override
	public Object replace(Object arg0, Object arg1, Object arg2) throws HibernateException {
		return arg0;
	}

	@Override
	public Class returnedClass() {
		return ArrayList.class;
	}

	@Override
	public int[] sqlTypes() {
		return types;
	}

}
