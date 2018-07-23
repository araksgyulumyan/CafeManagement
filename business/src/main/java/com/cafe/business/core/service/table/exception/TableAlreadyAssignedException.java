package com.cafe.business.core.service.table.exception;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 2:11 PM
 */
public class TableAlreadyAssignedException extends RuntimeException {

    private static final long serialVersionUID = -860312704097038100L;

    // Properties
    private Integer tableNumber;

    public TableAlreadyAssignedException(final Integer tableNumber) {
        super(String.format("Table with number %d cannot already assigned", tableNumber));
        this.tableNumber = tableNumber;
    }

    // Getters
    public Integer getTableNumber() {
        return tableNumber;
    }
}
