package com.ME.pse;

import java.awt.Frame;

import javax.swing.JPanel;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import com.LANIT.EngChange.*;
import com.LANIT.reports.Specification.SpecificationCommand;
import com.LANIT.util.LUtil;
import com.teamcenter.rac.aif.AbstractAIFCommand;
import com.teamcenter.rac.aif.AbstractAIFOperation;
import com.teamcenter.rac.aif.AbstractAIFUIApplication;
import com.teamcenter.rac.aif.kernel.*;
import com.teamcenter.rac.aifrcp.AIFUtility;
import com.teamcenter.rac.kernel.TCComponentBOMLine;
import com.teamcenter.rac.kernel.TCSession;
import com.teamcenter.rac.pse.common.BOMTreeTable;
import com.teamcenter.rac.util.MessageBox;
import com.teamcenter.rac.util.Registry;
import com.teamcenter.rac.cme.mpp.*;



public class LDefaultHandlerBL extends AbstractHandler
{
  //Registry R = Registry.getRegistry("com.LANIT.action.action");

  static AbstractAIFUIApplication appl;
  //static NotificationApplicationPanel appPanel;
  final String sMB_Title="Спецификация vv";
  Frame parent = null;

  
  public Object execute(ExecutionEvent exeEvent)  throws ExecutionException
  {
	AbstractAIFUIApplication abstractAIFUIApp = AIFUtility.getCurrentApplication();
	
	appl = abstractAIFUIApp;
	parent = LUtil.digParentFrame();
    //appPanel = (NotificationApplicationPanel)appl.getApplicationPanel();
    AbstractAIFSession abstractaifsession = appl.getSession();
	
	//Get the paste targets from this application
	InterfaceAIFComponent[] c_targets = appl.getTargetComponents();
	InterfaceAIFComponent c_target = null;
	// check if any objects are selected
	if (c_targets.length > 0) c_target = c_targets[0];
	if (c_targets.length > 1 || !(c_target instanceof TCComponentBOMLine))
	{
	    MessageBox mb = new MessageBox(parent, "Нужно выбрать в РСИ строку головного изделия",
		sMB_Title, MessageBox.WARNING);
	    mb.setModal(true);
	    mb.setVisible(true);
	    return null;
	}
    // Get the command key
    //String commandKey = getCommandKey();

    String sCmdID = exeEvent.getCommand().getId();
    TCComponentBOMLine bom_line = (TCComponentBOMLine)c_target;

    try
    {
    	if (sCmdID.equals("MIL.PSE.specCmd56"))
    	{
    		MessageBox.post("1", "", MessageBox.INFORMATION);
          String s;

          int i, n;
          boolean bCancel = false;
          // construct the command
          //AbstractAIFCommand cmd = (AbstractAIFCommand)R.newInstanceForEx(commandKey,
          //    new Object[] {parent, bom_line}); //new Boolean(false)
          //AbstractAIFCommand cmd = new SpecificationCommand(parent, bom_line);
          AbstractAIFCommand cmd = new AddOperationCommand(parent, bom_line);
          // Execute the command
          cmd.executeModal();
        }

    }
    catch(Exception er)
    {
      System.out.println("Error in LDefaultHandlerBL");
      er.printStackTrace();
    }
	return null;
  }
}