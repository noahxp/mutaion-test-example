package tw.noah.mutaion.test.example;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import tw.noah.mutaion.test.example.entity.Salary;
import tw.noah.mutaion.test.example.service.MathServivce;
import tw.noah.mutaion.test.example.service.SalaryService;

@Controller
@Log4j2
public class MainApp {

	@Autowired
	private SalaryService salaryService;

	@Autowired
	private MathServivce mathServivce;


	public void salaryExample(){
		Salary salary = salaryService.getSalary();
		salary = salaryService.calcSalary(salary);

		log.info("Base salary is : " + salary.getBaseSalary());
		log.info("Overtime hours is : " + salary.getOvertimeHours());
		log.info("Lobor Insurance : " + salary.getLoborInsurance());
		log.info("Health Insurance : " + salary.getHealthInsurance());
		log.info("Result salary is :" + salary.getSalary());
	}

	public void mathExample(){
		long add = mathServivce.add(1,1);
		log.info("1+1=" + add);
	}

	public void run(){
		salaryExample();
		mathExample();
	}
}
