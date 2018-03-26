package tw.noah.mutaion.testing.example.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tw.noah.mutaion.testing.example.entity.Salary;
import tw.noah.mutaion.testing.example.service.SalaryService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class SalaryServiceTest {

	@Autowired
	private SalaryService salaryService;

	@Test
	public void testGetSalary(){
		log.info("test getSalary...");
		salaryService.getSalary();
	}


	@Test
	public void testCalcSalary(){
		log.info("test calcSalary...");

		log.info("test null data...");
		assertEquals(null,salaryService.calcSalary(null));

		log.info("main test...");

		log.info("一般性驗證");
		Salary salary = salaryService.getSalary();
		salary = salaryService.calcSalary(salary);
		assertEquals(1_000,salary.getLoborInsurance());
		assertEquals(1_200,salary.getHealthInsurance());

		// 驗證薪資計算
		log.info("驗證薪資計算");
		int trialSalary = salary.getBaseSalary()-salary.getLoborInsurance()-salary.getHealthInsurance()+salary.getOvertimeHours()*salary.getOvertimePay();
		assertEquals(trialSalary ,salary.getSalary());
		assertTrue(salary.getSalary()>0);

		// < 0 驗證
		log.info("< 0 驗證");
		salary = salaryService.getSalary();
		salary.setBaseSalary(-1);
		salary = salaryService.calcSalary(salary);
		assertTrue(salary.getSalary()>=0);
	}
}
