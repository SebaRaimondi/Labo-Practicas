import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaColores {
    private JList colorList;
    private JTextField colorField;
    private JButton addButton;
    private JButton removeButton;
    private JPanel listaColoresView;

    public ListaColores() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String color = colorField.getText();
                if (!color.isEmpty()) addColor(color);
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String color = (String) colorList.getSelectedValue();
                if (!color.isEmpty()) removeColor(color);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ColorList");
        frame.setContentPane(new ListaColores().listaColoresView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void addColor(String color) {
        DefaultListModel model = (DefaultListModel) colorList.getModel();
        if (!model.contains(color)) model.addElement(color);
    }

    private void removeColor(String color) {
        DefaultListModel model = (DefaultListModel) colorList.getModel();
        if (model.contains(color)) model.removeElement(color);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        DefaultListModel<String> model = new DefaultListModel<>();
        colorList = new JList<>(model);
    }
}
