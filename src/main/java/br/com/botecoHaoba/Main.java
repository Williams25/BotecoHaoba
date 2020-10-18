package br.com.botecoHaoba;

import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import br.com.botecoHaoba.gui.FrmBoteco;


public class Main {


   public static final void main(String[] args) {

      try {
         UIManager.setLookAndFeel(new NimbusLookAndFeel());
      }
      catch (Throwable ex) {

      }

      FrmBoteco frm = new FrmBoteco();
      frm.setVisible(true);

   }


}
