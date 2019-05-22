package mastermind.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import mastermind.distributed.dispatchers.FrameType;
import mastermind.types.Color;
import mastermind.types.Error;

public class TCPIP {
	
	private ServerSocket serverSocket;

	private Socket socket;

	private PrintWriter out;

	private BufferedReader in;

	public TCPIP(Socket socket, PrintWriter out, BufferedReader in) {
		this.socket = socket;
		this.out = out;
		this.in = in;
		this.serverSocket = null;
	}

	public TCPIP(ServerSocket serverSocket, Socket socket, PrintWriter out, BufferedReader in) {
		this.socket = socket;
		this.out = out;
		this.in = in;
		this.serverSocket = serverSocket;
	}

	public static TCPIP createClientSocket() {
		try {
			Socket socket = new Socket("localhost", 2020);
			System.out.println("Cliente> Establecida conexion");
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			return new TCPIP(socket, out, in);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(0);
			return null;
		}
	}

	public static TCPIP createServerSocket() {
		try {
			ServerSocket serverSocket = new ServerSocket(2020);
			System.out.println("Servidor> Esperando conexion...");
			Socket socket = serverSocket.accept();
			System.out.println("Servidor> Recibida conexion de " + socket.getInetAddress().getHostAddress() + ":"
					+ socket.getPort());
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			return new TCPIP(serverSocket, socket, out, in);
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public void send(String value) {
		this.out.println(value);
		this.out.flush();
	}

	public void send(int value) {
		this.send("" + value);
	}

	public void send(boolean value) {
		this.send("" + value);
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
	
	public String receiveLine() {
		String result = null;
		try {
			result = this.in.readLine();
		} catch (IOException e) {
			System.out.println("Error en servidor!!! Lectura de string");
		}
		return result;
	}

	public boolean receiveBoolean() {
		boolean result = false;
		try {
			result = Boolean.parseBoolean(this.in.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int receiveInt() {
		int result = -1;
		try {
			result = Integer.parseInt(this.in.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
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
		try {
			this.send(FrameType.CLOSE.name());
			this.in.close();
			this.out.close();
			this.socket.close();
			if (this.serverSocket != null) {
				this.serverSocket.close();				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
