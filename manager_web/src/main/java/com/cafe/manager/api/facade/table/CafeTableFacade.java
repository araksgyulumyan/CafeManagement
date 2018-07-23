package com.cafe.manager.api.facade.table;

import com.cafe.manager.api.model.request.table.CafeTableCreationRequestModel;
import com.cafe.manager.api.model.response.table.CafeTableResponseModel;

import java.util.List;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 6:20 PM
 */

public interface CafeTableFacade {

    CafeTableResponseModel create(final CafeTableCreationRequestModel cafeTableCreationRequestModel);

    CafeTableResponseModel getByTableNumber(final Integer tableNumber);

    List<CafeTableResponseModel> getTables();

}
