package mastermind.distributed.dispatchers;

import java.util.HashMap;
import java.util.Map;

import mastermind.utils.TCPIP;

public class DispatcherPrototype {
	
	private TCPIP tcpip;
	
	private Map<FrameType, Dispatcher> dispatcherMap;
	
	public DispatcherPrototype() {
		this.tcpip = TCPIP.createServerSocket();
		this.dispatcherMap = new HashMap<FrameType, Dispatcher>();
	}
	
	public void add (FrameType frameType, Dispatcher dispatcher) {
		this.dispatcherMap.put(frameType, dispatcher);
		dispatcher.associate(this.tcpip);
	}

	public void dispatch(FrameType frameType) {
		this.dispatcherMap.get(frameType).dispatch();
	}

	public void serve() {
		FrameType frameType = null;
		do {
			String string = this.tcpip.receiveLine();
			System.out.println("llego por socket: " + string);
			frameType = FrameType.parser(string);
			if (frameType != FrameType.CLOSE) {
				this.dispatch(frameType);
			}
		} while (frameType != FrameType.CLOSE);
		this.tcpip.close();		
	}

}
