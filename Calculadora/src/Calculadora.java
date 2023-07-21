package CalculadoraJur.calculadora;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;

public  class Calculadora extends CalculadoraForm{

	private BigDecimal toBigDecimal(String valor) {
		try {
			return new BigDecimal(valor).setScale(4, RoundingMode.HALF_EVEN);
		}catch (Exception ex) {
			return BigDecimal.ZERO;
		}
	}
	
	@Override
	protected void btnCalcularClick(ActionEvent ev) {
		// TODO Auto-generated method stub
		BigDecimal capital = toBigDecimal(txtCapital.getText());
		BigDecimal juros= toBigDecimal(txtJuros.getText());
		BigDecimal periodo = toBigDecimal(txtPeriodo.getText());
		
		BigDecimal montante = juros.divide(new BigDecimal(100), RoundingMode.HALF_EVEN);
		montante = montante.add(BigDecimal.ONE); 
		montante = montante.pow(periodo.intValue());
		montante = montante.multiply(capital);
		montante = montante.setScale(2, RoundingMode.HALF_EVEN);
		
		txtMontante.setText(montante.toPlainString());
	}

	@Override
	protected void btnLimparClick(ActionEvent ev) {
		// TODO Auto-generated method stub
		txtCapital.setText("");
		txtJuros.setText("");
		txtPeriodo.setText("");
		txtMontante.setText("");
	}

	@Override
	protected void btnFecharClick(ActionEvent ev) {
		// TODO Auto-generated method stub
		this.setVisible(false);
		this.dispose();
	}
	
}
