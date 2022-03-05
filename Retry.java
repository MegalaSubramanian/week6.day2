package week6.assignment;

	import java.lang.reflect.Constructor;
	import java.lang.reflect.Method;

	import org.testng.IAnnotationTransformer;
	import org.testng.IRetryAnalyzer;
	import org.testng.ITestResult;
	import org.testng.annotations.ITestAnnotation;
	import org.testng.internal.annotations.TestAnnotation;

	public class Retry implements IRetryAnalyzer{
		
		int count = 1;
		public boolean retry(ITestResult result) {
			if(count < 2) {
				count++;
			return true;	
			}
			return false;
			}
		 
		}

