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


package ntorrent;

import java.io.IOException;

import ntorrent.gui.GUIController;
import ntorrent.io.IOController;
import ntorrent.model.ModelController;
import ntorrent.settings.Constants;
import ntorrent.threads.ThreadController;


/**
 * @author   Kim Eik
 */
public class Controller{
	
	private String[] filesToLoad;
	private IOController IO;
	private GUIController GC;
	private ThreadController TC;
	private ModelController MC;
	
	public Controller(String[] args) throws IOException{
		this();
		filesToLoad = args;
	}
	
	public Controller() throws IOException {
		//new ErrorLog();
		System.out.println(Constants.getReleaseName());
		System.out.println("Drawing gui");
		IO = new IOController();
		GC = new GUIController(this);
	}
	
	public void connect(String host, String username, String password){
		try {
			GC.drawMainWindow();
			System.out.println("Connecting");
			IO.connect(host, username, password);
			IO.loadStartupFiles(filesToLoad);
			
			//Save profile
			IO.getProfile().setHost(host);
			IO.getProfile().setUsername(username);
			IO.getProfile().saveSettings();
			
			MC = new ModelController(this);
			TC = new ThreadController(this);
			
			GC.getTorrentTableModel().fillData(MC.getTorrentPool());
			TC.startThreads();
		} catch (Exception e) {
			GC.showError(e);
		}
	}

	

	/**
	 * @return
	 * @uml.property  name="gC"
	 */
	public GUIController getGC() {
		return GC;
	}
	
	/**
	 * @return
	 * @uml.property  name="iO"
	 */
	public IOController getIO() {
		return IO;
	}
	
	/**
	 * @return
	 * @uml.property  name="mC"
	 */
	public ModelController getMC() {
		return MC;
	}
	
	/**
	 * @return
	 * @uml.property  name="tC"
	 */
	public ThreadController getTC() {
		return TC;
	}
	
}