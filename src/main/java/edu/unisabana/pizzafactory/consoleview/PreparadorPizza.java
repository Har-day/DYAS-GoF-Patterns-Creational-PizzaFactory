
package edu.unisabana.pizzafactory.consoleview;

import edu.unisabana.pizzafactory.model.AmasadorPizzaDelgada;
import edu.unisabana.pizzafactory.model.AmasadorPizzaGruesa;
import edu.unisabana.pizzafactory.model.AmasadorPizzaIntegral;
import edu.unisabana.pizzafactory.model.ExcepcionParametrosInvalidos;
import edu.unisabana.pizzafactory.model.HorneadorPizzaDelgada;
import edu.unisabana.pizzafactory.model.HorneadorPizzaGruesa;
import edu.unisabana.pizzafactory.model.HorneadorPizzaIntegral;
import edu.unisabana.pizzafactory.model.Ingrediente;
import edu.unisabana.pizzafactory.model.MoldeadorPizzaDelgada;
import edu.unisabana.pizzafactory.model.MoldeadorPizzaGruesa;
import edu.unisabana.pizzafactory.model.MoldeadorPizzaIntegral;
import edu.unisabana.pizzafactory.model.Tamano;
import edu.unisabana.pizzafactory.model.Tipo;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cesarvefe
 */
public class PreparadorPizza {

    public static void main(String args[]){
        try {
                  Ingrediente[] ingredientes = new Ingrediente[]{new Ingrediente("queso", 1), new Ingrediente("jamon", 2)};
            PreparadorPizza pp = new PreparadorPizza();

            // Generar valores aleatorios para Tamano y Tipo
            Random random = new Random();
            
            Tamano[] tamanos = Tamano.values();
            Tamano tamanoAleatorio = tamanos[random.nextInt(tamanos.length)];
            
            Tipo[] tipos = Tipo.values();
            Tipo tipoAleatorio = tipos[random.nextInt(tipos.length)];

            pp.prepararPizza(ingredientes, tamanoAleatorio, tipoAleatorio);
        } catch (ExcepcionParametrosInvalidos ex) {
            Logger.getLogger(PreparadorPizza.class.getName()).log(Level.SEVERE, "Problema en la preparacion de la Pizza", ex);
        }
                
    }
    
    
    public void prepararPizza(Ingrediente[] ingredientes, Tamano tam, Tipo tipo)
            throws ExcepcionParametrosInvalidos {
        AmasadorPizzaDelgada am = new AmasadorPizzaDelgada();
        HorneadorPizzaDelgada hpd = new HorneadorPizzaDelgada();
        MoldeadorPizzaDelgada mp = new MoldeadorPizzaDelgada();
        
        AmasadorPizzaGruesa amg = new AmasadorPizzaGruesa();
        HorneadorPizzaGruesa hpg = new HorneadorPizzaGruesa();
        MoldeadorPizzaGruesa mpg = new MoldeadorPizzaGruesa();
        
        AmasadorPizzaIntegral ami = new AmasadorPizzaIntegral();
        HorneadorPizzaIntegral hpi = new HorneadorPizzaIntegral();
        MoldeadorPizzaIntegral mpi = new MoldeadorPizzaIntegral();
        
       
        if (tipo == Tipo.DELGADA) {
             am.amasar();
             if (tam == Tamano.PEQUENO) {
                mp.moldearPizzaPequena();
                aplicarIngredientes(ingredientes);
                hpd.hornear();              
             } else if (tam == Tamano.MEDIANO) {
                mp.molderarPizzaMediana();
                aplicarIngredientes(ingredientes);
                hpd.hornear();
             } else {
                throw new ExcepcionParametrosInvalidos("Tamano de piza invalido:"+tam);
             }
             
             
        } else if (tipo == Tipo.GRUESA) {
             amg.amasar();
               if (tam == Tamano.PEQUENO) {
                mpg.moldearPizzaPequena();
                aplicarIngredientes(ingredientes);
                hpg.hornear();
               } else if (tam == Tamano.MEDIANO) {
                mpg.molderarPizzaMediana();
                aplicarIngredientes(ingredientes);
                hpg.hornear();
               } else {
                    throw new ExcepcionParametrosInvalidos("Tamano de piza invalido:"+tam);
             }
        } else if (tipo == Tipo.INTEGRAL) {
             ami.amasar();
               if (tam == Tamano.PEQUENO) {
                mpi.moldearPizzaPequena();
                aplicarIngredientes(ingredientes);
                hpi.hornear();
               } else if (tam == Tamano.MEDIANO) {
                mpi.molderarPizzaMediana();
                aplicarIngredientes(ingredientes);
                hpi.hornear();
               } else {
                    throw new ExcepcionParametrosInvalidos("Tamano de piza invalido:"+tam);
             }
        } else {
            throw new ExcepcionParametrosInvalidos("Tipo de pizza invalido:"+tipo);
        }
    }

    private void aplicarIngredientes(Ingrediente[] ingredientes) {
        Logger.getLogger(PreparadorPizza.class.getName())
                .log(Level.INFO, "APLICANDO INGREDIENTES!:{0}", Arrays.toString(ingredientes));
        
        //CODIGO DE LLAMADO AL MICROCONTROLADOR
        
        
        
    }


}
