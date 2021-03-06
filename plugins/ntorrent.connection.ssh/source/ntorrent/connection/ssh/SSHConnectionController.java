package ntorrent.connection.ssh;

import java.awt.Component;

import org.apache.log4j.Logger;
import org.java.plugin.Plugin;

import ntorrent.connection.model.ConnectionProfileExtension;
import ntorrent.connection.model.ProxyProfile;
import ntorrent.connection.ssh.SSHConnectionController;
import ntorrent.connection.ssh.model.SSHConnectionProfile;
import ntorrent.connection.ssh.view.SSHConnectionView;
import ntorrent.io.xmlrpc.XmlRpcConnection;
import ntorrent.locale.ResourcePool;

public class SSHConnectionController extends Plugin implements ConnectionProfileExtension {

	private final SSHConnectionView display = new SSHConnectionView();
	private final SSHConnectionProfile connectionProfile = new SSHConnectionProfile();
	private String name;
	
	/**
	 * Log4j logger
	 */
	private final static Logger log = Logger.getLogger(SSHConnectionController.class);
	
	public SSHConnectionController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Component getDisplay() {
		return display;
	}

	@Override
	protected void doStart() throws Exception {
		log.info("doStart() called");
	}

	@Override
	protected void doStop() throws Exception {
		log.info("doStop() called");
	}
	
	public String getName() {
		if(name == null)
			return ResourcePool.getString("connection.ssh", this);
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public SSHConnectionController getClonedInstance() throws CloneNotSupportedException {
		return (SSHConnectionController) this.clone();
	}

	public void saveEvent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connectEvent() {
		// TODO Auto-generated method stub
	}

	@Override
	public XmlRpcConnection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProxyConnectionInfo(ProxyProfile profile) {
		// TODO Auto-generated method stub
		
	}
}
