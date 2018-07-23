package com.cafe.business.core.repository.table;

import com.cafe.business.core.entity.table.CafeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 12:49 PM
 */
@Repository
public interface CafeTableRepository extends JpaRepository<CafeTable, Long> {

    /**
     * Finds table with provided userId
     *
     * @param userId
     * @return CafeTable
     */
    CafeTable findByUser(final Long userId);

    /**
     * Finds unassigned table with provided table number
     *
     * @param tableNumber
     * @return unassigned table
     */
    CafeTable findByNumberAndUserIsNull(final Integer tableNumber);

    /**
     * Finds table with provided table number
     *
     * @param tableNumber
     * @return CafeTable
     */
    CafeTable findByNumber(final Integer tableNumber);

}
