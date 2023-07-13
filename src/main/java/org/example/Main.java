package org.example;

import org.example.client.Client;
import org.example.dao.MembreImpl;
import org.example.entities.Membre;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        MembreImpl membreImpl=new MembreImpl();
        System.out.println("Entrer votre username pour le group de chat");
        String username = scanner.nextLine();
        Socket socket = new Socket("localhost", 5000);
        Client client = new Client(socket, username);
        Membre membre=new Membre();
        membre.setUsename(username);
        membreImpl.save(membre);
        client.listenForMessage();
        client.sendMessage();
    }
}