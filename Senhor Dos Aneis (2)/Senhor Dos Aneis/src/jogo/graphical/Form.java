package jogo.graphical;

import jogo.batalha.Batalha;
import jogo.personagens.Besta;
import jogo.personagens.Heroi;
import jogo.personagens.tipos.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Objects;

public class Form extends JFrame {

    private JPanel mainPanel;
    private JPanel bottomPanel;
    private JPanel topLeftPanel;
    private JPanel topRightPanel;
    private JLabel labelHerois;
    private JLabel labelBestas;
    private JButton addHerois;
    private JPanel heroisPanel;
    private JTextField nomeHTextField;
    private JTextField vidaHTextField;
    private JTextField armaduraHTextField;
    private JPanel bestasPanel;
    private JList listaHerois;
    private JButton lutarButton;
    private JList listaBesta;
    private JPanel panelListaHerois;
    private JPanel panelListaBestas;
    private JPanel panelLuta;
    private JComboBox comboBoxTipoHerois;
    private JComboBox comboTipoBestas;
    private JTextField armaduraBTextField;
    private JTextField vidaBTextField;
    private JTextField nomeBTextField;
    private JButton addBestas;
    private JTextArea textAreaOutput;
    private JLabel labelHerois2;
    private JLabel labelBestas2;

    public Form(){

        // Configurações da janela
        setContentPane(mainPanel);
        setTitle("Senhor dos Anéis");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 900);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        labelHerois.setForeground(Color.white);
        labelBestas.setForeground(Color.white);
        labelHerois2.setForeground(Color.white);
        labelBestas2.setForeground(Color.white);

        ImageIcon image = new ImageIcon("image//iconLordOfTheRings.png");
        setIconImage(image.getImage());


        // Preencher comboBoxes de heróis e bestas com tipos
        for (String tipoHeroi: Heroi.listaHerois()){
            comboBoxTipoHerois.addItem(tipoHeroi);
        }

        for (String tipoBesta: Besta.listaBestas()){
            comboTipoBestas.addItem(tipoBesta);
        }


        Batalha batalha = new Batalha();

        /**************************** ACTION LISTENERS *******************************/

        addHerois.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nomeHTextField.getText().isEmpty() || vidaHTextField.getText().isEmpty() || armaduraHTextField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(Form.this, "Erro! Preencha todos os campos!");
                }else{
                    Heroi heroi = null;
                    switch ((String) Objects.requireNonNull(comboBoxTipoHerois.getSelectedItem())){
                        case "Elfo":
                            heroi = new Elfo(nomeHTextField.getText(), Integer.parseInt(vidaHTextField.getText()), Integer.parseInt(armaduraHTextField.getText()));
                            break;
                        case "Hobbit":
                            heroi = new Hobbit(nomeHTextField.getText(), Integer.parseInt(vidaHTextField.getText()), Integer.parseInt(armaduraHTextField.getText()));
                            break;
                        case "Humano":
                            heroi = new Humano(nomeHTextField.getText(), Integer.parseInt(vidaHTextField.getText()), Integer.parseInt(armaduraHTextField.getText()));
                            break;
                    }
                    batalha.addListaHerois(heroi);

                    String[] nomesHerois = new String[batalha.getListaHerois().size()];

                    for(int i=0; i<batalha.getListaHerois().size(); i++){
                        nomesHerois[i] = batalha.getListaHerois().get(i).descricao();
                    }

                    listaHerois.setListData(nomesHerois);

                }
            }
        });

        addBestas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nomeBTextField.getText().isEmpty() || vidaBTextField.getText().isEmpty() || armaduraBTextField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(Form.this, "Erro! Preencha todos os campos!");
                }else{
                    Besta besta = null;
                    switch ((String) Objects.requireNonNull(comboTipoBestas.getSelectedItem())){
                        case "Orque":
                            besta = new Orque(nomeBTextField.getText(), Integer.parseInt(vidaBTextField.getText()), Integer.parseInt(armaduraBTextField.getText()));
                            break;
                        case "Troll":
                            besta = new Troll(nomeBTextField.getText(), Integer.parseInt(vidaBTextField.getText()), Integer.parseInt(armaduraBTextField.getText()));
                            break;
                    }
                    batalha.addListaBestas(besta);

                    String[] nomesBesta = new String[batalha.getListaBesta().size()];

                    for(int i=0; i<batalha.getListaBesta().size(); i++){
                        nomesBesta[i] = batalha.getListaBesta().get(i).descricao();
                    }

                    listaBesta.setListData(nomesBesta);

                }
            }
        });

        lutarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Redirecionar a saída do console para a textAreaOutput
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                PrintStream ps = new PrintStream(baos);
                System.setOut(ps);

                // Limpar a textAreaOutput antes de exibir novo resultado
                textAreaOutput.setText("");

                // Realizar a batalha
                batalha.turnos();


                // Exibir o resultado na textAreaOutput
                textAreaOutput.setText(baos.toString());

                batalha.resetListaBestas();
                batalha.resetListaHerois();

                nomeHTextField.setText("");
                vidaHTextField.setText("");
                armaduraHTextField.setText("");

                nomeBTextField.setText("");
                vidaBTextField.setText("");
                armaduraBTextField.setText("");


                // Limpar completamente as listas
                listaHerois.setModel(new DefaultListModel());
                listaBesta.setModel(new DefaultListModel());

            }
        });
    }
}
