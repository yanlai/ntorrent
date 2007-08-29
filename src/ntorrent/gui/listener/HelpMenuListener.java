/**
 *   nTorrent - A GUI client to administer a rtorrent process 
 *   over a network connection.
 *   
 *   Copyright (C) 2007  Kim Eik
 *
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package ntorrent.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ntorrent.gui.AboutGui;
import ntorrent.gui.SettingsGui;

public class HelpMenuListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if(s.equalsIgnoreCase("about")){
			AboutGui about = new AboutGui();
			about.drawWindow();
		}else if(s.equalsIgnoreCase("settings")){
			new SettingsGui();
		}
	}

}
