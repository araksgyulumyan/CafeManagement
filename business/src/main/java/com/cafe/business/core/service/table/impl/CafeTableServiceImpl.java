package com.cafe.business.core.service.table.impl;

import com.cafe.business.core.entity.table.CafeTable;
import com.cafe.business.core.entity.user.User;
import com.cafe.business.core.repository.table.CafeTableRepository;
import com.cafe.business.core.service.table.CafeTableService;
import com.cafe.business.core.service.table.exception.TableAlreadyAssignedException;
import com.cafe.business.core.service.table.exception.TableAlreadyExistsForTableNumberException;
import com.cafe.business.core.service.table.exception.TableCannotBeAssignedException;
import com.cafe.business.core.service.table.exception.TableNotExistsForTableNumberException;
import com.cafe.business.core.service.user.UserService;
import com.cafe.business.core.service.user.common.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 2:08 PM
 */

@Service
public class CafeTableServiceImpl implements CafeTableService {

    @Autowired
    private CafeTableRepository cafeTableRepository;

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public CafeTable createTable(final Integer tableNumber) {
        assertTableNumber(tableNumber);
        checkIfTableNumberIsUnique(tableNumber);
        CafeTable table = new CafeTable();
        table.setNumber(tableNumber);
        table = cafeTableRepository.save(table);
        return table;
    }

    @Override
    @Transactional
    public CafeTable assignTableToUser(final Long userId, Integer tableNumber) {
        assertUserId(userId);
        assertTableNumber(tableNumber);
        User user = userService.getUserById(userId);
        checkIfTableCanBeAssignedToUser(tableNumber, userId, user.getUserRole());
        CafeTable table = getTableByNumber(tableNumber);
        checkIfTableIsAlreadyAssignedToUser(tableNumber, table);
        table.setUser(user);
        table = cafeTableRepository.save(table);
        return table;
    }

    @Override
    @Transactional
    public void unassignTableFromUser(final Integer tableNumber) {
        assertTableNumber(tableNumber);
        CafeTable table = getTableByNumber(tableNumber);
        table.setUser(null);
        cafeTableRepository.save(table);
    }

    @Override
    public CafeTable getTableByNumber(final Integer tableNumber) {
        assertTableNumber(tableNumber);
        CafeTable cafeTable = cafeTableRepository.findByNumber(tableNumber);
        assertTableNotNullForTableNumber(tableNumber, cafeTable);
        return cafeTable;
    }

    @Override
    public List<CafeTable> getAllTables() {
        return cafeTableRepository.findAll();
    }

    // Utility methods
    private void assertTableNotNullForTableNumber(final Integer tableNumber, final CafeTable cafeTable) {
        if (cafeTable == null) {
            throw new TableNotExistsForTableNumberException(tableNumber);
        }
    }

    private void checkIfTableCanBeAssignedToUser(final Integer tableNumber, final Long userId, final UserRole userRole) {
        if (UserRole.MANAGER.equals(userRole)) {
            throw new TableCannotBeAssignedException(tableNumber, userId);
        }
    }

    private static void checkIfTableIsAlreadyAssignedToUser(final Integer tableNumber, final CafeTable cafeTable) {
        if (Objects.nonNull(cafeTable.getUser())) {
            throw new TableAlreadyAssignedException(tableNumber);
        }
    }

    private static void assertTableNumber(final Integer tableNumber) {
        Assert.notNull(tableNumber, "Table number should not be null");
    }

    private void checkIfTableNumberIsUnique(final Integer tableNumber) {
        CafeTable cafeTable = cafeTableRepository.findByNumber(tableNumber);
        if (Objects.nonNull(cafeTable)) {
            throw new TableAlreadyExistsForTableNumberException(tableNumber);
        }
    }

    private static void assertUserId(final Long userId) {
        Assert.notNull(userId, "User id should not be null");
    }
}
