package notepad;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Notepad extends JFrame {

    JTextPane textArea;
    JScrollPane scrollPane;
    JToolBar menus, quickButtons;
    JButton openFile, saveFile, undo, redo, printFile;
    Dimension buttonSeperator;
    JMenuBar menuBar;
    JMenu fileDropdown, editDropdown;
    Font f;
    ActionListener actionListener = new FileOptions();

    // constructor
    public Notepad(String title) {
        super(title);
        setFonts();
        createWindow();

        add(createMenusToolbar());
        add(createButtonToolbar());
        add(createTextArea());

    }

    public void setFonts() {
        f = new Font("sans-serif", Font.PLAIN, 16);
        UIManager.put("MenuItem.font", f);
        UIManager.put("Button.font", f);
    }

    public void createWindow() {
        setMinimumSize(new Dimension(300, 200));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    }

    public JScrollPane createTextArea() {
        textArea = new JTextPane();
        textArea.setBorder(BorderFactory.createEmptyBorder(100, 75, 75, 75));
        textArea.setFont(f);
        
        scrollPane = new JScrollPane(textArea);
        scrollPane.setBackground(new Color(230, 243, 255));
        scrollPane.setBorder(BorderFactory.createEmptyBorder(50, 200, 10, 200));

        return scrollPane;
    }

    public JToolBar createMenusToolbar() {

        menus = new JToolBar();
        menuBar = new JMenuBar();
        fileDropdown = new JMenu("File");
        fileDropdown.add("New").addActionListener(actionListener);
        fileDropdown.add("Open").addActionListener(actionListener);
        fileDropdown.add("Save").addActionListener(actionListener);
        fileDropdown.add("Print").addActionListener(actionListener);
        fileDropdown.setFont(f);
        menuBar.add(fileDropdown);

        editDropdown = new JMenu("Edit");
        editDropdown.add("Undo").addActionListener(actionListener);
        editDropdown.add("Redo").addActionListener(actionListener);
        editDropdown.setFont(f);
        menuBar.add(editDropdown);

        menus.add(menuBar);
        menus.add(Box.createHorizontalGlue());
        editDropdown.setMaximumSize(new Dimension(300, 100));
        fileDropdown.setMaximumSize(new Dimension(300, 100));
        menus.setFloatable(false);
        return menus;
    }

    public JToolBar createButtonToolbar() {
        buttonSeperator = new Dimension(10, 0);
        quickButtons = new JToolBar();

        openFile = new JButton("Open");
        openFile.addActionListener(actionListener);
        quickButtons.add(openFile);
        quickButtons.addSeparator(buttonSeperator);

        saveFile = new JButton("Save");
        saveFile.addActionListener(actionListener);
        quickButtons.add(saveFile);
        quickButtons.addSeparator(buttonSeperator);

        undo = new JButton("Undo");
        undo.addActionListener(actionListener);
        quickButtons.add(undo);
        quickButtons.addSeparator(buttonSeperator);

        redo = new JButton("Redo");
        redo.addActionListener(actionListener);
        quickButtons.add(redo);
        quickButtons.addSeparator(buttonSeperator);

        printFile = new JButton("Print");
        printFile.addActionListener(actionListener);
        quickButtons.add(printFile);

        quickButtons.add(Box.createHorizontalGlue());

        quickButtons.setFloatable(false);
        return quickButtons;
    }
    
    public void close(){
        close();
    }

}