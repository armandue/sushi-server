package com.cin.sushi.hibernate.column;

import java.io.IOException;
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

import com.cin.sushi.entity.column.Dish;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DishType implements UserType{
	
	private int[] types = {Types.ARRAY};
	private ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public int[] sqlTypes() {
		return types;
	}

	@Override
	public Class returnedClass() {
		return ArrayList.class;
	}

	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		return (x == y) ||
				((x != null) && (y != null) && (x.equals(y)));
	}

	@Override
	public int hashCode(Object x) throws HibernateException {
		return x.hashCode();
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner)
			throws HibernateException, SQLException {
		if (rs.wasNull()) return null;
		String[] array = (String[]) rs.getArray(names[0]).getArray();
		List<Dish> dishes = new ArrayList<>();
		for (String dishInJson : array) {
			try {
				Dish dish = mapper.readValue(dishInJson, Dish.class);
				dishes.add(dish);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return dishes;
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session)
			throws HibernateException, SQLException {
		if (value == null) {
			st.setNull(index, types[0]);
		} else {
			ArrayList<String> dishesInJson = new ArrayList<String>();
			
			@SuppressWarnings("unchecked")
			ArrayList<Dish> list = (ArrayList<Dish>) value;
			
			for (Dish dish : list) {
				try {
					dishesInJson.add(mapper.writeValueAsString(dish));
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
			}
			
			Array sqlArray = session.connection().createArrayOf("text", dishesInJson.toArray());
			st.setArray(index, sqlArray);
		}
		
	}

	@Override
	public Object deepCopy(Object value) throws HibernateException {
		if (value == null) return null;
		return value;
	}

	@Override
	public boolean isMutable() {
		return true;
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		return (Serializable) value;
	}

	@Override
	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		return cached;
	}

	@Override
	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		return original;
	}

}
