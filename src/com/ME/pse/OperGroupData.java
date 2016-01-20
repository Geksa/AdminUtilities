package com.ME.pse;

import java.math.BigDecimal;
import javax.swing.tree.TreePath;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.tree.TreeNode;

public class OperGroupData
{
  int key;
  public int index;
  public String name;
  public String sInnerTable=null;
  public int count=0;
  public int owner=-1;

  public OperGroupData()
  {
    key = 0;
    index = 0;
    name = "";
  }

  public OperGroupData(int theKey, int theIndex, String theName)
  {
    key = theKey;
    index = theIndex;
    name = theName;
  }

  public String toString()
  {
    return name;
  }

  public static TreePath getNodePath(TreeNode node)
  {
    List list = new ArrayList();
    // Add all nodes to list
    while (node != null)
    {
        list.add(node);
        node = node.getParent();
    }
    Collections.reverse(list);

    // Convert array of nodes to TreePath
    return new TreePath(list.toArray());
  }

}
