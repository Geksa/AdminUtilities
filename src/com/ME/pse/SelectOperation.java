package com.ME.pse;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import com.LANIT.extmaterial.IMBASE_Util;
import com.borland.dbswing.JdbTable;
import com.borland.dbswing.TableScrollPane;
import com.borland.dx.dataset.Column;
import com.borland.dx.dataset.ParameterRow;
import com.borland.dx.sql.dataset.Database;
import com.borland.dx.sql.dataset.Load;
import com.borland.dx.sql.dataset.QueryDataSet;
import com.borland.dx.sql.dataset.QueryDescriptor;
import com.teamcenter.rac.util.MessageBox;
import com.teamcenter.rac.util.Registry;



/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class SelectOperation extends JFrame{
	String sqGroup, sqMat;
	  QueryDataSet qMat = new QueryDataSet();
	  QueryDataSet qGroup = new QueryDataSet();
	  DefaultMutableTreeNode nodeRoot = new DefaultMutableTreeNode( "Операции" );
	  JTree jTree = new JTree(nodeRoot);
	  JScrollPane spTree = new JScrollPane(jTree);
	  public Database dbOperations = new Database();
	  ParameterRow paramRow = new ParameterRow();
	  Registry R = Registry.getRegistry("com.LANIT.extmaterial.extmaterial");
	  Column FKey = new Column();
	  Column Level = new Column();
	  Column FGOST = new Column();
	  Column FMatName = new Column();
	  Column parTableName = new Column();
	  Column FPrim = new Column();
	  Column FInnerTable = new Column();
	  private JLabel jLabelKod;
	  private JButton jButtonCancel;
	  private JButton jButtonOK;
	  private JPanel jPanel2;
	  QueryDataSet qInner = new QueryDataSet();
	  private JLabel jLabelKodOp;
	  private JTextField jTextFieldKodProf;
	  private JTextField jTextFieldKdOp;
	  private JTextField jTextFieldKod;
	  private JLabel jLabelKodProf;
	  //TableScrollPane tspInner = new TableScrollPane();
	  //JdbTable dbtInner = new JdbTable();

	  private void initGUI() {
		try {
			{
				 nodeRoot.setUserObject(new OperGroupData( 0, 0, "Операции" ));
				 sqGroup = "SELECT * FROM TC_OPER WHERE F_MASK=0 or F_MASK is NULL ORDER BY F_NAME";
			      /*sqMat = "SELECT ctl.F8,ctl.F_KEY,ctl.F_LEVEL,ctl.F5,ctl.F7,ctl.F13, t.F_DESCR \"Описание\" " +
			          "FROM CTL000002_REC ctl, IM_TABLES t "+
			          "WHERE ctl.F8 = '+'  AND ctl.F13 = t.F_TABLE "+
			          "ORDER BY ctl.F5 ";*/
				 sqMat = "SELECT ctl.F_KEY,ctl.F_LEVEL,ctl.F1 FROM TC_OPER_REC ctl ORDER BY ctl.F_Level";
			      
				   
			      qMat.setReadOnly(true);
			      qMat.setEditable(false);
			      qMat.setEnableInsert(false);
			      qMat.setEnableUpdate(false);
			      qMat.setEnableDelete(false);
			      qMat.setQuery(new com.borland.dx.sql.dataset.QueryDescriptor(dbOperations, sqMat, null, true, Load.AS_NEEDED));

			      qGroup.setReadOnly(true);
			      qGroup.setEditable(false);
			      qGroup.setEnableInsert(false);
			      qGroup.setEnableUpdate(false);
			      qGroup.setEnableDelete(false);
			      qGroup.setQuery(new com.borland.dx.sql.dataset.QueryDescriptor(dbOperations, sqGroup, null, true, Load.ALL));   
			      
			      dbOperations.setConnection(IMBASE_Util.new_IMBASE_Connection(R));
			      qInner.setDisplayErrors(true);
			      qInner.setReadOnly(true);
			      qInner.setEditable(false);
			      qInner.setTableName("");
			      qInner.setEnableInsert(false);
			      qInner.setEnableUpdate(false);
			      qInner.setEnableDelete(false);
		
			      FKey.setColumnName("F_KEY");
			      FKey.setDataType(com.borland.dx.dataset.Variant.INT);
			      FKey.setPrecision(10);
			      FKey.setPreferredOrdinal(0);
			      FKey.setRowId(true);
			      FKey.setScale(0);
			      FKey.setVisible(com.borland.jb.util.TriStateProperty.FALSE);
			      FKey.setServerColumnName("F_KEY");
			      FKey.setSqlType(3);
			      Level.setColumnName("F_LEVEL");
			      Level.setDataType(com.borland.dx.dataset.Variant.INT);
			      Level.setPrecision(10);
			      Level.setPreferredOrdinal(1);
			      Level.setScale(0);
			      Level.setVisible(com.borland.jb.util.TriStateProperty.FALSE);
			      Level.setServerColumnName("F_LEVEL");
			      Level.setSqlType(3);
			      FGOST.setCaption("ГОСТ");
			      FGOST.setColumnName("F7");
			      FGOST.setCurrency(false);
			      FGOST.setDataType(com.borland.dx.dataset.Variant.STRING);
			      FGOST.setPrecision(64);
			      FGOST.setWidth(16);
			      FGOST.setPreferredOrdinal(4);
			      FGOST.setServerColumnName("F7");
			      FGOST.setSqlType(12);
			      FMatName.setCaption("Наименование");
			      FMatName.setColumnName("F5");
			      FMatName.setDataType(com.borland.dx.dataset.Variant.STRING);
			      FMatName.setPrecision(20);
			      FMatName.setWidth(12);
			      FMatName.setPreferredOrdinal(3);
			      FMatName.setServerColumnName("F5");
			      FMatName.setSqlType(12);
			      FPrim.setCaption("Прим.");
			      FPrim.setColumnName("F8");
			      FPrim.setDataType(com.borland.dx.dataset.Variant.STRING);
			      FPrim.setPreferredOrdinal(2);
			      FPrim.setWidth(6);
			      FPrim.setServerColumnName("F8");
			      FPrim.setSqlType(0);
			      FInnerTable.setCaption("Inner Table");
			      FInnerTable.setColumnName("F13");
			      FInnerTable.setDataType(com.borland.dx.dataset.Variant.STRING);
			      FInnerTable.setPreferredOrdinal(5);
			      FInnerTable.setVisible(com.borland.jb.util.TriStateProperty.FALSE);
			      FInnerTable.setServerColumnName("F13");
			      FInnerTable.setSqlType(0);
			      
			      //dbtInner.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			      //dbtInner.setDataSet(qInner);
			      
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1, BorderLayout.NORTH);
				jScrollPane1.setPreferredSize(new java.awt.Dimension(792, 515));
				jSplitPane1 = new JSplitPane();
				jSplitPane1.setDividerLocation(450);
				jScrollPane1.setViewportView(jSplitPane1);
				jSplitPane1.add(spTree, JSplitPane.LEFT);
				jPanel1 = new JPanel();
				GridBagLayout jPanel1Layout = new GridBagLayout();
				jPanel1Layout.rowWeights = new double[] {0.3, 0.1, 0.1, 0.1, 0.3};
				jPanel1Layout.rowHeights = new int[] {7, 7, 7, 7, 7};
				jPanel1Layout.columnWeights = new double[] {0.1, 0.0, 0.0, 0.1};
				jPanel1Layout.columnWidths = new int[] {7, 97, 100, 7};
				jPanel1.setLayout(jPanel1Layout);
				jSplitPane1.add(jPanel1, JSplitPane.RIGHT);
				{
					jLabelKod = new JLabel();
					jPanel1.add(jLabelKod, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabelKod.setText("\u041a\u043e\u0434");
				}
				{
					jLabelKodOp = new JLabel();
					jPanel1.add(jLabelKodOp, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabelKodOp.setText("\u041a\u043e\u0434 \u043e\u043f\u0435\u0440\u0430\u0446\u0438\u0438");
				}
				{
					jLabelKodProf = new JLabel();
					jPanel1.add(jLabelKodProf, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabelKodProf.setText("\u041a\u043e\u0434 \u043f\u0440\u043e\u0444\u0435\u0441\u0441\u0438\u0438");
				}
				{
					jTextFieldKod = new JTextField();
					jPanel1.add(jTextFieldKod, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				}
				{
					jTextFieldKdOp = new JTextField();
					jPanel1.add(jTextFieldKdOp, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				}
				{
					jTextFieldKodProf = new JTextField();
					jPanel1.add(jTextFieldKodProf, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				}
				//jPanel1.add(tspInner);	

			}
			{
				jPanel2 = new JPanel();
				GridBagLayout jPanel2Layout = new GridBagLayout();
				getContentPane().add(jPanel2, BorderLayout.CENTER);
				jPanel2.setPreferredSize(new java.awt.Dimension(792, 48));
				jPanel2Layout.rowWeights = new double[] {0.1, 0.1, 0.1};
				jPanel2Layout.rowHeights = new int[] {7, 7, 7};
				jPanel2Layout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1};
				jPanel2Layout.columnWidths = new int[] {7, 7, 7, 7};
				jPanel2.setLayout(jPanel2Layout);
				{
					jButtonOK = new JButton();
					jPanel2.add(jButtonOK, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 0, 0));
					jButtonOK.setText("OK");
					jButtonOK.setPreferredSize(new java.awt.Dimension(52, 21));
					jButtonOK.addActionListener(new ActionListener(){

						public void actionPerformed(ActionEvent arg0) {
						
							
						}
						
					});
				}
				{
					jButtonCancel = new JButton();
					jPanel2.add(jButtonCancel, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 0, 0), 0, 0));
					jButtonCancel.setText("\u041e\u0442\u043c\u0435\u043d\u0430");
				}
			}
			//qInner.setColumns(new Column[] {FKey});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	  
	  
	  // -- Сваязывает узлы по индексу, возвращает объект узла по индексу ID
	  private DefaultMutableTreeNode bindNode_Parent(int ID, int Parent_ID)
	  {
	    DefaultMutableTreeNode
	        node, root, group = null,  parent = null;

	    root = (DefaultMutableTreeNode)jTree.getModel().getRoot();
	    Enumeration nodes = root.breadthFirstEnumeration();
	    while (nodes.hasMoreElements())
	    {
	      node = (DefaultMutableTreeNode) nodes.nextElement();
	      OperGroupData tree_data = (OperGroupData)node.getUserObject();
	      int data = tree_data.index;
	      if (data==ID)          group = node;
	      if (data==Parent_ID)     parent = node;
	      if (group!=null && parent!=null)
	      {
	        root.remove(group);
	        parent.insert(group, parent.getChildCount());
	        break;
	      }
	    }
	    return group;
	  }
	  
	  
	  private void fillTree(DefaultMutableTreeNode top)
	  {
	    DefaultMutableTreeNode group = null;

	    qGroup.open();
	    qGroup.first();
	    while (qGroup.inBounds())
	    {
	      OperGroupData data = new OperGroupData( qGroup.getBigDecimal("F_KEY").intValue(), qGroup.getBigDecimal("F_LEVEL").intValue(), qGroup.getString("F_NAME") );
	      group = new DefaultMutableTreeNode(data);
	      top.add(group);
	      
	      qGroup.next();
	    }

	    // -- Установление родителей
	    qGroup.first();
	    while (qGroup.inBounds())
	    {
	      bindNode_Parent(  qGroup.getBigDecimal("F_LEVEL").intValue(),  qGroup.getBigDecimal("F_OWNER").intValue() );
	      qGroup.next();
	    }
	    qGroup.close();
	    // -- Удалить папки IM
	    group = (DefaultMutableTreeNode)jTree.getModel().getRoot();
	
	    
	    // -- Развернуть самый корень дерева --
	    jTree.expandRow(0);
	  }  
	  
	  

	  void jTree_valueChanged(TreeSelectionEvent evTreeChange)
	  {
	    TreePath path = evTreeChange.getPath();
	    if (!evTreeChange.isAddedPath(path)) return;
	    
	    if (qInner.isOpen()) qInner.close();
	  
	    DefaultMutableTreeNode node = (DefaultMutableTreeNode)path.getLastPathComponent();
	    if (node.getChildCount()>0)  return;
	    OperGroupData tree_data = (OperGroupData)node.getUserObject();
	   
	    String sqInner = "SELECT TC_OPER.F_LEVEL as \"Level\", F1, F3, TC_OPER_REC.F_KEY as \"key\" From TC_OPER , TC_OPER_REC where TC_OPER_REC.F_level=-TC_OPER.F_LEVEL and TC_OPER.F_KEY="+tree_data.key;
	    qInner.setQuery(new QueryDescriptor(dbOperations, sqInner, null, true, Load.AS_NEEDED));
	    qInner.open();
	   
	    jTextFieldKod.setText(qInner.getBigDecimal("Level").toString()+" ("+qInner.getBigDecimal("key").toString()+")");
	    jTextFieldKdOp.setText(qInner.getString("F1").toString());
	    jTextFieldKodProf.setText(qInner.getString("F3").toString());
	  }
	  
	  
	  
	  
	  
	private JScrollPane jScrollPane1;
	private JTree jTree1;
	private JPanel jPanel1;
	private JSplitPane jSplitPane1;

	SelectOperation(){
		 
		//paramRow.setInt("F_LEVEL",0);
		initGUI();
		System.out.println("o");
	    qMat.open();
		System.out.println("dd");
	    fillTree(nodeRoot);
	    jTree.setCellRenderer(new OperTreeRenderer(null));
	    jTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener()
	      {
	        public void valueChanged(TreeSelectionEvent e)
	        {
	          jTree_valueChanged(e);
	        }


	      });
		this.setVisible(true);
		setSize(800,600);
	      java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
	      Dimension dim = toolkit.getScreenSize();
	      setLocation((dim.width-getWidth())/2, (dim.height-getHeight())/2);
	}

}
