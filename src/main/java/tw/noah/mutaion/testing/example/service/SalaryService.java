package tw.noah.mutaion.testing.example.service;

import tw.noah.mutaion.testing.example.entity.Salary;

public interface SalaryService {

	/**
	 * 薪資料算
	 * @param salary 不含薪資淨額的資料
	 * @return 含薪資淨額的資料
	 */
	public Salary calcSalary(Salary salary);

	/**
	 * 取得薪資
	 * @return
	 */
	public Salary getSalary();

}
