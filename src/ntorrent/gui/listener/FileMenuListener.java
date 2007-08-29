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

import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import ntorrent.controller.Controller;
import ntorrent.gui.dialogues.PromptEnv;
import ntorrent.gui.dialogues.PromptFile;
import ntorrent.gui.dialogues.PromptString;

import org.apache.xmlrpc.XmlRpcException;

public class FileMenuListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if(e.getSource() instanceof Menu)
			if(s.equalsIgnoreCase("add torrent")){
				PromptFile filePrompt = new PromptFile();
				if(filePrompt.getFile() != null){
					try {
						Controller.getRpc().loadTorrent(filePrompt.getFile());
					} catch (IOException x) {
						Controller.writeToLog(x);
					} catch (XmlRpcException x) {
						Controller.writeToLog(x);
					}
				}
			}else if(s.equalsIgnoreCase("add url")){
				PromptString stringPrompt = new PromptString();
				try {
					if(stringPrompt.getInput() != null)
						Controller.getRpc().loadTorrent(stringPrompt.getInput());
				} catch (XmlRpcException x) {
					Controller.writeToLog(x);
				}
			}else if(s.equalsIgnoreCase("quit")){
				System.exit(0);
			}else if(s.equalsIgnoreCase("connect")){
				PromptEnv env = new PromptEnv(Controller.getGui().getRootWin());
				env.setHost(Controller.getProfile().getHost());
				env.setUsername(Controller.getProfile().getUsername());
				env.drawWindow();
			}


	}

}
