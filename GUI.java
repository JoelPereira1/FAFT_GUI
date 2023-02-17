/**
* Our GUI
 */

// import java.awt.BorderLayout;
// import java.awt.GridLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;

// import javax.swing.BorderFactory;
// import javax.swing.JFrame;
// import javax.swing.JPanel;

public class GUI implements ActionListener {

  private static JLabel pathLabel;
  private static JTextField xmlPath;

  private static JLabel yearLabel;
  private static JTextField year;

  private static JLabel monthLabel;
  private static JTextField month;

  private static JLabel nifLabel;
  private static JTextField nif;

  private static JLabel passLabel;
  private static JTextField pass;

  private static JLabel actionLabel;
  private static JTextField actionText;

  private static JButton send;

  private static Path jarPath;

  public static void main(String[] args) {
    //Creating the Frame
    JFrame frame = new JFrame("SATF GUI");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 400);

    //Creating the MenuBar and adding components
    JMenuBar mb = new JMenuBar();
    JMenu m1 = new JMenu("FILE");
    JMenu m2 = new JMenu("Help");
    mb.add(m1);
    mb.add(m2);
    JMenuItem m11 = new JMenuItem("Open");
    JMenuItem m22 = new JMenuItem("Save as");
    m1.add(m11);
    m1.add(m22);

    //Creating the panel at bottom and adding components
    JPanel panel = new JPanel(); // the panel is not visible in output
    panel.setLayout(new GridLayout(0, 1));


    pathLabel = new JLabel("Caminho para ficheiro .xml");
    pathLabel.setBounds(10, 30, 80, 25);
    panel.add(pathLabel); // Components Added using Flow Layout

    xmlPath = new JTextField(50); // accepts upto 10 characters
    xmlPath.setBounds(100, 30, 300, 25);
    panel.add(xmlPath);


    yearLabel = new JLabel("Ano");
    yearLabel.setBounds(10, 20, 40, 25);
    panel.add(yearLabel); // Components Added using Flow Layout

    year = new JTextField(10); // accepts upto 10 characters
    year.setBounds(100, 20, 100, 25);
    panel.add(year);


    monthLabel = new JLabel("Mês");
    monthLabel.setBounds(0, 20, 40, 25);
    panel.add(monthLabel); // Components Added using Flow Layout

    month = new JTextField(10); // accepts upto 10 characters
    month.setBounds(100, 20, 100, 25);
    panel.add(month);


    nifLabel = new JLabel("NIF");
    nifLabel.setBounds(10, 20, 80, 25);
    panel.add(nifLabel); // Components Added using Flow Layout

    nif = new JTextField(20); // accepts upto 10 characters
    nif.setBounds(0, 20, 165, 25);
    panel.add(nif);


    passLabel = new JLabel("Password");
    passLabel.setBounds(10, 20, 80, 25);
    panel.add(passLabel); // Components Added using Flow Layout

    pass = new JTextField(20); // accepts upto 10 characters
    pass.setBounds(0, 20, 165, 25);
    panel.add(pass);


    actionLabel = new JLabel("Ação (validar/enviar)");
    actionLabel.setBounds(10, 20, 80, 25);
    panel.add(actionLabel); // Components Added using Flow Layout

    actionText = new JTextField(20); // accepts upto 10 characters
    actionText.setBounds(0, 20, 165, 25);
    panel.add(actionText);


    send = new JButton("Send");
    send.setBounds(10, 80, 80, 25);
    // JButton reset = new JButton("Reset");
    send.addActionListener(new GUI());
    panel.add(send);
    // panel.add(reset);

    //Text Area at the Center
    //JTextArea ta = new JTextArea();

    //Adding Components to the frame.
    // frame.getContentPane().add(BorderLayout.SOUTH, panel);
    // frame.getContentPane().add(BorderLayout.NORTH, mb);
    // frame.getContentPane().add(BorderLayout.CENTER, ta);


    // JPanel panel = new JPanel();

    // panel.setBorder(BorderFactory.createEmptyBorder(200, 200, 20, 200));
    // panel.setLayout(new GridLayout(0, 1));
    // frame.add(panel, BorderLayout.CENTER);
    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // frame.setTitle("Our SAFT GUI");
    // frame.pack();
    // frame.setVisible(true);

    //Titled borders
    //Keep references to the next few borders,
    //for use in titles and compound borders.
    // Border blackline, loweredetched, loweredbevel, empty;
    // blackline = BorderFactory.createLineBorder(Color.black);
    // loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
    // loweredbevel = BorderFactory.createLoweredBevelBorder();
    // empty = BorderFactory.createEmptyBorder();

    // TitledBorder title;
    // title = BorderFactory.createTitledBorder("title");
    // panel.setBorder(title);

    // title = BorderFactory.createTitledBorder(blackline, "title");
    // title.setTitleJustification(TitledBorder.CENTER);
    // panel.setBorder(title);

    // title = BorderFactory.createTitledBorder(loweredetched, "title");
    // title.setTitleJustification(TitledBorder.RIGHT);
    // panel.setBorder(title);

    // title = BorderFactory.createTitledBorder(loweredbevel, "title");
    // title.setTitlePosition(TitledBorder.ABOVE_TOP);
    // panel.setBorder(title);

    // title = BorderFactory.createTitledBorder(empty, "title");
    // title.setTitlePosition(TitledBorder.BOTTOM);
    // panel.setBorder(title);

    jarPath = Paths.get(".src\\FACTEMICLI-2.5.24-40209-cmdClient.jar");

    frame.setVisible(true);
    frame.add(panel, BorderLayout.CENTER);

  }

  // public static void main(String[] args) {
  //   new GUI();
  // }

  public void processSaft(String xmlVar, String yearVar, String monthVar, String nifVar, String passVar, String actionVar) {
    try {
        // Runtime rt = Runtime.getRuntime();
        //Process pr = rt.exec("cmd /c dir");

        // Process pr = rt.exec("cmd /c start cmd.exe /K \"java -jar\"");
        // Process pr = new ProcessBuilder("cmd /c start cmd.exe /K \"java -jar\"").start();
        // BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));

        // String line=null;

        // while((line=input.readLine()) != null) {
        //   System.out.println(line);
        // }

        // int exitVal = pr.waitFor();
        // System.out.println("Exited with error code "+exitVal);

        String string = String.format("java -jar %s -i %s -n %s -p %s -a %s -m %s -op %s", jarPath.toAbsolutePath(), xmlVar, nifVar, passVar, yearVar, monthVar, actionVar);
        ProcessBuilder builder = new ProcessBuilder(
            "cmd.exe", "/c", string);
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
          line = r.readLine();
          if (line == null) {
            break;
          }
          System.out.println(line);
        }

    } catch(Exception e) {
        System.out.println(e.toString());
        e.printStackTrace();
    }
}

  public void actionPerformed(ActionEvent e) {
    String xmlVar = xmlPath.getText();
    String yearVar = year.getText();
    String monthVar = month.getText();
    String nifVar = nif.getText();
    String passVar = pass.getText();
    String actionVar = actionText.getText();

    if (e.getSource() == send) {
      processSaft(xmlVar, yearVar, monthVar, nifVar, passVar, actionVar);

      String string = String.format("java -jar %s -i %s -n %s -p %s -a %s -m %s -op %s", jarPath.toAbsolutePath(), xmlVar, yearVar, monthVar, nifVar, passVar, actionVar);
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      System.setOut(new PrintStream(bos));
      System.out.println(string);
      JOptionPane.showMessageDialog(null, "Captured: " + bos.toString());
      JOptionPane.showMessageDialog(null, "Everything fine!");
    }


  }
}