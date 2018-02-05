package notepad;

public class Main {

    Notepad notepad;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main notePadWindow = new Main();
    }
    
    public Main(){
        notepad = new Notepad("Notepad");
        //DataStuff data = new DataStuff();
        //@SuppressWarnings("unused")
        //ProcessEvents process = new ProcessEvents(mainFrame, data );
        notepad.setVisible(true);
    }
    
}