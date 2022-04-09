package br.calebe.ticketmachine.test;

import org.junit.Assert;
import org.junit.Test;
import br.calebe.ticketmachine.core.TicketMachine;

public class TicketMachineTest {
    
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
    public void imprimirTest() {
        
    }

}