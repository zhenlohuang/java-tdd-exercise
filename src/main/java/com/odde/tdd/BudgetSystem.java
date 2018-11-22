package com.odde.tdd;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;

public class BudgetSystem {
    private BudgetRepo budgetRepo = null;
    private Map<YearMonth, Budget> budgetMap = new HashMap<>();

    public BudgetSystem(BudgetRepo budgetRepo) {
        this.budgetRepo = budgetRepo;
        for(Budget budget: this.budgetRepo.findAll()) {
            budgetMap.put(budget.getMonth(), budget);
        }
    }

    public long getBudget(LocalDate startDate, LocalDate endDate) {
        long totalBudget = 0;

        if(YearMonth.from(startDate).equals(YearMonth.from(endDate))) {
            totalBudget += budgetMap.get(YearMonth.from(startDate)).getBudgetInDay() * (endDate.getDayOfMonth() - startDate.getDayOfMonth() + 1);
        } else {
            for(LocalDate date = startDate; YearMonth.from(date).compareTo(YearMonth.from(endDate)) < 0; date = date.plusMonths(1)) {
                if(date.equals(startDate) && date.getDayOfMonth() > 1) {
                    totalBudget += (long)(budgetMap.get(YearMonth.from(date)).getBudgetInDay() * (startDate.lengthOfMonth() - startDate.getDayOfMonth()));
                } else {
                    totalBudget += budgetMap.get(YearMonth.from(date)).getAmount();
                }
            }

            totalBudget += (long)(budgetMap.get(YearMonth.from(endDate)).getBudgetInDay() * endDate.getDayOfMonth());
        }

        return  totalBudget;
    }
}
