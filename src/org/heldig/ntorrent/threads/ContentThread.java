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

package org.heldig.ntorrent.threads;

import org.heldig.ntorrent.GUIController;
import org.heldig.ntorrent.NTorrent;
import org.heldig.ntorrent.gui.StatusBarComponent;
import org.heldig.ntorrent.gui.torrent.TorrentPool;
import org.heldig.ntorrent.io.Rpc;


/**
 * @author  Kim Eik
 */
public class ContentThread extends Thread {

	StatusBarComponent bar;
	Rpc rpc;
	TorrentPool torrents;
	
	public ContentThread(Rpc r, StatusBarComponent b, TorrentPool tp) {
		rpc = r;
		bar = b;
		torrents = tp;
	}

	
	public void run(){
		try {
			rpc.getTorrentSet(torrents.getView(), torrents);
			bar.setDownloadRate(torrents.getRateDown());
			bar.setUploadRate(torrents.getRateUp());
			while(true){
				try {
					Thread.sleep(NTorrent.settings.vintervall);
					rpc.getTorrentVariables(torrents.getView(),torrents);
					bar.repaint();
				} catch (InterruptedException e) {
					torrents.table.fireTableDataChanged();
					rpc.getTorrentSet(torrents.getView(), torrents);
				}
			}
		} catch (Exception e) {
			GUIController.showError(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}
	
}
