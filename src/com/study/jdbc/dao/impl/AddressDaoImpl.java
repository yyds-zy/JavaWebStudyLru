package com.study.jdbc.dao.impl;

import com.study.jdbc.dao.AddressDao;
import com.study.jdbc.entity.Address;

import java.sql.Connection;
import java.util.List;

public class AddressDaoImpl implements AddressDao {
    @Override
    public void insert(Connection conn, Address address) {

    }

    @Override
    public void update(Connection conn, Long id, Address address) {

    }

    @Override
    public void delete(Connection conn, Address address) {

    }

    @Override
    public List<Address> query(Connection conn) {
        return null;
    }
}
