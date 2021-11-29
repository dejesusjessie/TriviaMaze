package view;

import javax.swing.JPanel;
import javax.swing.JEditorPane;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.DropMode;
import javax.swing.UIManager;
import java.awt.Cursor;
import java.awt.CardLayout;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class InfoPanelBuilder extends JPanel {

	/**
	 * Create the panel.
	 */
	public InfoPanelBuilder() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_2 = new JButton("New button");
		add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("New button");
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		add(lblNewLabel);
		


		JTextArea textArea_1 = new JTextArea("	Welcome!"
				+"	You are a husky and looking for food in the jungle."
				+"There are many rivers block your way during the serching."
				+"But luckly, if when you click the river, there will be a trivia question,"
				+ "if you select the correct answer, you will get a bridge to cross the river,"
				+ "but if you select the wrong answer, ahhhhhhhhhh...", 10,20);
		textArea_1.setFocusCycleRoot(true);
//		textArea_1.setDisabledTextColor(new Color(255, 0, 0));
//		textArea_1.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		textArea_1.setBorder(UIManager.getBorder("EditorPane.border"));
//		textArea_1.setCaretColor(new Color(255, 69, 0));
//		textArea_1.setSelectionColor(new Color(238, 130, 238));
		textArea_1.setForeground(new Color(0, 128, 0));
		textArea_1.setWrapStyleWord(true);
		textArea_1.setLineWrap(true);
		textArea_1.setBackground(new Color(255,222,173));
		textArea_1.setFont(new Font("Wawati SC", Font.PLAIN, 20));
		add(textArea_1);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		//textArea_1.add(scrollPane);

	}

}
