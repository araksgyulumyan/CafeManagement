package com.cafe.business.core.service.table.exception;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 2:10 PM
 */
public class TableCannotBeAssignedException extends RuntimeException {

    private static final long serialVersionUID = 4072038832044648322L;

    // Properties
    private Integer tableNumber;

    private Long userId;

    public TableCannotBeAssignedException(final Integer tableNumber, final Long userId) {
        super(String.format("Table with number %d cannot be assigned to user with id %d, because user's role is MANAGER", tableNumber, userId));
        this.tableNumber = tableNumber;
    }

    // Getters
    public Integer getTableNumber() {
        return tableNumber;
    }

    public Long getUserId() {
        return userId;
    }
}
