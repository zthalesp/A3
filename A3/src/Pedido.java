import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A classe de pedido, a interface que irá aparecer ao usuário quando ele realizar o login no aplicativo.
 */
public class Pedido extends JFrame implements ActionListener {

    private JCheckBox TFP13;
    private JCheckBox TFP45;
    private JCheckBox TFLiquinho;
    private JTextField txtP13;
    private JTextField txtP45;
    private JTextField txtLiquinho;
    private JButton btnContinuar;

    // Criando os objetos de venda
    Produto p13 = new GLP13("P13", 130);
    Produto p45 = new GLP45("P45", 460);
    Produto liquinho = new GLLiquinho("Liquinho", 60);

    /**
     * Tela de pedido do programa. Ao chamar este método, irá aparecer a janela de pedido para o usuário.
     */
    public Pedido() {
        super("Tela de pedido");

        // Criando os componentes da interface
        JLabel lblTanques = new JLabel("Tanques");
        JLabel lblEscolha = new JLabel("Selecione o tipo");
        JLabel lblQuantidade = new JLabel("Escolha a quantidade");
        JLabel lblP13 = new JLabel(p13.nome() + " - R$" + p13.preco());
        TFP13 = new JCheckBox();
        txtP13 = new JTextField();
        JLabel lblP45 = new JLabel(p45.nome() + " - R$" + p45.preco());
        TFP45 = new JCheckBox();
        txtP45 = new JTextField();
        JLabel lblLiquinho = new JLabel(liquinho.nome() + " - R$" + liquinho.preco());
        TFLiquinho = new JCheckBox();
        txtLiquinho = new JTextField();
        btnContinuar = new JButton("Continuar");

        // Posicionando os componentes
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(5, 3, 5, 5));
        painel.add(lblTanques);
        painel.add(lblEscolha);
        painel.add(lblQuantidade);
        painel.add(lblP13);
        painel.add(TFP13);
        painel.add(txtP13);
        painel.add(lblP45);
        painel.add(TFP45);
        painel.add(txtP45);
        painel.add(lblLiquinho);
        painel.add(TFLiquinho);
        painel.add(txtLiquinho);
        painel.add(btnContinuar);

        // Adicionando o painel à tela
        getContentPane().add(painel, BorderLayout.CENTER);

        // Definindo o tamanho da tela
        setSize(450, 250);

        // Mostrando a tela
        setVisible(true);

        // Adicionando listener ao botão
        btnContinuar.addActionListener(this);
    }

    /**
     * Este método irá realizar o calculo do preço total entre o valor dos tanques e a quantidade dos tanques.
     * @return irá retornar o valor total do pedido.
     */
    public double calculoPreco() {
        String SQtdP13 = txtP13.getText();
        String SQtdP45 = txtP45.getText();
        String SQtdLiquinho = txtLiquinho.getText();
        boolean CKP13 = TFP13.isSelected();
        boolean CKP45 = TFP45.isSelected();
        boolean CKPLiquinho = TFLiquinho.isSelected();
        double ValorTP13 = 0;
        double ValorTP45 = 0;
        double ValorTLiquinho = 0;

        // Irá testar cada CheckBox verificando se seu valor é true ou false e calcular o valor total de cada tanque
        if (CKP13) {
            double IQtdP13 = Double.parseDouble(SQtdP13);
            ValorTP13 = p13.preco() * IQtdP13;
        }
        if (CKP45) {
            double IQtdP45 = Double.parseDouble(SQtdP45);
            ValorTP45 = p45.preco() * IQtdP45;
        }
        if (CKPLiquinho) {
            double IQtdLiquinho = Double.parseDouble(SQtdLiquinho);
            ValorTLiquinho = liquinho.preco() * IQtdLiquinho;
        }

        // Irá retornar o valor total do pedido
        return ValorTLiquinho + ValorTP13 + ValorTP45;
    }

    /**
     * Este método é executado ao clique de um botão na interface gráfica.
     * @param e o evento que  será executado ao clique do botão.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnContinuar) {
            // Fazer a janela atual desaparecer, ao mesmo tempo que irá aparecer uma mensagem e uma nova janela.
            this.setVisible(false);
            JOptionPane.showMessageDialog(null, "O valor total é de: R$" + calculoPreco());
            FinalizaPedido finalizar = new FinalizaPedido();
            finalizar.setVisible(true);
        }
    }
}