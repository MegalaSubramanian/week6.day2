	package runner;
	
	import io.cucumber.testng.CucumberOptions;
	import steps.Baseclass;
	
	@CucumberOptions(
			features = "src/test/java/features/LeafTaps.feature",
			glue = "steps",
			monochrome = true, 
			publish = true
			//tags = "@smoke" 	
			)
	
	public class LeafTapsRunner extends Baseclass{
	
	}
