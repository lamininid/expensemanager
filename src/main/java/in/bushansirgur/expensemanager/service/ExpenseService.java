package in.bushansirgur.expensemanager.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import in.bushansirgur.expensemanager.dto.ExpenseDTO;
import in.bushansirgur.expensemanager.entity.Expense;
import in.bushansirgur.expensemanager.repository.ExpenseRepository;
import in.bushansirgur.expensemanager.util.DateTimeUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseService {
	
	private final ExpenseRepository expenseRepository;
	private final ModelMapper modelMapper;
	
	public List<ExpenseDTO> getAllExpenses() {
		List<Expense> list = expenseRepository.findAll();
		List<ExpenseDTO> expenseList = list.stream().map(this::mapToDTO).collect(Collectors.toList());
		return expenseList;
	}
	
	private ExpenseDTO mapToDTO(Expense expense) {
		ExpenseDTO expenseDTO = modelMapper.map(expense, ExpenseDTO.class);
		expenseDTO.setDateString(DateTimeUtil.convertDateToString(expenseDTO.getDate()));
		return expenseDTO;
	}
}





















