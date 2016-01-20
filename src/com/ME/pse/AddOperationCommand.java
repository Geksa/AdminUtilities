package com.ME.pse;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import com.LANIT.util.LUtil;
import com.LANIT.extmaterial.*;

//import com.MIL.extmaterial.IMBASE_Util;
import com.borland.dx.sql.dataset.Database;
import com.borland.dx.sql.dataset.QueryDataSet;
import com.teamcenter.rac.aif.*;
import com.teamcenter.rac.aif.kernel.*;
import com.teamcenter.rac.kernel.*;
import com.teamcenter.rac.util.*;

// Используем эту команду теперь для генерации отчёта, чтобы не писать новую

public class AddOperationCommand
    extends AbstractAIFCommand {
  TCSession session = null;
  QueryDataSet qMat = new QueryDataSet();
  QueryDataSet qInner = new QueryDataSet();
  IMBASE_Util IMB;

  protected Object objs[];

  class ExecSpecOperation
      extends AbstractAIFOperation {
    public void executeOperation() throws Exception {
      try {
    	
    
    	 
      }
      catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }

  public AddOperationCommand(Frame parent, TCComponentBOMLine bom_line) {
	  Registry R = Registry.getRegistry("com.LANIT.extmaterial.extmaterial");
	  new SelectOperation();


  }

  public AddOperationCommand(Frame parent, TCSession theSession) throws
      Exception {
    MessageBox.post("Выберите верхнюю линию головного изделия", "Teamcenter",
                    MessageBox.ERROR);
  }



}
