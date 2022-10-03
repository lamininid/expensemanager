package in.bushansirgur.expensemanager.controller;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import in.bushansirgur.expensemanager.dto.ExpenseDTO;
import in.bushansirgur.expensemanager.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ExpenseController {
	
	private final ExpenseService expenseService;
	
	@GetMapping("/expenses")
	public String showExpenseList(Model model) {
		model.addAttribute("expenses", expenseService.getAllExpenses());
		return "expenses-list";
	}
	@GetMapping("/createExpense")
	public String showExpenseForm(Model model){
		model.addAttribute("expense",new ExpenseDTO());
		return "expense-form";
	}
	@PostMapping("/saveOrUpdateExpense")
	public String showOrUpdateExpenseDetails(@ModelAttribute("expense") ExpenseDTO expenseDTO){
		System.out.println("Printing ExpenseDTO"+expenseDTO);
		return "redirect:/expenses";
	}

}






















