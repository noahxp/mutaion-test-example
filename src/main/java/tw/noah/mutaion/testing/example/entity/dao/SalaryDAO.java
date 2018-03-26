package tw.noah.mutaion.testing.example.entity.dao;

import java.util.Random;
import org.springframework.stereotype.Repository;
import tw.noah.mutaion.testing.example.entity.Salary;

@Repository
public class SalaryDAO {

	/**
	 * 模擬薪資數據
	 * @return 薪資
	 */
	public Salary getSalary(){
		Salary salary = new Salary();
		salary.setBaseSalary(new Random().nextInt(30_000 - 22_000 + 1) + 22_000);
		salary.setHealthInsurance(1_200);
		salary.setLoborInsurance(1_000);
		salary.setOvertimeHours(new Random().nextInt(50 - 2 + 1) + 2);
		salary.setOvertimePay(salary.getBaseSalary()/30/8*2);
		return salary;
	}

}
