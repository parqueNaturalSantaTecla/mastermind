package mastermind.distributed.dispatchers;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import mastermind.distributed.FrameType;
import mastermind.types.Color;
import mastermind.types.Error;

public class TCPIP extends santaTecla.utils.TCPIP {

	public TCPIP(Socket socket, PrintWriter out, BufferedReader in) {
		super(socket, out, in);
	}
	
	public TCPIP(ServerSocket serverSocket, Socket socket, PrintWriter out, BufferedReader in) {
		super(serverSocket, socket, out, in);
	}

	public void send(Color value) {
		if (value == null) {
			this.send("null");
		}else {
			this.send(value.name());			
		}
	}

	public void send(Error value) {
		if (value == null) {
			this.send("null");
		}else {
			this.send(value.name());
		}
	}

	public Error receiveError() {
		String error = this.receiveLine();
		if (error.equals("null")) {
			return null;
		}
		return Error.valueOf(error);
	}

	public Color receiveColor() {
		String color = this.receiveLine();
		if (color.equals("null")) {
			return null;
		}else {
			return Color.valueOf(color);			
		}
	}

	public void close() {
		this.send(FrameType.CLOSE.name());
		super.close();
	}	

}
