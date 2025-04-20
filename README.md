Tarea 2 - Java - Macarena Raffo Palma

1. Desarrolle una app que sea maven y que genere un jar. El artefacto debe ser Actividad2, el groupId ar.edu.udeci.pv. y la version 1.0-SNAPSHOT.

    Dentro del archivo pom.xml configuré lo solicitado:
    
    <groupId>ar.edu.udeci.pv</groupId>
    <artifactId>Actividad2</artifactId>
    <version>1.0-SNAPSHOT</version>

2. El proyecto debe contener las librerías:  commons-cli y log4j.

    En primer lugar investigué con ayuda del Chat GPT para qué servían las librerías. commons-cli para la lectura de argumentos de la línea de comandos y log4j para registrar eventos en la aplicación (como errores o información importante) para hacer el seguimiento y luego con esa información depurar los problemas.
    
    Para poder utilizar estas librerías agregué la siguiente programación en el pom.xml:
    
    <dependencies>
        <dependency>
            <groupId>commons-cli</groupId>
            <artifactId>commons-cli</artifactId>
            <version>1.5.0</version>
        </dependency>
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-core</artifactId>
            <version>2.20.0</version>
        </dependency>
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-api</artifactId>
            <version>2.20.0</version>
        </dependency>
    </dependencies>
    

3. Solicitar a una llm que le de un ejemplo de código de cada librería e incluirla en la entrega.

    Le pregunté al Chat GPT si me podía dar un ejemplo de aplicación de las librerías y me dio lo siguiente (que lo puse en el mail con ayuda del chat para construirlo por completo):
    
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
    
    La idea es que el programa solicite un nombre, si este es correcto nos dirá "Hola, nombre", por ejemplo, "Hola, Macarena". Caso contrario, nos dará mensajes de error.
    

4. Ejecutar la aplicación utilizando maven.

    Al momento de ejecutarlo me encontré con muchos problemas:
    
    En primer lugar, no podía ejecutarlo porque me faltó instalar el maven previamente. Por lo cual tuve que descargarlo e intalarlo siguiendo la informaciónd e la PT y luego con ayuda del Chat GPT porque me aparecían errores continuamente.
    
    Cuando ya tuve instalado correctamente el maven, me faltaba instalar Java. Procedí a instalarlo. Pese a hacerlo correctamente no podía ejecutar la aplicación hasta que reinicié a máquina y tomó las instalaciones correctamente. Por último, tras instentar probar la app y tener errores nuevamente, el Caht GPT me sugirió programar un plugin.

   Después de estos pasos, finalmente pude ejecutar el proyecto utilizando el comando mvn exec:java -Dexec.args="-n Macarena" obteniendo como resultado "Hola, Macarena"
