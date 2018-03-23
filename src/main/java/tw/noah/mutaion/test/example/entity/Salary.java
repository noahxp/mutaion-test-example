package tw.noah.mutaion.test.example.entity;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Data
public class Salary {

	/**
	 * 底薪
	 */
	private int baseSalary;
	/**
	 * 加班時數
	 */
	private int overtimeHours;
	/**
	 * 健保費
	 */
	private int healthInsurance;

	/**
	 * 勞保費
	 */
	private int loborInsurance;
	/**
	 * 加班每小時薪資
	 */
	private int overtimePay;
	/**
	 * 計算後薪水
	 */
	private int salary;

}


