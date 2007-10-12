/**
 * 
 */
package org.heldig.ntorrent.gui.listener;

import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import org.heldig.ntorrent.language.Language;

/**
 * @author Kim Eik
 *
 */
public abstract class MenuImplementation implements ActionListener {

	
	public static final void createMenuItems(JComponent target,Object[] menuItems, ActionListener t){
	    for(Object mitem : menuItems){
	    	if(mitem instanceof Object[]){
	    		target.add(createMenu((Object[])mitem,t));
	    	}else if(mitem == null){
	    		target.add(new JSeparator(SwingConstants.HORIZONTAL));
	    	} else if(mitem instanceof Language) {
		    	JMenuItem menuItem = new JMenuItem((Language)mitem);
		    	menuItem.addActionListener(t);
		    	target.add(menuItem);
	    	}
	    }
	}
	
	public static final JMenu createMenu(Object[] objects, ActionListener t) {
		JMenu submenu = new JMenu(objects[0].toString());
		Object[] menuitems = new Object[objects.length-1];
		for(int x = 1; x < objects.length; x++)
			menuitems[x-1] = objects[x];
		createMenuItems(submenu, menuitems,t);
		return submenu;		
	}	
}
