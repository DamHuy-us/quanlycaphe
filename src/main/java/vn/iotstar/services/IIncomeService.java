package vn.iotstar.services;

import java.util.List;

import vn.iotstar.entity.Branch;

public interface IIncomeService {
    Double sumIncomeValue();
    List<Object[]> findMonthlyIncome(int year);
    List<Object[]> findTotalIncomeByBranch();
	List<Branch> getTop4BranchesByTotalValue();

}
