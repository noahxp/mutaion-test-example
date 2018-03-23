package tw.noah.mutaion.test.example.service.test;

import lombok.extern.log4j.Log4j2;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tw.noah.mutaion.test.example.service.MathServivce;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class MathServiceTest {

	@Autowired
	private MathServivce mathServivce;

	@Test
	public void testAdd(){

		int left = 100;
		int right = 0;
		long add = mathServivce.add(left,right);

		assertEquals(add,left+right);
//		assertNotEquals(add,left);
	}

}
