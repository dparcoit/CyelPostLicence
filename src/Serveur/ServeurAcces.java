/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serveur;

import Impl.GestionnaireAccesImpl;
import Outils.CorbaName;
import org.omg.CosNaming.NamingContext;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

/**
 *
 * @author Linkro
 */
public class ServeurAcces {

    public static void main(String[] args) {
        try {
            // Intialisation de l'ORB
            //************************
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

            // Gestion du POA
            //****************
            // Recuperation du POA
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

            // Creation du servant
            //*********************
            GestionnaireAccesImpl gestAcces = new GestionnaireAccesImpl();

            // Activer le servant au sein du POA et recuperer son ID
            byte[] gestAccesId = rootPOA.activate_object(gestAcces);

            // Activer le POA manager
            rootPOA.the_POAManager().activate();

            // Enregistrement dans le service de nommage
            //*******************************************
            // Recuperation du naming service
            //NamingContext nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
            //Naming Service sur le PC portable de romain
            NamingContext nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.string_to_object("corbaloc:iiop:1.2@"+CorbaName.NOM_NAMINGSERV+":2001/NameService"));

            // Construction du nom a enregistrer
            org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];
            String nomObj = CorbaName.GEST_ACCES;
            nameToRegister[0] = new org.omg.CosNaming.NameComponent(nomObj, "");

            // Enregistrement de l'objet CORBA dans le service de noms
            nameRoot.rebind(nameToRegister, rootPOA.servant_to_reference(gestAcces));
            System.out.println("==> Nom '" + nomObj + "' est enregistre dans le service de noms.");

            String IORServant = orb.object_to_string(rootPOA.servant_to_reference(gestAcces));
            System.out.println("L'objet possede la reference suivante :");
            System.out.println(IORServant);

            // Lancement de l'ORB et mise en attente de requete
            //**************************************************
            orb.run();

        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main
}