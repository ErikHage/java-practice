package concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {

	@Pointcut("execution(** concert.Performance.perform(..))")
	public void performance() {}
	
//	@Before("performance()")
//	public void silenceCellPhones() {
//		System.out.println("Please silence your cell phones");
//	}
//	
//	@Before("performance()")
//	public void takeSeats() {
//		System.out.println("Please take your seats");
//	}
//	
//	@AfterReturning("performance()")
//	public void applause() {
//		System.out.println("The audience is applauding");
//	}
//	
//	@AfterThrowing("performance()")
//	public void demandRefund() {
//		System.out.println("The audience are demanding refunds!!!");
//	}
	
	@Around("performance()")
	public void watchPerformance(ProceedingJoinPoint jp) {
		try {
			System.out.println("Please silence your cell phones");
			System.out.println("Please take your seats");
			jp.proceed();
			System.out.println("The audience is applauding");
		} catch(Throwable e) {
			System.out.println("The audience are demanding refunds!!!");
		}
	}
	
}
