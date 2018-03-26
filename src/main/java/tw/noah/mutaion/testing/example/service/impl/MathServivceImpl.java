package tw.noah.mutaion.testing.example.service.impl;


import org.springframework.stereotype.Service;
import tw.noah.mutaion.testing.example.service.MathServivce;

@Service
public class MathServivceImpl implements MathServivce {

	@Override
	public long add(int x, int y) {
		long ret = x - y;
		return ret;
	}
}
