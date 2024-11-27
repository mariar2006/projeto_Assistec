package br.com.loja.assistec.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MensagemView extends JDialog {
	private static final long serialVersionUID = 1L;
	private int resposta;

	public MensagemView(String mensagem, int tipo) {
		setTitle("Mensagem");
		setSize(350,200);
		setModal(true);

		JPanel painel = new JPanel();
		painel.setLayout(new BorderLayout());
		add(painel);

		JLabel lblMensagem = new JLabel(mensagem, SwingConstants.CENTER);
		painel.add(lblMensagem, BorderLayout.CENTER);

		String iconeURL;
		switch (tipo) {
		case 0:
			iconeURL = "/br/com/loja/assistec/icones/errro.png";
			lblMensagem.setIcon(new ImageIcon(getClass().getResource(iconeURL)));
			break;
		case 1:
			iconeURL = "/br/com/loja/assistec/icones/info.png";
			lblMensagem.setIcon(new ImageIcon(getClass().getResource(iconeURL)));
			break;
		case 2:
			iconeURL = "/br/com/loja/assistec/icones/alerta.png";
			lblMensagem.setIcon(new ImageIcon(getClass().getResource(iconeURL)));
			break;
		case 3:
			iconeURL = "/br/com/loja/assistec/icones/sucesso.png";
			lblMensagem.setIcon(new ImageIcon(getClass().getResource(iconeURL)));
			break;
		case 10:
			iconeURL = "/br/com/loja/assistec/icones/assistec.png";
			lblMensagem.setIcon(new ImageIcon(getClass().getResource(iconeURL)));
			break;
		}
		JPanel painelSul = new JPanel(new FlowLayout(FlowLayout.CENTER,20,10));
		painelSul.add(new JPanel());
		JButton btOk = new JButton("Ok");
        btOk.setPreferredSize(new Dimension(100, 30));
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}});
		painelSul.add(btOk);
		painelSul.add(new JPanel());
		painel.add(painelSul,BorderLayout.SOUTH);
		
		setSize(350,200);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	public MensagemView(String pergunta) {
        setTitle("Mensagem");
        setSize(350, 200);
        setModal(true);

        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());
        add(painel);

        JLabel lablPergunta = new JLabel(pergunta, SwingConstants.CENTER);
        String iconPath = "/br/com/loja/assistec/icones/question.png";
        lablPergunta.setIcon(new ImageIcon(getClass().getResource(iconPath)));
        painel.add(lablPergunta, BorderLayout.CENTER);

        JPanel painelSul = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton btSim = new JButton("Sim");
        btSim.setPreferredSize(new Dimension(100, 30));
        btSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resposta = 1;
				setVisible(false);
			}});
        painelSul.add(btSim);

        JButton btNao = new JButton("Não");
        btNao.setPreferredSize(new Dimension(100, 30));
        btNao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resposta = 0;
                setVisible(false);
            }
        });
        painelSul.add(btNao);

        painel.add(painelSul, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
        
        
    }

	public int getResposta() {
        return resposta;
    }

}