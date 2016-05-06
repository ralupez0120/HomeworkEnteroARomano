package co.edu.udea.app;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConversionNumericaTest {
	NumerosRomanos cn = new NumerosRomanos();
	String numeroConvertido = null;
	@Test
	public void test1() {
		numeroConvertido = cn.convertir(1);
		assertEquals("I",numeroConvertido);
	}
	@Test
	public void test7(){
		numeroConvertido = cn.convertir(7);
		assertEquals("VII",numeroConvertido);
	}
	@Test
	public void test9(){
		numeroConvertido = cn.convertir(9);
		assertEquals("IX",numeroConvertido);
	}
	@Test
	public void testMayor10YMenor50(){
		numeroConvertido = cn.convertir(35);
		assertEquals("XXXV",numeroConvertido);
	}
	@Test
	public void testMenor100(){
		numeroConvertido = cn.convertir(79);
		assertEquals("LXXIX",numeroConvertido);
	}
	@Test
	public void testMenor1000(){
		numeroConvertido = cn.convertir(583);
		assertEquals("DLXXXIII",numeroConvertido);
	}
	@Test
	public void test999(){
		numeroConvertido = cn.convertir(999);
		assertEquals("CMXCIX",numeroConvertido);
	}
	@Test
	public void test1000(){
		numeroConvertido = cn.convertir(1000);
		assertEquals("M",numeroConvertido);
	}
}
