package notepad;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Stack;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

public class FileOptions implements ActionListener {

    String buttonPressed;
    Stack undoStack = new Stack();
    Stack redoStack = new Stack();
    Boolean beenSaved = true;
    JFrame currentFrame;
    SaveWindow savePopUp;

    public void newFile(ActionEvent ae) {
        /* If page doesn't need saving
        Create new page with original settings
        else
        offer box: Save? Don't save? Cancel!
         */

        JMenuItem component = (JMenuItem) ae.getSource();
        JPopupMenu jpm = (JPopupMenu) component.getParent();
        JMenu menu = (JMenu) jpm.getInvoker();
        JFrame frame = (JFrame) SwingUtilities.getRoot(menu);

        if (!beenSaved) {

            frame.dispose();
            new Main();
        } else {
            //savePopUp = new SaveWindow();
            //savePopUp.setVisible(true);
            JDialog dialog = new JDialog();
            dialog.setModalityType(Dialog.ModalityType.TOOLKIT_MODAL);
            dialog.setVisible(true);
        }

    }

    public void saveFile() {

    }

    public void openFile() {

    }

    public void undo() {

    }

    public void redo() {

    }

    public void printFile() {
        PrinterJob pj = PrinterJob.getPrinterJob();
        if (pj.printDialog()) {
            try {
                pj.print();
            } catch (PrinterException exc) {
                System.out.println(exc);
            }
        } else {
            System.out.println("Failed...");
        }
    }

    public void actionPerformed(ActionEvent ae) {
        buttonPressed = ae.getActionCommand();
        switch (buttonPressed) {
            case "New":
                newFile(ae);
                break;

            case "Save":
                saveFile();
                break;

            case "Open":
                openFile();
                break;

            case "Undo":
                undo();
                break;

            case "Redo":
                redo();
                break;

            case "Print":
                printFile();
                break;
        }

    }

}
