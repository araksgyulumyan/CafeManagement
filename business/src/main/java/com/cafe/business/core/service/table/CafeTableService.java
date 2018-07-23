package com.cafe.business.core.service.table;

import com.cafe.business.core.entity.table.CafeTable;

import java.util.List;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 2:08 PM
 */
public interface CafeTableService {

    /**
     * Creates table
     *
     * @param tableNumber
     * @return create table
     */
    CafeTable createTable(final Integer tableNumber);

    /**
     * Assigns only one waiter to only one table
     *
     * @param userId
     * @param tableNumber
     * @return Table
     */
    CafeTable assignTableToUser(final Long userId, final Integer tableNumber);

    /**
     * Unassign table from user
     *
     * @param tableNumber
     */
    void unassignTableFromUser(final Integer tableNumber);

    /**
     * Get table by provided number
     *
     * @param tableNumber
     * @return
     */
    CafeTable getTableByNumber(final Integer tableNumber);

    /**
     * Get all tables
     *
     * @return list of all tables
     */
    List<CafeTable> getAllTables();

}
