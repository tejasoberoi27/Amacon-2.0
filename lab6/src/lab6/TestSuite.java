package lab6;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import	org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import	org.junit.runners.Suite;	
@RunWith(Suite.class)	
@Suite.SuiteClasses({	
	Test1.class,
	Test2.class,
	Test3.class,
	Test4.class,
	Test5.class,
	Test6.class,
	Test7.class
	
})	
public	class	TestSuite	{	
	public	static	void	main(String[]	args)	{	
		Result	result=	JUnitCore.runClasses(TestSuite.class);	
		for	(Failure	failure	:	result.getFailures())	{	
			System.out.println(failure.toString());	
		}
		System.out.println(result.wasSuccessful());	
	}
}