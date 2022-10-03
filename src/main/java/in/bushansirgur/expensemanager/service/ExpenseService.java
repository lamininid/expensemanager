package in.bushansirgur.expensemanager.service;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;
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
	public ExpenseDTO saveExpenseDetails(ExpenseDTO expenseDTO) throws ParseException {
		//map DTO to entity
		Expense expense= mapToEntity(expenseDTO);
		//save entity to db
		expense = expenseRepository.save(expense);
		//map entity to DTO.return
		return mapToDTO(expense);
	}

	private Expense mapToEntity(ExpenseDTO expenseDTO) throws ParseException {
		//map DTO to entity
		Expense expense = modelMapper.map(expenseDTO,Expense.class);
		//TODO:create entity ID
		expense.setExpenseId(UUID.randomUUID().toString());
		//TODO:create entity date
		expense.setDate(DateTimeUtil.convertStringToDate(expenseDTO.getDateString()));
		return expense;
	}
}





















