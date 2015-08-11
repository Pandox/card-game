package br.com.pandox.cg.server.boot;

import br.com.pandox.cg.server.boot.server.WebServer;
import br.com.pandox.cg.server.boot.server.ApplicationServer;

public class Main {


    public static void main(String[] args) throws Exception {
        WebServer server = new ApplicationServer();
        server.start();
    }

}
