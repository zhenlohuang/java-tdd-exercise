package com.odde.tdd;

import org.junit.Test;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BudgetSystemTest {

    @Test
    public void testGetBudgetWithinOneMonth() {
        BudgetRepo mockBudgetRepo = mock(BudgetRepo.class);
        when(mockBudgetRepo.findAll()).thenReturn(Arrays.asList(new Budget(YearMonth.of(2018, 11), 1000)));

        BudgetSystem budgetSystem = new BudgetSystem(mockBudgetRepo);
        assertEquals(500, budgetSystem.getBudget(
                LocalDate.of(2018, 11, 1),
                LocalDate.of(2018, 11, 15)));
    }

    @Test
    public void testGetBudgetAcrossMultipleMonths() {
        BudgetRepo mockBudgetRepo = mock(BudgetRepo.class);
        when(mockBudgetRepo.findAll()).thenReturn(Arrays.asList(
                new Budget(YearMonth.of(2018, 7), 31),
                new Budget(YearMonth.of(2018, 8), 310),
                new Budget(YearMonth.of(2018, 9), 3000),
                new Budget(YearMonth.of(2018, 10), 310)
        ));

        BudgetSystem budgetSystem = new BudgetSystem(mockBudgetRepo);
        assertEquals(3426, budgetSystem.getBudget(
                LocalDate.of(2018, 7, 15),
                LocalDate.of(2018, 10, 10)));
    }
}
