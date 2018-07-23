package com.cafe.business.core.service.table.exception;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 2:11 PM
 */
public class TableAlreadyExistsForTableNumberException extends RuntimeException {

    private static final long serialVersionUID = -3328418741785542809L;

    // Properties
    private Integer tableNumber;

    public TableAlreadyExistsForTableNumberException(final Integer tableNumber) {
        super(String.format("Table with number %d already exists", tableNumber));
        this.tableNumber = tableNumber;
    }

    // Getters
    public Integer getTableNumber() {
        return tableNumber;
    }
}
