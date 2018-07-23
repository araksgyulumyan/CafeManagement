package com.cafe.business.core.service.table.exception;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 2:10 PM
 */
public class TableNotExistsForTableNumberException extends RuntimeException {

    private static final long serialVersionUID = 8958561668906247523L;

    // Properties
    private Integer tableNumber;

    public TableNotExistsForTableNumberException(Integer tableNumber) {
        super(String.format("Table with number %d not exists", tableNumber));
        this.tableNumber = tableNumber;
    }

    // Getters
    public Integer getTableNumber() {
        return tableNumber;
    }
}
