import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Insets;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

public class ApkScanWin {
    private JFrame jFrame;
    private JTextField textField1;
    private JButton button1;
    private JTextArea textArea1;
    private JTextField textField2;
    private JButton exitButton;
    private JPanel panel1;
    private Map<String, String> markNameMap;
    
    private void setupUI() {
        JPanel jPanel = new JPanel();
        this.panel1 = jPanel;
        jPanel.setLayout(new GridLayoutManager(4, 3, new Insets(10, 15, 20, 10), -1, -1, false, false));
        JLabel jLabel = new JLabel();
        jLabel.setText("File");
        jPanel.add(jLabel, new GridConstraints(0, 0, 1, 1, 8, 0, 0, 0, null, null, null));
        jPanel.add(new Spacer(), new GridConstraints(1, 0, 1, 1, 0, 2, 1, 6, null, null, null));
        JTextField jTextField = new JTextField();
        this.textField1 = jTextField;
        jPanel.add(jTextField, new GridConstraints(0, 1, 1, 1, 8, 1, 6, 0, null, new Dimension(150, -1), null));
        JButton jButton = new JButton();
        this.button1 = jButton;
        jButton.setText(". . .");
        jPanel.add(jButton, new GridConstraints(0, 2, 1, 1, 0, 1, 3, 0, null, null, null));
        JTextArea jTextArea = new JTextArea();
        this.textArea1 = jTextArea;
        jTextArea.setText("\nCurrently only supported reinforcement vendors: Naga, Bangbang, IEncryption, Tongfu Shield, 360 reinforcement, Baidu reinforcement, Ali reinforcement, \nTencent reinforcement, Shengda reinforcement, Rising reinforcement, Netqin reinforcement, Guoxin Lingtong reinforcement, Apkprotect reinforcement, \nKiwi security reinforcement, Topimage Security reinforcement, Netease Yidun and other conventional manufacturers\nFind out more at: www.legendsec.org (Chinese website)");
        jPanel.add(jTextArea, new GridConstraints(1, 1, 1, 1, 0, 3, 6, 6, null, new Dimension(150, 50), null));
        jTextField = new JTextField();
        this.textField2 = jTextField;
        jPanel.add(jTextField, new GridConstraints(2, 1, 1, 1, 8, 1, 6, 0, null, new Dimension(150, -1), null));
        jLabel = new JLabel();
        jLabel.setText("Shell");
        jPanel.add(jLabel, new GridConstraints(2, 0, 1, 1, 8, 0, 0, 0, null, null, null));
        jButton = new JButton();
        this.exitButton = jButton;
        jButton.setText("Exit");
        jPanel.add(jButton, new GridConstraints(2, 2, 1, 1, 0, 1, 3, 0, null, null, null));
        jLabel = new JLabel();
        Font font = jLabel.getFont();
        if (font != null) {
            jLabel.setFont(new Font(font.getName(), font.getStyle(), 12));
        }
        jLabel.setText("Just drag and drop the file to the window!");
        jPanel.add(jLabel, new GridConstraints(3, 1, 1, 1, 0, 0, 0, 0, null, null, null));
    }


    public ApkScanWin() {
        setupUI();
        this.button1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                ApkScanWin.this.fileChooser();
                super.mouseClicked(e);
            }
        });
        this.exitButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ApkScanWin.this.jFrame.dispose();
            }
        });
    }

    public void init() {
        this.jFrame = new JFrame("APK Shell Detector");
        FileTransferHandler fileTransferHandler = new FileTransferHandler(this);
        this.panel1.setTransferHandler(fileTransferHandler);
        this.textField1.setTransferHandler(fileTransferHandler);
        this.textField2.setTransferHandler(fileTransferHandler);
        this.button1.setTransferHandler(fileTransferHandler);
        this.textArea1.setTransferHandler(fileTransferHandler);
        this.exitButton.setTransferHandler(fileTransferHandler);
        this.jFrame.setContentPane(this.panel1);
        this.jFrame.setDefaultCloseOperation(3);
        this.jFrame.pack();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int x = (int)(toolkit.getScreenSize().getWidth() - this.jFrame.getWidth()) / 2;
        int y = (int)(toolkit.getScreenSize().getHeight() - this.jFrame.getHeight()) / 2;
        this.jFrame.setLocation(x, y);
        this.jFrame.setVisible(true);
    }

    public void fileChooser() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.apk", new String[] { "apk", "apk", "apk" });
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(new JPanel());
        if(returnVal == 0) {
            String absolutePath = chooser.getSelectedFile().getAbsolutePath();
            this.textField1.setText(absolutePath);
            if(absolutePath.endsWith(".apk")) {
                List<String> result = MyUtil.readZipFile(absolutePath);
                if((result.size() == 1) && (((String)result.get(0)).startsWith("ERROR:")))
                    this.textArea1.setText((String)result.get(0));
                else {
                    boolean flag = true;
                    for(String fileName : result) {
                        if(this.markNameMap.containsKey(fileName)) {
                            this.textField2.setText((String)this.markNameMap.get(fileName) + " reinforced");
                            flag = false;
                            break;
                        }
                    }
                    if(flag)
                        this.textField2.setText("This apk does not use reinforcement or is an unknown reinforcement manufacturer!");
                }
            }
        }
    }

    public JTextField getTextField1() {
        return this.textField1;
    }

    public void setTextField1(JTextField textField1) {
        this.textField1 = textField1;
    }

    public JButton getButton1() {
        return this.button1;
    }

    public void setButton1(JButton button1) {
        this.button1 = button1;
    }

    public JTextArea getTextArea1() {
        return this.textArea1;
    }

    public void setTextArea1(JTextArea textArea1) {
        this.textArea1 = textArea1;
    }

    public JTextField getTextField2() {
        return this.textField2;
    }

    public void setTextField2(JTextField textField2) {
        this.textField2 = textField2;
    }

    public JButton getExitButton() {
        return this.exitButton;
    }

    public void setExitButton(JButton exitButton) {
        this.exitButton = exitButton;
    }

    public JPanel getPanel1() {
        return this.panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public Map<String, String> getMarkNameMap() {
        return this.markNameMap;
    }

    public void setMarkNameMap(Map<String, String> markNameMap) {
        this.markNameMap = markNameMap;
    }
}
