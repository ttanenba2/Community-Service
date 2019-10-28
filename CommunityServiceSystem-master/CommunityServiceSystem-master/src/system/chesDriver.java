package system;
import java.io.IOException;

import gui.*;

public class chesDriver {
	//actually display the window with main 
		public static void main(String [] args) throws ClassNotFoundException, IOException {
			ChesSystem ches = new ChesSystem();
			new OpeningScreen(ches);
		}
}
