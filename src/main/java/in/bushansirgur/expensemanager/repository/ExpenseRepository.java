package in.bushansirgur.expensemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.bushansirgur.expensemanager.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
