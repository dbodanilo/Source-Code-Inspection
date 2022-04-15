package br.calebe.ticketmachine.test;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import br.calebe.ticketmachine.core.PapelMoeda;
import br.calebe.ticketmachine.core.TicketMachine;

/**
 *
 * @author danil
 */
public class TicketMachineTest {
    
    // prevents Iterator<> tests from getting stuck in an infinite loop
    @Rule
    public Timeout globalTimeout= new Timeout(100, TimeUnit.MILLISECONDS);

    /**
     * Test of inserir method, of class TicketMachine.
     */    
    @Test
    public void testInserir() throws Exception {
        System.out.println("inserir");
        int valorBilhete = 5;
        int quantiaInserida = 10;
        TicketMachine tM = new TicketMachine(valorBilhete);
        try {
            tM.inserir(quantiaInserida);
            
            Assert.assertEquals(quantiaInserida, tM.getSaldo());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * Test of getSaldo method, of class TicketMachine.
     */
    @Test
    public void testGetSaldo() {
        System.out.println("getSaldo");
        int valorBilhete = 5;
        TicketMachine tM = new TicketMachine(valorBilhete);

        int expResult = 0;
        int result = tM.getSaldo();
        Assert.assertEquals(expResult, result);
    }

    /**
     * Test of getTroco method, of class TicketMachine.
     */
    @Test
    public void testGetTroco() {
        System.out.println("getTroco");
        int valorBilhete = 5;
        TicketMachine tM = new TicketMachine(valorBilhete);
        int saldoOriginal = 0;
        Iterator<PapelMoeda> troco = tM.getTroco();

        int totalTroco = 0;
        while (troco.hasNext()) {
            PapelMoeda papel = troco.next();
            totalTroco += papel.getValor() * papel.getQuantidade();
        }
            
        Assert.assertEquals(totalTroco, saldoOriginal);
    }

    /**
     * Test of imprimir method, of class TicketMachine.
     */
    @Test
    public void testImprimir() throws Exception {
        System.out.println("imprimir");
        int valorBilhete = 5;
        int saldo = 0;
        String expResult = "*****************\n*** R$ " + saldo + ",00 ****\n*****************\n";
        
        TicketMachine tM = new TicketMachine(valorBilhete);
        try {
            String result = tM.imprimir();
            
            Assert.assertEquals(expResult, result);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}