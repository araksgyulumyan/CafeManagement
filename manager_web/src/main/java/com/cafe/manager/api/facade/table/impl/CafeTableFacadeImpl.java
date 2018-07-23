package com.cafe.manager.api.facade.table.impl;

import com.cafe.business.core.entity.table.CafeTable;
import com.cafe.business.core.service.table.CafeTableService;
import com.cafe.business.core.service.table.exception.TableAlreadyExistsForTableNumberException;
import com.cafe.manager.api.facade.table.CafeTableFacade;
import com.cafe.manager.api.model.common.response.error.ErrorType;
import com.cafe.manager.api.model.request.table.CafeTableCreationRequestModel;
import com.cafe.manager.api.model.response.table.CafeTableResponseModel;
import com.cafe.manager.api.validation.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 6:20 PM
 */

@Facade
@Component
public class CafeTableFacadeImpl implements CafeTableFacade {

    @Autowired
    private CafeTableService cafeTableService;

    @Override
    public CafeTableResponseModel create(final CafeTableCreationRequestModel cafeTableCreationRequestModel) {
        assertCafeTableCreationRequestModel(cafeTableCreationRequestModel);
        try {
            final CafeTable cafeTable = cafeTableService.createTable(cafeTableCreationRequestModel.getTableNumber());
            return CafeTableResponseModel.fromTable(cafeTable);
        } catch (final TableAlreadyExistsForTableNumberException ex) {
            final List<ErrorType> errors = new ArrayList<>();
            errors.add(ErrorType.TABLE_NUMBER_ALREADY_EXISTS);
            return CafeTableResponseModel.withErrors(errors);
        }
    }

    @Override
    public CafeTableResponseModel getByTableNumber(final Integer tableNumber) {
        assertTableNumber(tableNumber);
        final CafeTable cafeTable = cafeTableService.getTableByNumber(tableNumber);
        return CafeTableResponseModel.fromTable(cafeTable);
    }

    @Override
    public List<CafeTableResponseModel> getTables() {
        final List<CafeTable> tables = cafeTableService.getAllTables();
        final List<CafeTableResponseModel> models = new ArrayList<>(tables.size());
        for (final CafeTable cafeTable : tables) {
            models.add(CafeTableResponseModel.fromTable(cafeTable));
        }
        return models;
    }

    // Utility methods
    private static void assertCafeTableCreationRequestModel(final CafeTableCreationRequestModel cafeTableCreationRequestModel) {
        Assert.notNull(cafeTableCreationRequestModel, "Cafe table creation request model should not be null");
        Assert.notNull(cafeTableCreationRequestModel.getTableNumber(), "Cafe table creation request model table number should not be null");
    }

    private static void assertTableNumber(final Integer tableNumber) {
        Assert.notNull(tableNumber, "Cafe table number should not be null");
    }
}
