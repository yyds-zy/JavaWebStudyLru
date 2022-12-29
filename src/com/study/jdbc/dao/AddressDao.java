package com.study.jdbc.dao;

import com.study.jdbc.entity.Address;

import java.sql.Connection;
import java.util.List;

public interface AddressDao {

    void insert(Connection conn, Address address);

    void update(Connection conn, Long id, Address address);

    void delete(Connection conn, Address address);

    List<Address> query(Connection conn);
}
