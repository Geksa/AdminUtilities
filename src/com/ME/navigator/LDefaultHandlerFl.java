package com.ME.navigator;

import java.awt.Frame;

import javax.swing.JPanel;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import com.LANIT.EngChange.*;
import com.LANIT.regbook.CrMat_Command;
import com.LANIT.reports.Specification.SpecificationCommand;
import com.LANIT.util.LUtil;
import com.teamcenter.rac.aif.AbstractAIFCommand;
import com.teamcenter.rac.aif.AbstractAIFOperation;
import com.teamcenter.rac.aif.AbstractAIFUIApplication;
import com.teamcenter.rac.aif.kernel.*;
import com.teamcenter.rac.aifrcp.AIFUtility;
import com.teamcenter.rac.kernel.TCComponentBOMLine;
import com.teamcenter.rac.kernel.TCComponentFolder;
import com.teamcenter.rac.util.MessageBox;
import com.teamcenter.rac.util.Registry;

public class LDefaultHandlerFl extends AbstractHandler
{
  //Registry R = Registry.getRegistry("com.LANIT.action.action");

  static AbstractAIFUIApplication appl;
  //static NotificationApplicationPanel appPanel;
  final String sMB_Title="Выбор объекта";
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
	if (c_targets.length > 1 || !(c_target instanceof TCComponentFolder))
	{
	    MessageBox mb = new MessageBox(parent, "Нужно выбрать 1 папку!",
		sMB_Title, MessageBox.WARNING);
	    mb.setModal(true);
	    mb.setVisible(true);
	    return null;
	}
    // Get the command key
    //String commandKey = getCommandKey();

    String sCmdID = exeEvent.getCommand().getId();
	
	if (sCmdID.equals("LANIT.EXPL.CrMatCmd"))
	{
      try
      {
        String s;
		TCComponentFolder folder = (TCComponentFolder) c_target;
		/*
		 * s = bom_line.getProperty("bl_item_object_type"); MessageBox
		 * mb = new MessageBox(parent, "Тип Item-a = "+s, sMB_Title,
		 * MessageBox.INFORMATION); mb.setModal(true); mb.show();
		 */
		int i, n;
		boolean bCancel = false;
		// construct the command
		// AbstractAIFCommand cmd =
		// (AbstractAIFCommand)R.newInstanceForEx(commandKey,
		// new Object[] {parent, bom_line}); //new Boolean(false)
		AbstractAIFCommand cmd = new CrMat_Command(parent, folder);
		// Execute the command
		cmd.executeModeless(); // при модальной команде модальный диалог завешивает всё
      }
      catch(Exception er)
      {
         er.printStackTrace();
      }
	}
	return null;
  }
}