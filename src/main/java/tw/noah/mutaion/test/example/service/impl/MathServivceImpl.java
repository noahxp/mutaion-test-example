package tw.noah.mutaion.test.example.service.impl;


import org.springframework.stereotype.Service;
import tw.noah.mutaion.test.example.service.MathServivce;

@Service
public class MathServivceImpl implements MathServivce {

	@Override
	public long add(int x, int y) {
//		long ret = x + y;
		return (long)x + y;
	}
}
