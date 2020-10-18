package br.com.botecoHaoba.gui.grid;

import java.text.NumberFormat;

import javax.swing.table.AbstractTableModel;

import br.com.botecoHaoba.model.entidades.Comanda;
import br.com.botecoHaoba.model.facade.BotecoFacade;

public class MesasTableModel extends AbstractTableModel {
   
   
   private BotecoFacade     facade;
   
   private MesasColumnModel columnModel;
   
   public MesasTableModel( BotecoFacade facade, MesasColumnModel columnModel ) {
      
      this.facade      = facade;
      this.columnModel = columnModel;
      
   }
   
   @Override
   public int getRowCount() {
      
      return facade.getComandas().size();
   }
   
   @Override
   public int getColumnCount() {
      
      return columnModel.getColumnCount();
   }
   
   @Override
   public Object getValueAt( int rowIndex, int columnIndex ) {
      
      Comanda comanda = facade.getComandas().get( rowIndex );
      
      if ( columnIndex == 0 ) {
         return comanda.getMesa();
         
      }
      
      if ( columnIndex == 1 ) {
         return comanda.getClienteReferencia();
      }
      
      if ( columnIndex == 2 ) {
         return comanda.getQuantidadePessoasMesa();
      }
      
      if ( columnIndex == 3 ) {
         return comanda.getQuantidadeItensConsumidos();
      }
      
      if ( columnIndex == 4 ) {
         return NumberFormat.getCurrencyInstance().format( comanda.getValorTotal() );
      }
      
      if ( columnIndex == 5 ) {
         return NumberFormat.getCurrencyInstance().format( comanda.getValorComissao() );
      }
      
      return null;
   }
}
