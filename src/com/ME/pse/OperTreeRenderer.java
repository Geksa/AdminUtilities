package com.ME.pse;

import javax.swing.tree.*;
import javax.swing.Icon;
import java.awt.Component;
import javax.swing.JTree;

import com.LANIT.extmaterial.IMBASE_Util;


public class OperTreeRenderer extends DefaultTreeCellRenderer
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3260514772631959675L;
	Icon customIcon;

    public OperTreeRenderer(final Icon icon)
    {
        customIcon = icon;
    }

    public Component getTreeCellRendererComponent( final JTree tree, final Object value,
        final boolean sel, final boolean expanded,  final boolean leaf, final int row, final boolean hasFocus)
    {
      boolean my_leaf = false;
      // если это элемент марки материала, то рисуем как лист (конечный элемент)
      if (value!=null)
      {
        final DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
        final OperGroupData data = (OperGroupData) node.getUserObject();
        if (data!=null)
          my_leaf = data.index == -10;
      }
      super.getTreeCellRendererComponent( tree, value, sel, expanded, my_leaf, row, hasFocus);
      return this;
    }
}
