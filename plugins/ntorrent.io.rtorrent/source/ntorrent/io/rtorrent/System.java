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
package ntorrent.io.rtorrent;

import redstone.xmlrpc.XmlRpcArray;

/**
 * This interface governs the system.* commands as written in rtorrent.
 * @author Kim Eik
 *
 */
public interface System {
	XmlRpcArray listMethods();
	Object methodSignature(String method);
	Object methodHelp();
	Object multicall();
	Object shutdown();
	String client_version();
	Object get_cwd();
	String hostname();
	String library_version();
	Long pid();
	Object set_cwd();
	Object set_umask();
}
