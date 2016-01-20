package com.ME.navigator;

import java.awt.Frame;

import javax.swing.JPanel;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import com.teamcenter.rac.aif.AbstractAIFCommand;
import com.teamcenter.rac.aif.AbstractAIFOperation;
import com.teamcenter.rac.aif.AbstractAIFUIApplication;
import com.teamcenter.rac.aif.kernel.*;
import com.teamcenter.rac.aifrcp.AIFUtility;
import com.teamcenter.rac.kernel.TCComponentBOMLine;
import com.teamcenter.rac.kernel.TCComponentFolder;
import com.teamcenter.rac.util.MessageBox;
import com.teamcenter.rac.util.Registry;

public class SampleHandler extends AbstractHandler
{
  static AbstractAIFUIApplication appl;
  final String sMB_Title="Выбор объекта";
  Frame parent = null;
  
  public Object execute(ExecutionEvent exeEvent)  throws ExecutionException
  {
	AbstractAIFUIApplication abstractAIFUIApp = AIFUtility.getCurrentApplication();
	
	appl = abstractAIFUIApp;
    AbstractAIFSession abstractaifsession = appl.getSession();

	InterfaceAIFComponent[] c_targets = appl.getTargetComponents();
	InterfaceAIFComponent c_target = null;
	if (c_targets.length > 0) c_target = c_targets[0];
	if (c_targets.length > 1 || !(c_target instanceof TCComponentFolder))
	{
	    MessageBox mb = new MessageBox(parent, "Нужно выбрать папку",
		sMB_Title, MessageBox.WARNING);
	    mb.setModal(true);
	    mb.setVisible(true);
	    return null;
	}

    String sCmdID = exeEvent.getCommand().getId();
	
	if (sCmdID.equals("MIL.EXPL.CrMatCmd"))
	{
      try
      {
        String s;
		TCComponentFolder folder = (TCComponentFolder) c_target;

		int i, n;
		boolean bCancel = false;

      }
      catch(Exception er)
      {
         er.printStackTrace();
      }
	}
	return null;
  }
}