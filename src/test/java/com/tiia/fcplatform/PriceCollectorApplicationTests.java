package com.tiia.fcplatform;

import com.tiia.fcplatform.exception.FcPlatformException;
import com.tiia.fcplatform.services.RevenueCalculationService;
import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PriceCollectorApplicationTests {

	@Test
	public void contextLoads() {
	}
}
