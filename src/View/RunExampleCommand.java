package View;

import Controller.Controller;

public class RunExampleCommand extends Command{
	
	Controller ctrl;
	
	public RunExampleCommand(String key, String desc, Controller ctrl)
	{
		super(key, desc);
		this.ctrl = ctrl;
		description = this.ctrl.getState().getStack().toString();
	}
	
	public void execute()
	{
		try{
			ctrl.allSteps();
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
	}
}