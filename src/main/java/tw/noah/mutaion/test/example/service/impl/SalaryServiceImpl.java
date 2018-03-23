package tw.noah.mutaion.test.example.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.noah.mutaion.test.example.entity.Salary;
import tw.noah.mutaion.test.example.entity.dao.SalaryDAO;
import tw.noah.mutaion.test.example.service.SalaryService;

@Log4j2
@Service
public class SalaryServiceImpl implements SalaryService {

	@Autowired
	private SalaryDAO salaryDAO;

	@Override
	public Salary getSalary() {
		return salaryDAO.getSalary();
	}


	@Override
	public Salary calcSalary(Salary salary) {

		if (salary==null){
			return null;
		}

		if(salary.getBaseSalary()<=0){
			salary.setSalary(0);
		}else {
			int s = salary.getBaseSalary() + salary.getOvertimeHours() * salary.getOvertimePay();
			s = s - salary.getLoborInsurance() - salary.getHealthInsurance();
			salary.setSalary(s);
		}

		return salary;
	}




}
