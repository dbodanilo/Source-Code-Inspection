package br.calebe.ticketmachine.test;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import br.calebe.ticketmachine.core.PapelMoeda;
import br.calebe.ticketmachine.core.TicketMachine;

public class TicketMachineTest {
    
    // prevents Iterator<> tests from getting stuck in an infinite loop
    @Rule
    public Timeout globalTimeout= new Timeout(100, TimeUnit.MILLISECONDS);
    
    @Test
    public void inserirValorTest(){
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
    
    @Test
    public void getTrocoTest() {
        int valorBilhete = 5;
        TicketMachine tM = new TicketMachine(valorBilhete);
        int saldoOriginal = tM.getSaldo();
        Iterator<PapelMoeda> troco = tM.getTroco();

        int totalTroco = 0;
        while (troco.hasNext()) {
            PapelMoeda papel = troco.next();
            totalTroco += papel.getValor() * papel.getQuantidade();
        }
            
        Assert.assertEquals(totalTroco, saldoOriginal);
    }

    @Test
    public void imprimirTest() {
        
    }

}