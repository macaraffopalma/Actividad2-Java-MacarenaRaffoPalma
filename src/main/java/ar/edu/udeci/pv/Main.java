package ar.edu.udeci.pv;

import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Options options = new Options();
        options.addOption("n", "name", true, "Nombre del usuario");

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);
            if (cmd.hasOption("name")) {
                String name = cmd.getOptionValue("name");
                logger.info("Nombre recibido: {}", name);
                System.out.println("Hola, " + name);
            } else {
                System.out.println("Usá -n o --name para pasar tu nombre.");
            }
        } catch (ParseException e) {
            logger.error("Error al parsear argumentos", e);
        }
    }
}