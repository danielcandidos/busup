package com.example.busup2;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
 
public class MeuAdapter extends BaseExpandableListAdapter {
	 
	Context context;
	 
	// Definindo o conte�do de nossa lista e sublista
	 
	String[] listaPai = { " Camaragibe (Macaxeira)", " Barro (V�rzea)", " Casa Amarela (Cabug�)"
			, " Dois Irm�os (Rui Barbosa)", " TI Tancredo Neves" };
	String[][] listafilho = { { "180m - Lotado", "1,2km - Moderado", "2,3km - Livre" },
			{ "70m - Moderado" }, { "220m - Moderado" } , {}, {"900m - Livre"}};
	 
	public MeuAdapter(Context context) {
	this.context = context;
	}
	 
	@Override
	public Object getChild(int groupPosition, int childPosition) {
	// TODO Auto-generated method stub
	return listafilho[groupPosition][childPosition];
	}
	 
	@Override
	public long getChildId(int groupPosition, int childPosition) {
	// TODO Auto-generated method stub
	return childPosition;
	}
	 
	@Override
	public View getChildView(int groupPosition, int childPosition,
	boolean isLastChild, View convertView, ViewGroup parent) {
	 
	// Criamos um TextView que conter� as informa��es da listafilho que
	// criamos
	TextView textViewSubLista = new TextView(context);
	textViewSubLista.setText(listafilho[groupPosition][childPosition]);
	// Definimos um alinhamento
	textViewSubLista.setPadding(60, 5, 0, 5);
	textViewSubLista.setTextSize(18);
	 
	return textViewSubLista;
	}
	 
	@Override
	public int getChildrenCount(int groupPosition) {
	// TODO Auto-generated method stub
	return listafilho[groupPosition].length;
	}
	 
	@Override
	public Object getGroup(int groupPosition) {
	// TODO Auto-generated method stub
	return listaPai[groupPosition];
	}
	 
	@Override
	public int getGroupCount() {
	// TODO Auto-generated method stub
	return listaPai.length;
	}
	 
	@Override
	public long getGroupId(int groupPosition) {
	// TODO Auto-generated method stub
	return groupPosition;
	}
	 
	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
	View convertView, ViewGroup parent) {
	 
	// Criamos um TextView que conter� as informa��es da listaPai que
	// criamos
	TextView textViewCategorias = new TextView(context);
	textViewCategorias.setText(listaPai[groupPosition]);
	// Definimos um alinhamento
	textViewCategorias.setPadding(50, 12, 0, 12);
	// Definimos o tamanho do texto
	textViewCategorias.setTextSize(20);
	// Definimos que o texto estar� em negrito
	textViewCategorias.setTypeface(null, Typeface.BOLD);
	 
	return textViewCategorias;
	}
	 
	@Override
	public boolean hasStableIds() {
	// TODO Auto-generated method stub
	return false;
	}
	 
	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
	// Defina o return como sendo true se vc desejar que sua sublista seja selecion�vel
	return false;
	}
 
}
